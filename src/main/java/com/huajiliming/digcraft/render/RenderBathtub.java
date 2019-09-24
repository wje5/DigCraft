package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelBathtub;
import com.huajiliming.digcraft.model.ModelBathtub2;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBathtub extends TileEntitySpecialRenderer {
	private ModelBathtub model = new ModelBathtub();
	private ModelBathtub2 model2 = new ModelBathtub2();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		int meta = tileentity.getBlockMetadata();
		if (meta < 8) {
			switch (tileentity.getBlockMetadata() % 4) {
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
			if (meta < 4) {
				this.bindTexture(new ResourceLocation("digcraft:textures/models/bathtub.png"));
				this.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			} else {
				this.bindTexture(new ResourceLocation("digcraft:textures/models/bathtub2.png"));
				this.model2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			}
		}
		GL11.glPopMatrix();
	}
}
