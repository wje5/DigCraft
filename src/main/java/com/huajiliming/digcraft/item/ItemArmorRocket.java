package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.achievement.AchievementLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.model.ModelRocketBoot;
import com.huajiliming.digcraft.model.ModelRocketChestplate;
import com.huajiliming.digcraft.model.ModelRocketHelmet;
import com.huajiliming.digcraft.model.ModelRocketLegging;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemArmorRocket extends ItemArmor {
	public static final ItemArmor.ArmorMaterial METEORICSTEEL_ARMOR = EnumHelper.addArmorMaterial("METEORICSTEEL", 10,
			new int[] { 3, 7, 5, 3 }, 10);

	public ItemArmorRocket(int armorType) {
		super(METEORICSTEEL_ARMOR, 4, armorType);
	}

	public static class Helmet extends ItemArmorRocket {
		public Helmet() {
			super(0);
			this.setUnlocalizedName("meteoricSteelHelmet");
			this.setTextureName("digcraft:meteoricSteelHelmet");
			this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		}

		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			super.onArmorTick(world, player, itemStack);

			NBTTagCompound tag;
			if (!itemStack.hasTagCompound()) {
				tag = new NBTTagCompound();
			} else {
				tag = itemStack.getTagCompound();
			}
			double thrust = 0.0D;
			if (tag.hasKey("thrust")) {
				thrust = tag.getDouble("thrust");
			}
			if ((player.getCurrentArmor(0) != null)
					&& (player.getCurrentArmor(0).getItem() == ItemLoader.meteoricSteelBoots)
					&& (player.getCurrentArmor(1) != null)
					&& (player.getCurrentArmor(1).getItem() == ItemLoader.meteoricSteelLeggings)
					&& (player.getCurrentArmor(2) != null)
					&& (player.getCurrentArmor(2).getItem() == ItemLoader.meteoricSteelChestplate)) {
				player.triggerAchievement(AchievementLoader.meteoricSteelHelmet);
				if (player.posY >= 10000.0D) {
					player.triggerAchievement(AchievementLoader.space);
				}
				player.motionY += thrust;
				if (thrust > 0.0D) {
					for (int i = 0; i < ((int) (thrust / 0.1D)) + 1; i++) {
						world.spawnParticle("explode", player.posX - 0.25D, player.posY - 1.5D, player.posZ - 0.25D,
								itemRand.nextFloat() - 0.5F, 0.0D, itemRand.nextFloat() - 0.5F);
						world.spawnParticle("explode", player.posX - 0.25D, player.posY - 1.5D, player.posZ + 0.25D,
								itemRand.nextFloat() - 0.5F, 0.0D, itemRand.nextFloat() - 0.5F);
						world.spawnParticle("explode", player.posX + 0.25D, player.posY - 1.5D, player.posZ - 0.25D,
								itemRand.nextFloat() - 0.5F, 0.0D, itemRand.nextFloat() - 0.5F);
						world.spawnParticle("explode", player.posX + 0.25D, player.posY - 1.5D, player.posZ + 0.25D,
								itemRand.nextFloat() - 0.5F, 0.0D, itemRand.nextFloat() - 0.5F);
					}
				}
				if (player.motionY >= 0.0D) {
					player.fallDistance = 0.0F;
				}
			} else {
				thrust = 0.0D;
			}
			tag.setDouble("thrust", thrust);
			itemStack.setTagCompound(tag);
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			return "digcraft:textures/models/armor/rocketHelmet.png";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, int slot) {
			return new ModelRocketHelmet();
		}
	}

	public static class Chestplate extends ItemArmorRocket {
		public Chestplate() {
			super(1);
			this.setUnlocalizedName("meteoricSteelChestplate");
			this.setTextureName("digcraft:meteoricSteelChestplate");
			this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			return "digcraft:textures/models/armor/rocketChestplate.png";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, int slot) {
			return new ModelRocketChestplate();
		}
	}

	public static class Leggings extends ItemArmorRocket {
		public Leggings() {
			super(2);
			this.setUnlocalizedName("meteoricSteelLeggings");
			this.setTextureName("digcraft:meteoricSteelLeggings");
			this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			return "digcraft:textures/models/armor/rocketLegging.png";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, int slot) {
			return new ModelRocketLegging();
		}
	}

	public static class Boots extends ItemArmorRocket {
		public Boots() {
			super(3);
			this.setUnlocalizedName("meteoricSteelBoots");
			this.setTextureName("digcraft:meteoricSteelBoots");
			this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			return "digcraft:textures/models/armor/rocketBoot.png";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, int slot) {
			return new ModelRocketBoot();
		}
	}
}