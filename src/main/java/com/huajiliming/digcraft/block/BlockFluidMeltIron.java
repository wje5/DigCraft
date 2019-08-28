package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.fluid.FluidLoader;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidMeltIron extends BlockFluidClassic {
	public IIcon still;
	public IIcon flow;

	public BlockFluidMeltIron() {
		super(FluidLoader.meltIron, Material.lava);
		this.setBlockName("fluidMeltIron");
		this.setBlockTextureName("digcraft:fluidMeltIron");
		this.setHardness(100.0F);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		this.still = register.registerIcon("digcraft:fluidMeltIron");
		this.flow = register.registerIcon("digcraft:fluidMeltIron_flow");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side < 2 ? this.flow : this.still;
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		return side < 2 ? this.flow : this.still;
	}
}
