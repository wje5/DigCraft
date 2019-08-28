package com.huajiliming.digcraft.tileentity;

import java.util.List;

import com.huajiliming.digcraft.block.BlockBurningBox;
import com.huajiliming.digcraft.fluid.FluidLoader;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.TileFluidHandler;

public class TileEntityCrucible extends TileFluidHandler implements IInventory {
	private ItemStack[] slots = new ItemStack[1];
	public float temp = 20;

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			FluidStack fluid = this.tank.drain(1, false);
			int meta = this.getBlockMetadata() % 4;
			if (fluid != null && fluid.amount > 0) {
				meta += 4;
			}
			if (this.getStackInSlot(0) != null) {
				meta += 8;
			}
			this.worldObj.setBlockMetadataWithNotify(this.xCoord, yCoord, zCoord, meta, 2);
			if (this.worldObj.getBlock(this.xCoord, this.yCoord - 1, this.zCoord) instanceof BlockBurningBox) {
				TileEntityBurningBox te = (TileEntityBurningBox) this.worldObj.getTileEntity(this.xCoord,
						this.yCoord - 1, this.zCoord);
				if (te.burning) {
					this.temp = Math.min(this.temp + 1.2F, 1220.0F);
				} else {
					if (this.temp > 20.0F) {
						this.temp -= Math.sqrt(this.temp - 20);
					} else {
						this.temp = 20.0F;
					}
				}
			} else {
				if (this.temp > 20.0F) {
					this.temp -= Math.sqrt(this.temp - 20.0F) / 20.0F;
				} else {
					this.temp = 20.0F;
				}
			}
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
					(Entity) null, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord + 0.5D, this.zCoord,
							this.xCoord + 1.0D, this.yCoord + 1.5D, this.zCoord + 1.0D),
					IEntitySelector.selectAnything);
			for (Object entity : list) {
				if (entity instanceof EntityItem) {
					EntityItem entityItem = (EntityItem) entity;
					ItemStack stack = entityItem.getEntityItem();
					if (stack != null && stack.getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
						if (this.getStackInSlot(0) == null) {
							this.setInventorySlotContents(0, new ItemStack(Blocks.iron_ore, stack.stackSize));
							stack = null;
							entityItem.setDead();
						} else {
							int a = Math.min(64 - this.getStackInSlot(0).stackSize, stack.stackSize);
							this.getStackInSlot(0).stackSize += a;
							stack.stackSize -= a;
							if (stack.stackSize <= 0) {
								entityItem.setDead();
							}
						}
					}
				}
			}
			if (this.temp >= 935 && this.slots[0] != null && this.slots[0].stackSize > 0) {
				if (this.tank.fill(new FluidStack(FluidLoader.meltIron, 144), false) == 144) {
					this.temp -= 120;
					this.tank.fill(new FluidStack(FluidLoader.meltIron, 144), true);
					this.slots[0].stackSize--;
				}
			}
		}
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.slots[slot];
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
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
	public String getInventoryName() {
		return "container.crucible";
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
		this.temp = tag.getFloat("temp");
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
		tag.setFloat("temp", this.temp);
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
}