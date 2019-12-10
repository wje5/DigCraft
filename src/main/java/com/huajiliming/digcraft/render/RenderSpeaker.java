package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderSpeaker extends TileEntitySpecialRenderer {
	private IModelCustom model;
	private ResourceLocation texture;

	public RenderSpeaker() {
		this.model = AdvancedModelLoader.loadModel(new ResourceLocation("digcraft:models/speaker.obj"));
		this.texture = new ResourceLocation("digcraft:textures/models/speaker.png");
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 0.85D, z + 0.5D);
		GL11.glScalef(0.425F, 0.425F, 0.425F);
		int meta = tileentity.getBlockMetadata();
		switch (meta % 4) {
		case 0:
			break;
		case 1:
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			break;
		case 2:
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			break;
		case 3:
			GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
		}
		if (meta < 8) {
			this.bindTexture(this.texture);
			this.model.renderAll();
		}
		GL11.glPopMatrix();
	}
}
