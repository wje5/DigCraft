package com.huajiliming.digcraft.world.gen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.huajiliming.digcraft.block.BlockLoader;

import net.minecraft.init.Blocks;

public class GenBuildingApartment extends GenBuilding {
	private List<ApartmentFloor> floorGen = new ArrayList<ApartmentFloor>();

	public GenBuildingApartment() {
		this.floorGen.add(new Floor1());
	}

	@Override
	public boolean generate(CityGen gen, Random rand, int x, int y, int z) {
		for (int i = 2; i < 29; i++) {
			for (int j = y + 1; j < y + 63; j++) {
				gen.setBlock(x + 2, j, z + i, BlockLoader.puttyWall, 5);
				gen.setBlock(x + i, j, z + 2, BlockLoader.puttyWall, 3);
				gen.setBlock(x + 28, j, z + 30 - i, BlockLoader.puttyWall, 4);
				gen.setBlock(x + 30 - i, j, z + 28, BlockLoader.puttyWall, 2);
			}
		}
		for (int i = 0; i < 13; i++) {
			for (int j = 3; j < 28; j++) {
				for (int k = 3; k < 28; k++) {
					gen.setBlock(x + j, y + i * 5 + 1, z + k, BlockLoader.puttyWall, 0);
				}
			}
			if (i != 12) {
				boolean flag = false;
				while (!flag) {
					int weight = 0;
					Iterator<ApartmentFloor> it = this.floorGen.iterator();
					while (it.hasNext()) {
						weight += it.next().getWeight();
					}
					weight = rand.nextInt(weight);
					it = this.floorGen.iterator();
					while (it.hasNext()) {
						ApartmentFloor floor = it.next();
						if (floor.getWeight() > weight) {
							flag = floor.generate(gen, rand, x + 3, y + i * 5 + 1, z + 3, i);
							break;
						} else {
							weight -= floor.getWeight();
						}
					}
				}
			}
			if (i == 12) {
				for (int j = 20; j < 24; j++) {
					for (int k = 3; k < 6; k++) {
						gen.setBlock(x + j, y + i * 5 + 1, z + k, Blocks.air, 0);
					}
				}
				gen.setBlock(x + 24, y + i * 5 + 1, z + 3, Blocks.stone_brick_stairs, 0);
				gen.setBlock(x + 24, y + i * 5 + 1, z + 4, Blocks.stone_brick_stairs, 0);
				gen.setBlock(x + 24, y + i * 5 + 1, z + 5, Blocks.stone_brick_stairs, 0);
			}
		}
		gen.setBlock(x + 6, y + 2, z + 2, Blocks.iron_door, 1);
		gen.setBlock(x + 6, y + 3, z + 2, Blocks.iron_door, 9);
		return true;
	}

	@Override
	public int getWeight() {
		return 20;
	}

	private static abstract class ApartmentFloor {
		public boolean generate(CityGen gen, Random rand, int x, int y, int z, int floor) {
			for (int i = 0; i < 3; i++) {
				if (floor != 12) {
					for (int j = 0; j < 4; j++) {
						gen.setBlock(x + j + 17, y + j + 1, z + i, Blocks.stone_brick_stairs, 0);
						gen.setBlock(x + j + 18, y + j + 1, z + i, Blocks.stone_brick_stairs, 5);
					}
				}
				if (floor != 0) {
					gen.setBlock(x + 21, y, z + i, Blocks.stone_brick_stairs, 0);
				}
			}
			if (floor != 0) {
				for (int j = 17; j < 21; j++) {
					for (int k = 0; k < 3; k++) {
						gen.setBlock(x + j, y, z + k, Blocks.air, 0);
					}
				}
			}
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 25; k++) {
					gen.setBlock(x + k, y + j + 1, z + 4, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 3, y + 1, z + 4, Blocks.iron_door, 1);
			gen.setBlock(x + 3, y + 2, z + 4, Blocks.iron_door, 9);
			gen.setBlock(x + 2, y + 2, z + 3, BlockLoader.doorbell, 0);
			gen.setBlock(x + 16, y + 1, z + 4, Blocks.iron_door, 1);
			gen.setBlock(x + 16, y + 2, z + 4, Blocks.iron_door, 9);
			gen.setBlock(x + 15, y + 2, z + 3, BlockLoader.doorbell, 0);
			gen.setBlock(x + 3, y + 4, z + 2, BlockLoader.fluorescentLamp, 0);
			gen.setBlock(x + 11, y + 4, z + 2, BlockLoader.fluorescentLamp, 0);
			return true;
		}

		public abstract int getWeight();
	}

	private static class Floor1 extends ApartmentFloor {
		@Override
		public boolean generate(CityGen gen, Random rand, int x, int y, int z, int floor) {
			super.generate(gen, rand, x, y, z, floor);
			for (int i = 5; i <= 24; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 12, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			for (int i = 0; i <= 3; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + i, y + j, z + 8, BlockLoader.putty, 0);
				}
			}
			for (int i = 9; i <= 16; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 3, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			for (int i = 1; i <= 3; i++) {
				gen.setBlock(x + 3, y + i, z + 14, Blocks.air, 0);
				gen.setBlock(x + 3, y + i, z + 15, Blocks.air, 0);
			}
			for (int i = 0; i <= 4; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + i, y + j, z + 17, BlockLoader.putty, 0);
				}
			}
			for (int i = 18; i <= 24; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 4, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 4, y + 1, z + 22, Blocks.wooden_door, 2);
			gen.setBlock(x + 4, y + 2, z + 22, Blocks.wooden_door, 10);
			for (int i = 22; i <= 24; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 8, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			for (int i = 9; i <= 11; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + i, y + j, z + 22, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 8, y + 1, z + 23, Blocks.wooden_door, 0);
			gen.setBlock(x + 8, y + 2, z + 23, Blocks.wooden_door, 8);
			gen.setBlock(x + 10, y + 1, z + 10, BlockLoader.longTable, 8);
			gen.setBlock(x + 10, y + 1, z + 11, BlockLoader.longTable, 2);
			gen.setBlock(x + 10, y + 1, z + 12, BlockLoader.longTable, 9);
			gen.setBlock(x + 10, y + 1, z + 9, BlockLoader.littleSofa, 1);
			gen.setBlock(x + 10, y + 1, z + 13, BlockLoader.littleSofa, 0);
			gen.setBlock(x + 11, y + 1, z + 10, BlockLoader.longSofa, 8);
			gen.setBlock(x + 11, y + 1, z + 11, BlockLoader.longSofa, 2);
			gen.setBlock(x + 11, y + 1, z + 12, BlockLoader.longSofa, 9);
			gen.setBlock(x, y + 1, z + 5, BlockLoader.shoeArc, 3);
			gen.setBlock(x, y + 1, z + 6, BlockLoader.shoeArc, 3);
			gen.setBlock(x, y + 1, z + 7, BlockLoader.shoeArc, 3);
			gen.setBlock(x, y + 2, z + 5, BlockLoader.shoeArc, 3);
			gen.setBlock(x, y + 2, z + 6, BlockLoader.shoeArc, 3);
			gen.setBlock(x, y + 2, z + 7, BlockLoader.shoeArc, 3);
			gen.setBlock(x + 8, y + 1, z + 18, BlockLoader.diningTable, 1);
			gen.setBlock(x + 8, y + 1, z + 19, BlockLoader.diningTable, 3);
			gen.setBlock(x + 9, y + 1, z + 18, BlockLoader.diningTable, 2);
			gen.setBlock(x + 9, y + 1, z + 19, BlockLoader.diningTable, 0);
			gen.setBlock(x + 8, y + 1, z + 17, BlockLoader.diningChair, 1);
			gen.setBlock(x + 8, y + 2, z + 17, BlockLoader.diningChair, 9);
			gen.setBlock(x + 9, y + 1, z + 17, BlockLoader.diningChair, 1);
			gen.setBlock(x + 9, y + 2, z + 17, BlockLoader.diningChair, 9);
			gen.setBlock(x + 8, y + 1, z + 20, BlockLoader.diningChair, 0);
			gen.setBlock(x + 8, y + 2, z + 20, BlockLoader.diningChair, 8);
			gen.setBlock(x + 9, y + 1, z + 20, BlockLoader.diningChair, 0);
			gen.setBlock(x + 9, y + 2, z + 20, BlockLoader.diningChair, 8);
			gen.setBlock(x + 7, y + 4, z + 9, BlockLoader.fluorescentLamp, 0);
			gen.setBlock(x + 7, y + 4, z + 14, BlockLoader.fluorescentLamp, 0);
			gen.setBlock(x + 7, y + 4, z + 18, BlockLoader.fluorescentLamp, 0);
			gen.setBlock(x, y + 1, z + 18, Blocks.bed, 9);
			gen.setBlock(x + 1, y + 1, z + 18, Blocks.bed, 1);
			gen.setBlock(x, y + 1, z + 19, BlockLoader.bedsideTable, 3);
			gen.setBlock(x + 2, y + 4, z + 21, BlockLoader.fluorescentLamp, 0);
			for (int i = 0; i < 4; i++) {
				gen.setBlock(x + i, y + 2, z + 25, Blocks.glass_pane, 0);
				gen.setBlock(x + i, y + 3, z + 25, Blocks.glass_pane, 0);
			}
			gen.setBlock(x, y + 1, z + 22, BlockLoader.desk, 14);
			gen.setBlock(x, y + 1, z + 23, BlockLoader.desk, 3);
			gen.setBlock(x, y + 1, z + 24, BlockLoader.desk, 15);
			gen.setBlock(x + 11, y + 1, z + 23, BlockLoader.toilet, 1);
			gen.setBlock(x, y + 1, z + 9, BlockLoader.ambry, 1);
			gen.setBlock(x + 1, y + 1, z + 9, BlockLoader.ambry, 1);
			gen.setBlock(x + 2, y + 1, z + 9, BlockLoader.putty, 0);
			gen.setBlock(x + 2, y + 1, z + 10, BlockLoader.ambry, 2);
			gen.setBlock(x + 2, y + 1, z + 11, BlockLoader.ambry, 2);
			gen.setBlock(x + 2, y + 1, z + 12, BlockLoader.ambry, 2);
			gen.setBlock(x + 2, y + 1, z + 13, BlockLoader.ambry, 2);
			gen.setBlock(x, y + 2, z + 9, BlockLoader.gasBurner, 1);
			gen.setBlock(x + 1, y + 2, z + 9, BlockLoader.gasBurner, 9);
			gen.setBlock(x, y + 1, z + 16, BlockLoader.fridge, 0);
			gen.setBlock(x, y + 2, z + 16, BlockLoader.fridge, 4);
			gen.setBlock(x, y + 3, z + 16, BlockLoader.fridge, 8);
			gen.setBlock(x + 4, y + 2, z + 10, BlockLoader.tv, 7);
			gen.setBlock(x + 4, y + 2, z + 11, BlockLoader.tv, 3);
			gen.setBlock(x + 4, y + 2, z + 12, BlockLoader.tv, 7);
			gen.setBlock(x + 4, y + 3, z + 10, BlockLoader.tv, 11);
			gen.setBlock(x + 4, y + 3, z + 11, BlockLoader.tv, 7);
			gen.setBlock(x + 4, y + 3, z + 12, BlockLoader.tv, 15);
			// #####################################################
			for (int i = 5; i <= 14; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 15, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 15, y + 1, z + 11, Blocks.air, 0);
			gen.setBlock(x + 15, y + 2, z + 11, Blocks.air, 0);
			for (int i = 13; i <= 15; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + i, y + j, z + 15, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 13, y + 1, z + 16, BlockLoader.putty, 0);
			for (int i = 5; i <= 11; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + 19, y + j, z + i, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 20, y + 3, z + 11, BlockLoader.putty, 0);
			gen.setBlock(x + 20, y + 4, z + 11, BlockLoader.putty, 0);
			for (int i = 21; i <= 24; i++) {
				for (int j = 1; j <= 4; j++) {
					gen.setBlock(x + i, y + j, z + 11, BlockLoader.putty, 0);
				}
			}
			gen.setBlock(x + 14, y + 1, z + 16, BlockLoader.ambry, 1);
			gen.setBlock(x + 15, y + 1, z + 16, BlockLoader.ambry, 1);
			for (int i = 17; i <= 23; i++) {
				gen.setBlock(x + 13, y + 1, z + i, BlockLoader.ambry, 3);
			}
			gen.setBlock(x + 13, y + 2, z + 18, BlockLoader.gasBurner, 3);
			gen.setBlock(x + 13, y + 2, z + 19, BlockLoader.gasBurner, 11);
			gen.setBlock(x + 13, y + 2, z + 22, BlockLoader.gasBurner, 3);
			gen.setBlock(x + 13, y + 1, z + 24, BlockLoader.fridge, 3);
			gen.setBlock(x + 13, y + 2, z + 24, BlockLoader.fridge, 7);
			gen.setBlock(x + 13, y + 3, z + 24, BlockLoader.fridge, 11);
			gen.setBlock(x + 16, y + 1, z + 20, BlockLoader.diningTable, 1);
			gen.setBlock(x + 16, y + 1, z + 21, BlockLoader.diningTable, 3);
			gen.setBlock(x + 17, y + 1, z + 20, BlockLoader.diningTable, 2);
			gen.setBlock(x + 17, y + 1, z + 21, BlockLoader.diningTable, 0);
			gen.setBlock(x + 16, y + 1, z + 19, BlockLoader.diningChair, 1);
			gen.setBlock(x + 16, y + 2, z + 19, BlockLoader.diningChair, 9);
			gen.setBlock(x + 17, y + 1, z + 19, BlockLoader.diningChair, 1);
			gen.setBlock(x + 17, y + 2, z + 19, BlockLoader.diningChair, 9);
			gen.setBlock(x + 16, y + 1, z + 22, BlockLoader.diningChair, 0);
			gen.setBlock(x + 16, y + 2, z + 22, BlockLoader.diningChair, 8);
			gen.setBlock(x + 17, y + 1, z + 22, BlockLoader.diningChair, 0);
			gen.setBlock(x + 17, y + 2, z + 22, BlockLoader.diningChair, 8);
			gen.setBlock(x + 19, y + 1, z + 20, BlockLoader.longSofa, 8);
			gen.setBlock(x + 19, y + 1, z + 21, BlockLoader.longSofa, 3);
			gen.setBlock(x + 19, y + 1, z + 22, BlockLoader.longSofa, 9);
			gen.setBlock(x + 19, y + 1, z + 19, BlockLoader.littleSofa, 3);
			gen.setBlock(x + 19, y + 1, z + 23, BlockLoader.littleSofa, 3);
			gen.setBlock(x + 24, y + 2, z + 20, BlockLoader.tv, 6);
			gen.setBlock(x + 24, y + 2, z + 21, BlockLoader.tv, 2);
			gen.setBlock(x + 24, y + 2, z + 22, BlockLoader.tv, 6);
			gen.setBlock(x + 24, y + 3, z + 20, BlockLoader.tv, 10);
			gen.setBlock(x + 24, y + 3, z + 21, BlockLoader.tv, 6);
			gen.setBlock(x + 24, y + 3, z + 22, BlockLoader.tv, 14);
			for (int i = 15; i <= 18; i++) {
				gen.setBlock(x + i, y + 2, z + 25, Blocks.glass_pane, 0);
				gen.setBlock(x + i, y + 3, z + 25, Blocks.glass_pane, 0);
			}
			for (int i = 13; i <= 17; i += 2) {
				for (int j = 16; j <= 24; j += 2) {
					gen.setBlock(x + i, y + 4, z + j, BlockLoader.spotLightSmall, 0);
				}
			}
			for (int i = 20; i <= 24; i += 2) {
				for (int j = 12; j <= 24; j += 2) {
					gen.setBlock(x + i, y + 4, z + j, BlockLoader.spotLightSmall, 0);
				}
			}
			for (int i = 6; i <= 14; i += 2) {
				gen.setBlock(x + 17, y + 4, z + i, BlockLoader.spotLightSmall, 0);
			}
			gen.setBlock(x + 20, y + 1, z + 11, Blocks.wooden_door, 3);
			gen.setBlock(x + 20, y + 2, z + 11, Blocks.wooden_door, 8);
			gen.setBlock(x + 21, y + 1, z + 5, BlockLoader.bedsideTable, 1);
			gen.setBlock(x + 24, y + 1, z + 5, BlockLoader.bedsideTable, 1);
			gen.setBlock(x + 20, y + 4, z + 5, BlockLoader.spotLightSmall, 0);
			gen.setBlock(x + 24, y + 4, z + 5, BlockLoader.spotLightSmall, 0);
			gen.setBlock(x + 22, y + 4, z + 7, BlockLoader.fluorescentLamp, 0);
			gen.setBlock(x + 24, y + 1, z + 12, BlockLoader.cabinetAirConditioner, 1);
			gen.setBlock(x + 24, y + 2, z + 12, BlockLoader.cabinetAirConditioner, 5);
			gen.setBlock(x + 24, y + 3, z + 12, BlockLoader.cabinetAirConditioner, 9);
			gen.setBlock(x + 20, y + 4, z + 10, BlockLoader.airConditioner, 3);
			gen.setBlock(x + 20, y + 4, z + 9, BlockLoader.airConditioner, 11);
			gen.setBlock(x + 22, y + 1, z + 5, Blocks.bed, 10);
			gen.setBlock(x + 22, y + 1, z + 6, Blocks.bed, 2);
			gen.setBlock(x + 23, y + 1, z + 5, Blocks.bed, 10);
			gen.setBlock(x + 23, y + 1, z + 6, Blocks.bed, 2);
			for (int i = 5; i <= 14; i++) {
				gen.setBlock(x + 13, y + 4, z + i, BlockLoader.putty, 0);
				gen.setBlock(x + 14, y + 4, z + i, BlockLoader.putty, 0);
			}
			gen.setBlock(x + 13, y + 1, z + 5, BlockLoader.bathtub, 8);
			gen.setBlock(x + 14, y + 1, z + 5, BlockLoader.bathtub, 0);
			gen.setBlock(x + 13, y + 3, z + 8, Blocks.glass_pane, 0);
			gen.setBlock(x + 14, y + 3, z + 8, Blocks.glass_pane, 0);
			gen.setBlock(x + 13, y + 1, z + 8, BlockLoader.glassDoor, 1);
			gen.setBlock(x + 14, y + 1, z + 8, BlockLoader.glassDoor, 9);
			gen.setBlock(x + 13, y + 2, z + 8, BlockLoader.glassDoor, 4);
			gen.setBlock(x + 14, y + 2, z + 8, BlockLoader.glassDoor, 13);
			gen.setBlock(x + 13, y + 3, z + 14, BlockLoader.spotLightSmall, 0);
			gen.setBlock(x + 14, y + 3, z + 14, BlockLoader.spotLightSmall, 0);
			gen.setBlock(x + 13, y + 2, z + 14, BlockLoader.washBasin, 8);
			gen.setBlock(x + 14, y + 2, z + 14, BlockLoader.washBasin, 0);
			gen.setBlock(x + 13, y + 1, z + 14, BlockLoader.ark, 0);
			gen.setBlock(x + 14, y + 1, z + 14, BlockLoader.ark, 0);
			return true;
		}

		@Override
		public int getWeight() {
			return 20;
		}
	}
}
