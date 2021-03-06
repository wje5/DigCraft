package com.huajiliming.digcraft.config;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigLoader {
	private static Configuration config;
	private static Logger logger;
	public static boolean canBlackholeSuckEntity;
	public static boolean canBlackholeSuckBlock;
	public static boolean canBlackholeLightning;
	public static boolean canBlackholeFrozen;
	public static boolean enableNoBlackholeMode;
	public static int recBufferSize;

	public ConfigLoader(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		load();
	}

	public static void load() {
		logger.info("Started loading config. ");

		String comment = "Can Blackhole suck Entity.";
		canBlackholeSuckEntity = config.get("general", "canBlackholeSuckEntity", true, comment).getBoolean();

		comment = "Can Blackhole suck Block.";
		canBlackholeSuckBlock = config.get("general", "canBlackholeSuckBlock", true, comment).getBoolean();

		comment = "Can Blackhole Lighting.";
		canBlackholeLightning = config.get("general", "canBlackholeLightning", true, comment).getBoolean();

		comment = "Can Blackhole Frozen.";
		canBlackholeFrozen = config.get("general", "canBlackholeFrozen", true, comment).getBoolean();

		comment = "Enable No Blackhole Mode.";
		enableNoBlackholeMode = config.get("general", "enableNoBlackholeMode", false, comment).getBoolean();

		comment = "Record buffer size (byte).";
		recBufferSize = config.get("general", "enableNoBlackholeMode", 1024, comment).getInt();

		config.save();
		logger.info("Finished loading config. ");
	}

	public static Logger logger() {
		return logger;
	}
}