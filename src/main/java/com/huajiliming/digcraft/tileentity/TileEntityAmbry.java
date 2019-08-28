package com.huajiliming.digcraft.tileentity;

import java.util.Random;

import com.huajiliming.digcraft.WeightHelper;
import com.huajiliming.digcraft.WeightHelper.WeightedItem;
import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class TileEntityAmbry extends StandardInventoryTileEntity implements IInitableTE {
	@Override
	public int getSizeInventory() {
		return 27;
	}

	@Override
	public String getInventoryName() {
		return "container.ambry";
	}

	@Override
	public void init() {
		Random rand = new Random();
		WeightHelper helper = new WeightHelper(new Random(), new WeightedItem(Items.carrot, 0, 3, 4, 8),
				new WeightedItem(Items.cooked_chicken, 0, 2, 1, 3), new WeightedItem(Items.cooked_beef, 0, 2, 1, 3),
				new WeightedItem(Items.cooked_porkchop, 0, 2, 1, 3), new WeightedItem(Items.cooked_fished, 0, 2, 1, 3),
				new WeightedItem(Blocks.cake, 0, 1, 1, 1), new WeightedItem(Items.egg, 0, 3, 4, 6),
				new WeightedItem(Items.milk_bucket, 0, 1, 1, 1), new WeightedItem(ItemLoader.gasCylinder, 0, 1, 1, 1),
				new WeightedItem(Items.pumpkin_pie, 0, 2, 1, 2), new WeightedItem(Items.bowl, 0, 3, 1, 4),
				new WeightedItem(Items.wheat, 0, 3, 3, 5), new WeightedItem(Items.sugar, 0, 3, 4, 6),
				new WeightedItem(Items.dye, 3, 1, 4, 8), new WeightedItem(Items.potionitem, 0, 3, 1, 1),
				new WeightedItem(Blocks.red_mushroom, 0, 3, 4, 8), new WeightedItem(Blocks.brown_mushroom, 0, 3, 4, 8),
				new WeightedItem(Items.glass_bottle, 0, 3, 1, 3), new WeightedItem(Items.baked_potato, 0, 2, 2, 4),
				new WeightedItem(Items.cookie, 0, 3, 4, 8));
		for (int i = 0; i < 27; i++) {
			if (rand.nextInt(8) == 0) {
				this.slots[i] = helper.getRandomObject();
			}
		}
	}
}
