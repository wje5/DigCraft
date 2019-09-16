package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLargeBed extends Item {
	public ItemLargeBed() {
		this.setUnlocalizedName("largeBed");
		this.setTextureName("digcraft:largeBed");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		switch (face) {
		case 0:
			if (this.trySetBlock(world, x - 1, y - 1, z, 10, face, player, stack)
					&& this.trySetBlock(world, x, y - 1, z, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y - 1, z, 11, face, player, stack)) {
				world.setBlock(x - 1, y - 1, z, BlockLoader.longTable, 10, 2);
				world.setBlock(x, y - 1, z, BlockLoader.longTable, 0, 2);
				world.setBlock(x + 1, y - 1, z, BlockLoader.longTable, 11, 2);
			} else {
				return false;
			}
			break;
		case 1:
			if (this.trySetBlock(world, x - 1, y + 1, z, 10, face, player, stack)
					&& this.trySetBlock(world, x, y + 1, z, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y + 1, z, 11, face, player, stack)) {
				world.setBlock(x - 1, y + 1, z, BlockLoader.longTable, 10, 2);
				world.setBlock(x, y + 1, z, BlockLoader.longTable, 0, 2);
				world.setBlock(x + 1, y + 1, z, BlockLoader.longTable, 11, 2);
			} else {
				return false;
			}
			break;
		case 2:
			if (this.trySetBlock(world, x - 1, y, z - 1, 10, face, player, stack)
					&& this.trySetBlock(world, x, y, z - 1, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z - 1, 11, face, player, stack)) {
				world.setBlock(x - 1, y, z - 1, BlockLoader.longTable, 10, 2);
				world.setBlock(x, y, z - 1, BlockLoader.longTable, 0, 2);
				world.setBlock(x + 1, y, z - 1, BlockLoader.longTable, 11, 2);
			} else {
				return false;
			}
			break;
		case 3:
			if (this.trySetBlock(world, x - 1, y, z + 1, 10, face, player, stack)
					&& this.trySetBlock(world, x, y, z + 1, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z + 1, 11, face, player, stack)) {
				world.setBlock(x - 1, y, z + 1, BlockLoader.longTable, 10, 2);
				world.setBlock(x, y, z + 1, BlockLoader.longTable, 1, 2);
				world.setBlock(x + 1, y, z + 1, BlockLoader.longTable, 11, 2);
			} else {
				return false;
			}
			break;
		case 4:
			if (this.trySetBlock(world, x - 1, y, z - 1, 10, face, player, stack)
					&& this.trySetBlock(world, x - 1, y, z, 0, face, player, stack)
					&& this.trySetBlock(world, x - 1, y, z + 1, 11, face, player, stack)) {
				world.setBlock(x - 1, y, z - 1, BlockLoader.longTable, 8, 2);
				world.setBlock(x - 1, y, z, BlockLoader.longTable, 2, 2);
				world.setBlock(x - 1, y, z + 1, BlockLoader.longTable, 9, 2);
			} else {
				return false;
			}
			break;
		case 5:
			if (this.trySetBlock(world, x + 1, y, z - 1, 10, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z, 0, face, player, stack)
					&& this.trySetBlock(world, x + 1, y, z + 1, 11, face, player, stack)) {
				world.setBlock(x + 1, y, z - 1, BlockLoader.longTable, 8, 2);
				world.setBlock(x + 1, y, z, BlockLoader.longTable, 3, 2);
				world.setBlock(x + 1, y, z + 1, BlockLoader.longTable, 9, 2);
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
