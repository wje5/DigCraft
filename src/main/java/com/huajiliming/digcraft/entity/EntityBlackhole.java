package com.huajiliming.digcraft.entity;

import java.util.List;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.config.ConfigLoader;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityBlackhole extends Entity {
	public EntityBlackhole(World world) {
		super(world);
		this.width = 0.3F;
		this.height = 0.3F;
	}

	public EntityBlackhole(World world, double x, double y, double z) {
		this(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (ConfigLoader.canBlackholeSuckEntity) {
			suckEntity();
		}
		if (ConfigLoader.canBlackholeSuckBlock) {
			suckBlock();
		}
		killEntity();
		if (ConfigLoader.canBlackholeLightning) {
			skillLightning();
		}
		if (ConfigLoader.canBlackholeLightning) {
			skillFrozen();
		}
		if (this.rand.nextInt(100) == 0) {
			setMass(getMass() + 1);
		}
		for (int i = 0; i < 3; i++) {
			this.worldObj.spawnParticle("portal", this.posX, this.posY + 2.0D, this.posZ, 0.0D, -2.5D, 0.0D);
			this.worldObj.spawnParticle("portal", this.posX - 2.5D, this.posY - 3.0D, this.posZ - 2.5D, 2.5D, 2.5D,
					2.5D);

			this.worldObj.spawnParticle("portal", this.posX + 2.5D, this.posY - 3.0D, this.posZ - 2.5D, -2.5D, 2.5D,
					2.5D);

			this.worldObj.spawnParticle("portal", this.posX, this.posY - 3.0D, this.posZ + 2.5D, 0.0D, 2.5D, -2.5D);
		}
		if (this.rand.nextInt(100) == 0) {
			this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "portal.portal", 1.0F,
					this.rand.nextFloat() * 0.4F + 0.8F, false);
		}
	}

	protected void suckEntity() {
		int mass = getMass();
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.posX - mass * 0.2F, this.posY - mass * 0.2F,
				this.posZ - mass * 0.2F, this.posX + mass * 0.2F, this.posY + mass * 0.2F, this.posZ + mass * 0.2F);

		List<Entity> list = this.worldObj.selectEntitiesWithinAABB(Entity.class, aabb, new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return (!(entity instanceof EntityPlayer)) || (!((EntityPlayer) entity).capabilities.isCreativeMode);
			}
		});
		for (Entity entity : list) {
			if (!(entity instanceof EntityBlackhole)) {
				double x = 0.10000000149011612D * (this.posX - entity.posX) / getDistanceToEntity(entity);
				double y = 0.10000000149011612D * (this.posY - entity.posY) / getDistanceToEntity(entity);
				double z = 0.10000000149011612D * (this.posZ - entity.posZ) / getDistanceToEntity(entity);
				if ((entity.posY < this.posY) && (!(entity instanceof EntitySuckingBlock))) {
					entity.motionY = 0.0D;
				}
				entity.moveEntity(x, y, z);
			}
		}
	}

	protected void suckBlock() {
		int chance = 0;
		int mass = getMass();
		if (mass <= 50) {
			chance = 60;
		} else if (mass <= 250) {
			chance = 30;
		} else if (mass <= 1000) {
			chance = 15;
		} else {
			chance = 5;
		}
		int c = this.rand.nextInt(chance);
		if (c == 0) {
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Block closestBlock = null;
			int closestBlockX = 0;
			int closestBlockY = 0;
			int closestBlockZ = 0;
			int suckRange = (int) (mass * 0.2D);
			for (int i = x - suckRange; i <= x + suckRange; i++) {
				for (int j = y - suckRange; j <= y + suckRange; j++) {
					for (int k = z - suckRange; k <= z + suckRange; k++) {
						Block b = this.worldObj.getBlock(i, j, k);
						if ((b != Blocks.air) && (b.getBlockHardness(this.worldObj, closestBlockX, closestBlockY,
								closestBlockZ) <= 5.0D + mass * 0.05D) && ((closestBlock == null) ||

										(getDistanceSq(closestBlockX, closestBlockY, closestBlockZ) > getDistanceSq(i,
												j, k)))) {
							closestBlock = b;
							closestBlockX = i;
							closestBlockY = j;
							closestBlockZ = k;
						}
					}
				}
			}
			if (closestBlock != null) {
				EntitySuckingBlock entity = new EntitySuckingBlock(this.worldObj, closestBlockX, closestBlockY,
						closestBlockZ, closestBlock,
						this.worldObj.getBlockMetadata(closestBlockX, closestBlockY, closestBlockZ));
				float yaw = (float) Math.atan((entity.posX - this.posX) / (entity.posZ - this.posZ));
				entity.setPositionAndRotation(closestBlockX, closestBlockY, closestBlockZ, yaw, 0.0F);
				this.worldObj.spawnEntityInWorld(entity);

				this.worldObj.setBlockToAir(closestBlockX, closestBlockY, closestBlockZ);
			}
		}
	}

	protected void killEntity() {
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.posX - 0.30000001192092896D, this.posY - 1.0D,
				this.posZ - 0.30000001192092896D, this.posX + 0.30000001192092896D, this.posY + 1.0D,
				this.posZ + 0.30000001192092896D);

		List<Entity> list = this.worldObj.selectEntitiesWithinAABB(Entity.class, aabb, new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return (!(entity instanceof EntityPlayer)) || (!((EntityPlayer) entity).capabilities.isCreativeMode);
			}
		});
		for (Entity entity : list) {
			if (entity != this) {
				if ((entity instanceof EntityPlayer)) {
					EntityPlayer player = (EntityPlayer) entity;
					player.setHealth(player.getHealth() - 4.0F);
					setMass(getMass() + 1);
				} else {
					if ((entity instanceof EntityItem)) {
						ItemStack stack = ((EntityItem) entity).getDataWatcher().getWatchableObjectItemStack(10);
						if (stack != null) {
							setMass(getMass() + stack.stackSize);
						}
					}
					entity.setDead();
					this.worldObj.removeEntity(entity);
				}
			}
		}
	}

	protected void skillLightning() {
		int mass = getMass();
		if ((mass >= 100) && (this.rand.nextInt(30) == 0)) {
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.posX - 0.8F * mass, this.posY - 0.8F * mass,
					this.posZ - 0.8F * mass, this.posX + 0.8F * mass, this.posY + 0.8F * mass, this.posZ + 0.8F * mass);

			List<Entity> list = this.worldObj.selectEntitiesWithinAABB(Entity.class, aabb, new IEntitySelector() {
				@Override
				public boolean isEntityApplicable(Entity entity) {
					return ((entity instanceof EntityLiving)) && ((!(entity instanceof EntityPlayer))
							|| (!((EntityPlayer) entity).capabilities.isCreativeMode));
				}
			});
			if (!list.isEmpty()) {
				Entity entity = list.get(this.rand.nextInt(list.size()));
				this.worldObj.addWeatherEffect(
						new EntityLightningBolt(this.worldObj, entity.posX, entity.posY, entity.posZ));
			}
		}
	}

	protected void skillFrozen() {
		if (this.rand.nextInt(50) == 0) {
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			int frozenRange = (int) (getMass() * 0.8D);
			for (int i = x - frozenRange; i <= x + frozenRange; i++) {
				for (int j = y - frozenRange; j <= y + frozenRange; j++) {
					for (int k = z - frozenRange; k <= z + frozenRange; k++) {
						Block b = this.worldObj.getBlock(i, j, k);
						if ((b == Blocks.water) || ((b == Blocks.flowing_water) && (this.rand.nextInt(10) == 0))) {
							this.worldObj.setBlock(i, j, k, Blocks.ice);
						} else if ((b == Blocks.lava) || ((b == Blocks.flowing_lava) && (this.rand.nextInt(10) == 0))) {
							this.worldObj.setBlock(i, j, k, Blocks.obsidian);
						} else if ((b == BlockLoader.abyssOre) && (this.rand.nextInt(24) == 0)) {
							this.worldObj.setBlock(i, j, k, BlockLoader.chargedAbyssOre);
						}
					}
				}
			}
		}
	}

	public void setMass(int mass) {
		this.dataWatcher.updateObject(16, Integer.valueOf(mass));
	}

	public int getMass() {
		return this.dataWatcher.getWatchableObjectInt(16);
	}

	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(16, new Integer(20));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {
		this.dataWatcher.updateObject(16, Integer.valueOf(tag.getInteger("mass")));
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {
		tag.setInteger("mass", this.dataWatcher.getWatchableObjectInt(16));
	}
}