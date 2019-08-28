package com.huajiliming.digcraft.tileentity;

import com.huajiliming.digcraft.block.BlockBurningBox;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBurningBox extends StandardInventoryTileEntity {
	public int smeltTime = 0;
	public boolean burning = false;

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
			if (this.smeltTime <= 0) {
				if (this.slots[0] != null && this.slots[0].stackSize > 0) {
					this.smeltTime += 200;
					this.slots[0].stackSize--;
					if (this.slots[0].stackSize <= 0) {
						this.slots[0] = null;
					}
				}
			}

			if (this.smeltTime > 0) {
				this.burning = true;
				if (meta < 8) {
					meta += 8;
					this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
				}
			} else {
				this.burning = false;
				if (meta >= 8) {
					meta -= 8;
					this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
				}
			}
			BlockBurningBox.updateBlockState(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			this.smeltTime = Math.max(0, this.smeltTime - 1);
		}
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public String getInventoryName() {
		return "container.burningBox";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.smeltTime = tag.getInteger("smeltTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("smeltTime", this.smeltTime);
	}
}