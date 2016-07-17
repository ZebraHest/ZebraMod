package com.bdm.tutorial.item;

import net.minecraft.item.Item;

import com.bdm.tutorial.ModTab;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName, String regName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(regName);
		this.setCreativeTab(ModTab.modTab);

	}
}
