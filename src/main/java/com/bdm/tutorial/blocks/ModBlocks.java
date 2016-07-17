package com.bdm.tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.bdm.tutorial.client.render.blocks.ItemBlockMeta;

public final class ModBlocks {
	public static BasicBlock tutorialBlock;
	public static Block blockProperties;
	public static Block modBlockTileEntity;

	public static void createBlocks() {
		tutorialBlock = new BasicBlock("tutorial_block", "tutorial_block");
		GameRegistry.register(tutorialBlock);
		createAndRegisterItemBlock(tutorialBlock);

		GameRegistry.register(modBlockTileEntity = new ModBlockTileEntity("modblock_tileentity", "modblock_tileentity"));
		createAndRegisterItemBlock(modBlockTileEntity);

		GameRegistry.register(blockProperties = new BlockProperties("block_properties", "block_properties"));

		createAndRegisterItemBlockMeta(blockProperties);
	}

	private static void createAndRegisterItemBlock(Block block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		GameRegistry.register(itemBlock);
	}

	private static void createAndRegisterItemBlockMeta(Block block) {
		ItemBlock itemBlock = new ItemBlockMeta(block);
		itemBlock.setRegistryName(block.getRegistryName());
		GameRegistry.register(itemBlock);
	}
}
