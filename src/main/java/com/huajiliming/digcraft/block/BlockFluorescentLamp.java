package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.tileentity.TileEntityFluorescentLamp;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFluorescentLamp extends BlockContainer {
	public BlockFluorescentLamp() {
		super(Material.circuits);
		this.setHardness(1.0F);
		this.setBlockName("fluorescentLamp");
		this.setBlockTextureName("digcraft:fluorescentLamp");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 8) {
			world.setBlock(x, y, z, BlockLoader.fluorescentLampLight, meta + 8, 2);
		} else {
			world.setBlock(x, y, z, BlockLoader.fluorescentLamp, meta - 8, 2);
		}
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (world.getBlock(x, y + 1, z) == null || !world.getBlock(x, y + 1, z).isOpaqueCube()) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(BlockLoader.fluorescentLamp));
			world.setBlockToAir(x, y, z);
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.9375F, 0.0F, 1.0F, 1.0F, 1.0F);
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
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFluorescentLamp();
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int face) {
		return face == 0;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(BlockLoader.fluorescentLamp);
	}
}
