package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityDiningChair;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDiningChair extends BlockContainer {
	public BlockDiningChair() {
		super(Material.wood);
		this.setHardness(1.0F);
		this.setBlockName("diningChair");
		this.setBlockTextureName("digcraft:diningChair");
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
			if (world.getBlock(x, y + 1, z) != BlockLoader.diningChair) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.diningChair));
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 8) {
			world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 8) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.375F, 0.875F);
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.diningChair : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.diningChair;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityDiningChair();
	}
}
