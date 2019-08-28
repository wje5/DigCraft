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
			case 1:
				if (world.getBlock(x - 1, y, z) != BlockLoader.tv || world.getBlock(x + 1, y, z) != BlockLoader.tv
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
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.tv || world.getBlock(x, y, z + 1) != BlockLoader.tv) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.tv));
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
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
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.tv : null;
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
