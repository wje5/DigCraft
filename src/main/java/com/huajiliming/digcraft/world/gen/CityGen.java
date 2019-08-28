package com.huajiliming.digcraft.world.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.tileentity.IInitableTE;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class CityGen {
	private int[][][][] data = new int[489][100][489][2];
	public Random rand;
	private int y;
	public boolean isInit = false;
	private List<GenBuilding> buildingGen = new ArrayList<GenBuilding>();

	public static CityGen gen = new CityGen();

	public void init(Random rand, int y) {
		this.y = y - 3;
		this.rand = rand;
		this.buildingGen.add(new GenBuildingApartment());
		for (int i = 0; i < 489; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 489; k++) {
					this.setBlock(i, j, k, BlockLoader.pitch, 0);
				}
			}
		}
		for (int i = 0; i < 489; i++) {
			if (i % 40 > 8) {
				for (int j = 0; j < 489; j++) {
					if (j % 40 > 8) {
						for (int k = 0; k <= 2; k++) {
							this.setBlock(i, k, j, BlockLoader.concrete, 0);
						}
					}
				}
			}
		}
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 489; j++) {
				if (j % 40 >= 9) {
					this.setBlock(i * 40, 2, j, BlockLoader.roadSideLine, 0);
					this.setBlock(i * 40 + 2, 2, j, BlockLoader.roadDotted, 0);
					this.setBlock(i * 40 + 4, 2, j, BlockLoader.roadYellowLine, 0);
					this.setBlock(i * 40 + 6, 2, j, BlockLoader.roadDotted, 0);
					this.setBlock(i * 40 + 8, 2, j, BlockLoader.roadSideLine, 6);

					this.setBlock(j, 2, i * 40, BlockLoader.roadSideLine, 7);
					this.setBlock(j, 2, i * 40 + 2, BlockLoader.roadDotted, 1);
					this.setBlock(j, 2, i * 40 + 4, BlockLoader.roadYellowLine, 1);
					this.setBlock(j, 2, i * 40 + 6, BlockLoader.roadDotted, 1);
					this.setBlock(j, 2, i * 40 + 8, BlockLoader.roadSideLine, 1);
				} else if (j % 40 == 0) {
					this.setBlock(i * 40, 2, j, BlockLoader.roadSideLine, 2);
					this.setBlock(i * 40 + 8, 2, j, BlockLoader.roadSideLine, 5);
				} else if (j % 40 == 8) {
					this.setBlock(i * 40, 2, j, BlockLoader.roadSideLine, 3);
					this.setBlock(i * 40 + 8, 2, j, BlockLoader.roadSideLine, 4);
				}
			}
		}
		for (int i = 0; i < 489; i++) {
			this.setBlock(i, 2, 0, BlockLoader.roadSideLine, 7);
			this.setBlock(0, 2, i, BlockLoader.roadSideLine, 0);
			this.setBlock(488 - i, 2, 488, BlockLoader.roadSideLine, 1);
			this.setBlock(488, 2, 488 - i, BlockLoader.roadSideLine, 6);
		}
		for (int i = 1; i <= 9; i++) {
			this.setBlock(i, 2, 0, BlockLoader.roadSideLine, 7);
			this.setBlock(0, 2, i, BlockLoader.roadSideLine, 0);
			this.setBlock(488 - i, 2, 0, BlockLoader.roadSideLine, 7);
			this.setBlock(488, 2, i, BlockLoader.roadSideLine, 6);
			this.setBlock(i, 2, 488, BlockLoader.roadSideLine, 1);
			this.setBlock(0, 2, 488 - i, BlockLoader.roadSideLine, 0);
			this.setBlock(488 - i, 2, 488, BlockLoader.roadSideLine, 1);
			this.setBlock(488, 2, 488 - i, BlockLoader.roadSideLine, 6);
		}
		this.setBlock(0, 2, 0, BlockLoader.roadSideLine, 10);
		this.setBlock(488, 2, 0, BlockLoader.roadSideLine, 9);
		this.setBlock(0, 2, 488, BlockLoader.roadSideLine, 11);
		this.setBlock(488, 2, 488, BlockLoader.roadSideLine, 8);
		for (int i = 1; i <= 7; i++) {
			this.setBlock(2 + i, 2, 2, BlockLoader.roadDotted, 1);
			this.setBlock(2, 2, 2 + i, BlockLoader.roadDotted, 0);
			this.setBlock(486 - i, 2, 2, BlockLoader.roadDotted, 1);
			this.setBlock(486, 2, 2 + i, BlockLoader.roadDotted, 0);
			this.setBlock(2 + i, 2, 486, BlockLoader.roadDotted, 1);
			this.setBlock(2, 2, 486 - i, BlockLoader.roadDotted, 0);
			this.setBlock(486 - i, 2, 486, BlockLoader.roadDotted, 1);
			this.setBlock(486, 2, 486 - i, BlockLoader.roadDotted, 0);
		}
		this.setBlock(2, 2, 2, BlockLoader.roadDotted, 4);
		this.setBlock(486, 2, 2, BlockLoader.roadDotted, 3);
		this.setBlock(2, 2, 486, BlockLoader.roadDotted, 5);
		this.setBlock(486, 2, 486, BlockLoader.roadDotted, 2);
		for (int i = 1; i <= 5; i++) {
			this.setBlock(4 + i, 2, 4, BlockLoader.roadYellowLine, 1);
			this.setBlock(4, 2, 4 + i, BlockLoader.roadYellowLine, 0);
			this.setBlock(484 - i, 2, 4, BlockLoader.roadYellowLine, 1);
			this.setBlock(484, 2, 4 + i, BlockLoader.roadYellowLine, 0);
			this.setBlock(4 + i, 2, 484, BlockLoader.roadYellowLine, 1);
			this.setBlock(4, 2, 484 - i, BlockLoader.roadYellowLine, 0);
			this.setBlock(484 - i, 2, 484, BlockLoader.roadYellowLine, 1);
			this.setBlock(484, 2, 484 - i, BlockLoader.roadYellowLine, 0);
		}
		this.setBlock(4, 2, 4, BlockLoader.roadYellowLine, 4);
		this.setBlock(484, 2, 4, BlockLoader.roadYellowLine, 3);
		this.setBlock(4, 2, 484, BlockLoader.roadYellowLine, 5);
		this.setBlock(484, 2, 484, BlockLoader.roadYellowLine, 2);
		for (int i = 1; i <= 3; i++) {
			this.setBlock(6 + i, 2, 6, BlockLoader.roadDotted, 1);
			this.setBlock(6, 2, 6 + i, BlockLoader.roadDotted, 0);
			this.setBlock(482 - i, 2, 6, BlockLoader.roadDotted, 1);
			this.setBlock(482, 2, 6 + i, BlockLoader.roadDotted, 0);
			this.setBlock(6 + i, 2, 482, BlockLoader.roadDotted, 1);
			this.setBlock(6, 2, 482 - i, BlockLoader.roadDotted, 0);
			this.setBlock(482 - i, 2, 482, BlockLoader.roadDotted, 1);
			this.setBlock(482, 2, 482 - i, BlockLoader.roadDotted, 0);
		}
		this.setBlock(6, 2, 6, BlockLoader.roadDotted, 4);
		this.setBlock(8, 2, 8, BlockLoader.roadSideLine, 4);
		this.setBlock(482, 2, 6, BlockLoader.roadDotted, 3);
		this.setBlock(480, 2, 8, BlockLoader.roadSideLine, 3);
		this.setBlock(6, 2, 482, BlockLoader.roadDotted, 5);
		this.setBlock(8, 2, 480, BlockLoader.roadSideLine, 5);
		this.setBlock(482, 2, 482, BlockLoader.roadDotted, 2);
		this.setBlock(480, 2, 480, BlockLoader.roadSideLine, 2);
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				boolean flag = false;
				while (!flag) {
					int weight = 0;
					Iterator<GenBuilding> it = this.buildingGen.iterator();
					while (it.hasNext()) {
						weight += it.next().getWeight();
					}
					weight = rand.nextInt(weight);
					it = this.buildingGen.iterator();
					while (it.hasNext()) {
						GenBuilding gen = it.next();
						if (gen.getWeight() > weight) {
							flag = gen.generate(this, this.rand, 9 + i * 40, 2, 9 + j * 40);
							break;
						} else {
							weight -= gen.getWeight();
						}
					}
				}
			}
		}
		this.isInit = true;
	}

	public void setBlock(int x, int y, int z, Block block, int meta) {
		this.data[x][y][z][0] = Block.getIdFromBlock(block);
		this.data[x][y][z][1] = meta;
	}

	public void genChunk(World world, int chunkX, int chunkZ) {
		if (chunkX > 30 || chunkX < 0 || chunkZ > 30 || chunkZ < 0) {
			return;
		}
		System.out.println("Start generate in " + chunkX + "|" + chunkZ);
		long time = new Date().getTime();
		for (int i = chunkX * 16; i < chunkX * 16 + 16 && i < 489; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = chunkZ * 16; k < chunkZ * 16 + 16 && k < 489; k++) {
					Block block = Block.getBlockById(data[i][j][k][0]);
					world.setBlock(i, j + this.y, k, block, data[i][j][k][1], 2);
					if (block == BlockLoader.gasBurner || block == BlockLoader.ambry || block == BlockLoader.shoeArc
							|| block == BlockLoader.desk || block == BlockLoader.bedsideTable
							|| block == BlockLoader.fridge) {
						((IInitableTE) world.getTileEntity(i, j + this.y, k)).init();
					}
				}
			}
		}
		System.out.println("Spawn as " + chunkX + "|" + chunkZ + " used " + (new Date().getTime() - time) + " ms.");
	}
}
