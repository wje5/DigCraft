package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.tileentity.TileEntityFridge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFridgeSmall extends Container {
	protected TileEntityFridge tileEntity;
	protected Slot[] slots = new Slot[27];
	protected int smeltTime = 0;

	public ContainerFridgeSmall(EntityPlayer player, TileEntityFridge tileEntity) {
		this.tileEntity = tileEntity;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(this.tileEntity, j + i * 9 + 54, 8 + j * 18, 18 + i * 18));
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 86 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 144));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 27) {
				if (!this.mergeItemStack(itemstack1, 27, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 27, false)) {
				return null;
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return playerIn.getDistanceSq(this.tileEntity.xCoord, this.tileEntity.yCoord, this.tileEntity.zCoord) <= 64.0D;
	}
}