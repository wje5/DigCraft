package com.huajiliming.digcraft.proxy;

import com.huajiliming.digcraft.RecordHelper;
import com.huajiliming.digcraft.key.KeyLoader;
import com.huajiliming.digcraft.nei.NEIIntergration;
import com.huajiliming.digcraft.render.RenderLoader;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		new RenderLoader();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		new KeyLoader();
		if (Loader.isModLoaded("NotEnoughItems")) {
			new NEIIntergration();
		}
		RecordHelper.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}