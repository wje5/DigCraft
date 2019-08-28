package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.tileentity.IBindableTE;
import com.huajiliming.digcraft.tileentity.TileEntityFluorescentLamp;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFluorescentLamp extends BlockContainer implements IBindable {
	public BlockFluorescentLamp() {
		super(Material.circuits);
		this.setHardness(1.0F);
		this.setBlockName("fluorescentLamp");
		this.setBlockTextureName("digcraft:fluorescentLamp");
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
		return face == 0 ? this.canPlaceBlockAt(world, x, y, z) : false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		this.unBind(world, x, y, z);
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public boolean canBind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ) {
		return bindWorld.getBlock(bindX, bindY, bindZ) == BlockLoader.wallSwitch;
	}

	@Override
	public void bind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ) {
		((IBindableTE) world.getTileEntity(x, y, z)).bind(bindWorld, bindX, bindY, bindZ);
	}

	@Override
	public void unBind(World world, int x, int y, int z) {
		((IBindableTE) world.getTileEntity(x, y, z)).unBind();
	}
}
