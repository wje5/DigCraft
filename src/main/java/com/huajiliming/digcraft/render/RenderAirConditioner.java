package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelAirConditioner;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderAirConditioner extends TileEntitySpecialRenderer {
	private ModelAirConditioner model = new ModelAirConditioner();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		if (tileentity.getBlockMetadata() < 8) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/airConditioner.png"));
			switch (tileentity.blockMetadata) {
			case 0:
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				break;
			case 1:
				break;
			case 2:
				GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
				break;
			case 3:
				GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
			}
			this.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
	}
}
