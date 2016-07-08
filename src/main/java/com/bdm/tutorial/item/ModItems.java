package com.bdm.tutorial.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item tutorialItem;
	public static Item metaItem;

	public static final void createItems() {
		tutorialItem = new BasicItem("Tutorial Item", "tutorial_item");
		GameRegistry.register(tutorialItem);
		GameRegistry.register(metaItem = new MetaItem("meta_item", "meta_item"));
	}
}
