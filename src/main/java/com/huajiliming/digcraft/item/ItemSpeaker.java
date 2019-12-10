package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpeaker extends Item {
	public ItemSpeaker() {
		this.setUnlocalizedName("speaker");
		this.setTextureName("digcraft:speaker");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		switch (face) {
		case 0:
			return false;
		case 1:
			if (this.trySetBlock(world, x, y + 1, z, 0, face, player, stack)
					&& this.trySetBlock(world, x, y + 2, z, 8, face, player, stack)) {
				world.setBlock(x, y + 1, z, BlockLoader.speaker, 0, 2);
				world.setBlock(x, y + 2, z, BlockLoader.speaker, 8, 2);
			} else {
				return false;
			}
			break;
		case 2:
			if (this.trySetBlock(world, x, y, z - 1, 0, face, player, stack)
					&& this.trySetBlock(world, x, y + 1, z - 1, 8, face, player, stack)) {
				world.setBlock(x, y, z - 1, BlockLoader.speaker, 0, 2);
				world.setBlock(x, y + 1, z - 1, BlockLoader.speaker, 8, 2);
			} else {
				return false;
			}
			break;
		case 3:
			if (this.trySetBlock(world, x, y, z + 1, 0, face, player, stack)
					&& this.trySetBlock(world, x, y + 1, z + 1, 8, face, player, stack)) {
				world.setBlock(x, y, z + 1, BlockLoader.speaker, 1, 2);
				world.setBlock(x, y + 1, z + 1, BlockLoader.speaker, 9, 2);
			} else {
				return false;
			}
			break;
		case 4:
			if (this.trySetBlock(world, x - 1, y, z, 0, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z, 8, face, player, stack)) {
				world.setBlock(x - 1, y, z, BlockLoader.speaker, 2, 2);
				world.setBlock(x - 1, y + 1, z, BlockLoader.speaker, 10, 2);
			} else {
				return false;
			}
			break;
		case 5:
			if (this.trySetBlock(world, x + 1, y, z, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y + 1, z, 8, face, player, stack)) {
				world.setBlock(x + 1, y, z, BlockLoader.speaker, 3, 2);
				world.setBlock(x + 1, y + 1, z, BlockLoader.speaker, 11, 2);
			} else {
				return false;
			}
			break;
		}
		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
			if (stack.stackSize <= 0) {
				stack = null;
			}
		}
		return true;
	}

	private boolean trySetBlock(World world, int x, int y, int z, int meta, int face, EntityPlayer player,
			ItemStack stack) {
		return player.canPlayerEdit(x, y, z, face, stack) && world.isAirBlock(x, y, z);
	}
}
