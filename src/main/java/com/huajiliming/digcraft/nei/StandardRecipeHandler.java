package com.huajiliming.digcraft.nei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.util.Pair;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public abstract class StandardRecipeHandler extends TemplateRecipeHandler {
	public abstract String getUnlocatedName();

	public abstract HashMap<ItemStack, ItemStack[]> getRecipeList();

	public abstract String getRecipeId();

	@Override
	public String getRecipeName() {
		return I18n.format("nei.recipe." + this.getUnlocatedName() + ".name");
	}

	public abstract ArrayList<Pair<Integer, Integer>> getPositions();

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals(this.getRecipeId())) {
			for (Entry<ItemStack, ItemStack[]> entry : this.getRecipeList().entrySet()) {
				if (NEIServerUtils.areStacksSameTypeCrafting(entry.getKey(), (ItemStack) results[0])) {
					PositionedStack[] stacks = new PositionedStack[entry.getValue().length];
					for (int i = 0; i < entry.getValue().length; i++) {
						stacks[i] = new PositionedStack(entry.getValue()[i], this.getPositions().get(i + 1).first(),
								this.getPositions().get(i + 1).second());
					}
					this.arecipes.add(new StandardRecipe(new PositionedStack(entry.getKey(),
							this.getPositions().get(0).first(), this.getPositions().get(0).second()), stacks));
				}
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		for (Entry<ItemStack, ItemStack[]> entry : this.getRecipeList().entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(entry.getKey(), result)) {
				PositionedStack[] stacks = new PositionedStack[entry.getValue().length];
				for (int i = 0; i < entry.getValue().length; i++) {
					stacks[i] = new PositionedStack(entry.getValue()[i], this.getPositions().get(i + 1).first(),
							this.getPositions().get(i + 1).second());
				}
				this.arecipes.add(new StandardRecipe(new PositionedStack(entry.getKey(),
						this.getPositions().get(0).first(), this.getPositions().get(0).second()), stacks));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals(this.getRecipeId())) {
			for (Entry<ItemStack, ItemStack[]> entry : this.getRecipeList().entrySet()) {
				PositionedStack[] stacks = new PositionedStack[entry.getValue().length];
				for (int i = 0; i < entry.getValue().length; i++) {
					stacks[i] = new PositionedStack(entry.getValue()[i], this.getPositions().get(i + 1).first(),
							this.getPositions().get(i + 1).second());
				}
				this.arecipes.add(new StandardRecipe(new PositionedStack(entry.getKey(),
						this.getPositions().get(0).first(), this.getPositions().get(0).second()), stacks));
			}
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		for (Entry<ItemStack, ItemStack[]> entry : this.getRecipeList().entrySet()) {
			for (ItemStack stack : entry.getValue()) {
				if (NEIServerUtils.areStacksSameTypeCrafting(stack, ingredient)) {
					PositionedStack[] stacks = new PositionedStack[entry.getValue().length];
					for (int i = 0; i < entry.getValue().length; i++) {
						stacks[i] = new PositionedStack(entry.getValue()[i], this.getPositions().get(i + 1).first(),
								this.getPositions().get(i + 1).second());
					}
					this.arecipes.add(new StandardRecipe(new PositionedStack(entry.getKey(),
							this.getPositions().get(0).first(), this.getPositions().get(0).second()), stacks));
				}
			}
		}
		super.loadUsageRecipes(ingredient);
	}

	@Override
	public void drawBackground(int recipe) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiDraw.changeTexture(this.getGuiTexture());
		GuiDraw.drawTexturedModalRect(0, 0, 0, 0, 166, this.recipiesPerPage() == 2 ? 65 : 115);
	}

	public class StandardRecipe extends CachedRecipe {
		private final PositionedStack[] inputs;
		private final PositionedStack output;

		public StandardRecipe(PositionedStack output, PositionedStack... inputs) {
			this.output = output;
			this.inputs = inputs;
		}

		@Override
		public List<PositionedStack> getIngredients() {
			return Arrays.asList(this.inputs);
		}

		@Override
		public PositionedStack getResult() {
			return this.output;
		}
	}
}
