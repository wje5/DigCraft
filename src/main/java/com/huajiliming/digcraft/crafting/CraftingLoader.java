package com.huajiliming.digcraft.crafting;

import java.util.Iterator;
import java.util.Map;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.config.ConfigLoader;
import com.huajiliming.digcraft.item.ItemLoader;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class CraftingLoader {
	public CraftingLoader() {
		registerRecipe();
		registerSmelting();
	}

	private static void registerRecipe() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sapphirePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.sapphire, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.rubyPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.ruby, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.aluminiumPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.aluminium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sulfurPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.sulfur, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chromePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.chrome, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.depletedUraniumPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.depletedUranium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.amethystPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.amethyst, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.iridiumPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.iridium, '*', Items.stick }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.devilStonePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.devilStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.forgetMetalPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.forgetMetal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.soulBoosterPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.soulBooster, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.abyss, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.energyCrystalPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.energyCrystal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.emberStonePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.emberStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.sunlitAlloyPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.sunlitAlloy, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toxicPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.toxic, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.annihilatePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.annihilate, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.encourageStonePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.encourageStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.mistarillePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.mistarille, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blightStonePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.blightStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.glowPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.glow, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelPickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.meteoricSteel, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.gloryStonePickaxe),
				new Object[] { "###", " * ", " * ", '#', ItemLoader.gloryStone, '*', Items.stick });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sapphireSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.sapphire, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.rubySword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.ruby, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.aluminiumSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.aluminium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sulfurSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.sulfur, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chromeSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.chrome, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.depletedUraniumSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.depletedUranium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.amethystSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.amethyst, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.iridiumSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.iridium, '*', Items.stick }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.devilStoneSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.devilStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.forgetMetalSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.forgetMetal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.soulBoosterSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.soulBooster, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.abyss, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.energyCrystalSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.energyCrystal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.emberStoneSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.emberStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.sunlitAlloySword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.sunlitAlloy, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toxicSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.toxic, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.annihilateSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.annihilate, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.encourageStoneSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.encourageStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.mistarilleSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.mistarille, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blightStoneSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.blightStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.glowSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.glow, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.meteoricSteel, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadeSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.gloryStoneSword),
				new Object[] { " # ", " # ", " * ", '#', ItemLoader.gloryStone, '*', Items.stick });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sapphireAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.sapphire, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.rubyAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.ruby, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.aluminiumAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.aluminium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sulfurAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.sulfur, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chromeAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.chrome, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.depletedUraniumAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.depletedUranium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.amethystAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.amethyst, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.iridiumAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.iridium, '*', Items.stick }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.devilStoneAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.devilStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.forgetMetalAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.forgetMetal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.soulBoosterAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.soulBooster, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.abyss, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.energyCrystalAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.energyCrystal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.emberStoneAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.emberStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.sunlitAlloyAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.sunlitAlloy, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toxicAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.toxic, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.annihilateAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.annihilate, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.encourageStoneAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.encourageStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.mistarilleAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.mistarille, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blightStoneAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.blightStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.glowAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.glow, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.meteoricSteel, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadeAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.gloryStoneAxe),
				new Object[] { "## ", "#* ", " * ", '#', ItemLoader.gloryStone, '*', Items.stick });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sapphireHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.sapphire, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.rubyHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.ruby, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.aluminiumHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.aluminium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sulfurHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.sulfur, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chromeHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.chrome, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.depletedUraniumHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.depletedUranium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.amethystHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.amethyst, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.iridiumHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.iridium, '*', Items.stick }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.devilStoneHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.devilStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.forgetMetalHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.forgetMetal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.soulBoosterHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.soulBooster, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.abyss, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.energyCrystalHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.energyCrystal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.emberStoneHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.emberStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.sunlitAlloyHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.sunlitAlloy, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toxicHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.toxic, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.annihilateHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.annihilate, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.encourageStoneHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.encourageStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.mistarilleHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.mistarille, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blightStoneHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.blightStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.glowHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.glow, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.meteoricSteel, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadeHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.gloryStoneHoe),
				new Object[] { "## ", " * ", " * ", '#', ItemLoader.gloryStone, '*', Items.stick });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sapphireShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.sapphire, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.rubyShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.ruby, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.aluminiumShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.aluminium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sulfurShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.sulfur, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chromeShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.chrome, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.depletedUraniumShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.depletedUranium, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.amethystShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.amethyst, '*', Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.iridiumShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.iridium, '*', Items.stick }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.devilStoneShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.devilStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.forgetMetalShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.forgetMetal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.soulBoosterShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.soulBooster, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.abyss, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.energyCrystalShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.energyCrystal, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.emberStoneShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.emberStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.sunlitAlloyShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.sunlitAlloy, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toxicShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.toxic, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.annihilateShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.annihilate, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.encourageStoneShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.encourageStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.mistarilleShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.mistarille, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blightStoneShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.blightStone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.glowShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.glow, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.meteoricSteel, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadeShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.gloryStoneShovel),
				new Object[] { " # ", " * ", " * ", '#', ItemLoader.gloryStone, '*', Items.stick });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.sapphireBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.sapphire }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.rubyBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.ruby }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.aluminiumBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.aluminium }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.sulfurBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.sulfur }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.chromeBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.chrome }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.depletedUraniumBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.depletedUranium }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.amethystBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.amethyst }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.iridiumBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.iridium }));
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.devilStoneBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.devilStone });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.forgetMetalBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.forgetMetal });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.soulBoosterBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.soulBooster });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.abyssBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.abyss });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.energyCrystalBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.energyCrystal });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.emberStoneBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.emberStone });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.sunlitAlloyBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.sunlitAlloy });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.toxicBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.toxic });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.annihilateBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.annihilate });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.encourageStoneBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.encourageStone });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.mistarilleBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.mistarille });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blightStoneBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.blightStone });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.glowBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.glow });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.meteoricSteelBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.meteoricSteel });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.grayJadeBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.grayJade });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.gloryStoneBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.gloryStone });

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.smelter), new Object[] { "###", "*+*",
				"###", '#', ItemLoader.aluminium, '*', ItemLoader.sulfur, '+', ItemLoader.sapphire }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.smelter), new Object[] { "###", "*+*",
				"###", '#', ItemLoader.aluminium, '*', ItemLoader.sulfur, '+', ItemLoader.ruby }));
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.abyssKey),
				new Object[] { " ##", "## ", " * ", '#', ItemLoader.forgetMetal, '*', ItemLoader.devilStone });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.ritualStructureBlock),
				new Object[] { "#*#", "* *", "#*#", '#', ItemLoader.forgetMetal, '*', Items.ghast_tear });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.ritualCoreBlock),
				new Object[] { "#*#", "+O+", "#*#", '#', BlockLoader.ritualStructureBlock, '*', ItemLoader.devilStone,
						'+', ItemLoader.soulBooster, 'o', Items.ender_eye });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.ritualCoreBlock),
				new Object[] { "#*#", "+O+", "#*#", '#', BlockLoader.ritualStructureBlock, '*', ItemLoader.soulBooster,
						'+', ItemLoader.devilStone, 'o', Items.ender_eye });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.grayJadeDagger),
				new Object[] { "# ", " *", '#', ItemLoader.grayJade, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.stygianDesolator), new Object[] { "##*", " + ", " + ",
				'#', ItemLoader.mistarille, '*', ItemLoader.blightStone, '+', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.battleFury),
				new Object[] { "###", "#+#", " + ", '#', ItemLoader.emberStone, '+', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelHelmet),
				new Object[] { " # ", "###", "# #", '#', ItemLoader.meteoricSteel });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelChestplate),
				new Object[] { "# #", "# #", "# #", '#', ItemLoader.meteoricSteel });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelLeggings),
				new Object[] { "  #", " ##", "###", '#', ItemLoader.meteoricSteel });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.meteoricSteelBoots),
				new Object[] { " # ", " # ", "###", '#', ItemLoader.meteoricSteel });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.hammer),
				new Object[] { "###", "###", " * ", '#', Blocks.cobblestone, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.ironHammer),
				new Object[] { "###", "###", " * ", '#', Items.iron_ingot, '*', Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.graphite, 4),
				new ItemStack(ItemLoader.hammer, 1, 32767), BlockLoader.graphiteOre);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.graphite, 4),
				new ItemStack(ItemLoader.ironHammer, 1, 32767), BlockLoader.graphiteOre);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.sagger), Items.clay_ball, ItemLoader.graphite,
				Items.clay_ball, ItemLoader.graphite, Items.clay_ball, ItemLoader.graphite, Items.clay_ball,
				ItemLoader.graphite, Items.clay_ball);
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.crucible),
				new Object[] { "# #", "# #", "###", '#', ItemLoader.sagger });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.burningBox),
				new Object[] { "###", "# #", "#*#", '#', ItemLoader.fireBrick, '*', Blocks.furnace });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.fireBrickBlock),
				new Object[] { "##", "##", '#', ItemLoader.fireBrick });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.castingTable), new Object[] { "#*#", "+#+", "+ +", '#',
				Blocks.stone, '*', ItemLoader.ceramicMold, '+', Blocks.planks });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.clayMold),
				new Object[] { "###", "#*#", "###", '#', Items.clay_ball, '*', Items.brick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.crucibleSpoon),
				new Object[] { "  #", " * ", "*  ", '#', Items.bowl, '*', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.spanner),
				new Object[] { "# #", "###", " # ", '#', Items.iron_ingot });
	}

	private static void registerSmelting() {
		GameRegistry.addSmelting(BlockLoader.aluminiumOre, new ItemStack(ItemLoader.aluminium), 1.3F);
		GameRegistry.addSmelting(BlockLoader.uraniumOre, new ItemStack(ItemLoader.uranium), 1.7F);
		GameRegistry.addSmelting(BlockLoader.forgetMetalOre, new ItemStack(ItemLoader.forgetMetal), 3.1F);
		GameRegistry.addSmelting(BlockLoader.chargedAbyssOre, new ItemStack(ItemLoader.abyss), 6.2F);
		if (ConfigLoader.enableNoBlackholeMode) {
			GameRegistry.addSmelting(BlockLoader.abyssOre, new ItemStack(ItemLoader.abyss), 4.0F);
		}
		GameRegistry.addSmelting(BlockLoader.sunlitAlloyOre, new ItemStack(ItemLoader.sunlitAlloy), 6.5F);
		GameRegistry.addSmelting(BlockLoader.toxicOre, new ItemStack(ItemLoader.toxic), 7.0F);
		GameRegistry.addSmelting(BlockLoader.annihilateOre, new ItemStack(ItemLoader.annihilate), 7.5F);
		GameRegistry.addSmelting(BlockLoader.mistarilleOre, new ItemStack(ItemLoader.mistarille), 8.0F);
		GameRegistry.addSmelting(BlockLoader.glowOre, new ItemStack(ItemLoader.glow), 8.5F);
		GameRegistry.addSmelting(BlockLoader.meteoricSteelOre, new ItemStack(ItemLoader.meteoricSteel), 9.0F);
		GameRegistry.addSmelting(ItemLoader.sagger, new ItemStack(ItemLoader.fireBrick), 0.5F);
		removeSmelting(Item.getItemFromBlock(Blocks.iron_ore));
		GameRegistry.addSmelting(ItemLoader.clayMold, new ItemStack(ItemLoader.ceramicMold), 0.5F);

	}

	private static void removeSmelting(Item item) {
		Map smeltList = FurnaceRecipes.smelting().getSmeltingList();
		for (Iterator<ItemStack> i = smeltList.keySet().iterator(); i.hasNext();) {
			ItemStack input = i.next();
			if (input.getItem() == item) {
				i.remove();
			}
		}
	}
}