package com.bdm.tutorial.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class ModTileEntity extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	private String customName;

	public ModTileEntity() {
		this.inventory = new ItemStack[this.getSizeInventory()];
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public String getName() {
		return hasCustomName() ? getCustomName() : "container.tutorial_tile_entity";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public int getSizeInventory() {
		return 9;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index > this.getSizeInventory())
			return null;
		return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack itemStack = this.getStackInSlot(index);
		if (itemStack == null)
			return null;

		if (itemStack.stackSize <= count) {
			this.setInventorySlotContents(index, null);
			this.markDirty();
			return itemStack;
		} else {
			itemStack = itemStack.splitStack(count);
			if (this.getStackInSlot(index).stackSize <= 0) {
				this.setInventorySlotContents(index, null);
			} else {
				this.setInventorySlotContents(index, this.getStackInSlot(index));
			}

			this.markDirty();
			return itemStack;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if(index < 0 || index > this.getSizeInventory())
			return;
		
		if(stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();
		
		if(stack != null && stack.stackSize == 0)
			stack.stackSize = 0;
		
		this.inventory[index] = stack;
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		for(int i = 0 ; i < this.getSizeInventory() ; i++){
			if(this.getStackInSlot(i) != null){
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);
		
		if(this.hasCustomName())
			nbt.setString("CustomName", this.customName);
		
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("Items", 10);
		for(int i = 0 ; i < list.tagCount() ; i++){
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}
		
		if(nbt.hasKey("CustomName")){
			this.setCustomName(nbt.getString("CustomName"));
		}
		System.out.println("HEST");
	}
	
}
