package com.huajiliming.digcraft.entity;

import com.huajiliming.digcraft.item.ItemLoader;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityGrayJadeGolem extends EntityIronGolem {
	public EntityGrayJadeGolem(World world) {
		super(world);
	}

	public void setSummonTime(int summonTime) {
		this.dataWatcher.updateObject(17, Integer.valueOf(summonTime));
	}

	@Override
	public float getRenderSizeModifier() {
		return 0.1F * this.dataWatcher.getWatchableObjectInt(17);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setInteger("summonTime", this.dataWatcher.getWatchableObjectInt(17));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.dataWatcher.updateObject(17, Integer.valueOf(tag.getInteger("summonTime")));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(17, new Integer(0));
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.dataWatcher.getWatchableObjectInt(
				17) != getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() / 10.0D) {
			this.setSize(this.dataWatcher.getWatchableObjectInt(17) * 0.14F,
					this.dataWatcher.getWatchableObjectInt(17) * 0.29F);
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(this.dataWatcher.getWatchableObjectInt(17) * 10.0D);
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
					.setBaseValue(this.dataWatcher.getWatchableObjectInt(17) * 0.025D);
			this.setHealth((float) (this.dataWatcher.getWatchableObjectInt(17) * 10.0D));
		}
	}

	@Override
	protected void dropFewItems(boolean byPlayer, int lootLevel) {
		this.dropItem(ItemLoader.grayJade, 1);
	}
}