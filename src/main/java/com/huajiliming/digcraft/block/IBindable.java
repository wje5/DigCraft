package com.huajiliming.digcraft.block;

import net.minecraft.world.World;

public interface IBindable {
	public boolean canBind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ);

	public void bind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ);

	public void unBind(World world, int x, int y, int z);
}
