package net.pannekake.testmod;

import net.fabricmc.api.ModInitializer;

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
	}
}