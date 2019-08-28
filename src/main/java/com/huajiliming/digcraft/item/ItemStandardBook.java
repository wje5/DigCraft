package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.inventory.GuiScreenStandardBook;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStandardBook extends Item {
	private String name;

	public ItemStandardBook(String name) {
		this.setUnlocalizedName(name);
		this.setTextureName("digcraft:" + name);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		this.name = name;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		this.openScreen(stack, player);
		return stack;
	}

	@SideOnly(Side.CLIENT)
	private void openScreen(ItemStack stack, EntityPlayer player) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiScreenStandardBook(stack, "book." + this.name));
	}
}