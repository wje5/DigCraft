package com.huajiliming.digcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCastingTable extends TileEntity {
	private int tick;

	public TileEntityCastingTable() {
		this.tick = -1;
	}

	public boolean tryFill() {
		if (this.tick < 0) {
			this.tick = 300;
			return true;
		} else {
			return false;
		}
	}

	public boolean tryTake() {
		if (this.tick == 0) {
			this.tick = -1;
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return this.tick < 0;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			int meta = this.getBlockMetadata();
			if (this.tick > 0) {
				meta = meta % 4 + 8;
			} else if (this.tick == 0) {
				meta = meta % 4 + 4;
			} else {
				meta = meta % 4;
			}
			this.worldObj.setBlockMetadataWithNotify(this.xCoord, yCoord, zCoord, meta, 2);
			this.tick = this.tick < 0 ? -1 : this.tick - 1 < 0 ? 0 : this.tick - 1;
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.tick = tag.getInteger("tick");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("tick", this.tick);
	}
}
