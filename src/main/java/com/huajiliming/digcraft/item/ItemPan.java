package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPan extends Item {
	public ItemPan() {
		this.setUnlocalizedName("pan");
		this.setTextureName("digcraft:pan");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);

	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		if (face == 1 && world.getBlock(x, y, z) == BlockLoader.gasBurner && world.getBlockMetadata(x, y, z) < 8) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 8, 2);
			player.inventory.mainInventory[player.inventory.currentItem] = null;
			return true;
		}
		return false;
	}
}