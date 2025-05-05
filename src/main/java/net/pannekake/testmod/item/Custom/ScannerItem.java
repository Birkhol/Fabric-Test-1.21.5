package net.pannekake.testmod.item.Custom;

import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.pannekake.testmod.sound.ModSounds;
import net.minecraft.component.DataComponentTypes;

import java.util.HashMap;
import java.util.UUID;

public class ScannerItem extends Item {
    private static final HashMap<UUID, Long> lastBeepTimeMap = new HashMap<>();

    public ScannerItem(Settings settings) {
        super(settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, EquipmentSlot slot) {

        if (world.isClient || (!(entity instanceof PlayerEntity player)) || slot != EquipmentSlot.MAINHAND) return;

        BlockPos playerPos = player.getBlockPos();
        int scanRadius = 30;
        BlockPos nearestDebris = null;
        double closestDistance = Double.MAX_VALUE;

        for (int dx = -scanRadius; dx <= scanRadius; dx++) {
            for (int dy = -scanRadius; dy <= scanRadius; dy++) {
                for (int dz = -scanRadius; dz <= scanRadius; dz++) {
                    BlockPos checkPos = playerPos.add(dx, dy, dz);
                    if (world.getBlockState(checkPos).isOf(Blocks.ANCIENT_DEBRIS)) {
                        double distSq = checkPos.getSquaredDistance(playerPos);
                        if (distSq < closestDistance) {
                            closestDistance = distSq;
                            nearestDebris = checkPos;
                        }
                    }
                }
            }
        }

        if(nearestDebris != null) {
            double distance = Math.sqrt(closestDistance);
            //float pitch = (float) (1.5 - (distance / scanRadius));
            //pitch = Math.max(0.3f, Math.min(pitch, 2.0f));
            //float volume = 0.1f;

            // Direction from player to debris
            Vec3d toDebris = new Vec3d(
                    nearestDebris.getX() + 0.5 - player.getX(),
                    nearestDebris.getY() + 0.5 - player.getY(),
                    nearestDebris.getZ() + 0.5 - player.getZ()
            ).normalize();

            Vec3d look = player.getRotationVec(1.0f).normalize();

            double dot = look.dotProduct(toDebris); // Ranges from -1 (behind) to 1 (facing)

            if (dot < 0.5) return;

            // Beep delay calculation
            long currentTime = world.getTime(); // in ticks (20 per second)
            long lastBeep = lastBeepTimeMap.getOrDefault(player.getUuid(), 0L);
            int modelValue = 0;

            long delayTicks;
            if (distance <= 2) {
                delayTicks = 8;
                modelValue = 3;
            }
            else if (distance <= 10) {
                delayTicks = 10;
                modelValue = 2;
            }
            else if (distance <= 20) {
                delayTicks = 20;
                modelValue = 1;
            }
            else {
                delayTicks = 40;
                modelValue = 0;
            }

            if ((currentTime - lastBeep) >= delayTicks) {
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SCANNER_BEEP, SoundCategory.PLAYERS, 0.08f, 1f);
                lastBeepTimeMap.put(player.getUuid(), currentTime);
            }


            }

        }

}

