package com.huajiliming.digcraft.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
	public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("digcraft");
	public static int nextId = 0;

	public NetworkHandler() {
		instance.registerMessage(MessageKeyboardInput.PocketHandler.class, MessageKeyboardInput.class, nextId++,
				Side.SERVER);
		instance.registerMessage(MessageBookPage.PocketHandler.class, MessageBookPage.class, nextId++, Side.SERVER);
		instance.registerMessage(MessageSoundDataToServer.PocketHandler.class, MessageSoundDataToServer.class, nextId++,
				Side.SERVER);
		instance.registerMessage(MessageSoundDataToClient.PocketHandler.class, MessageSoundDataToClient.class, nextId++,
				Side.CLIENT);
	}
}
