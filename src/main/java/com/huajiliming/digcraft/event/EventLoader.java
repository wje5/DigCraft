package com.huajiliming.digcraft.event;

import com.huajiliming.digcraft.achievement.AchievementLoader;
import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.entity.EntityGrayJadeGolem;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.key.KeyLoader;
import com.huajiliming.digcraft.network.MessageKeyboardInput;
import com.huajiliming.digcraft.network.NetworkHandler;
import com.huajiliming.digcraft.potioneffect.PotionLoader;
import com.huajiliming.digcraft.world.gen.OreGenerateHandler;
import com.huajiliming.digcraft.worldstorage.GolemWorldSavedData;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class EventLoader {
	OreGenerateHandler gen;

	public EventLoader() {
		MinecraftForge.ORE_GEN_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
		this.gen = new OreGenerateHandler();
	}

	@SubscribeEvent
	public void onGenerateOres(OreGenEvent.Post event) {
		if (event.world.provider.getDimensionName() == "Overworld") {
			this.gen.generateOres(event.world, event.worldX, event.worldZ);
		}
	}

	@SubscribeEvent
	public void onGenerateNetherOres(DecorateBiomeEvent.Post event) {
		if (event.world.provider.getDimensionName() == "Nether") {
			this.gen.generateNetherOres(event.world, event.chunkX, event.chunkZ);
		}
	}

	@SubscribeEvent
	public void onPlayerDestroyItem(PlayerDestroyItemEvent event) {
		if ((event.original != null) && (event.original.getItem() == ItemLoader.grayJadeDagger)) {
			EntityGrayJadeGolem golem = new EntityGrayJadeGolem(event.entityPlayer.worldObj);
			int summonTime = GolemWorldSavedData.getGlobal(event.entityPlayer.worldObj).addSummonTime();
			golem.setSummonTime(summonTime);
			golem.setPlayerCreated(true);
			golem.setPositionAndRotation(event.entityPlayer.posX, event.entityPlayer.posY + 3.0D + summonTime * 0.3F,
					event.entityPlayer.posZ,
					MathHelper.wrapAngleTo180_float(event.entityPlayer.worldObj.rand.nextFloat() * 360.0F), 0.0F);
			event.entityPlayer.worldObj.spawnEntityInWorld(golem);
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		if (event.source instanceof EntityDamageSource
				&& ((EntityDamageSource) event.source).getEntity() instanceof EntityGrayJadeGolem) {
			event.ammount *= ((EntityDamageSource) event.source).getEntity().getDataWatcher().getWatchableObjectInt(17)
					* 0.1F;
		}
		if (event.source.equals(DamageSource.fall) && event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if ((player.getCurrentArmor(0) != null)
					&& (player.getCurrentArmor(0).getItem() == ItemLoader.meteoricSteelBoots)
					&& (player.getCurrentArmor(1) != null)
					&& (player.getCurrentArmor(1).getItem() == ItemLoader.meteoricSteelLeggings)
					&& (player.getCurrentArmor(2) != null)
					&& (player.getCurrentArmor(2).getItem() == ItemLoader.meteoricSteelChestplate)) {
				event.ammount /= 2.5;
			}
		}
		if ((event.entityLiving.getActivePotionEffect(PotionLoader.armorReduction) != null)
				&& (!event.source.isUnblockable())) {
			float reductionArmorDamage = (1.0F - (event.entityLiving.getTotalArmorValue() - 7) * 0.04F) * event.ammount;
			float extraDamage = reductionArmorDamage
					- (1.0F - event.entityLiving.getTotalArmorValue() * 0.04F) * event.ammount;
			event.entityLiving.setHealth(event.entityLiving.getHealth() - extraDamage);
		}
	}

	@SubscribeEvent
	public void onPlayerPickupItem(EntityItemPickupEvent event) {
		if (event.item.getEntityItem() == null) {
			return;
		}
		Item item = event.item.getEntityItem().getItem();
		if (item == ItemLoader.sapphire || item == ItemLoader.ruby) {
			event.entityPlayer.triggerAchievement(AchievementLoader.ruby);
		} else if (item == ItemLoader.sulfur) {
			event.entityPlayer.triggerAchievement(AchievementLoader.sulfur);
		} else if (item == ItemLoader.amethyst) {
			event.entityPlayer.triggerAchievement(AchievementLoader.amethyst);
		} else if (item == ItemLoader.devilStone) {
			event.entityPlayer.triggerAchievement(AchievementLoader.devilStone);
		} else if (item == ItemLoader.soulBooster) {
			event.entityPlayer.triggerAchievement(AchievementLoader.soulBooster);
		} else if (item == ItemLoader.energyCrystal) {
			event.entityPlayer.triggerAchievement(AchievementLoader.energyCrystal);
		} else if (item == ItemLoader.emberStone) {
			event.entityPlayer.triggerAchievement(AchievementLoader.emberStone);
		} else if (item == ItemLoader.encourageStone) {
			event.entityPlayer.triggerAchievement(AchievementLoader.encourageStone);
		} else if (item == ItemLoader.blightStone) {
			event.entityPlayer.triggerAchievement(AchievementLoader.blightStone);
		} else if (item == ItemLoader.grayJade) {
			event.entityPlayer.triggerAchievement(AchievementLoader.grayJade);
		} else if (item == ItemLoader.gloryStone) {
			event.entityPlayer.triggerAchievement(AchievementLoader.gloryStone);
		}
	}

	@SubscribeEvent
	public void onItemSmelted(ItemSmeltedEvent event) {
		if (event.smelting == null) {
			return;
		}
		Item item = event.smelting.getItem();
		if (item == ItemLoader.aluminium) {
			event.player.triggerAchievement(AchievementLoader.aluminium);
		} else if (item == ItemLoader.forgetMetal) {
			event.player.triggerAchievement(AchievementLoader.forgetMetal);
		} else if (item == ItemLoader.abyss) {
			event.player.triggerAchievement(AchievementLoader.abyss);
		} else if (item == ItemLoader.sunlitAlloy) {
			event.player.triggerAchievement(AchievementLoader.sunlitAlloy);
		} else if (item == ItemLoader.toxic) {
			event.player.triggerAchievement(AchievementLoader.toxic);
		} else if (item == ItemLoader.annihilate) {
			event.player.triggerAchievement(AchievementLoader.annihilate);
		} else if (item == ItemLoader.mistarille) {
			event.player.triggerAchievement(AchievementLoader.mistarille);
		} else if (item == ItemLoader.glow) {
			event.player.triggerAchievement(AchievementLoader.glow);
		} else if (item == ItemLoader.meteoricSteel) {
			event.player.triggerAchievement(AchievementLoader.meteoricSteel);
		}
	}

	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event) {
		if (event.crafting == null) {
			return;
		}
		Item item = event.crafting.getItem();
		if (item == Item.getItemFromBlock(BlockLoader.smelter)) {
			event.player.triggerAchievement(AchievementLoader.smelter);
		} else if (item == ItemLoader.battleFury) {
			event.player.triggerAchievement(AchievementLoader.battleFury);
		} else if (item == ItemLoader.stygianDesolator) {
			event.player.triggerAchievement(AchievementLoader.stygianDesolator);
		} else if (item == ItemLoader.grayJadeDagger) {
			event.player.triggerAchievement(AchievementLoader.grayJadeDagger);
		}
	}

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		if (KeyLoader.increaseThrust.isPressed()) {
			NetworkHandler.instance.sendToServer(new MessageKeyboardInput(0));
		}
		if (KeyLoader.decreaseThrust.isPressed()) {
			NetworkHandler.instance.sendToServer(new MessageKeyboardInput(1));
		}
	}
}