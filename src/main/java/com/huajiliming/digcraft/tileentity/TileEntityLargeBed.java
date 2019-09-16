package com.huajiliming.digcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLargeBed extends TileEntity {
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		switch (this.getBlockMetadata() % 4) {
		case 0:
		case 1:
			return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord, xCoord + 2, yCoord + 2, zCoord + 1);
		case 2:
		case 3:
			return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord - 1, xCoord + 1, yCoord + 2, zCoord + 2);
		}
		return this.INFINITE_EXTENT_AABB;
	}
}
