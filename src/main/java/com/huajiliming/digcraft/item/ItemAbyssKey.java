package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.achievement.AchievementLoader;
import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.entity.EntityRitual;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAbyssKey extends Item {
	public ItemAbyssKey() {
		this.setUnlocalizedName("abyssKey");
		this.setTextureName("digcraft:abyssKey");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		if (!world.isRemote) {
			boolean[][][] pos = {
					{ { false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, true, true, true, true, true, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false } },
					{ { false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, true, true, false, false, false, true, true, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false } },
					{ { false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ true, true, false, false, false, false, false, true, true },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false } },
					{ { false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ true, false, false, false, false, false, false, false, true },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false } },
					{ { false, false, true, true, true, true, true, false, false },
							{ false, true, true, false, false, false, true, true, false },
							{ true, true, false, false, false, false, false, true, true },
							{ true, false, false, false, false, false, false, false, true },
							{ true, false, false, false, false, false, false, false, true },
							{ true, false, false, false, false, false, false, false, true },
							{ true, true, false, false, false, false, false, true, true },
							{ false, true, true, false, false, false, true, true, false },
							{ false, false, true, true, true, true, true, false, false } },
					{ { false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ true, false, false, false, false, false, false, false, true },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false } },
					{ { false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ true, true, false, false, false, false, false, true, true },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false } },
					{ { false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, true, true, false, false, false, true, true, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false } },
					{ { false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, true, true, true, true, true, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, true, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false },
							{ false, false, false, false, false, false, false, false, false } } };
			for (int i = 0; i <= 8; i++) {
				for (int j = 0; j <= 8; j++) {
					for (int k = 0; k <= 8; k++) {
						if (((pos[i][j][k] == false) || (world.getBlock(x + i - 4, y + j - 4,
								z + k - 4) != BlockLoader.ritualStructureBlock))
								&& ((pos[i][j][k] != false)
										|| (world.getBlock(x + i - 4, y + j - 4, z + k - 4) != Blocks.air))
								&& ((i != 4) || (j != 4) || (k != 4))) {
							return false;
						}
					}
				}
			}
			world.setBlock(x, y, z, Blocks.air);
			Entity ritual = new EntityRitual(world, x + 0.5F, y + 0.5F, z + 0.5F);
			world.spawnEntityInWorld(ritual);
			player.triggerAchievement(AchievementLoader.blackhole);
		}
		return true;
	}
}