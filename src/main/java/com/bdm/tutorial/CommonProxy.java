package com.bdm.tutorial;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.bdm.tutorial.blocks.ModBlocks;
import com.bdm.tutorial.item.ModItems;
import com.bdm.tutorial.network.ModGuiHandler;
import com.bdm.tutorial.tileentity.ModTileEntities;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
		ModTileEntities.init();
	}

	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}
