package com.huajiliming.digcraft.entity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityRitual extends Entity {
	public int tick;

	public EntityRitual(World world) {
		super(world);
		this.setSize(5.0F, 5.0F);
		this.yOffset = 2.5F;
		this.tick = 0;
		this.renderDistanceWeight = 64.0D;
	}

	public EntityRitual(World world, double x, double y, double z) {
		this(world);
		this.setPosition(x, y, z);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (!this.worldObj.isRemote) {
			this.tick += 1;
			if (this.tick >= 600) {
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 20.0F, false);
				setDead();
				Entity blackhole = new EntityBlackhole(this.worldObj, this.posX, this.posY, this.posZ);
				this.worldObj.spawnEntityInWorld(blackhole);
			}
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			for (int i = x - 5; i <= x + 5; i++) {
				for (int j = y - 5; j <= y + 5; j++) {
					for (int k = z - 5; k <= z + 5; k++) {
						if (this.worldObj.getBlock(i, j, k) != Blocks.air) {
							this.destroyBlock(i, j, k);
							return;
						}
					}
				}
			}
		}
	}

	private void destroyBlock(int x, int y, int z) {
		Minecraft mc = Minecraft.getMinecraft();
		WorldClient worldclient = mc.theWorld;
		if (worldclient != null) {
			Block block = worldclient.getBlock(x, y, z);
			worldclient.playAuxSFX(2001, x, y, z,
					Block.getIdFromBlock(block) + (worldclient.getBlockMetadata(x, y, z) << 12));
			int i1 = worldclient.getBlockMetadata(x, y, z);
			boolean flag = this.worldObj.setBlockToAir(x, y, z);
			if (flag) {
				block.onBlockDestroyedByPlayer(worldclient, x, y, z, i1);
			}
		}
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {
		this.tick = tag.getInteger("tick");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {
		tag.setInteger("tick", this.tick);
	}
}