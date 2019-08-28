package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelShoeArc;
import com.huajiliming.digcraft.tileentity.TileEntityShoeArc;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderShoeArc extends TileEntitySpecialRenderer {
	private ModelShoeArc modelShoeArc = new ModelShoeArc();
	private RenderItem itemRenderer;

	public RenderShoeArc() {
		this.itemRenderer = new RenderItem() {
			@Override
			public byte getMiniBlockCount(ItemStack stack, byte original) {
				return 1;
			}

			@Override
			public byte getMiniItemCount(ItemStack stack, byte original) {
				return 1;
			}

			@Override
			public boolean shouldBob() {
				return false;
			}

			@Override
			public boolean shouldSpreadItems() {
				return false;
			}
		};
		this.itemRenderer.setRenderManager(RenderManager.instance);

	}

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
		this.bindTexture(new ResourceLocation("digcraft:textures/models/shoeArc.png"));
		this.modelShoeArc.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		ItemStack stack = ((TileEntityShoeArc) tileentity).getStackInSlot(1);
		if (stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.6F, 0.15F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			RenderItem.renderInFrame = true;
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
		stack = ((TileEntityShoeArc) tileentity).getStackInSlot(0);
		if (stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.1F, 0.15F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			RenderItem.renderInFrame = true;
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}
}
