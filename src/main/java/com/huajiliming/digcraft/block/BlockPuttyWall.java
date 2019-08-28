package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPuttyWall extends Block {
	private IIcon[] icons = new IIcon[2];

	public BlockPuttyWall() {
		super(Material.rock);
		this.setBlockName("puttyWall");
		this.setBlockTextureName("digcraft:puttyWall");
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		world.setBlockMetadataWithNotify(x, y, z, BlockPistonBase.determineOrientation(world, x, y, z, entity), 2);
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		this.icons[0] = register.registerIcon("digcraft:puttyWall");
		this.icons[1] = register.registerIcon("digcraft:puttyWall_2");
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		int meta = world.getBlockMetadata(x, y, z);
		return this.icons[meta == side ? 0 : 1];
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side == 2 ? this.icons[0] : this.icons[1];
	}
}
