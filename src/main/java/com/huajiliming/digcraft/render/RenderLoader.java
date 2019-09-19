package com.huajiliming.digcraft.render;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.entity.EntityBlackhole;
import com.huajiliming.digcraft.entity.EntityGrayJadeGolem;
import com.huajiliming.digcraft.entity.EntityRitual;
import com.huajiliming.digcraft.entity.EntitySuckingBlock;
import com.huajiliming.digcraft.inventory.GuiThrustMeter;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.model.ModelAmbry;
import com.huajiliming.digcraft.model.ModelBedsideTable;
import com.huajiliming.digcraft.model.ModelCastingTable;
import com.huajiliming.digcraft.model.ModelCrucible;
import com.huajiliming.digcraft.model.ModelFluorescentLamp;
import com.huajiliming.digcraft.model.ModelGasBurner;
import com.huajiliming.digcraft.model.ModelLittleSofa;
import com.huajiliming.digcraft.model.ModelPan;
import com.huajiliming.digcraft.model.ModelShoeArc;
import com.huajiliming.digcraft.model.ModelSpotLightSmall;
import com.huajiliming.digcraft.model.ModelToilet;
import com.huajiliming.digcraft.tileentity.TileEntityAirConditioner;
import com.huajiliming.digcraft.tileentity.TileEntityAmbry;
import com.huajiliming.digcraft.tileentity.TileEntityBathtub;
import com.huajiliming.digcraft.tileentity.TileEntityBedsideTable;
import com.huajiliming.digcraft.tileentity.TileEntityCabinetAirConditioner;
import com.huajiliming.digcraft.tileentity.TileEntityCastingTable;
import com.huajiliming.digcraft.tileentity.TileEntityCrucible;
import com.huajiliming.digcraft.tileentity.TileEntityDesk;
import com.huajiliming.digcraft.tileentity.TileEntityDiningChair;
import com.huajiliming.digcraft.tileentity.TileEntityDiningTable;
import com.huajiliming.digcraft.tileentity.TileEntityDoorbell;
import com.huajiliming.digcraft.tileentity.TileEntityFluorescentLamp;
import com.huajiliming.digcraft.tileentity.TileEntityFridge;
import com.huajiliming.digcraft.tileentity.TileEntityGasBurner;
import com.huajiliming.digcraft.tileentity.TileEntityGlassDoor;
import com.huajiliming.digcraft.tileentity.TileEntityLittleSofa;
import com.huajiliming.digcraft.tileentity.TileEntityLongSofa;
import com.huajiliming.digcraft.tileentity.TileEntityLongTable;
import com.huajiliming.digcraft.tileentity.TileEntityShoeArc;
import com.huajiliming.digcraft.tileentity.TileEntitySpotLightSmall;
import com.huajiliming.digcraft.tileentity.TileEntityTV;
import com.huajiliming.digcraft.tileentity.TileEntityToilet;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class RenderLoader {
	public RenderLoader() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackhole.class,
				new RenderSnowball(ItemLoader.blackhole));
		RenderingRegistry.registerEntityRenderingHandler(EntitySuckingBlock.class, new RenderFallingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrayJadeGolem.class, new RenderGrayJadeGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityRitual.class, new RenderRitual());
		MinecraftForge.EVENT_BUS.register(new GuiThrustMeter(Minecraft.getMinecraft()));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrucible.class, new RenderCrucible());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.crucible),
				new StandardBlockItemRenderer(new ModelCrucible(), "crucible"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCastingTable.class, new RenderCastingTable());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.castingTable),
				new StandardBlockItemRenderer(new ModelCastingTable(), "castingTable"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLittleSofa.class,
				new StandardBlockRenderer(new ModelLittleSofa(), "littleSofa", true));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.littleSofa),
				new StandardBlockItemRenderer(new ModelLittleSofa(), "littleSofa"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLongSofa.class, new RenderLongSofa());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.longSofa, new RenderItemLongSofa());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLongTable.class, new RenderLongTable());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.longTable, new RenderItemLongTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDoorbell.class, new RenderDoorbell());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShoeArc.class, new RenderShoeArc());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.shoeArc),
				new StandardBlockItemRenderer(new ModelShoeArc(), "shoeArc"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBedsideTable.class, new RenderBedsideTable());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.bedsideTable),
				new StandardBlockItemRenderer(new ModelBedsideTable(), "bedsideTable"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiningTable.class, new RenderDiningTable());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.diningTable, new RenderItemDiningTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiningChair.class, new RenderDiningChair());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.diningChair, new RenderItemDiningChair());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluorescentLamp.class, new RenderFluorescentLamp());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.fluorescentLamp),
				new StandardBlockItemRenderer(new ModelFluorescentLamp(), "fluorescentLamp"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderDesk());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.desk, new RenderItemDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityToilet.class,
				new StandardBlockRenderer(new ModelToilet(), "toilet", true));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.toilet),
				new StandardBlockItemRenderer(new ModelToilet(), "toilet"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmbry.class,
				new StandardBlockRenderer(new ModelAmbry(), "ambry", true));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.ambry),
				new StandardBlockItemRenderer(new ModelAmbry(), "ambry"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGasBurner.class, new RenderGasBurner());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.gasBurner),
				new StandardBlockItemRenderer(new ModelGasBurner(), "gasBurner"));
		MinecraftForgeClient.registerItemRenderer(ItemLoader.pan, new StandardBlockItemRenderer(new ModelPan(), "pan"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFridge.class, new RenderFridge());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.fridge, new RenderItemFridge());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTV.class, new RenderTV());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.tv, new RenderItemTV());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpotLightSmall.class, new RenderSpotLightSmall());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.spotLightSmall),
				new StandardBlockItemRenderer(new ModelSpotLightSmall(), "spotLightSmall"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirConditioner.class, new RenderAirConditioner());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.airConditioner, new RenderItemAirConditioner());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCabinetAirConditioner.class,
				new RenderCabinetAirConditioner());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.cabinetAirConditioner,
				new RenderItemCabinetAirConditioner());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBathtub.class, new RenderBathtub());
		MinecraftForgeClient.registerItemRenderer(ItemLoader.bathtub, new RenderItemBathtub());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlassDoor.class, new RenderGlassDoor());
	}
}