package net.quilters.unnamedmod;

import net.fabricmc.api.ModInitializer;

import net.quilters.unnamedmod.block.ModBlocks;
import net.quilters.unnamedmod.item.ModItemGroups;
import net.quilters.unnamedmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnnamedMod implements ModInitializer {
	public static final String MOD_ID = "unnamed-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}