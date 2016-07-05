package com.bdm.tutorial.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.bdm.tutorial.blocks.ModBlocks;

public final class BlockRenderRegister {
	public static void registerBlockRenderer() {
		reg(ModBlocks.tutorialBlock);
	}

	private static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

	}
}
