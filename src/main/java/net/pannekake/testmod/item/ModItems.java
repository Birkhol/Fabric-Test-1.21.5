package net.pannekake.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pannekake.testmod.Testmod;
import net.pannekake.testmod.item.Custom.ChiselItem;
import net.pannekake.testmod.item.Custom.ScannerItem;


import java.util.function.Function;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new, new Item.Settings());
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new, new Item.Settings());
    public static final Item SVEN_OLAI = registerItem("sven_olai", Item::new, new Item.Settings());
    public static final Item CHISEL = registerItem("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));
    public static final Item NETHERITE_SCANNER = registerItem("netherite_scanner", ScannerItem::new, new Item.Settings().maxCount(1));


    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testmod.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        Testmod.LOGGER.info("Registering Mod Items for " + Testmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(SVEN_OLAI);
        });
    }

}
