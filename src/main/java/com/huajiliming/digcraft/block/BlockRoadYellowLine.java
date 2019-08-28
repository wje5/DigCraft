package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockRoadYellowLine extends Block {
	private IIcon[] icons = new IIcon[6];
	private IIcon other;

	public BlockRoadYellowLine() {
		super(Material.rock);
		this.setBlockName("roadYellowLine");
		this.setBlockTextureName("digcraft:pitch");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = register.registerIcon("digcraft:roadYellowLine_" + i);
		}
		this.other = register.registerIcon("digcraft:pitch");
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		int meta = world.getBlockMetadata(x, y, z);
		if (side != 1 || meta >= icons.length) {
			return this.other;
		}
		return this.icons[meta];
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.icons[0] : this.other;
	}
}
