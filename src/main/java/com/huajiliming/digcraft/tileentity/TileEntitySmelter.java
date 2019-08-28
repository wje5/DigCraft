package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntitySmelter extends StandardInventoryTileEntity {
	public int smeltTime = -1;
	public boolean energy;
	public boolean isChrome;

	@Override
	public int getSizeInventory() {
		return 3;
	}

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			this.energy = ((this.slots[1] != null) && (this.slots[1].getItem() == ItemLoader.uranium));
			if ((!this.energy) && (this.smeltTime != -1)) {
				this.smeltTime = -1;
				this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "digcraft:smelter.stop", 1.0F,
						this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}
			if ((this.smeltTime == -1) && (this.slots[0] != null) && (this.energy)
					&& ((this.slots[2] == null) || (this.slots[2].stackSize < 64))) {
				if ((this.slots[0].getItem() == Item.getItemFromBlock(BlockLoader.chromeOre))
						&& ((this.slots[2] == null) || ((this.slots[2].getItem() == ItemLoader.chrome)
								&& (this.slots[2].stackSize < 64)))) {
					this.isChrome = true;
					this.smeltTime = 300;
					if (this.slots[0].stackSize > 1) {
						this.slots[0].stackSize -= 1;
					} else {
						this.slots[0] = null;
					}
				} else if ((this.slots[0].getItem() == Item.getItemFromBlock(BlockLoader.iridiumOre))
						&& ((this.slots[2] == null) || ((this.slots[2].getItem() == ItemLoader.iridium)
								&& (this.slots[2].stackSize < 64)))) {
					this.isChrome = false;
					this.smeltTime = 300;
					if (this.slots[0].stackSize > 1) {
						this.slots[0].stackSize -= 1;
					} else {
						this.slots[0] = null;
					}
				}
			}
			if (this.smeltTime > 0) {
				if (this.energy) {
					this.smeltTime -= 1;
					if (this.slots[1].attemptDamageItem(1, new Random())) {
						this.slots[1] = new ItemStack(ItemLoader.depletedUranium);
					}
				}
			} else if (this.smeltTime == 0) {
				this.smeltTime = -1;
				if (this.isChrome) {
					if (this.slots[2] == null) {
						this.slots[2] = new ItemStack(ItemLoader.chrome);
					} else if ((this.slots[2].getItem() == ItemLoader.chrome) && (this.slots[2].stackSize < 64)) {
						this.slots[2].stackSize += 1;
					}
				} else if (this.slots[2] == null) {
					this.slots[2] = new ItemStack(ItemLoader.iridium);
				} else if ((this.slots[2].getItem() == ItemLoader.iridium) && (this.slots[2].stackSize < 64)) {
					this.slots[2].stackSize += 1;
				}
			}
			int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
			if (this.smeltTime > -1) {
				if (meta < 8) {
					meta += 8;
				}
			} else if (meta >= 8) {
				meta -= 8;
			}
			this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
			this.markDirty();
		}
	}

	@Override
	public String getInventoryName() {
		return "container.smelter";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.smeltTime = tag.getInteger("smeltTime");
		this.isChrome = tag.getBoolean("isChrome");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("smeltTime", this.smeltTime);
		tag.setBoolean("isChrome", this.isChrome);
	}
}