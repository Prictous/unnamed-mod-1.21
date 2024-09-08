package net.quilters.unnamedmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.quilters.unnamedmod.UnnamedMod;

public class ModBlocks {
    public static final Block SMOOTH_BASALT_BRICKS = registerBlock("smooth_basalt_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.25F, 4.2F)
                    .sounds(BlockSoundGroup.BASALT)));

    public static final Block SMOOTH_SANDSTONE_BRICKS = registerBlock("smooth_sandstone_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(0.8F)
                    .sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(UnnamedMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(UnnamedMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        UnnamedMod.LOGGER.info("Registering Mod Blocks for " + UnnamedMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SMOOTH_BASALT_BRICKS);
            entries.add(ModBlocks.SMOOTH_SANDSTONE_BRICKS);
        });
    }
}
