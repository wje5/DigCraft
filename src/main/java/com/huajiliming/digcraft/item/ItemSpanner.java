package com.huajiliming.digcraft.item;

import java.util.List;

import com.huajiliming.digcraft.block.IBindable;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSpanner extends Item {
	public ItemSpanner() {
		this.setUnlocalizedName("spanner");
		this.setTextureName("digcraft:spanner");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		this.setMaxDamage(250);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		if (!world.isRemote) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag == null) {
				tag = new NBTTagCompound();
			}
			int[] pos = tag.getIntArray("pos");
			int worldId = tag.getInteger("world");
			if (player.isSneaking()) {
				pos = new int[0];
			} else {
				Block block = world.getBlock(x, y, z);
				if (block instanceof IBindable) {
					if (pos.length == 0) {
						pos = new int[] { x, y, z };
						worldId = world.provider.dimensionId;
					} else if (!(pos[0] == x && pos[1] == y && pos[2] == z)) {
						World world1 = ((EntityPlayerMP) player).mcServer.worldServerForDimension(worldId);
						Block block1 = world1.getBlock(pos[0], pos[1], pos[2]);
						if (block instanceof IBindable
								&& ((IBindable) block).canBind(world, x, y, z, world1, pos[0], pos[1], pos[2])
								&& block1 instanceof IBindable
								&& ((IBindable) block1).canBind(world1, pos[0], pos[1], pos[2], world, x, y, z)) {
							((IBindable) block).bind(world, x, y, z, world1, pos[0], pos[1], pos[2]);
							((IBindable) block1).bind(world1, pos[0], pos[1], pos[2], world, x, y, z);
							pos = new int[0];
						}
					}
				}
			}
			tag.setIntArray("pos", pos);
			tag.setInteger("world", worldId);
			stack.setTagCompound(tag);
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean wut) {
		if (stack != null) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null && tag.hasKey("pos")) {
				int[] pos = tag.getIntArray("pos");
				if (pos.length != 0) {
					tooltip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("tooltip.spanner.record")
							+ pos[0] + "-" + pos[1] + "-" + pos[2]);
				}
			}
		}
	}
}