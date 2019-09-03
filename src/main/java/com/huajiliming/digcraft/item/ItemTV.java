package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTV extends Item {
	public ItemTV() {
		this.setUnlocalizedName("tv");
		this.setTextureName("digcraft:tv");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		switch (face) {
		case 0:
			return false;
		case 1:
			return false;
		case 2:
			if (this.trySetBlock(world, x - 1, y, z - 1, 4, face, player, stack)
					&& this.trySetBlock(world, x, y, z - 1, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z - 1, 4, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z - 1, 4, face, player, stack)
					&& this.trySetBlock(world, x, y + 1, z - 1, 4, face, player, stack)
					&& this.trySetBlock(world, x + 1, y + 1, z - 1, 4, face, player, stack)) {
				world.setBlock(x - 1, y, z - 1, BlockLoader.tv, 4, 2);
				world.setBlock(x, y, z - 1, BlockLoader.tv, 0, 2);
				world.setBlock(x + 1, y, z - 1, BlockLoader.tv, 4, 2);
				world.setBlock(x - 1, y + 1, z - 1, BlockLoader.tv, 8, 2);
				world.setBlock(x, y + 1, z - 1, BlockLoader.tv, 4, 2);
				world.setBlock(x + 1, y + 1, z - 1, BlockLoader.tv, 12, 2);
			} else {
				return false;
			}
			break;
		case 3:
			if (this.trySetBlock(world, x - 1, y, z + 1, 5, face, player, stack)
					&& this.trySetBlock(world, x, y, z + 1, 1, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z + 1, 5, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z + 1, 5, face, player, stack)
					&& this.trySetBlock(world, x, y + 1, z + 1, 5, face, player, stack)
					&& this.trySetBlock(world, x + 1, y + 1, z + 1, 5, face, player, stack)) {
				world.setBlock(x - 1, y, z + 1, BlockLoader.tv, 5, 2);
				world.setBlock(x, y, z + 1, BlockLoader.tv, 1, 2);
				world.setBlock(x + 1, y, z + 1, BlockLoader.tv, 5, 2);
				world.setBlock(x - 1, y + 1, z + 1, BlockLoader.tv, 9, 2);
				world.setBlock(x, y + 1, z + 1, BlockLoader.tv, 5, 2);
				world.setBlock(x + 1, y + 1, z + 1, BlockLoader.tv, 13, 2);
			} else {
				return false;
			}
			break;
		case 4:
			if (this.trySetBlock(world, x - 1, y, z - 1, 6, face, player, stack)
					&& this.trySetBlock(world, x - 1, y, z, 2, face, player, stack)
					&& this.trySetBlock(world, x - 1, y, z + 1, 6, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z - 1, 6, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z, 6, face, player, stack)
					&& this.trySetBlock(world, x - 1, y + 1, z + 1, 6, face, player, stack)) {
				world.setBlock(x - 1, y, z - 1, BlockLoader.tv, 6, 2);
				world.setBlock(x - 1, y, z, BlockLoader.tv, 2, 2);
				world.setBlock(x - 1, y, z + 1, BlockLoader.tv, 6, 2);
				world.setBlock(x - 1, y + 1, z - 1, BlockLoader.tv, 10, 2);
				world.setBlock(x - 1, y + 1, z, BlockLoader.tv, 6, 2);
				world.setBlock(x - 1, y + 1, z + 1, BlockLoader.tv, 14, 2);
			} else {
				return false;
			}
			break;
		case 5:
			if (this.trySetBlock(world, x + 1, y, z - 1, 7, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z, 3, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z + 1, 7, face, player, stack)) {
				world.setBlock(x + 1, y, z - 1, BlockLoader.tv, 7, 2);
				world.setBlock(x + 1, y, z, BlockLoader.tv, 3, 2);
				world.setBlock(x + 1, y, z + 1, BlockLoader.tv, 7, 2);
				world.setBlock(x + 1, y + 1, z - 1, BlockLoader.tv, 11, 2);
				world.setBlock(x + 1, y + 1, z, BlockLoader.tv, 7, 2);
				world.setBlock(x + 1, y + 1, z + 1, BlockLoader.tv, 15, 2);
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
