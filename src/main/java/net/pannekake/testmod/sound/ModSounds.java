package net.pannekake.testmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.pannekake.testmod.Testmod;

public class ModSounds {
    public static SoundEvent COOL_SOUND = registerSoundEvent("cool_sound");

    public static SoundEvent ANIMATED_BLOCK_BREAK = registerSoundEvent("animated_block_break");
    public static SoundEvent ANIMATED_BLOCK_WALK = registerSoundEvent("animated_block_walk");
    public static SoundEvent ANIMATED_BLOCK_PLACE = registerSoundEvent("animated_block_place");
    public static SoundEvent ANIMATED_BLOCK_HIT = registerSoundEvent("animated_block_hit");

    public static SoundEvent SCANNER_BEEP = registerSoundEvent("scanner_beep");

    public static final BlockSoundGroup ANIMATED_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f, ModSounds.ANIMATED_BLOCK_BREAK,
            ModSounds.ANIMATED_BLOCK_WALK, ModSounds.ANIMATED_BLOCK_PLACE, ModSounds.ANIMATED_BLOCK_HIT, ModSounds.ANIMATED_BLOCK_WALK);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Testmod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

}
