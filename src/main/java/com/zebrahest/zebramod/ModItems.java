package com.zebrahest.zebramod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {

	public static Item findingRod;
	
	public static void init(){
		findingRod = new FindingRod().setCreativeTab(CreativeTabs.MISC);
	}
}
