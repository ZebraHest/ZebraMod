package com.bdm.tutorial.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.bdm.tutorial.Main;
import com.bdm.tutorial.item.ModItems;

public final class ItemRenderRegister {
	public static String modid = Main.MODID;

	public static void registerItemRender() {
		regItem(ModItems.tutorialItem);
	}

	private static void regItem(Item item) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
