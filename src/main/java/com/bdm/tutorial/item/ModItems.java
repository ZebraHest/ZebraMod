package com.bdm.tutorial.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item tutorialItem;

	public static final void createItems() {
		tutorialItem = new BasicItem("Tutorial Item", "tutorial_item");
		GameRegistry.register(tutorialItem);
	}
}
