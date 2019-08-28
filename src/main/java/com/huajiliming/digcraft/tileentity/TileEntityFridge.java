package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import com.huajiliming.digcraft.WeightHelper;
import com.huajiliming.digcraft.WeightHelper.WeightedItem;

import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityFridge extends StandardInventoryTileEntity implements IInitableTE {
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 3, zCoord + 1);
	}

	@Override
	public int getSizeInventory() {
		return 81;
	}

	@Override
	public String getInventoryName() {
		return "container.fridge";
	}

	@Override
	public void init() {
		if (this.getBlockMetadata() < 4) {
			Random rand = new Random();
			WeightHelper helper = new WeightHelper(new Random(), new WeightedItem(Items.melon, 0, 3, 4, 8),
					new WeightedItem(Items.cake, 0, 1, 1, 1), new WeightedItem(Items.cookie, 0, 3, 6, 12),
					new WeightedItem(Items.cooked_fished, 0, 2, 1, 3),
					new WeightedItem(Items.cooked_fished, 1, 2, 1, 3),
					new WeightedItem(Items.cooked_porkchop, 0, 2, 1, 3),
					new WeightedItem(Items.cooked_beef, 0, 2, 1, 3), new WeightedItem(Items.cooked_chicken, 0, 2, 1, 3),
					new WeightedItem(Items.bread, 0, 2, 2, 4), new WeightedItem(Items.mushroom_stew, 0, 2, 1, 1),
					new WeightedItem(Items.apple, 0, 3, 4, 6), new WeightedItem(Items.pumpkin_pie, 0, 2, 1, 3),
					new WeightedItem(Items.baked_potato, 0, 3, 2, 4), new WeightedItem(Items.potato, 0, 3, 2, 4),
					new WeightedItem(Items.carrot, 0, 3, 4, 8), new WeightedItem(Items.milk_bucket, 0, 1, 1, 1));
			WeightHelper helper2 = new WeightHelper(new Random(), new WeightedItem(Items.porkchop, 0, 2, 1, 3),
					new WeightedItem(Items.fish, 0, 2, 1, 3), new WeightedItem(Items.fish, 1, 2, 1, 3),
					new WeightedItem(Items.fish, 2, 2, 1, 3), new WeightedItem(Items.fish, 3, 2, 1, 3),
					new WeightedItem(Items.cake, 0, 1, 1, 1), new WeightedItem(Items.beef, 0, 2, 1, 3),
					new WeightedItem(Items.chicken, 0, 2, 1, 3));
			for (int i = 0; i < 54; i++) {
				if (rand.nextInt(4) == 0) {
					this.slots[i] = helper.getRandomObject();
				}
			}
			for (int i = 54; i < 81; i++) {
				if (rand.nextInt(4) == 0) {
					this.slots[i] = helper2.getRandomObject();
				}
			}
		}
	}
}
