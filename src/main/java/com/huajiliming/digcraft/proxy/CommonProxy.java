package com.huajiliming.digcraft.proxy;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.config.ConfigLoader;
import com.huajiliming.digcraft.crafting.CraftingLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.entity.EntityLoader;
import com.huajiliming.digcraft.event.EventLoader;
import com.huajiliming.digcraft.fluid.FluidLoader;
import com.huajiliming.digcraft.inventory.GuiElementLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.network.NetworkHandler;
import com.huajiliming.digcraft.potioneffect.PotionLoader;
import com.huajiliming.digcraft.tileentity.TileEntityLoader;
import com.huajiliming.digcraft.world.gen.EndGenHandler;
import com.huajiliming.digcraft.world.gen.RadiationCityGenHandler;
import com.huajiliming.digcrafta.achievement.AchievementLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigLoader(event);
		new CreativeTabsLoader(event);
		new FluidLoader(event);
		new BlockLoader(event);
		new ItemLoader(event);
		new PotionLoader(event);
		new TileEntityLoader(event);
		new EntityLoader();
	}

	public void init(FMLInitializationEvent event) {
		new CraftingLoader();
		new AchievementLoader();
		new NetworkHandler();
		new EventLoader();
		GameRegistry.registerWorldGenerator(new EndGenHandler(), 1);
		GameRegistry.registerWorldGenerator(new RadiationCityGenHandler(), Integer.MAX_VALUE);
		new GuiElementLoader();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}