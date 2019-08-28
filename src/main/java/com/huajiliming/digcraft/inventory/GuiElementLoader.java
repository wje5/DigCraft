package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.DigCraft;
import com.huajiliming.digcraft.tileentity.TileEntityAmbry;
import com.huajiliming.digcraft.tileentity.TileEntityBurningBox;
import com.huajiliming.digcraft.tileentity.TileEntityFridge;
import com.huajiliming.digcraft.tileentity.TileEntitySmelter;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiElementLoader implements IGuiHandler {
	public static final int GUI_SMELTER = 1;
	public static final int GUI_BURNINGBOX = 2;
	public static final int GUI_AMBRY = 3;
	public static final int GUI_FRIDGEBIG = 4;
	public static final int GUI_FRIDGESMALL = 5;

	public GuiElementLoader() {
		NetworkRegistry.INSTANCE.registerGuiHandler(DigCraft.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_SMELTER:
			return new ContainerSmelter(player, (TileEntitySmelter) world.getTileEntity(x, y, z));
		case GUI_BURNINGBOX:
			return new ContainerBurningBox(player, (TileEntityBurningBox) world.getTileEntity(x, y, z));
		case GUI_AMBRY:
			return new ContainerAmbry(player, (TileEntityAmbry) world.getTileEntity(x, y, z));
		case GUI_FRIDGEBIG:
			return new ContainerFridgeBig(player, (TileEntityFridge) world.getTileEntity(x, y, z));
		case GUI_FRIDGESMALL:
			return new ContainerFridgeSmall(player, (TileEntityFridge) world.getTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_SMELTER:
			return new GuiContainerSmelter(
					new ContainerSmelter(player, (TileEntitySmelter) world.getTileEntity(x, y, z)));
		case GUI_BURNINGBOX:
			return new GuiContainerBurningBox(
					new ContainerBurningBox(player, (TileEntityBurningBox) world.getTileEntity(x, y, z)));
		case GUI_AMBRY:
			return new GuiContainerAmbry(new ContainerAmbry(player, (TileEntityAmbry) world.getTileEntity(x, y, z)));
		case GUI_FRIDGEBIG:
			return new GuiContainerFridgeBig(
					new ContainerFridgeBig(player, (TileEntityFridge) world.getTileEntity(x, y, z)));
		case GUI_FRIDGESMALL:
			return new GuiContainerFridgeSmall(
					new ContainerFridgeSmall(player, (TileEntityFridge) world.getTileEntity(x, y, z)));
		}
		return null;
	}
}