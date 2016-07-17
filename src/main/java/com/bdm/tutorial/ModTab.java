package com.bdm.tutorial;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.bdm.tutorial.item.ModItems;

public class ModTab {
	public static final CreativeTabs modTab = new CreativeTabs("tutorial_tab") {
		@Override
		public Item getTabIconItem() {
			return ModItems.tutorialItem;
		}
	};
}
