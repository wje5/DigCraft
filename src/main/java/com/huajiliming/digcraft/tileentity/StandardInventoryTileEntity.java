package com.huajiliming.digcraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public abstract class StandardInventoryTileEntity extends TileEntity implements IInventory {
	protected ItemStack[] slots = new ItemStack[this.getSizeInventory()];

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int decrement) {
		if (this.slots[slot] == null) {
			return null;
		}
		if (decrement < this.slots[slot].stackSize) {
			ItemStack take = this.slots[slot].splitStack(decrement);
			if (this.slots[slot].stackSize <= 0) {
				this.slots[slot] = null;
			}
			this.markDirty();
			return take;
		}
		ItemStack take = this.slots[slot];
		this.slots[slot] = null;
		this.markDirty();
		return take;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.slots[slot] == null) {
			return null;
		}
		ItemStack itemstack = this.slots[slot];
		this.slots[slot] = null;
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.slots[slot] = stack;
		if ((stack != null) && (stack.stackSize > getInventoryStackLimit())) {
			stack.stackSize = getInventoryStackLimit();
		}
		this.markDirty();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this)
				&& (player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList taglist = tag.getTagList("Items", 10);
		this.slots = new ItemStack[getSizeInventory()];
		for (int i = 0; i < taglist.tagCount(); i++) {
			NBTTagCompound tag1 = taglist.getCompoundTagAt(i);
			int j = tag1.getByte("Slot") & 0xFF;
			if ((j >= 0) && (j < this.slots.length)) {
				this.slots[j] = ItemStack.loadItemStackFromNBT(tag1);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList taglist = new NBTTagList();
		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbttagcompound1);
				taglist.appendTag(nbttagcompound1);
			}
		}
		tag.setTag("Items", taglist);
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	public void updateToClient() {
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
}
