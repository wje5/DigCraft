package com.huajiliming.digcraft.world.gen;

import java.util.Random;

import com.huajiliming.digcraft.block.BlockLoader;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EndGenHandler implements IWorldGenerator {
	public Random randomGenerator = new Random();
	public WorldGenerator glowGen;
	public WorldGenerator meteoricSteelGen;
	public WorldGenerator grayJadeGen;
	public WorldGenerator gloryStoneGen;

	public EndGenHandler() {
		this.glowGen = new WorldGenMinable(BlockLoader.glowOre, 7, Blocks.end_stone);
		this.meteoricSteelGen = new WorldGenMinable(BlockLoader.meteoricSteelOre, 6, Blocks.end_stone);
		this.grayJadeGen = new WorldGenMinable(BlockLoader.grayJadeOre, 5, Blocks.end_stone);
		this.gloryStoneGen = new WorldGenMinable(BlockLoader.gloryStoneOre, 4, Blocks.end_stone);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimensionName() == "The End") {
			chunkX *= 16;
			chunkZ *= 16;
			genStandardOre(world, 8, chunkX, chunkZ, this.glowGen, 1, 70);
			genStandardOre(world, 7, chunkX, chunkZ, this.meteoricSteelGen, 1, 70);
			genStandardOre(world, 6, chunkX, chunkZ, this.grayJadeGen, 1, 70);
			genStandardOre(world, 5, chunkX, chunkZ, this.gloryStoneGen, 1, 70);
		}
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