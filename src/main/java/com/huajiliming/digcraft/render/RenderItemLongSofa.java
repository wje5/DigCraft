package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelLongSofa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderItemLongSofa implements IItemRenderer {
	private ModelBase model;
	private ResourceLocation texture;

	public RenderItemLongSofa() {
		this.model = new ModelLongSofa();
		this.texture = new ResourceLocation("digcraft:textures/models/longSofa.png");
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		if (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}
		GL11.glTranslatef(0.0F, -0.5F, 0.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(0.7F, 0.7F, 0.7F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
