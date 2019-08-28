package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityLongSofa;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLongSofa extends BlockContainer {
	public BlockLongSofa() {
		super(Material.cloth);
		this.setHardness(1.0F);
		this.setBlockName("longSofa");
		this.setBlockTextureName("digcraft:longSofa");
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
			case 1:
				if (world.getBlock(x - 1, y, z) != BlockLoader.longSofa
						|| world.getBlock(x + 1, y, z) != BlockLoader.longSofa) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.longSofa));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.longSofa
						|| world.getBlock(x, y, z + 1) != BlockLoader.longSofa) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.longSofa));
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
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
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
			break;
		case 2:
		case 3:
			this.setBlockBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
			break;
		case 8:
			this.setBlockBounds(0.125F, 0.0F, 0.3125F, 0.875F, 1.0F, 1.0F);
			break;
		case 9:
			this.setBlockBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 0.6875F);
			break;
		case 10:
			this.setBlockBounds(0.3125F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
			break;
		case 11:
			this.setBlockBounds(0.0F, 0.0F, 0.125F, 0.6875F, 1.0F, 0.875F);
			break;
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.longSofa : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.longSofa;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLongSofa();
	}
}
