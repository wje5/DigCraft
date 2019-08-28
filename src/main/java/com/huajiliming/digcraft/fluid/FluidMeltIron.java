package com.huajiliming.digcraft.fluid;

import net.minecraftforge.fluids.Fluid;

public class FluidMeltIron extends Fluid {
	public FluidMeltIron() {
		super("meltIron");
		this.setDensity(6800);
		this.setViscosity(6000);
		this.setLuminosity(15);
		this.setTemperature(1823);
		this.setGaseous(false);
	}
}
