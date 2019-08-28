package com.huajiliming.digcraft.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityDoorbell extends TileEntity {
	private int timer = 0;

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		if (this.getBlockMetadata() >= 8) {
			this.timer--;
			if (this.timer <= 0) {
				int meta = this.getBlockMetadata();
				meta = meta < 8 ? meta : meta - 8;
				this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
			}
		}
	}

	public void srartTimer() {
		int meta = this.getBlockMetadata();
		meta = meta >= 8 ? meta : meta + 8;
		this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
		this.timer = 20;
	}
}
