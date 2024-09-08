package net.quilters.unnamedmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.quilters.unnamedmod.UnnamedMod;
import net.quilters.unnamedmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup UNNAMED_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(UnnamedMod.MOD_ID, "unnamed_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SMOOTH_SANDSTONE_BRICKS))
                    .displayName(Text.translatable("itemgroup.unnamed-mod.unnamed_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TEST_ITEM);
                        entries.add(ModItems.LIGHTNING_STICK);
                        entries.add(ModBlocks.SMOOTH_BASALT_BRICKS);
                        entries.add(ModBlocks.SMOOTH_SANDSTONE_BRICKS);
                    }).build());
    public static void registerItemGroups() {
        UnnamedMod.LOGGER.info("Registering Item Groups for " + UnnamedMod.MOD_ID);
    }
}
