package com.huajiliming.digcraft.nei;

import codechicken.nei.api.API;

public class NEIIntergration {
	public NEIIntergration() {
		API.registerRecipeHandler(new RecipeBlackhole());
		API.registerUsageHandler(new RecipeBlackhole());
		API.registerRecipeHandler(new RecipeSmelter());
		API.registerUsageHandler(new RecipeSmelter());
	}
}
