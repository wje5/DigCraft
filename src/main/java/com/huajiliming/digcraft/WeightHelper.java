package com.huajiliming.digcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WeightHelper {
	private Random rand;
	private WeightedItem[] objects;

	public WeightHelper(Random rand, WeightedItem... objects) {
		this.rand = rand;
		this.objects = objects;
	}

	public ItemStack getRandomObject() {
		int totalWeight = 0;
		for (WeightedItem o : this.objects) {
			totalWeight += o.weight;
		}
		totalWeight = this.rand.nextInt(totalWeight) + 1;
		for (WeightedItem o : this.objects) {
			if (o.weight >= totalWeight) {
				return o.getRandomStack();
			} else {
				totalWeight -= o.weight;
			}
		}
		return null;
	}

	public static class WeightedItem {
		public Item item;
		public int weight;
		public int min;
		public int max;
		public int damage;

		public WeightedItem(Item item, int damage, int weight, int min, int max) {
			this.item = item;
			this.weight = weight;
			this.min = min;
			this.max = max;
			this.damage = damage;
		}

		public WeightedItem(Block block, int damage, int weight, int min, int max) {
			this(Item.getItemFromBlock(block), damage, weight, min, max);
		}

		public ItemStack getRandomStack() {
			return new ItemStack(this.item, this.min + new Random().nextInt(this.max - this.min + 1), this.damage);
		}
	}
}
