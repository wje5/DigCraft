package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.model.ModelSpotLightSmall;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSpotLightSmall extends TileEntitySpecialRenderer {
	private ModelSpotLightSmall model = new ModelSpotLightSmall();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		if (tileentity.getBlockType() == BlockLoader.spotLightSmall) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/spotLightSmall.png"));
		} else {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/spotLightSmallLight.png"));
		}
		this.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

}
