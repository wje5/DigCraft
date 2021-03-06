package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemLoader {
	public static Item sapphire = new ItemMaterial("sapphire", false, 4, 2247, 9.0F, 4.0F, 16, 6);
	public static Item ruby = new ItemMaterial("ruby", false, 4, 2247, 9.0F, 4.0F, 16, 6);
	public static Item aluminium = new ItemMaterial("aluminium", true, 5, 3268, 10.0F, 5.0F, 22, 7);
	public static Item sulfur = new ItemMaterial("sulfur", false, 6, 3972, 11.0F, 6.0F, 16, 8);
	public static Item chrome = new ItemMaterial("chrome", true, 7, 5375, 12.0F, 7.0F, 22, 9);
	public static Item depletedUranium = new ItemMaterial("depletedUranium", true, 7, 6268, 12.0F, 7.0F, 5, 9);
	public static Item uranium = new ItemMaterial("uranium", true, 7, 6268, 12.0F, 7.0F, 5, 9).setMaxStackSize(1)
			.setMaxDamage(2000);
	public static Item amethyst = new ItemMaterial("amethyst", false, 8, 8768, 13.0F, 8.0F, 16, 10);
	public static Item iridium = new ItemMaterial("iridium", true, 9, 10000, 14.0F, 9.0F, 22, 11);
	public static Item devilStone = new ItemMaterial("devilStone", false, 10, 12000, 15.0F, 10.0F, 28, 12);
	public static Item forgetMetal = new ItemMaterial("forgetMetal", true, 11, 14000, 16.0F, 11.0F, 32, 13);
	public static Item soulBooster = new ItemMaterial("soulBooster", false, 12, 16000, 17.0F, 12.0F, 28, 14);
	public static Item abyss = new ItemMaterial("abyss", true, 13, 18000, 18.0F, 13.0F, 32, 15);
	public static Item chargedAbyss = new ItemMaterial("chargedAbyss", true, 13, 18000, 18.0F, 13.0F, 32, 15);
	public static Item energyCrystal = new ItemMaterial("energyCrystal", false, 14, 20000, 19.0F, 14.0F, 28, 16);
	public static Item emberStone = new ItemMaterial("emberStone", false, 15, 20000, 20.0F, 15.0F, 28, 17);
	public static Item sunlitAlloy = new ItemMaterial("sunlitAlloy", true, 16, 22000, 21.0F, 16.0F, 32, 18);
	public static Item toxic = new ItemMaterial("toxic", true, 17, 24000, 22.0F, 17.0F, 32, 19);
	public static Item annihilate = new ItemMaterial("annihilate", true, 18, 22000, 23.0F, 18.0F, 32, 20);
	public static Item encourageStone = new ItemMaterial("encourageStone", false, 19, 24000, 24.0F, 19.0F, 28, 21);
	public static Item mistarille = new ItemMaterial("mistarille", true, 20, 26000, 25.0F, 20.0F, 32, 22);
	public static Item blightStone = new ItemMaterial("blightStone", false, 21, 28000, 26.0F, 21.0F, 28, 23);
	public static Item glow = new ItemMaterial("glow", true, 22, 30000, 27.0F, 22.0F, 32, 24);
	public static Item meteoricSteel = new ItemMaterial("meteoricSteel", true, 23, 32000, 28.0F, 23.0F, 32, 25);
	public static Item grayJade = new ItemMaterial("grayJade", false, 24, 34000, 29.0F, 24.0F, 28, 26);
	public static Item gloryStone = new ItemMaterial("gloryStone", false, 25, 0, 30.0F, 25.0F, 28, 27);

	public static Item sapphirePickaxe = new ItemMaterialPickaxe((ItemMaterial) sapphire);
	public static Item rubyPickaxe = new ItemMaterialPickaxe((ItemMaterial) ruby);
	public static Item aluminiumPickaxe = new ItemMaterialPickaxe((ItemMaterial) aluminium);
	public static Item sulfurPickaxe = new ItemMaterialPickaxe((ItemMaterial) sulfur);
	public static Item chromePickaxe = new ItemMaterialPickaxe((ItemMaterial) chrome);
	public static Item depletedUraniumPickaxe = new ItemMaterialPickaxe((ItemMaterial) depletedUranium);
	public static Item amethystPickaxe = new ItemMaterialPickaxe((ItemMaterial) amethyst);
	public static Item iridiumPickaxe = new ItemMaterialPickaxe((ItemMaterial) iridium);
	public static Item devilStonePickaxe = new ItemMaterialPickaxe((ItemMaterial) devilStone);
	public static Item forgetMetalPickaxe = new ItemMaterialPickaxe((ItemMaterial) forgetMetal);
	public static Item soulBoosterPickaxe = new ItemMaterialPickaxe((ItemMaterial) soulBooster);
	public static Item abyssPickaxe = new ItemMaterialPickaxe((ItemMaterial) abyss);
	public static Item energyCrystalPickaxe = new ItemMaterialPickaxe((ItemMaterial) energyCrystal);
	public static Item emberStonePickaxe = new ItemMaterialPickaxe((ItemMaterial) emberStone);
	public static Item sunlitAlloyPickaxe = new ItemMaterialPickaxe((ItemMaterial) sunlitAlloy);
	public static Item toxicPickaxe = new ItemMaterialPickaxe((ItemMaterial) toxic);
	public static Item annihilatePickaxe = new ItemMaterialPickaxe((ItemMaterial) annihilate);
	public static Item encourageStonePickaxe = new ItemMaterialPickaxe((ItemMaterial) encourageStone);
	public static Item mistarillePickaxe = new ItemMaterialPickaxe((ItemMaterial) mistarille);
	public static Item blightStonePickaxe = new ItemMaterialPickaxe((ItemMaterial) blightStone);
	public static Item glowPickaxe = new ItemMaterialPickaxe((ItemMaterial) glow);
	public static Item meteoricSteelPickaxe = new ItemMaterialPickaxe((ItemMaterial) meteoricSteel);
	public static Item grayJadePickaxe = new ItemMaterialPickaxe((ItemMaterial) grayJade);
	public static Item gloryStonePickaxe = new ItemMaterialPickaxe((ItemMaterial) gloryStone);

	public static Item sapphireSword = new ItemMaterialSword((ItemMaterial) sapphire);
	public static Item rubySword = new ItemMaterialSword((ItemMaterial) ruby);
	public static Item aluminiumSword = new ItemMaterialSword((ItemMaterial) aluminium);
	public static Item sulfurSword = new ItemMaterialSword((ItemMaterial) sulfur);
	public static Item chromeSword = new ItemMaterialSword((ItemMaterial) chrome);
	public static Item depletedUraniumSword = new ItemMaterialSword((ItemMaterial) depletedUranium);
	public static Item amethystSword = new ItemMaterialSword((ItemMaterial) amethyst);
	public static Item iridiumSword = new ItemMaterialSword((ItemMaterial) iridium);
	public static Item devilStoneSword = new ItemMaterialSword((ItemMaterial) devilStone);
	public static Item forgetMetalSword = new ItemMaterialSword((ItemMaterial) forgetMetal);
	public static Item soulBoosterSword = new ItemMaterialSword((ItemMaterial) soulBooster);
	public static Item abyssSword = new ItemMaterialSword((ItemMaterial) abyss);
	public static Item energyCrystalSword = new ItemMaterialSword((ItemMaterial) energyCrystal);
	public static Item emberStoneSword = new ItemMaterialSword((ItemMaterial) emberStone);
	public static Item sunlitAlloySword = new ItemMaterialSword((ItemMaterial) sunlitAlloy);
	public static Item toxicSword = new ItemMaterialSword((ItemMaterial) toxic);
	public static Item annihilateSword = new ItemMaterialSword((ItemMaterial) annihilate);
	public static Item encourageStoneSword = new ItemMaterialSword((ItemMaterial) encourageStone);
	public static Item mistarilleSword = new ItemMaterialSword((ItemMaterial) mistarille);
	public static Item blightStoneSword = new ItemMaterialSword((ItemMaterial) blightStone);
	public static Item glowSword = new ItemMaterialSword((ItemMaterial) glow);
	public static Item meteoricSteelSword = new ItemMaterialSword((ItemMaterial) meteoricSteel);
	public static Item grayJadeSword = new ItemMaterialSword((ItemMaterial) grayJade);
	public static Item gloryStoneSword = new ItemMaterialSword((ItemMaterial) gloryStone);

	public static Item sapphireAxe = new ItemMaterialAxe((ItemMaterial) sapphire);
	public static Item rubyAxe = new ItemMaterialAxe((ItemMaterial) ruby);
	public static Item aluminiumAxe = new ItemMaterialAxe((ItemMaterial) aluminium);
	public static Item sulfurAxe = new ItemMaterialAxe((ItemMaterial) sulfur);
	public static Item chromeAxe = new ItemMaterialAxe((ItemMaterial) chrome);
	public static Item depletedUraniumAxe = new ItemMaterialAxe((ItemMaterial) depletedUranium);
	public static Item amethystAxe = new ItemMaterialAxe((ItemMaterial) amethyst);
	public static Item iridiumAxe = new ItemMaterialAxe((ItemMaterial) iridium);
	public static Item devilStoneAxe = new ItemMaterialAxe((ItemMaterial) devilStone);
	public static Item forgetMetalAxe = new ItemMaterialAxe((ItemMaterial) forgetMetal);
	public static Item soulBoosterAxe = new ItemMaterialAxe((ItemMaterial) soulBooster);
	public static Item abyssAxe = new ItemMaterialAxe((ItemMaterial) abyss);
	public static Item energyCrystalAxe = new ItemMaterialAxe((ItemMaterial) energyCrystal);
	public static Item emberStoneAxe = new ItemMaterialAxe((ItemMaterial) emberStone);
	public static Item sunlitAlloyAxe = new ItemMaterialAxe((ItemMaterial) sunlitAlloy);
	public static Item toxicAxe = new ItemMaterialAxe((ItemMaterial) toxic);
	public static Item annihilateAxe = new ItemMaterialAxe((ItemMaterial) annihilate);
	public static Item encourageStoneAxe = new ItemMaterialAxe((ItemMaterial) encourageStone);
	public static Item mistarilleAxe = new ItemMaterialAxe((ItemMaterial) mistarille);
	public static Item blightStoneAxe = new ItemMaterialAxe((ItemMaterial) blightStone);
	public static Item glowAxe = new ItemMaterialAxe((ItemMaterial) glow);
	public static Item meteoricSteelAxe = new ItemMaterialAxe((ItemMaterial) meteoricSteel);
	public static Item grayJadeAxe = new ItemMaterialAxe((ItemMaterial) grayJade);
	public static Item gloryStoneAxe = new ItemMaterialAxe((ItemMaterial) gloryStone);

	public static Item sapphireHoe = new ItemMaterialHoe((ItemMaterial) sapphire);
	public static Item rubyHoe = new ItemMaterialHoe((ItemMaterial) ruby);
	public static Item aluminiumHoe = new ItemMaterialHoe((ItemMaterial) aluminium);
	public static Item sulfurHoe = new ItemMaterialHoe((ItemMaterial) sulfur);
	public static Item chromeHoe = new ItemMaterialHoe((ItemMaterial) chrome);
	public static Item depletedUraniumHoe = new ItemMaterialHoe((ItemMaterial) depletedUranium);
	public static Item amethystHoe = new ItemMaterialHoe((ItemMaterial) amethyst);
	public static Item iridiumHoe = new ItemMaterialHoe((ItemMaterial) iridium);
	public static Item devilStoneHoe = new ItemMaterialHoe((ItemMaterial) devilStone);
	public static Item forgetMetalHoe = new ItemMaterialHoe((ItemMaterial) forgetMetal);
	public static Item soulBoosterHoe = new ItemMaterialHoe((ItemMaterial) soulBooster);
	public static Item abyssHoe = new ItemMaterialHoe((ItemMaterial) abyss);
	public static Item energyCrystalHoe = new ItemMaterialHoe((ItemMaterial) energyCrystal);
	public static Item emberStoneHoe = new ItemMaterialHoe((ItemMaterial) emberStone);
	public static Item sunlitAlloyHoe = new ItemMaterialHoe((ItemMaterial) sunlitAlloy);
	public static Item toxicHoe = new ItemMaterialHoe((ItemMaterial) toxic);
	public static Item annihilateHoe = new ItemMaterialHoe((ItemMaterial) annihilate);
	public static Item encourageStoneHoe = new ItemMaterialHoe((ItemMaterial) encourageStone);
	public static Item mistarilleHoe = new ItemMaterialHoe((ItemMaterial) mistarille);
	public static Item blightStoneHoe = new ItemMaterialHoe((ItemMaterial) blightStone);
	public static Item glowHoe = new ItemMaterialHoe((ItemMaterial) glow);
	public static Item meteoricSteelHoe = new ItemMaterialHoe((ItemMaterial) meteoricSteel);
	public static Item grayJadeHoe = new ItemMaterialHoe((ItemMaterial) grayJade);
	public static Item gloryStoneHoe = new ItemMaterialHoe((ItemMaterial) gloryStone);

	public static Item sapphireShovel = new ItemMaterialShovel((ItemMaterial) sapphire);
	public static Item rubyShovel = new ItemMaterialShovel((ItemMaterial) ruby);
	public static Item aluminiumShovel = new ItemMaterialShovel((ItemMaterial) aluminium);
	public static Item sulfurShovel = new ItemMaterialShovel((ItemMaterial) sulfur);
	public static Item chromeShovel = new ItemMaterialShovel((ItemMaterial) chrome);
	public static Item depletedUraniumShovel = new ItemMaterialShovel((ItemMaterial) depletedUranium);
	public static Item amethystShovel = new ItemMaterialShovel((ItemMaterial) amethyst);
	public static Item iridiumShovel = new ItemMaterialShovel((ItemMaterial) iridium);
	public static Item devilStoneShovel = new ItemMaterialShovel((ItemMaterial) devilStone);
	public static Item forgetMetalShovel = new ItemMaterialShovel((ItemMaterial) forgetMetal);
	public static Item soulBoosterShovel = new ItemMaterialShovel((ItemMaterial) soulBooster);
	public static Item abyssShovel = new ItemMaterialShovel((ItemMaterial) abyss);
	public static Item energyCrystalShovel = new ItemMaterialShovel((ItemMaterial) energyCrystal);
	public static Item emberStoneShovel = new ItemMaterialShovel((ItemMaterial) emberStone);
	public static Item sunlitAlloyShovel = new ItemMaterialShovel((ItemMaterial) sunlitAlloy);
	public static Item toxicShovel = new ItemMaterialShovel((ItemMaterial) toxic);
	public static Item annihilateShovel = new ItemMaterialShovel((ItemMaterial) annihilate);
	public static Item encourageStoneShovel = new ItemMaterialShovel((ItemMaterial) encourageStone);
	public static Item mistarilleShovel = new ItemMaterialShovel((ItemMaterial) mistarille);
	public static Item blightStoneShovel = new ItemMaterialShovel((ItemMaterial) blightStone);
	public static Item glowShovel = new ItemMaterialShovel((ItemMaterial) glow);
	public static Item meteoricSteelShovel = new ItemMaterialShovel((ItemMaterial) meteoricSteel);
	public static Item grayJadeShovel = new ItemMaterialShovel((ItemMaterial) grayJade);
	public static Item gloryStoneShovel = new ItemMaterialShovel((ItemMaterial) gloryStone);

	public static Item debugger = new ItemDebugger();
	public static Item abyssKey = new ItemAbyssKey();
	public static Item blackhole = new ItemBlackhole();
	public static Item grayJadeDagger = new ItemGrayJadeDagger();
	public static Item stygianDesolator = new ItemStygianDesolator();
	public static Item battleFury = new ItemBattleFury();
	public static Item meteoricSteelHelmet = new ItemArmorRocket.Helmet();
	public static Item meteoricSteelChestplate = new ItemArmorRocket.Chestplate();
	public static Item meteoricSteelLeggings = new ItemArmorRocket.Leggings();
	public static Item meteoricSteelBoots = new ItemArmorRocket.Boots();
	public static Item hammer = new ItemHammer().setUnlocalizedName("hammer").setTextureName("digcraft:hammer")
			.setMaxStackSize(1).setMaxDamage(9).setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item ironHammer = new ItemHammer().setUnlocalizedName("ironHammer")
			.setTextureName("digcraft:ironHammer").setMaxStackSize(1).setMaxDamage(249)
			.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item graphite = new ItemMaterial("graphite", true, 2, 0, 0.0F, 0.0F, 0, 4);
	public static Item sagger = new Item().setUnlocalizedName("sagger").setTextureName("digcraft:sagger")
			.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item fireBrick = new Item().setUnlocalizedName("fireBrick").setTextureName("digcraft:fireBrick")
			.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item crucibleSpoon = new ItemCrucibleSpoon();
	public static Item clayMold = new Item().setUnlocalizedName("clayMold").setTextureName("digcraft:clayMold")
			.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item ceramicMold = new Item().setUnlocalizedName("ceramicMold").setTextureName("digcraft:ceramicMold")
			.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Item longSofa = new ItemLongSofa();
	public static Item longTable = new ItemLongTable();
	public static Item diningTable = new ItemDiningTable();
	public static Item diningChair = new ItemDiningChair();
	public static Item desk = new ItemDesk();
	public static Item pan = new ItemPan();
	public static Item gasCylinder = new ItemGasCylinder();
	public static Item ATaleOfTwoCities = new ItemStandardBook("ATaleOfTwoCities");
	public static Item fridge = new ItemFridge();
	public static Item tv = new ItemTV();
	public static Item paintBrush = new ItemPaintBrush();
	public static Item airConditioner = new ItemAirConditioner();
	public static Item cabinetAirConditioner = new ItemCabinetAirConditioner();
	public static Item bathtub = new ItemBathtub();
	public static Item glassDoor = new ItemGlassDoor();
	public static Item washBasin = new ItemWashBasin();
	public static Item microPhone = new ItemMicroPhone();
	public static Item speaker = new ItemSpeaker();

	public ItemLoader(FMLPreInitializationEvent event) {
		register(sapphire);
		register(ruby);
		register(aluminium);
		register(sulfur);
		register(chrome);
		register(depletedUranium);
		register(uranium);
		register(amethyst);
		register(iridium);
		register(devilStone);
		register(forgetMetal);
		register(soulBooster);
		register(abyss);
		register(energyCrystal);
		register(emberStone);
		register(sunlitAlloy);
		register(toxic);
		register(annihilate);
		register(encourageStone);
		register(mistarille);
		register(blightStone);
		register(glow);
		register(meteoricSteel);
		register(grayJade);
		register(gloryStone);

		register(sapphirePickaxe);
		register(rubyPickaxe);
		register(aluminiumPickaxe);
		register(sulfurPickaxe);
		register(chromePickaxe);
		register(depletedUraniumPickaxe);
		register(amethystPickaxe);
		register(iridiumPickaxe);
		register(devilStonePickaxe);
		register(forgetMetalPickaxe);
		register(soulBoosterPickaxe);
		register(abyssPickaxe);
		register(energyCrystalPickaxe);
		register(emberStonePickaxe);
		register(sunlitAlloyPickaxe);
		register(toxicPickaxe);
		register(annihilatePickaxe);
		register(encourageStonePickaxe);
		register(mistarillePickaxe);
		register(blightStonePickaxe);
		register(glowPickaxe);
		register(meteoricSteelPickaxe);
		register(grayJadePickaxe);
		register(gloryStonePickaxe);

		register(sapphireSword);
		register(rubySword);
		register(aluminiumSword);
		register(sulfurSword);
		register(chromeSword);
		register(depletedUraniumSword);
		register(amethystSword);
		register(iridiumSword);
		register(devilStoneSword);
		register(forgetMetalSword);
		register(soulBoosterSword);
		register(abyssSword);
		register(energyCrystalSword);
		register(emberStoneSword);
		register(sunlitAlloySword);
		register(toxicSword);
		register(annihilateSword);
		register(encourageStoneSword);
		register(mistarilleSword);
		register(blightStoneSword);
		register(glowSword);
		register(meteoricSteelSword);
		register(grayJadeSword);
		register(gloryStoneSword);

		register(sapphireAxe);
		register(rubyAxe);
		register(aluminiumAxe);
		register(sulfurAxe);
		register(chromeAxe);
		register(depletedUraniumAxe);
		register(amethystAxe);
		register(iridiumAxe);
		register(devilStoneAxe);
		register(forgetMetalAxe);
		register(soulBoosterAxe);
		register(abyssAxe);
		register(energyCrystalAxe);
		register(emberStoneAxe);
		register(sunlitAlloyAxe);
		register(toxicAxe);
		register(annihilateAxe);
		register(encourageStoneAxe);
		register(mistarilleAxe);
		register(blightStoneAxe);
		register(glowAxe);
		register(meteoricSteelAxe);
		register(grayJadeAxe);
		register(gloryStoneAxe);

		register(sapphireHoe);
		register(rubyHoe);
		register(aluminiumHoe);
		register(sulfurHoe);
		register(chromeHoe);
		register(depletedUraniumHoe);
		register(amethystHoe);
		register(iridiumHoe);
		register(devilStoneHoe);
		register(forgetMetalHoe);
		register(soulBoosterHoe);
		register(abyssHoe);
		register(energyCrystalHoe);
		register(emberStoneHoe);
		register(sunlitAlloyHoe);
		register(toxicHoe);
		register(annihilateHoe);
		register(encourageStoneHoe);
		register(mistarilleHoe);
		register(blightStoneHoe);
		register(glowHoe);
		register(meteoricSteelHoe);
		register(grayJadeHoe);
		register(gloryStoneHoe);

		register(sapphireShovel);
		register(rubyShovel);
		register(aluminiumShovel);
		register(sulfurShovel);
		register(chromeShovel);
		register(depletedUraniumShovel);
		register(amethystShovel);
		register(iridiumShovel);
		register(devilStoneShovel);
		register(forgetMetalShovel);
		register(soulBoosterShovel);
		register(abyssShovel);
		register(energyCrystalShovel);
		register(emberStoneShovel);
		register(sunlitAlloyShovel);
		register(toxicShovel);
		register(annihilateShovel);
		register(encourageStoneShovel);
		register(mistarilleShovel);
		register(blightStoneShovel);
		register(glowShovel);
		register(meteoricSteelShovel);
		register(grayJadeShovel);
		register(gloryStoneShovel);

		register(debugger);
		register(abyssKey);
		register(blackhole);
		register(grayJadeDagger);
		register(stygianDesolator);
		register(battleFury);
		register(meteoricSteelHelmet);
		register(meteoricSteelChestplate);
		register(meteoricSteelLeggings);
		register(meteoricSteelBoots);
		register(hammer);
		register(ironHammer);
		register(graphite);
		register(sagger);
		register(fireBrick);
		register(crucibleSpoon);
		register(clayMold);
		register(ceramicMold);
		register(longSofa);
		register(longTable);
		register(diningTable);
		register(diningChair);
		register(desk);
		register(pan);
		register(gasCylinder);
		register(ATaleOfTwoCities);
		register(fridge);
		register(tv);
		register(paintBrush);
		register(airConditioner);
		register(cabinetAirConditioner);
		register(bathtub);
		register(glassDoor);
		register(washBasin);
		register(microPhone);
		register(speaker);
	}

	private static void register(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}