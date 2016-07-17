package com.bdm.tutorial.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(ModTileEntity.class, "tutorial_tile_entity");
	}
}
