package com.huajiliming.digcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityDiningTable extends TileEntity {
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 1, yCoord + 1, zCoord + 1);
	}
}
