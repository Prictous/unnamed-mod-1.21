package net.quilters.unnamedmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quilters.unnamedmod.UnnamedMod;
import net.quilters.unnamedmod.item.custom.LightningStickItem;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("test_item", new Item(new Item.Settings()));
    public static final Item LIGHTNING_STICK = registerItem("lightning_stick", new LightningStickItem(new Item.Settings().maxDamage(5)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UnnamedMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UnnamedMod.LOGGER.info("Registering Mod Items for " + UnnamedMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TEST_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LIGHTNING_STICK);
        });
    }
}
