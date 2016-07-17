package com.bdm.tutorial.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.bdm.tutorial.ModTab;

public class MetaItem extends Item {

	public MetaItem(String unlocalizedName, String regName) {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(regName);
		this.setHasSubtypes(true);
		this.setCreativeTab(ModTab.modTab);

	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + (stack.getItemDamage() == 0 ? "white" : "black");
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		subItems.add(new ItemStack(itemIn, 1, 0));
		subItems.add(new ItemStack(itemIn, 1, 1));
	}
}
