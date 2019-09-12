package com.huajiliming.digcraft.item;

import java.util.List;
import java.util.Random;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;

import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBattleFury extends ItemSword {
	public ItemBattleFury() {
		super(((ItemMaterial) ItemLoader.emberStone).toolMaterial);
		setUnlocalizedName("battleFury");
		setTextureName("digcraft:battleFury");
		setCreativeTab(CreativeTabsLoader.tabDigcraft);
		setMaxDamage(-1);
	}

	public static class selectEntityInSector implements IEntitySelector {
		private EntityPlayer player;
		private EntityLivingBase target;
		private final float angle;

		public selectEntityInSector(EntityPlayer player, EntityLivingBase target) {
			this.player = player;
			this.target = target;
			this.angle = posToAngle(this.player.posX, this.player.posZ, target.posX, target.posZ);
		}

		@Override
		public boolean isEntityApplicable(Entity entity) {
			if ((!entity.equals(this.target)) && ((entity instanceof EntityLivingBase))
					&& (this.player.getDistanceToEntity(entity) <= 10.0F)) {
				float angle = posToAngle(this.player.posX, this.player.posZ, entity.posX, entity.posZ);
				if (Math.abs(angle - this.angle) <= 30.0F) {
					return true;
				}
			}
			return false;
		}

		public float posToAngle(double x1, double y1, double x2, double y2) {
			int quadrant;
			if (x1 >= x2) {
				if (y1 >= y2) {
					quadrant = 1;
				} else {
					quadrant = 4;
				}
			} else {
				if (y1 >= y2) {
					quadrant = 2;
				} else {
					quadrant = 3;
				}
			}
			switch (quadrant) {
			case 1:
			case 3:
				double x = Math.abs(x1 - x2);
				double d1 = Math.abs(y1 - y2);
			}
			double x = Math.abs(y1 - y2);
			double y = Math.abs(x1 - x2);

			double angle = Math.atan2(x, y) * 180.0D / 3.141592653589793D;
			switch (quadrant) {
			case 1:
				angle += 90.0D;
				break;
			case 2:
				angle += 180.0D;
				break;
			case 3:
				angle += 270.0D;
				break;
			case 4:
				angle = 90.0D - angle;
			}
			if (angle >= 360.0D) {
				angle -= 360.0D;
			}
			return (float) angle;
		}
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if ((!player.worldObj.isRemote) && ((entity instanceof EntityLivingBase))) {
			EntityLivingBase entityLiving = (EntityLivingBase) entity;
			selectEntityInSector selector = new selectEntityInSector(player, entityLiving);
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(player.posX - 10.0D, player.posY - 10.0D,
					player.posZ - 10.0D, player.posX + 10.0D, player.posY + 10.0D, player.posZ + 10.0D);
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb, selector);
			for (Object i : list) {
				EntityLivingBase living = (EntityLivingBase) i;
				doAttackWithoutEvent(player, living);
			}
		}
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Random rand = new Random();
		world.setSpawnLocation((int) player.posX, (int) player.posY, (int) player.posZ);
		for (int i = 0; i < 50; i++) {
			Entity entity = new EntityDragon(world);
			entity.setPosition(player.posX + rand.nextInt(200) - 100, player.posY + 50 + rand.nextInt(20) - 10,
					player.posZ + rand.nextInt(200) - 100);
			world.spawnEntityInWorld(entity);
		}
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float posX, float posY, float posZ) {
		return false;
	}

	public void doAttackWithoutEvent(EntityPlayer player, Entity entity) {
		float f = (float) player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		int i = 0;
		float f1 = 0.0F;
		if ((entity instanceof EntityLivingBase)) {
			f1 = EnchantmentHelper.getEnchantmentModifierLiving(player, (EntityLivingBase) entity);
			i += EnchantmentHelper.getKnockbackModifier(player, (EntityLivingBase) entity);
		}
		if (player.isSprinting()) {
			i++;
		}
		if ((f > 0.0F) || (f1 > 0.0F)) {
			boolean flag = (player.fallDistance > 0.0F) && (!player.onGround) && (!player.isOnLadder())
					&& (!player.isInWater()) && (!player.isPotionActive(Potion.blindness))
					&& (player.ridingEntity == null) && ((player instanceof EntityLivingBase));
			if ((flag) && (f > 0.0F)) {
				f *= 1.5F;
			}
			f += f1;
			boolean flag1 = false;
			int j = EnchantmentHelper.getFireAspectModifier(player);
			if (((entity instanceof EntityLivingBase)) && (j > 0) && (!entity.isBurning())) {
				flag1 = true;
				entity.setFire(1);
			}
			boolean flag2 = entity.attackEntityFrom(DamageSource.causePlayerDamage(player), f);
			if (flag2) {
				if (i > 0) {
					entity.addVelocity(-MathHelper.sin(player.rotationYaw * 3.1415927F / 180.0F) * i * 0.5F, 0.1D,
							MathHelper.cos(player.rotationYaw * 3.1415927F / 180.0F) * i * 0.5F);
					player.motionX *= 0.6D;
					player.motionZ *= 0.6D;
					player.setSprinting(false);
				}
				if (flag) {
					player.onCriticalHit(entity);
				}
				if (f1 > 0.0F) {
					player.onEnchantmentCritical(entity);
				}
				if (f >= 18.0F) {
					player.triggerAchievement(AchievementList.overkill);
				}
				player.setLastAttacker(entity);
				if ((entity instanceof EntityLivingBase)) {
					EnchantmentHelper.func_151384_a((EntityLivingBase) entity, player);
				}
				EnchantmentHelper.func_151385_b(player, entity);
				ItemStack itemstack = player.getCurrentEquippedItem();
				Object object = entity;
				if ((entity instanceof EntityDragonPart)) {
					IEntityMultiPart ientitymultipart = ((EntityDragonPart) entity).entityDragonObj;
					if ((ientitymultipart != null) && ((ientitymultipart instanceof EntityLivingBase))) {
						object = ientitymultipart;
					}
				}
				if ((itemstack != null) && ((object instanceof EntityLivingBase))) {
					itemstack.hitEntity((EntityLivingBase) object, player);
					if (itemstack.stackSize <= 0) {
						player.destroyCurrentEquippedItem();
					}
				}
				if ((entity instanceof EntityLivingBase)) {
					player.addStat(StatList.damageDealtStat, Math.round(f * 10.0F));
					if (j > 0) {
						entity.setFire(j * 4);
					}
				}
				player.addExhaustion(0.3F);
			} else if (flag1) {
				entity.extinguish();
			}
		}
	}
}