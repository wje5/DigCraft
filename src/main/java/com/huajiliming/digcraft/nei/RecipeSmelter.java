package com.huajiliming.digcraft.nei;

import java.util.ArrayList;
import java.util.HashMap;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.mojang.realmsclient.util.Pair;

import net.minecraft.item.ItemStack;

public class RecipeSmelter extends StandardRecipeHandler {
	public static final ArrayList<Pair<Integer, Integer>> positions = new ArrayList<Pair<Integer, Integer>>();
	public static final HashMap<ItemStack, ItemStack[]> recipes = new HashMap<ItemStack, ItemStack[]>();

	static {
		positions.add(Pair.of(103, 24));
		positions.add(Pair.of(43, 6));
		positions.add(Pair.of(43, 42));
		recipes.put(new ItemStack(ItemLoader.chrome),
				new ItemStack[] { new ItemStack(BlockLoader.chromeOre), new ItemStack(ItemLoader.uranium) });
	}

	@Override
	public void drawExtras(int recipe) {
		this.drawProgressBar(67, 24, 167, 14, 22, 16, 35, 0);
		drawProgressBar(48, 25, 170, 0, 6, 14, 35, 1);
	}

	@Override
	public String getUnlocatedName() {
		return "smelter";
	}

	@Override
	public HashMap<ItemStack, ItemStack[]> getRecipeList() {
		return recipes;
	}

	@Override
	public String getRecipeId() {
		return "smelter";
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getPositions() {
		return positions;
	}

	@Override
	public String getGuiTexture() {
		return "digcraft:textures/gui/nei/smelter.png";
	}
}
