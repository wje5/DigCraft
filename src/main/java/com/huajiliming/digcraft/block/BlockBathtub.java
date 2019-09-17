package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityBathtub;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBathtub extends BlockContainer {
	public BlockBathtub() {
		super(Material.clay);
		this.setHardness(1.0F);
		this.setBlockName("bathtub");
		this.setBlockTextureName("digcraft:bathtub");
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
		if (meta < 8) {
			switch (meta) {
			case 0:
				if (world.getBlock(x - 1, y, z) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			case 1:
				if (world.getBlock(x + 1, y, z) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
				if (world.getBlock(x, y, z + 1) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
				}
				break;
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 8) {
			switch (meta) {
			case 0:
			case 1:
				world.setBlockToAir(x - 1, y, z);
				world.setBlockToAir(x + 1, y, z);
				break;
			case 2:
			case 3:
				world.setBlockToAir(x, y, z - 1);
				world.setBlockToAir(x, y, z + 1);
				break;
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.6975F, 1.0F);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.bathtub : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.bathtub;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBathtub();
	}
}
