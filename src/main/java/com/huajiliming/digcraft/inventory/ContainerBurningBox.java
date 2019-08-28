package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.tileentity.TileEntityBurningBox;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBurningBox extends Container {
	protected TileEntityBurningBox tileEntity;
	protected Slot slot1;
	protected int smeltTime = 0;

	public ContainerBurningBox(EntityPlayer player, TileEntityBurningBox tileEntity) {
		this.tileEntity = tileEntity;
		addSlotToContainer(this.slot1 = new Slot(this.tileEntity, 0, 80, 35) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return (stack != null) && stack.getItem() == Items.coal && stack.getItemDamage() == 1;
			}
		});
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
		this.tileEntity = tileEntity;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		Slot slot = (Slot) this.inventorySlots.get(index);
		if ((slot == null) || (!slot.getHasStack())) {
			return null;
		}
		ItemStack newStack = slot.getStack();
		ItemStack oldStack = newStack.copy();

		boolean isMerged = false;
		if (index == 0) {
			isMerged = mergeItemStack(newStack, 1, 37, true);
		} else if (newStack.getItem() == Items.coal && newStack.getItemDamage() == 1) {
			isMerged = mergeItemStack(newStack, 0, 1, false);
		} else if ((index >= 1) && (index < 28)) {
			isMerged = mergeItemStack(newStack, 28, 37, false);
		} else if ((index >= 28) && (index < 37)) {
			isMerged = mergeItemStack(newStack, 1, 28, false);
		}
		if (!isMerged) {
			return null;
		}
		if (newStack.stackSize == 0) {
			slot.putStack(null);
		} else {
			slot.onSlotChanged();
		}
		slot.onPickupFromSlot(playerIn, newStack);

		return oldStack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return playerIn.getDistanceSq(this.tileEntity.xCoord, this.tileEntity.yCoord, this.tileEntity.zCoord) <= 64.0D;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		this.smeltTime = this.tileEntity.smeltTime;
		for (Object i : this.crafters) {
			((ICrafting) i).sendProgressBarUpdate(this, 0, this.smeltTime);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		super.updateProgressBar(id, data);
		switch (id) {
		case 0:
			this.smeltTime = data;
			break;
		}
	}
}