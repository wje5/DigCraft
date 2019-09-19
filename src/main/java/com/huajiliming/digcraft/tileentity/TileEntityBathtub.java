package com.huajiliming.digcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityBathtub extends TileEntity {
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		switch (this.getBlockMetadata()) {
		case 0:
		case 8:
			return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
		case 1:
		case 9:
			return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 2, yCoord + 1, zCoord + 1);
		case 2:
		case 10:
			return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 2);
		case 3:
		case 11:
			return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord - 1, xCoord + 1, yCoord + 1, zCoord + 1);
		}
		return this.INFINITE_EXTENT_AABB;
	}
}
