package com.bdm.tutorial.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.bdm.tutorial.ModTab;
import com.bdm.tutorial.item.itemstack.IMetaBlockName;

public class BlockProperties extends Block implements IMetaBlockName {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockProperties.EnumType.class);

	public BlockProperties(String unlocalizedName, String regName, Material material, float hardness, float resistence) {
		super(material);
		this.setRegistryName(regName);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModTab.modTab);
		this.setHardness(hardness);
		this.setResistance(resistence);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.BLACK));
	}

	public BlockProperties(String unlocalizedName, String regName, float hardness, float resistence) {
		this(unlocalizedName, regName, Material.ROCK, hardness, resistence);
	}

	public BlockProperties(String unlocalizedName, String regName) {
		this(unlocalizedName, regName, 2.0f, 10.0f);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.WHITE : EnumType.BLACK);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumType type = (EnumType) state.getValue(TYPE);
		return type.getId();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, 0));
		list.add(new ItemStack(itemIn, 1, 1));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(state));
	}

	public enum EnumType implements IStringSerializable {
		WHITE(0, "white"),
		BLACK(1, "black");

		private int ID;
		private String name;

		private EnumType(int id, String name) {
			this.ID = id;
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getId() {
			return ID;
		}

		@Override
		public String toString() {
			return getName();
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return stack.getItemDamage() == 0 ? "white" : "black";
	}
}
