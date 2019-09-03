package com.huajiliming.digcraft.achievement;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementLoader {
	public static AchievementPage pageDigcraft;
	public static Achievement ruby = factory("ruby", 0, 0, ItemLoader.ruby, null);
	public static Achievement aluminium = factory("aluminium", 2, 0, ItemLoader.aluminium, ruby);
	public static Achievement sulfur = factory("sulfur", 4, 0, ItemLoader.sulfur, aluminium);
	public static Achievement smelter = factory("smelter", 5, 2, BlockLoader.smelter, sulfur);
	public static Achievement depletedUranium = factory("depletedUranium", 6, 4, ItemLoader.depletedUranium, smelter);
	public static Achievement chrome = factory("chrome", 7, 2, ItemLoader.chrome, smelter);
	public static Achievement amethyst = factory("amethyst", 9, 2, ItemLoader.amethyst, chrome);
	public static Achievement iridium = factory("iridium", 10, 4, ItemLoader.iridium, amethyst, true);
	public static Achievement devilStone = factory("devilStone", 12, 5, ItemLoader.devilStone, iridium);
	public static Achievement forgetMetal = factory("forgetMetal", 14, 5, ItemLoader.forgetMetal, devilStone);
	public static Achievement soulBooster = factory("soulBooster", 16, 5, ItemLoader.soulBooster, forgetMetal);
	public static Achievement blackhole = factory("blackhole", 16, 7, ItemLoader.blackhole, soulBooster);
	public static Achievement abyss = factory("abyss", 18, 8, ItemLoader.abyss, blackhole);
	public static Achievement energyCrystal = factory("energyCrystal", 20, 8, ItemLoader.energyCrystal, abyss);
	public static Achievement emberStone = factory("emberStone", 22, 8, ItemLoader.emberStone, energyCrystal);
	public static Achievement battleFury = factory("battleFury", 22, 10, ItemLoader.battleFury, emberStone);
	public static Achievement sunlitAlloy = factory("sunlitAlloy", 24, 8, ItemLoader.sunlitAlloy, emberStone);
	public static Achievement toxic = factory("toxic", 26, 8, ItemLoader.toxic, sunlitAlloy);
	public static Achievement annihilate = factory("annihilate", 28, 8, ItemLoader.annihilate, toxic);
	public static Achievement encourageStone = factory("encourageStone", 30, 9, ItemLoader.encourageStone, annihilate);
	public static Achievement mistarille = factory("mistarille", 32, 9, ItemLoader.mistarille, encourageStone);
	public static Achievement blightStone = factory("blightStone", 33, 11, ItemLoader.blightStone, mistarille, true);
	public static Achievement stygianDesolator = factory("stygianDesolator", 33, 13, ItemLoader.stygianDesolator,
			blightStone);
	public static Achievement glow = factory("glow", 35, 12, ItemLoader.glow, blightStone);
	public static Achievement meteoricSteel = factory("meteoricSteel", 37, 12, ItemLoader.meteoricSteel, glow);
	public static Achievement meteoricSteelHelmet = factory("meteoricSteelHelmet", 37, 14,
			ItemLoader.meteoricSteelHelmet, meteoricSteel);
	public static Achievement space = factory("space", 39, 15, Items.fireworks, meteoricSteelHelmet, true);
	public static Achievement grayJade = factory("grayJade", 39, 12, ItemLoader.grayJade, meteoricSteel);
	public static Achievement grayJadeDagger = factory("grayJadeDagger", 39, 10, ItemLoader.grayJadeDagger, grayJade);
	public static Achievement gloryStone = factory("gloryStone", 41, 12, ItemLoader.gloryStone, grayJade, true);

	public AchievementLoader() {
		pageDigcraft = new AchievementPage("digcraft", ruby, aluminium, sulfur, smelter, depletedUranium, chrome,
				amethyst, iridium, devilStone, forgetMetal, soulBooster, blackhole, abyss, energyCrystal, emberStone,
				battleFury, sunlitAlloy, toxic, annihilate, encourageStone, mistarille, blightStone, stygianDesolator,
				glow, meteoricSteel, meteoricSteelHelmet, space, grayJade, grayJadeDagger, gloryStone);
		AchievementPage.registerAchievementPage(pageDigcraft);
	}

	public static Achievement factory(String id, int x, int y, Item icon, Achievement parent) {
		return factory(id, x, y, icon, parent, false);
	}

	public static Achievement factory(String id, int x, int y, Item icon, Achievement parent, boolean isSpecial) {
		Achievement a = new Achievement("achievement.digcraft." + id, "digcraft." + id, x, y, icon, parent);
		return (isSpecial ? a.setSpecial() : a).registerStat();
	}

	public static Achievement factory(String id, int x, int y, Block icon, Achievement parent) {
		return factory(id, x, y, icon, parent, false);
	}

	public static Achievement factory(String id, int x, int y, Block icon, Achievement parent, boolean isSpecial) {
		Achievement a = new Achievement("achievement.digcraft." + id, "digcraft." + id, x, y, icon, parent);
		return (isSpecial ? a.setSpecial() : a).registerStat();
	}
}
