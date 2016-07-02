package com.zebrahest.zebramod;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

public class FindingRod extends Item {
	public static Item item;

	public FindingRod(){
		setRegistryName("findingrod");
		setUnlocalizedName("findingrod");
		GameRegistry.register(this);
	}
}
