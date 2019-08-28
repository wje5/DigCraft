package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelDoorbell;
import com.huajiliming.digcraft.model.ModelDoorbellPushed;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderDoorbell extends TileEntitySpecialRenderer {
	private ModelDoorbell modelDoorbell = new ModelDoorbell();
	private ModelDoorbellPushed modelDoorbellPushed = new ModelDoorbellPushed();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		int meta = tileentity.getBlockMetadata();
		switch (meta % 4) {
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
		if (meta < 8) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/doorbell.png"));
			this.modelDoorbell.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/doorbellPushed.png"));
			this.modelDoorbellPushed.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
	}
}
