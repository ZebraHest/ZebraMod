package com.bdm.tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.bdm.tutorial.ModTab;

public class BasicBlock extends Block {

	public BasicBlock(String unlocalizedName, String regName, Material material, float hardness, float resistence) {
		super(material);
		this.setRegistryName(regName);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModTab.modTab);
		this.setHardness(hardness);
		this.setResistance(resistence);
		this.setLightLevel(1.f);
	}

	public BasicBlock(String unlocalizedName, String regName, float hardness, float resistence) {
		this(unlocalizedName, regName, Material.ROCK, hardness, resistence);
	}

	public BasicBlock(String unlocalizedName, String regName) {
		this(unlocalizedName, regName, 2.0f, 10.0f);
	}
}
