package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.block.BlockMaterialOre;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.tileentity.TileEntityCrucible;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemDebugger extends Item {
	public ItemDebugger() {
		setUnlocalizedName("debugger");
		setTextureName("digcraft:debugger");
		setMaxStackSize(1);
		setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	public boolean find(World world, EntityPlayer player, Block block, int blockX, int blockY, int blockZ) {
		int x = (int) player.posX;
		int y = (int) player.posY;
		int z = (int) player.posZ;
		Block closestBlock = null;
		int closestBlockX = 0;
		int closestBlockY = 0;
		int closestBlockZ = 0;
		for (int i = x - 15; i <= x + 15; i++) {
			for (int j = y - 15; j <= y + 15; j++) {
				for (int k = z - 15; k <= z + 15; k++) {
					Block b = world.getBlock(i, j, k);
					if (((block != null) && (block == b) && ((i != blockX) || (j != blockY) || (k != blockZ)))
							|| ((block == null) && ((b instanceof BlockMaterialOre)))) {
						if ((closestBlock == null) || (player.getDistanceSq(closestBlockX, closestBlockY,
								closestBlockZ) > player.getDistanceSq(i, j, k))) {
							closestBlock = b;
							closestBlockX = i;
							closestBlockY = j;
							closestBlockZ = k;
						}
					}
				}
			}
		}
		if (block != null) {
			if (closestBlock == null) {
				player.addChatMessage(new ChatComponentTranslation("chat.digcraft.debugger.noBlock",
						new Object[] { block.getLocalizedName() }));
				return false;
			}
			player.addChatMessage(new ChatComponentTranslation("chat.digcraft.debugger.block",
					new Object[] { block.getLocalizedName(), Integer.valueOf(closestBlockX),
							Integer.valueOf(closestBlockY), Integer.valueOf(closestBlockZ) }));
			return true;
		}
		if (closestBlock == null) {
			player.addChatMessage(new ChatComponentTranslation("chat.digcraft.debugger.noOre", new Object[0]));
			return false;
		}
		player.addChatMessage(new ChatComponentTranslation("chat.digcraft.debugger.ore",
				new Object[] { closestBlock.getLocalizedName(), Integer.valueOf(closestBlockX),
						Integer.valueOf(closestBlockY), Integer.valueOf(closestBlockZ) }));
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			this.find(world, player, null, 0, 0, 0);
		}
		return stack;
	}

	public void detectCrucible(World world, EntityPlayer player, int x, int y, int z) {
		float temp = ((TileEntityCrucible) world.getTileEntity(x, y, z)).temp;
		player.addChatComponentMessage(new ChatComponentTranslation("chat.thermometer", temp));
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				player.addChatComponentMessage(
						new ChatComponentTranslation("chat.metadata", world.getBlockMetadata(x, y, z)));
			} else if (world.getBlock(x, y, z) == BlockLoader.crucible) {
				this.detectCrucible(world, player, x, y, z);
			} else {
				this.find(world, player, world.getBlock(x, y, z), x, y, z);
			}

		}
		return true;
	}
}