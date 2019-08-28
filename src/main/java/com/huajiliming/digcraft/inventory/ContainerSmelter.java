package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntitySmelter;
import com.huajiliming.digcrafta.achievement.AchievementLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerSmelter extends Container {
	protected TileEntitySmelter tileEntity;
	protected Slot slot1;
	protected Slot slot2;
	protected Slot slot3;
	protected int smeltTime = -1;

	public ContainerSmelter(EntityPlayer player, TileEntitySmelter tileEntity) {
		this.tileEntity = tileEntity;
		this.addSlotToContainer(this.slot1 = new Slot(this.tileEntity, 0, 56, 17) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return (stack != null)
						&& ((stack.getItem() == Item.getItemFromBlock(BlockLoader.chromeOre))
								|| (stack.getItem() == Item.getItemFromBlock(BlockLoader.iridiumOre)))
						&& (super.isItemValid(stack));
			}
		});
		this.addSlotToContainer(this.slot2 = new Slot(this.tileEntity, 1, 56, 53) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return (stack != null) && (stack.getItem() == ItemLoader.uranium) && (super.isItemValid(stack));
			}

			@Override
			public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
				super.onPickupFromSlot(player, stack);
				if (stack != null) {
					Item item = stack.getItem();
					if (item == ItemLoader.depletedUranium) {
						player.triggerAchievement(AchievementLoader.depletedUranium);
					}
				}
			}
		});
		this.addSlotToContainer(this.slot3 = new Slot(this.tileEntity, 2, 116, 35) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}

			@Override
			public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
				super.onPickupFromSlot(player, stack);
				if (stack != null) {
					Item item = stack.getItem();
					if (item == ItemLoader.chrome) {
						player.triggerAchievement(AchievementLoader.chrome);
					} else if (item == ItemLoader.iridium) {
						player.triggerAchievement(AchievementLoader.iridium);
					}
				}
			}
		});
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + i));
			}
		}
		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 161 + i));
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
		if (index < 3) {
			isMerged = mergeItemStack(newStack, 3, 39, true);
		} else if ((newStack.getItem() == Item.getItemFromBlock(BlockLoader.chromeOre))
				|| (newStack.getItem() == Item.getItemFromBlock(BlockLoader.iridiumOre))) {
			isMerged = mergeItemStack(newStack, 0, 1, false);
		} else if (newStack.getItem() == ItemLoader.uranium) {
			isMerged = mergeItemStack(newStack, 1, 2, false);
		} else if ((index >= 3) && (index < 30)) {
			isMerged = mergeItemStack(newStack, 29, 38, false);
		} else if ((index >= 30) && (index < 39)) {
			isMerged = mergeItemStack(newStack, 3, 30, false);
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

	public boolean hasEnergy() {
		return (this.slot2.getHasStack()) && (this.slot2.getStack().getItem() == ItemLoader.uranium);
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
