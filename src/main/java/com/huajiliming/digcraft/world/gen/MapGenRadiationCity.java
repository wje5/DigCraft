package com.huajiliming.digcraft.world.gen;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenRadiationCity extends MapGenStructure {
	@Override
	public String func_143025_a() {
		return "RadiationCity";
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int x, int z) {
		return this.rand.nextDouble() < 0.0025D && this.rand.nextInt(80) < Math.max(Math.abs(x), Math.abs(z));
	}

	@Override
	protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_) {
		return null;
	}
}
