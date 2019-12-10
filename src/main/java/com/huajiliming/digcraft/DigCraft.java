package com.huajiliming.digcraft;

import com.huajiliming.digcraft.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "digcraft", name = "Dig Craft", version = "@version@", acceptedMinecraftVersions = "1.7.10", dependencies = "after:NotEnoughItems;required-after:maplelib")
public class DigCraft {
	public static final String MODID = "digcraft";
	public static final String NAME = "Dig Craft";
	public static final String VERSION = "1.4.3";

	@Instance("digcraft")
	public static DigCraft instance;

	@SidedProxy(clientSide = "com.huajiliming.digcraft.proxy.ClientProxy", serverSide = "com.huajiliming.digcraft.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}