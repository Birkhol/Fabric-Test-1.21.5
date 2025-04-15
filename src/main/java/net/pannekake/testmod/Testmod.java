package net.pannekake.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.pannekake.testmod.block.ModBlocks;
import net.pannekake.testmod.item.ModItemGroups;
import net.pannekake.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testmod implements ModInitializer {
	public static final String MOD_ID = "testmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
			if (itemStack.isOf(ModItems.CHISEL)){
				if (Screen.hasShiftDown()) {
					list.add(Text.translatable("tooltip.tutorialmod.chisel.shift_down"));
				} else {
					list.add(Text.translatable("tooltip.tutorialmod.chisel"));
				}

				return;
			}

			if (itemStack.isOf(ModBlocks.MAGIC_BLOCK.asItem())){
				list.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
				return;
			}

		});
	}
}