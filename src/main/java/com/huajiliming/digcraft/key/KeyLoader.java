package com.huajiliming.digcraft.key;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyLoader {
	public static KeyBinding increaseThrust;
	public static KeyBinding decreaseThrust;

	public KeyLoader() {
		increaseThrust = new KeyBinding("key.digcraft.increaseThrust", Keyboard.KEY_F, "key.categories.digcraft");
		decreaseThrust = new KeyBinding("key.digcraft.decreaseThrust", Keyboard.KEY_V, "key.categories.digcraft");
		ClientRegistry.registerKeyBinding(increaseThrust);
		ClientRegistry.registerKeyBinding(decreaseThrust);
	}
}
