package com.huajiliming.digcraft.tileentity;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLoader {
	public TileEntityLoader(FMLPreInitializationEvent event) {
		this.registerTileEntity(TileEntitySmelter.class, "Smelter");
		this.registerTileEntity(TileEntityCrucible.class, "Crucible");
		this.registerTileEntity(TileEntityBurningBox.class, "BurningBox");
		this.registerTileEntity(TileEntityCastingTable.class, "CastingTable");
		this.registerTileEntity(TileEntityLittleSofa.class, "LittleSofa");
		this.registerTileEntity(TileEntityLongSofa.class, "LongSofa");
		this.registerTileEntity(TileEntityLongTable.class, "LongTable");
		this.registerTileEntity(TileEntityDoorbell.class, "Doorbell");
		this.registerTileEntity(TileEntityShoeArc.class, "ShoeArc");
		this.registerTileEntity(TileEntityBedsideTable.class, "BedsideTable");
		this.registerTileEntity(TileEntityDiningTable.class, "DiningTable");
		this.registerTileEntity(TileEntityDiningChair.class, "DiningChair");
		this.registerTileEntity(TileEntityFluorescentLamp.class, "FlorescentLamp");
		this.registerTileEntity(TileEntityWallSwitch.class, "WallSwitch");
		this.registerTileEntity(TileEntityDesk.class, "Desk");
		this.registerTileEntity(TileEntityToilet.class, "Toilet");
		this.registerTileEntity(TileEntityAmbry.class, "Ambry");
		this.registerTileEntity(TileEntityGasBurner.class, "GasBurner");
		this.registerTileEntity(TileEntityFridge.class, "Fridge");
		this.registerTileEntity(TileEntityTV.class, "TV");
	}

	public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
		GameRegistry.registerTileEntity(tileEntityClass, "digcraft:" + id);
	}
}