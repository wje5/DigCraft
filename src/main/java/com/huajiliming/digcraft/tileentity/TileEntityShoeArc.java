package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TileEntityShoeArc extends StandardInventoryTileEntity implements IInitableTE {
	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public String getInventoryName() {
		return "container.shoeArc";
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
	public void init() {
		Random rand = new Random();
		for (int i = 0; i < 2; i++) {
			if (rand.nextInt(6) == 0) {
				ItemStack stack = new ItemStack(Items.leather_boots);
				Items.leather_boots.func_82813_b(stack, rand.nextInt(16777216));
				this.slots[i] = stack;

			}
		}
	}
}
