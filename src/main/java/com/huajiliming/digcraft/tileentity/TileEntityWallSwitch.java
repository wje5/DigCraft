package com.huajiliming.digcraft.tileentity;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.block.IBindable;
import com.huajiliming.digcraft.network.MessageGetWorldObjFromId;
import com.huajiliming.digcraft.network.NetworkHandler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityWallSwitch extends TileEntity implements IBindableTE {
	private int bindX;
	private int bindY;
	private int bindZ;
	private World bindWorld;
	private boolean binded;
	public String bindWorldName;
	private int bindWorldId;

	public void activate() {
		if (!this.worldObj.isRemote) {
			int meta = this.getBlockMetadata();
			if (meta >= 8) {
				meta -= 8;
			} else {
				meta += 8;
			}
			this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 2);
			if (this.binded) {
				this.bindWorld.setBlock(this.bindX, this.bindY, this.bindZ,
						meta < 8 ? BlockLoader.fluorescentLamp : BlockLoader.fluorescentLampLight);
				this.bind(this.bindWorld, this.bindX, this.bindY, this.bindZ);
				IBindable block = (IBindable) this.bindWorld.getBlock(this.bindX, this.bindY, this.bindZ);
				block.bind(this.bindWorld, this.bindX, this.bindY, this.bindZ, this.worldObj, this.xCoord, this.yCoord,
						this.zCoord);
				this.binded = true;
				this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
				this.bindWorld.markBlockForUpdate(this.bindX, this.bindY, this.bindZ);
			}
		}

	}

	@Override
	public void bind(World world, int x, int y, int z) {
		this.bindX = x;
		this.bindY = y;
		this.bindZ = z;
		this.bindWorld = world;
		this.binded = true;
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void unBind() {
		this.binded = false;
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		int[] pos = tag.getIntArray("pos");
		this.bindX = pos[0];
		this.bindY = pos[1];
		this.bindZ = pos[2];
		this.bindWorldId = tag.getInteger("world");
		try {
			this.bindWorld = this.getWorld(this.bindWorldId);
		} catch (Error e) {

		}
		this.binded = tag.getBoolean("binded");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setIntArray("pos", new int[] { this.bindX, this.bindY, this.bindZ });
		if (this.bindWorld != null) {
			tag.setInteger("world", this.bindWorld.provider.dimensionId);
		} else {
			tag.setInteger("world", 0);
		}
		tag.setBoolean("binded", this.binded);
	}

	@Override
	public boolean isBind() {
		return this.binded;
	}

	@Override
	public int[] getBind() {
		return new int[] { this.bindX, this.bindY, this.bindZ, this.bindWorldId };
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	@Override
	public String getBindWorldName() {
		NetworkHandler.instance
				.sendToServer(new MessageGetWorldObjFromId(this.bindWorldId, this.xCoord, this.yCoord, this.zCoord));
		return this.bindWorldName;
	}

	@Override
	public void setBindWorldName(String name) {
		this.bindWorldName = name;
	}
}
