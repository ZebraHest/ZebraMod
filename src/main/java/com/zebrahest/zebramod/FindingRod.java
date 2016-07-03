package com.zebrahest.zebramod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
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
	
	
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(playerIn.isSneaking()){
			playerIn.openGui(ZebraMod.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}else{
			Vec3i vec = facing.getDirectionVec();
			BlockPos newPos = pos.subtract(vec);
			if(worldIn.isRemote){
				scan(worldIn, pos, facing, 1, 30, Blocks.IRON_ORE, playerIn);
			}
		}
		return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	private boolean scan(World worldIn, BlockPos pos, EnumFacing facing, int radius, int range, Block block, EntityPlayer playerIn){
		Vec3i fVec = facing.getDirectionVec();
		Vec3i normalFacing = new Vec3i(Math.abs(fVec.getX()), Math.abs(fVec.getY()), Math.abs(fVec.getZ()));
		Vec3i hVec = new Vec3i(fVec.getX() == 0 ? 1 : 0, fVec.getX() == 0 ? 0 : 1, 0);
		Vec3i kVec = new Vec3i(0, fVec.getZ() == 0 ? 0 : 1, fVec.getZ() == 0 ? 1 : 0);
		
		pos= pos.add(facing.getDirectionVec());
		for(int i = 0; i <range ; i++){
			pos= pos.subtract(facing.getDirectionVec());
			for(int h = -radius ; h <= radius ; h++){
				for(int k = -radius; k <= radius ; k++){
					BlockPos tempPos = pos.add(multiply(hVec, h)).add(multiply(kVec, k));
					if(worldIn.getBlockState(tempPos).getBlock().equals(block)){
						playerIn.addChatMessage(new TextComponentString("Found "+block.getLocalizedName()+", "+i+" blocks away"));
						return true;
					}
				}
			}
		}
		playerIn.addChatMessage(new TextComponentString("Did not find "+block.getLocalizedName()));
		return false;
	}
	
	private Vec3i multiply(Vec3i vector, int multiplyer){
		return new Vec3i(vector.getX()*multiplyer, vector.getY()*multiplyer, vector.getZ()*multiplyer);
	}
	
}
