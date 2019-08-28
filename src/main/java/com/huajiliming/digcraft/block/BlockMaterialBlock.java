package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.item.ItemMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMaterialBlock extends Block {
	public BlockMaterialBlock(ItemMaterial material) {
		this(material, material.name + "Block");
	}

	public BlockMaterialBlock(ItemMaterial material, String name) {
		super(Material.iron);
		setBlockName(name);
		setBlockTextureName("digcraft:" + name);
		setResistance(30.0F);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", material.level);
		setHardness(material.hardness);
		setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}
}