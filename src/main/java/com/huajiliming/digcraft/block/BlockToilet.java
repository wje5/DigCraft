package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.tileentity.TileEntityToilet;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockToilet extends BlockContainer {
	public BlockToilet() {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setBlockName("toilet");
		this.setBlockTextureName("digcraft:toilet");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		int meta = BlockPistonBase.determineOrientation(world, x, y, z, entity);
		if ((meta == 0) || (meta == 1)) {
			meta = 2;
		}
		meta -= 2;
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
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
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
			this.setBlockBounds(0.125F, 0.0F, 0.0625F, 0.875F, 1.0F, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 0.9375F);
			break;
		case 2:
			this.setBlockBounds(0.0625F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.125F, 0.9375F, 1.0F, 0.875F);
			break;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityToilet();
	}
}
