package com.bdm.tutorial.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.bdm.tutorial.Main;
import com.bdm.tutorial.item.ModItems;

public final class ItemRenderRegister {
	public static String modid = Main.MODID;

	public static void preInit() {
		ModelBakery.registerItemVariants(ModItems.metaItem, new ResourceLocation("tutorial:meta_item_white"), new ResourceLocation("tutorial:meta_item_black"));
	}

	public static void registerItemRender() {
		regItem(ModItems.tutorialItem);
		regItem(ModItems.metaItem, 0, "meta_item_white");
		regItem(ModItems.metaItem, 1, "meta_item_black");
	}

	private static void regItem(Item item) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private static void regItem(Item item, int meta, String file) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
