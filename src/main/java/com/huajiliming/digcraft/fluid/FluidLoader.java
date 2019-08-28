package com.huajiliming.digcraft.fluid;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidLoader {
	public static Fluid meltIron = new FluidMeltIron();

	public FluidLoader(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(meltIron);
	}
}
