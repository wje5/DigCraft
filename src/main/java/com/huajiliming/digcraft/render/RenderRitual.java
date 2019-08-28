package com.huajiliming.digcraft.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRitual extends Render {
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float tick) {
		Tessellator tessellator = Tessellator.instance;
		RenderHelper.disableStandardItemLighting();
		Random random = new Random(432L);
		GL11.glDisable(3553);
		GL11.glShadeModel(7425);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 1);
		GL11.glDisable(3008);
		GL11.glEnable(2884);
		GL11.glDepthMask(false);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		for (int i = 0; i < 30; i++) {
			GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F + 72.0F, 0.0F, 0.0F, 1.0F);
			tessellator.startDrawing(6);
			float f3 = random.nextFloat() * 1.5F + 1.0F;

			float f4 = random.nextFloat() * 2.0F + 1.0F;
			tessellator.setColorRGBA_I(16777215, 255);
			tessellator.addVertex(0.0D, 0.0D, 0.0D);
			tessellator.setColorRGBA_I(16711935, 0);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0.0D, f3, 1.0F * f4);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.draw();
		}
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glDisable(2884);
		GL11.glDisable(3042);
		GL11.glShadeModel(7424);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(3553);
		GL11.glEnable(3008);
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return null;
	}
}