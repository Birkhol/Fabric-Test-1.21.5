package net.pannekake.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pannekake.testmod.Testmod;
import net.pannekake.testmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(Testmod.MOD_ID, "mod_items"),
    FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SVEN_OLAI))
            .displayName(Text.translatable("itemgroup.testmod.mod_items"))
            .entries((displayContext, entries) -> {
              entries.add(ModItems.PINK_GARNET);
              entries.add(ModItems.RAW_PINK_GARNET);
              entries.add(ModItems.SVEN_OLAI);
              entries.add(ModItems.CHISEL);
              entries.add(ModItems.PINK_GARNET_SWORD);
            }).build());

    public static final ItemGroup MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Testmod.MOD_ID, "mod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SVEN_OLAI_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.mod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.SVEN_OLAI_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Testmod.LOGGER.info("Registering Item Groups for " + Testmod.MOD_ID);
    }

}
