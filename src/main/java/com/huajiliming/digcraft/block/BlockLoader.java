package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.item.ItemMaterial;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader {
	public static Block sapphireOre = new BlockMaterialOre((ItemMaterial) ItemLoader.sapphire);
	public static Block rubyOre = new BlockMaterialOre((ItemMaterial) ItemLoader.ruby);
	public static Block aluminiumOre = new BlockMaterialOre((ItemMaterial) ItemLoader.aluminium);
	public static Block sulfurOre = new BlockMaterialOre((ItemMaterial) ItemLoader.sulfur);
	public static Block chromeOre = new BlockMaterialOre((ItemMaterial) ItemLoader.chrome);
	public static Block uraniumOre = new BlockMaterialOre((ItemMaterial) ItemLoader.uranium);
	public static Block amethystOre = new BlockMaterialOre((ItemMaterial) ItemLoader.amethyst);
	public static Block iridiumOre = new BlockMaterialOre((ItemMaterial) ItemLoader.iridium);
	public static Block graphiteOre = new BlockMaterialOre((ItemMaterial) ItemLoader.graphite);
	public static Block devilStoneOre = new BlockMaterialOre((ItemMaterial) ItemLoader.devilStone);
	public static Block forgetMetalOre = new BlockMaterialOre((ItemMaterial) ItemLoader.forgetMetal);
	public static Block soulBoosterOre = new BlockMaterialOre((ItemMaterial) ItemLoader.soulBooster);
	public static Block abyssOre = new BlockMaterialOre((ItemMaterial) ItemLoader.abyss);
	public static Block chargedAbyssOre = new BlockMaterialOre((ItemMaterial) ItemLoader.chargedAbyss);
	public static Block energyCrystalOre = new BlockMaterialOre((ItemMaterial) ItemLoader.energyCrystal);
	public static Block emberStoneOre = new BlockMaterialOre((ItemMaterial) ItemLoader.emberStone);
	public static Block sunlitAlloyOre = new BlockMaterialOre((ItemMaterial) ItemLoader.sunlitAlloy);
	public static Block toxicOre = new BlockMaterialOre((ItemMaterial) ItemLoader.toxic);
	public static Block annihilateOre = new BlockMaterialOre((ItemMaterial) ItemLoader.annihilate);
	public static Block encourageStoneOre = new BlockMaterialOre((ItemMaterial) ItemLoader.encourageStone);
	public static Block mistarilleOre = new BlockMaterialOre((ItemMaterial) ItemLoader.mistarille);
	public static Block blightStoneOre = new BlockMaterialOre((ItemMaterial) ItemLoader.blightStone);
	public static Block glowOre = new BlockMaterialOre((ItemMaterial) ItemLoader.glow);
	public static Block meteoricSteelOre = new BlockMaterialOre((ItemMaterial) ItemLoader.meteoricSteel);
	public static Block grayJadeOre = new BlockMaterialOre((ItemMaterial) ItemLoader.grayJade);
	public static Block gloryStoneOre = new BlockMaterialOre((ItemMaterial) ItemLoader.gloryStone);

	public static Block sapphireBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.sapphire);
	public static Block rubyBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.ruby);
	public static Block aluminiumBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.aluminium);
	public static Block sulfurBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.sulfur);
	public static Block chromeBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.chrome);
	public static Block depletedUraniumBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.depletedUranium);
	public static Block amethystBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.amethyst);
	public static Block iridiumBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.iridium);
	public static Block devilStoneBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.devilStone);
	public static Block forgetMetalBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.forgetMetal);
	public static Block soulBoosterBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.soulBooster);
	public static Block abyssBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.abyss);
	public static Block energyCrystalBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.energyCrystal);
	public static Block emberStoneBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.emberStone);
	public static Block sunlitAlloyBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.sunlitAlloy);
	public static Block toxicBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.toxic);
	public static Block annihilateBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.annihilate);
	public static Block encourageStoneBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.encourageStone);
	public static Block mistarilleBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.mistarille);
	public static Block blightStoneBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.blightStone);
	public static Block glowBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.glow);
	public static Block meteoricSteelBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.meteoricSteel);
	public static Block grayJadeBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.grayJade);
	public static Block gloryStoneBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.gloryStone);

	public static Block smelter = new BlockSmelter();
	public static Block ritualStructureBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.forgetMetal,
			"ritualStructureBlock");
	public static Block ritualCoreBlock = new BlockMaterialBlock((ItemMaterial) ItemLoader.forgetMetal,
			"ritualCoreBlock");
	public static Block crucible = new BlockCrucible();
	public static Block burningBox = new BlockBurningBox().setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Block burningBoxLight = new BlockBurningBox().setLightLevel(0.875F);
	public static Block fireBrickBlock = new StandardBlock("fireBrickBlock", Material.clay);
	public static Block fluidMeltIron = new BlockFluidMeltIron();
	public static Block castingTable = new BlockCastingTable();
	public static Block concrete = new StandardBlock("concrete", Material.rock).setHardness(2.0F).setResistance(10.0F);
	public static Block pitch = new StandardBlock("pitch", Material.rock).setHardness(2.0F).setResistance(10.0F);
	public static Block roadDotted = new BlockRoadDotted();
	public static Block roadSideLine = new BlockRoadSideLine();
	public static Block roadYellowLine = new BlockRoadYellowLine();
	public static Block puttyWall = new BlockPuttyWall();
	public static Block putty = new StandardBlock("puttyWall", Material.rock).setHardness(2.0F).setResistance(10.0F);
	public static Block littleSofa = new BlockLittleSofa();
	public static Block longSofa = new BlockLongSofa();
	public static Block longTable = new BlockLongTable();
	public static Block doorbell = new BlockDoorbell();
	public static Block shoeArc = new BlockShoeArc();
	public static Block bedsideTable = new BlockBedsideTable();
	public static Block diningTable = new BlockDiningTable();
	public static Block diningChair = new BlockDiningChair();
	public static Block fluorescentLamp = new BlockFluorescentLamp().setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Block fluorescentLampLight = new BlockFluorescentLamp().setLightLevel(1.0F);
	public static Block desk = new BlockDesk();
	public static Block toilet = new BlockToilet();
	public static Block ambry = new BlockAmbry();
	public static Block gasBurner = new BlockGasBurner();
	public static Block fridge = new BlockFridge();
	public static Block tv = new BlockTV();
	public static Block spotLightSmall = new BlockSpotLightSmall().setCreativeTab(CreativeTabsLoader.tabDigcraft);
	public static Block spotLightSmallLight = new BlockSpotLightSmall().setLightLevel(1.0F);
	public static Block airConditioner = new BlockAirConditioner();
	public static Block cabinetAirConditioner = new BlockCabinetAirConditioner();
	public static Block bathtub = new BlockBathtub();
	public static Block glassDoor = new BlockGlassDoor();

	public BlockLoader(FMLPreInitializationEvent event) {
		register(sapphireOre);
		register(rubyOre);
		register(aluminiumOre);
		register(sulfurOre);
		register(chromeOre);
		register(uraniumOre);
		register(amethystOre);
		register(iridiumOre);
		register(graphiteOre);
		register(devilStoneOre);
		register(forgetMetalOre);
		register(soulBoosterOre);
		register(abyssOre);
		register(chargedAbyssOre);
		register(energyCrystalOre);
		register(emberStoneOre);
		register(sunlitAlloyOre);
		register(toxicOre);
		register(annihilateOre);
		register(encourageStoneOre);
		register(mistarilleOre);
		register(blightStoneOre);
		register(glowOre);
		register(meteoricSteelOre);
		register(grayJadeOre);
		register(gloryStoneOre);

		register(sapphireBlock);
		register(rubyBlock);
		register(aluminiumBlock);
		register(sulfurBlock);
		register(chromeBlock);
		register(depletedUraniumBlock);
		register(amethystBlock);
		register(iridiumBlock);
		register(devilStoneBlock);
		register(forgetMetalBlock);
		register(soulBoosterBlock);
		register(abyssBlock);
		register(energyCrystalBlock);
		register(emberStoneBlock);
		register(sunlitAlloyBlock);
		register(toxicBlock);
		register(annihilateBlock);
		register(encourageStoneBlock);
		register(mistarilleBlock);
		register(blightStoneBlock);
		register(glowBlock);
		register(meteoricSteelBlock);
		register(grayJadeBlock);
		register(gloryStoneBlock);

		register(smelter);
		register(ritualStructureBlock);
		register(ritualCoreBlock);
		register(crucible);
		register(burningBox);
		register(burningBoxLight, "burningBoxLight");
		register(fireBrickBlock);
		register(fluidMeltIron);
		register(castingTable);
		register(concrete);
		register(pitch);
		register(roadDotted);
		register(roadSideLine);
		register(roadYellowLine);
		register(puttyWall);
		register(putty, "putty");
		register(littleSofa);
		register(longSofa);
		register(longTable);
		register(doorbell);
		register(shoeArc);
		register(bedsideTable);
		register(diningTable);
		register(diningChair);
		register(fluorescentLamp);
		register(fluorescentLampLight, "fluorescentLampLight");
		register(desk);
		register(toilet);
		register(ambry);
		register(gasBurner);
		register(fridge);
		register(tv);
		register(spotLightSmall);
		register(spotLightSmallLight, "spotLightSmallLight");
		register(airConditioner);
		register(cabinetAirConditioner);
		register(bathtub);
		register(glassDoor);
	}

	private static void register(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}

	private static void register(Block block, String id) {
		GameRegistry.registerBlock(block, id);
	}
}