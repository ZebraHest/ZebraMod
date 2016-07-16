package com.bdm.tutorial.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item tutorialItem;
	public static Item metaItem;

	public static final void createItems() {
		GameRegistry.register(tutorialItem = new BasicItem("tutorial_item", "tutorial_item"));
		GameRegistry.register(metaItem = new MetaItem("meta_item", "meta_item"));
	}
}
