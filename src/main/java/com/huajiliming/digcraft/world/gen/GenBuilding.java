package com.huajiliming.digcraft.world.gen;

import java.util.Random;

public abstract class GenBuilding {
	public abstract boolean generate(CityGen gen, Random rand, int x, int y, int z);

	public abstract int getWeight();
}
