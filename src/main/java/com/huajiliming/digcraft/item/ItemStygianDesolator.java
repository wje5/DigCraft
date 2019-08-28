package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;

public class ItemStygianDesolator extends ItemSword {
	public ItemStygianDesolator() {
		super(((ItemMaterial) ItemLoader.mistarille).toolMaterial);
		this.setUnlocalizedName("stygianDesolator");
		this.setTextureName("digcraft:stygianDesolator");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if ((entity instanceof EntityLivingBase)) {
			EntityLivingBase entityLiving = (EntityLivingBase) entity;
			entityLiving.addPotionEffect(new PotionEffect(24, 300));
		}
		return false;
	}
}