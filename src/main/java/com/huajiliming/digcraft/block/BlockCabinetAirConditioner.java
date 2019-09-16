package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityCabinetAirConditioner;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCabinetAirConditioner extends BlockContainer {
	public BlockCabinetAirConditioner() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setBlockName("cabinetAirConditioner");
		this.setBlockTextureName("digcraft:cabinetAirConditioner");
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 4) {
			world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
			world.setBlock(x, y + 2, z, Blocks.air, 0, 2);
		}
		super.breakBlock(world, x, y, z, block, meta);
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
			if (world.getBlock(x, y + 1, z) != BlockLoader.cabinetAirConditioner
					|| world.getBlock(x, y + 2, z) != BlockLoader.cabinetAirConditioner) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.cabinetAirConditioner));
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 2, z, Blocks.air, 0, 2);
			}
		} else if (meta < 8) {
			if (world.getBlock(x, y + 1, z) != BlockLoader.cabinetAirConditioner
					|| world.getBlock(x, y - 1, z) != BlockLoader.cabinetAirConditioner) {
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y - 1, z, Blocks.air, 0, 2);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.cabinetAirConditioner));
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta % 4) {
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 1.0F, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.8125F);
			break;
		case 2:
			this.setBlockBounds(0.1875F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.8125F, 1.0F, 1.0F);
			break;
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 4 ? ItemLoader.cabinetAirConditioner : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.cabinetAirConditioner;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCabinetAirConditioner();
	}
}
