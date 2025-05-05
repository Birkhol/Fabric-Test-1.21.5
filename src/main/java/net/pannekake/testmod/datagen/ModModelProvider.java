package net.pannekake.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.ItemModels;
import net.minecraft.client.data.Models;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.item.Item;
import net.pannekake.testmod.block.ModBlocks;
import net.pannekake.testmod.item.ModItems;
import net.pannekake.testmod.component.ModDataComponentTypes;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SVEN_OLAI_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        // itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_SCANNER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SVEN_OLAI, Models.GENERATED);


        Item chisel = ModItems.CHISEL;

        ItemModel.Unbaked unusedChisel = ItemModels.basic(itemModelGenerator.upload(chisel, Models.GENERATED));
        ItemModel.Unbaked usedChisel = ItemModels.basic(itemModelGenerator.registerSubModel(chisel, "_used", Models.GENERATED));

        itemModelGenerator.registerCondition(
                chisel,
                new HasComponentProperty(ModDataComponentTypes.COORDINATES, true),
                usedChisel,
                unusedChisel
        );
    }
}
