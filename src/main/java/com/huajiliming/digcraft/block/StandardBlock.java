package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StandardBlock extends Block {

	protected StandardBlock(String name, Material material) {
		super(material);
		this.setBlockName(name);
		this.setBlockTextureName("digcraft:" + name);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}
}
