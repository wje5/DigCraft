package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPaintBrush extends Item {
	public ItemPaintBrush() {
		this.setUnlocalizedName("paintBrush");
		this.setTextureName("digcraft:paintBrush");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		if (block == BlockLoader.roadDotted) {
			world.setBlockMetadataWithNotify(x, y, z, meta < 5 ? meta + 1 : 0, 2);
			return true;
		}
		if (block == BlockLoader.roadSideLine) {
			world.setBlockMetadataWithNotify(x, y, z, meta < 11 ? meta + 1 : 0, 2);
			return true;
		}
		if (block == BlockLoader.roadYellowLine) {
			world.setBlockMetadataWithNotify(x, y, z, meta < 5 ? meta + 1 : 0, 2);
			return true;
		}
		return false;
	}
}
