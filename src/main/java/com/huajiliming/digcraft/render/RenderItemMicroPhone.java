package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderItemMicroPhone implements IItemRenderer {
	private IModelCustom model;
	private ResourceLocation texture;

	public RenderItemMicroPhone() {
		this.model = AdvancedModelLoader.loadModel(new ResourceLocation("digcraft:models/microPhone.obj"));
		this.texture = new ResourceLocation("digcraft:textures/models/microPhone.png");
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
		GL11.glTranslatef(0.0F, -0.75F, 0.0F);
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		this.model.renderAll();
		GL11.glPopMatrix();
	}
}