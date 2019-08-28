package com.huajiliming.digcraft.nei;

import java.util.ArrayList;
import java.util.HashMap;

import com.huajiliming.digcraft.block.BlockLoader;
import com.mojang.realmsclient.util.Pair;

import net.minecraft.item.ItemStack;

public class RecipeBlackhole extends StandardRecipeHandler {
	public static final ArrayList<Pair<Integer, Integer>> positions = new ArrayList<Pair<Integer, Integer>>();
	public static final HashMap<ItemStack, ItemStack[]> recipes = new HashMap<ItemStack, ItemStack[]>();

	static {
		positions.add(Pair.of(115, 49));
		positions.add(Pair.of(35, 49));
		recipes.put(new ItemStack(BlockLoader.chargedAbyssOre),
				new ItemStack[] { new ItemStack(BlockLoader.abyssOre) });

	}

	@Override
	public String getUnlocatedName() {
		return "blackhole";
	}

	@Override
	public HashMap<ItemStack, ItemStack[]> getRecipeList() {
		return recipes;
	}

	@Override
	public String getRecipeId() {
		return "blackhole";
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getPositions() {
		return positions;
	}

	@Override
	public String getGuiTexture() {
		return "digcraft:textures/gui/nei/blackhole.png";
	}

	@Override
	public int recipiesPerPage() {
		return 1;
	}
}
