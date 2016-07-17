package com.bdm.tutorial.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.bdm.tutorial.Main;
import com.bdm.tutorial.blocks.ModBlocks;

public final class BlockRenderRegister {
	private static String modid = Main.MODID;

	public static void registerBlockRenderer() {
		reg(ModBlocks.tutorialBlock);
		reg(ModBlocks.blockProperties, 0, "block_properties_white");
		reg(ModBlocks.blockProperties, 1, "block_properties_black");
		reg(ModBlocks.modBlockTileEntity);
	}

	private static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

	}

	private static void reg(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(modid + ":" + file, "inventory"));

	}

	public static void preInit() {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.blockProperties), new ResourceLocation("tutorial:block_properties_white"), new ResourceLocation("tutorial:block_properties_black"));
	}
}
