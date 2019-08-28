package com.huajiliming.digcraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public interface IBindableTE {
	public void bind(World world, int x, int y, int z);

	public void unBind();

	public boolean isBind();

	public String getBindWorldName();

	public void setBindWorldName(String name);

	/**
	 * 
	 * @return [0]:x [1]:y [2]:z [3]:worldId
	 */
	public int[] getBind();

	@SideOnly(Side.SERVER)
	public default World getWorld(int id) {
		return MinecraftServer.getServer().worldServerForDimension(id);
	}
}
