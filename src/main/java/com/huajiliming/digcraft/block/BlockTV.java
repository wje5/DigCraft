package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityTV;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTV extends BlockContainer {
	public BlockTV() {
		super(Material.circuits);
		this.setHardness(1.0F);
		this.setBlockName("tv");
		this.setBlockTextureName("digcraft:tv");
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 4) {
			switch (meta) {
			case 0:
				if (world.getBlock(x, y, z + 1) == null || !world.getBlock(x, y, z + 1).isOpaqueCube()
						|| world.getBlock(x - 1, y, z) != BlockLoader.tv
						|| world.getBlock(x + 1, y, z) != BlockLoader.tv
						|| world.getBlock(x - 1, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x + 1, y + 1, z) != BlockLoader.tv) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.tv));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x - 1, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y + 1, z, Blocks.air, 0, 2);
				}
				break;
			case 1:
				if (world.getBlock(x, y, z - 1) == null || !world.getBlock(x, y, z - 1).isOpaqueCube()
						|| world.getBlock(x - 1, y, z) != BlockLoader.tv
						|| world.getBlock(x + 1, y, z) != BlockLoader.tv
						|| world.getBlock(x - 1, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x + 1, y + 1, z) != BlockLoader.tv) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.tv));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x - 1, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y + 1, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
				if (world.getBlock(x + 1, y, z) == null || !world.getBlock(x + 1, y, z).isOpaqueCube()
						|| world.getBlock(x, y, z - 1) != BlockLoader.tv
						|| world.getBlock(x, y, z + 1) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z - 1) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z + 1) != BlockLoader.tv) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.tv));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z + 1, Blocks.air, 0, 2);
				}
				break;
			case 3:
				if (world.getBlock(x - 1, y, z + 1) == null || !world.getBlock(x - 1, y, z).isOpaqueCube()
						|| world.getBlock(x, y, z - 1) != BlockLoader.tv
						|| world.getBlock(x, y, z + 1) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z - 1) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z) != BlockLoader.tv
						|| world.getBlock(x, y + 1, z + 1) != BlockLoader.tv) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.tv));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z + 1, Blocks.air, 0, 2);
				}
				break;
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta % 4) {
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.875F, 1.0F, 1.0F, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.125F);
			break;
		case 2:
			this.setBlockBounds(0.875F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.125F, 1.0F, 1.0F);
			break;
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 4) {
			switch (meta) {
			case 0:
			case 1:
				world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
				world.setBlock(x - 1, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x + 1, y + 1, z, Blocks.air, 0, 2);
				break;
			case 2:
			case 3:
				world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z - 1, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z + 1, Blocks.air, 0, 2);
				break;
			}
		} else if (meta >= 8) {
			switch (meta) {
			case 8:
			case 9:
				if (world.getBlock(x + 1, y - 1, z) == this) {
					this.dropBlockAsItem(world, x + 1, y - 1, z, new ItemStack(ItemLoader.tv));
				}
				world.setBlock(x + 1, y - 1, z, Blocks.air, 0, 2);
				break;
			case 10:
			case 11:
				if (world.getBlock(x, y - 1, z + 1) == this) {
					this.dropBlockAsItem(world, x, y - 1, z + 1, new ItemStack(ItemLoader.tv));
				}
				world.setBlock(x, y - 1, z + 1, Blocks.air, 0, 2);
				break;
			case 12:
			case 13:
				if (world.getBlock(x - 1, y - 1, z) == this) {
					this.dropBlockAsItem(world, x - 1, y - 1, z, new ItemStack(ItemLoader.tv));
				}
				world.setBlock(x - 1, y - 1, z, Blocks.air, 0, 2);
				break;
			case 14:
			case 15:
				if (world.getBlock(x, y - 1, z - 1) == this) {
					this.dropBlockAsItem(world, x, y - 1, z - 1, new ItemStack(ItemLoader.tv));
				}
				world.setBlock(x, y - 1, z - 1, Blocks.air, 0, 2);
				break;
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 4 ? ItemLoader.tv : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.tv;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityTV();
	}

}
