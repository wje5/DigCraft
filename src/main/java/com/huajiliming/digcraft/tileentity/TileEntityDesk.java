package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import com.huajiliming.digcraft.WeightHelper;
import com.huajiliming.digcraft.WeightHelper.WeightedItem;
import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityDesk extends StandardInventoryTileEntity implements IInitableTE {
	public boolean drawerOpenLeft;
	public boolean drawerOpenRight;

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		switch (this.getBlockMetadata()) {
		case 0:
		case 1:
		case 8:
		case 9:
			return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord, xCoord + 2, yCoord + 1, zCoord + 1);
		case 2:
		case 3:
		case 10:
		case 11:
			return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord - 1, xCoord + 1, yCoord + 1, zCoord + 2);
		}
		return this.INFINITE_EXTENT_AABB;
	}

	@Override
	public int getSizeInventory() {
		return 5;
	}

	@Override
	public String getInventoryName() {
		return "container.desk";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.drawerOpenLeft = tag.getBoolean("drawerOpenLeft");
		this.drawerOpenRight = tag.getBoolean("drawerOpenRight");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setBoolean("drawerOpenLeft", drawerOpenLeft);
		tag.setBoolean("drawerOpenRight", drawerOpenRight);
	}

	@Override
	public void init() {
		if (this.getBlockMetadata() < 4) {
			Random rand = new Random();
			WeightHelper helper = new WeightHelper(new Random(), new WeightedItem(Items.map, 0, 3, 1, 1),
					new WeightedItem(Items.paper, 0, 3, 1, 1), new WeightedItem(Items.compass, 0, 1, 1, 1),
					new WeightedItem(Items.clock, 0, 1, 1, 1), new WeightedItem(Items.book, 0, 2, 1, 1),
					new WeightedItem(Items.writable_book, 0, 2, 1, 1),
					new WeightedItem(ItemLoader.ATaleOfTwoCities, 0, 1, 1, 1));
			for (int i = 0; i < 5; i++) {
				if (rand.nextInt(3) == 0) {
					this.slots[i] = helper.getRandomObject();
				}
			}
		}
	}
}
