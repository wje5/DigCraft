package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelBedsideTable;
import com.huajiliming.digcraft.model.ModelDrawer;
import com.huajiliming.digcraft.tileentity.TileEntityBedsideTable;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBedsideTable extends TileEntitySpecialRenderer {
	private ModelBedsideTable modelBedsideTable = new ModelBedsideTable();
	private ModelDrawer modelDrawer = new ModelDrawer();
	private RenderItem itemRenderer;

	public RenderBedsideTable() {
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
		this.bindTexture(new ResourceLocation("digcraft:textures/models/bedsideTable.png"));
		this.modelBedsideTable.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		this.bindTexture(new ResourceLocation("digcraft:textures/models/drawer.png"));

		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -0.125F, meta >= 8 ? -0.3F : 0.0F);
		this.modelDrawer.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -0.5625F, meta % 8 >= 4 ? -0.3F : 0.0F);
		this.modelDrawer.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		TileEntityBedsideTable te = (TileEntityBedsideTable) tileentity;

		RenderItem.renderInFrame = true;
		ItemStack stack = te.getStackInSlot(0);
		if (meta >= 8 && stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.2F, -0.3F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			GL11.glPopMatrix();
		}
		stack = te.getStackInSlot(1);
		if (meta % 8 >= 4 && stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.7F, -0.3F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			GL11.glPopMatrix();
		}

		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
	}
}
