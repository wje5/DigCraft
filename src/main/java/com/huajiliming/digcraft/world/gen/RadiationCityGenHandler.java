package com.huajiliming.digcraft.world.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class RadiationCityGenHandler implements IWorldGenerator {
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimensionName() == "Overworld" && chunkX <= 30 && chunkX >= 0 && chunkZ <= 30
				&& chunkZ >= 0) {
			if (!CityGen.gen.isInit) {
//				int y = 1;
//				for (int i = 255; i > 0; i--) {
//					if (world.getBlock(chunkX, i, chunkZ) != Blocks.air) {
//						y = i;
//					}
//				}
				CityGen.gen.init(rand, world.provider.getAverageGroundLevel());
			}
			CityGen.gen.genChunk(world, chunkX, chunkZ);
		}
	}
}
