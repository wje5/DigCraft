package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.tileentity.TileEntityCastingTable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCastingTable extends BlockContainer {

	protected BlockCastingTable() {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setBlockName("castingTable");
		this.setBlockTextureName("digcraft:castingTable");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		if (!world.isRemote) {
			TileEntityCastingTable te = (TileEntityCastingTable) world.getTileEntity(x, y, z);
			if (te != null && te.tryTake()) {
				world.spawnEntityInWorld(
						new EntityItem(world, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack(Items.iron_ingot)));
				return true;
			}
		}
		return false;
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
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityCastingTable te = (TileEntityCastingTable) world.getTileEntity(x, y, z);
		if (te != null && te.tryTake()) {
			world.spawnEntityInWorld(
					new EntityItem(world, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack(Items.iron_ingot)));
			world.func_147453_f(x, y, z, block);
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
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.6875F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCastingTable();
	}
}
