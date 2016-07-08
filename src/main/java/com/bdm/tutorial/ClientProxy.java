package com.bdm.tutorial;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.bdm.tutorial.client.render.blocks.BlockRenderRegister;
import com.bdm.tutorial.client.render.items.ItemRenderRegister;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		BlockRenderRegister.preInit();
		ItemRenderRegister.preInit();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ItemRenderRegister.registerItemRender();
		BlockRenderRegister.registerBlockRenderer();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}

}
