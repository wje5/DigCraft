package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import com.huajiliming.digcraft.WeightHelper;
import com.huajiliming.digcraft.WeightHelper.WeightedItem;
import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.init.Items;

public class TileEntityBedsideTable extends StandardInventoryTileEntity implements IInitableTE {
	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public String getInventoryName() {
		return "container.bedsideTable";
	}

	@Override
	public void init() {
		Random rand = new Random();
		WeightHelper helper = new WeightHelper(new Random(), new WeightedItem(Items.map, 0, 3, 1, 1),
				new WeightedItem(Items.paper, 0, 3, 1, 1), new WeightedItem(Items.compass, 0, 1, 1, 1),
				new WeightedItem(Items.clock, 0, 1, 1, 1), new WeightedItem(Items.book, 0, 2, 1, 1),
				new WeightedItem(Items.writable_book, 0, 2, 1, 1),
				new WeightedItem(ItemLoader.ATaleOfTwoCities, 0, 1, 1, 1));
		for (int i = 0; i < 2; i++) {
			if (rand.nextInt(2) == 0) {
				this.slots[i] = helper.getRandomObject();
			}
		}
	}
}
