package com.bdm.tutorial.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	public static BasicBlock tutorialBlock;

	public static void createBlocks() {
		tutorialBlock = new BasicBlock("tutorial_block", "tutorial_block");
		GameRegistry.register(tutorialBlock);
	}
}
