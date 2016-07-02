package com.zebrahest.zebramod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event){
		ModItems.init();
		ModBlocks.init();
		ModCrafting.init();
	}
	
	public void init(FMLInitializationEvent event){
		ModelResourceLocation location = new ModelResourceLocation("zebramod:findingrod", "inventory");
		ZebraMod.log.info("Zebra test "+location);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(ModItems.findingRod, 0, new ModelResourceLocation("zebramod:findingrod", "inventory"));
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
	}
}