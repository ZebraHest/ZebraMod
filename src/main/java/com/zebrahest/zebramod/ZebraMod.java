package com.zebrahest.zebramod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ZebraMod.MODID, version = ZebraMod.VERSION, dependencies = "required-after:Forge@[12.18.0.2006,)", useMetadata = true)
public class ZebraMod {
	public static final String MODID = "ZebraMod";
	public static final String VERSION = "0.0";
	
	@Mod.Instance(MODID)
	public static ZebraMod instance;
	
	@SidedProxy(clientSide = "com.zebrahest.zebramod.ClientProxy", serverSide = "com.zebrahest.zebramod.ServerProxy")
	public static CommonProxy proxy;
	
	public static Logger log = LogManager.getLogger(MODID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		log.info("Zebra preInit");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		log.info("Zebra preInit");
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		log.info("Zebra preInit");
		proxy.postInit(event);
	}
}
