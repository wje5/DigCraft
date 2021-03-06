package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemMicroPhone extends Item {
	public ItemMicroPhone() {
		this.setUnlocalizedName("microPhone");
		this.setTextureName("digcraft:microPhone");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		NBTTagCompound tag = stack.getTagCompound();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		if (world.getBlock(x, y, z) == BlockLoader.speaker) {
			tag.setInteger("bindX", x);
			tag.setInteger("bindY", y);
			tag.setInteger("bindZ", z);
			tag.setBoolean("isBinded", true);
			stack.setTagCompound(tag);
			return true;
		}
		stack.setTagCompound(tag);
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		NBTTagCompound tag = stack.getTagCompound();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		if (tag.getBoolean("on")) {
			tag.setBoolean("on", false);
			if (world.isRemote) {
				player.addChatComponentMessage(new ChatComponentTranslation("chat.microPhone.off"));
			}

		} else {
			tag.setBoolean("on", true);
			if (world.isRemote) {
				player.addChatComponentMessage(new ChatComponentTranslation("chat.microPhone.on"));
			}
		}
		stack.setTagCompound(tag);
		return stack;
	}

	public boolean isOn(ItemStack stack) {
		NBTTagCompound tag = stack.getTagCompound();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		return tag.getBoolean("on");
	}
}