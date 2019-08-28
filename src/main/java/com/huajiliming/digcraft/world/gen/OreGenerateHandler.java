package com.huajiliming.digcraft.world.gen;

import java.util.Random;

import com.huajiliming.digcraft.block.BlockLoader;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OreGenerateHandler {
	public Random randomGenerator = new Random();
	public WorldGenerator sapphireGen;
	public WorldGenerator rubyGen;
	public WorldGenerator aluminiumGen;
	public WorldGenerator sulfurGen;
	public WorldGenerator chromeGen;
	public WorldGenerator uraniumGen;
	public WorldGenerator amethystGen;
	public WorldGenerator iridiumGen;
	public WorldGenerator devilStoneGen;
	public WorldGenerator forgetMetalGen;
	public WorldGenerator soulBoosterGen;
	public WorldGenerator abyssGen;
	public WorldGenerator energyCrystalGen;
	public WorldGenerator emberStoneGen;
	public WorldGenerator sunlitAlloyGen;
	public WorldGenerator toxicGen;
	public WorldGenerator annihilateGen;
	public WorldGenerator encourageStoneGen;
	public WorldGenerator mistarilleGen;
	public WorldGenerator blightStoneGen;
	public WorldGenerator graphiteGen;

	public OreGenerateHandler() {
		this.sapphireGen = new WorldGenMinable(BlockLoader.sapphireOre, 6);
		this.rubyGen = new WorldGenMinable(BlockLoader.rubyOre, 6);
		this.aluminiumGen = new WorldGenMinable(BlockLoader.aluminiumOre, 8);
		this.sulfurGen = new WorldGenMinable(BlockLoader.sulfurOre, 7);
		this.chromeGen = new WorldGenMinable(BlockLoader.chromeOre, 4);
		this.uraniumGen = new WorldGenMinable(BlockLoader.uraniumOre, 3);
		this.amethystGen = new WorldGenMinable(BlockLoader.amethystOre, 3);
		this.iridiumGen = new WorldGenMinable(BlockLoader.iridiumOre, 3);
		this.graphiteGen = new WorldGenMinable(BlockLoader.graphiteOre, 8);

		this.devilStoneGen = new WorldGenMinable(BlockLoader.devilStoneOre, 12, Blocks.netherrack);
		this.forgetMetalGen = new WorldGenMinable(BlockLoader.forgetMetalOre, 11, Blocks.netherrack);
		this.soulBoosterGen = new WorldGenMinable(BlockLoader.soulBoosterOre, 10, Blocks.netherrack);
		this.abyssGen = new WorldGenMinable(BlockLoader.abyssOre, 9, Blocks.netherrack);
		this.energyCrystalGen = new WorldGenMinable(BlockLoader.energyCrystalOre, 8, Blocks.netherrack);
		this.emberStoneGen = new WorldGenMinable(BlockLoader.emberStoneOre, 7, Blocks.netherrack);
		this.sunlitAlloyGen = new WorldGenMinable(BlockLoader.sunlitAlloyOre, 6, Blocks.netherrack);
		this.toxicGen = new WorldGenMinable(BlockLoader.toxicOre, 5, Blocks.netherrack);
		this.annihilateGen = new WorldGenMinable(BlockLoader.annihilateOre, 4, Blocks.netherrack);
		this.encourageStoneGen = new WorldGenMinable(BlockLoader.encourageStoneOre, 3, Blocks.netherrack);
		this.mistarilleGen = new WorldGenMinable(BlockLoader.mistarilleOre, 3, Blocks.netherrack);
		this.blightStoneGen = new WorldGenMinable(BlockLoader.blightStoneOre, 3, Blocks.netherrack);

	}

	public void generateOres(World world, int chunkX, int chunkZ) {
		genStandardOre(world, 1, chunkX, chunkZ, this.sapphireGen, 10, 40);
		genStandardOre(world, 1, chunkX, chunkZ, this.rubyGen, 10, 40);
		genStandardOre(world, 10, chunkX, chunkZ, this.aluminiumGen, 50, 90);
		genStandardOre(world, 7, chunkX, chunkZ, this.sulfurGen, 5, 20);
		genStandardOre(world, 1, chunkX, chunkZ, this.chromeGen, 10, 40);
		genStandardOre(world, 1, chunkX, chunkZ, this.uraniumGen, 10, 40);
		genStandardOre(world, 1, chunkX, chunkZ, this.amethystGen, 10, 40);
		genStandardOre(world, 1, chunkX, chunkZ, this.iridiumGen, 40, 50);
		genStandardOre(world, 10, chunkX, chunkZ, this.graphiteGen, 5, 20);
	}

	public void generateNetherOres(World world, int chunkX, int chunkZ) {
		genStandardOre(world, 15, chunkX, chunkZ, this.devilStoneGen, 10, 118);
		genStandardOre(world, 14, chunkX, chunkZ, this.forgetMetalGen, 10, 118);
		genStandardOre(world, 13, chunkX, chunkZ, this.soulBoosterGen, 10, 118);
		genStandardOre(world, 12, chunkX, chunkZ, this.abyssGen, 10, 118);
		genStandardOre(world, 11, chunkX, chunkZ, this.energyCrystalGen, 10, 118);
		genStandardOre(world, 10, chunkX, chunkZ, this.emberStoneGen, 10, 118);
		genStandardOre(world, 9, chunkX, chunkZ, this.sunlitAlloyGen, 10, 118);
		genStandardOre(world, 8, chunkX, chunkZ, this.toxicGen, 10, 118);
		genStandardOre(world, 7, chunkX, chunkZ, this.annihilateGen, 10, 118);
		genStandardOre(world, 6, chunkX, chunkZ, this.encourageStoneGen, 10, 118);
		genStandardOre(world, 5, chunkX, chunkZ, this.mistarilleGen, 10, 118);
		genStandardOre(world, 4, chunkX, chunkZ, this.blightStoneGen, 10, 118);
	}

	public void genStandardOre(World world, int amount, int chunkX, int chunkZ, WorldGenerator gen, int minY,
			int maxY) {
		for (int l = 0; l < amount; l++) {
			int i1 = chunkX + this.randomGenerator.nextInt(16);
			int j1 = this.randomGenerator.nextInt(maxY - minY) + minY;
			int k1 = chunkZ + this.randomGenerator.nextInt(16);
			gen.generate(world, this.randomGenerator, i1, j1, k1);
		}
	}
}

/*
 * Location: /Volumes/NO
 * NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/world/gen/
 * OreGenerateHandler.class Java compiler version: 6 (50.0) JD-Core Version:
 * 0.7.1
 */