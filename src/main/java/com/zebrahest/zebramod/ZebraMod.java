package com.zebrahest.zebramod;

import java.util.logging.Logger;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.example.examplemod.ExampleMod;

@Mod(modid = ZebraMod.MODID, version = ZebraMod.VERSION, dependencies = "required-after:Forge@[12.18.0.2006,)", useMetadata = true)
public class ZebraMod {
	public static final String MODID = "ZebraMod";
	public static final String VERSION = "0.0";
	
//	@Mod.Instance
//	public static ZebraMod instance;
	
	@SidedProxy(clientSide = "com.zebrahest.zebramod.ClientProxy", serverSide = "com.zebrahest.zebramod.ServerProxy")
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
}
