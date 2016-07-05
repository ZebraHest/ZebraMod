package com.bdm.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName, String regName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(regName);
		this.setCreativeTab(CreativeTabs.MISC);

	}
}
