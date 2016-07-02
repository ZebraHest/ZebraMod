package com.zebrahest.zebramod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init(){
		GameRegistry.addRecipe(new ItemStack(ModItems.findingRod), 
				"A A",
				" A ",
				"A A",
				'A', Blocks.COBBLESTONE);
		
		GameRegistry.addRecipe(new ItemStack(Items.ARROW), 
				"A A",
				" A ",
				"A  ",
				'A', Blocks.COBBLESTONE);
	}
}
