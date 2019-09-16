package com.huajiliming.digcraft.tileentity;

import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class TileEntityGasBurner extends StandardInventoryTileEntity implements IInitableTE {
	private int smeltTime = 0;

	@Override
	public void updateEntity() {
		if (this.getBlockMetadata() % 8 >= 4 && this.slots[1] != null
				&& this.slots[1].getItemDamage() < this.slots[1].getMaxDamage()) {
			this.smeltTime--;
			this.slots[1].setItemDamage(this.slots[1].getItemDamage() + 1);
			if (this.worldObj.isRemote && this.slots[0] != null && this.worldObj.rand.nextInt(8) == 0) {
				this.worldObj.spawnParticle("explode", this.xCoord + 0.5F, this.yCoord + 1.0F, this.zCoord + 0.5F, 0.0D,
						0.0D, 0.0D);
			}
			if (this.smeltTime == 0) {
				this.slots[0] = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			} else if (this.smeltTime <= -200 && this.slots[0] != null) {
				this.slots[0] = null;
				if (this.worldObj.isRemote) {
					this.worldObj.spawnParticle("smoke", this.xCoord + 0.5F, this.yCoord + 1.0F, this.zCoord + 0.5F,
							0.0D, 0.0D, 0.0D);
				}
			}
		}
		super.updateEntity();
	}

	public boolean tryPutItem(ItemStack stack) {
		if (this.slots[0] == null && stack != null) {
			ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(stack);
			if (result != null && result.getItem() instanceof ItemFood) {
				this.slots[0] = new ItemStack(stack.getItem());
				this.smeltTime = 200;
				return true;
			}
		}
		return false;
	}

	public ItemStack takeItem() {
		ItemStack stack = this.slots[0];
		this.slots[0] = null;
		this.smeltTime = 0;
		return stack;
	}

	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public String getInventoryName() {
		return "container.gasBurner";
	}

	@Override
	public void init() {
		this.slots[1] = new ItemStack(ItemLoader.gasCylinder, 1,
				this.worldObj.rand.nextInt(ItemLoader.gasCylinder.getMaxDamage()));
		this.updateToClient();
	}
}
