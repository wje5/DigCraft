package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelGasBurner;
import com.huajiliming.digcraft.model.ModelGasBurnerFire;
import com.huajiliming.digcraft.model.ModelGasBurnerFireLow;
import com.huajiliming.digcraft.model.ModelGasCylinder;
import com.huajiliming.digcraft.model.ModelPan;
import com.huajiliming.digcraft.tileentity.TileEntityGasBurner;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderGasBurner extends TileEntitySpecialRenderer {
	private ModelGasBurner model = new ModelGasBurner();
	private ModelGasBurnerFire model2 = new ModelGasBurnerFire();
	private ModelGasBurnerFireLow model3 = new ModelGasBurnerFireLow();
	private ModelPan model4 = new ModelPan();
	private ModelGasCylinder model5 = new ModelGasCylinder();
	private RenderItem itemRenderer;

	public RenderGasBurner() {
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
		TileEntityGasBurner te = (TileEntityGasBurner) tileentity;
		int meta = te.getBlockMetadata();
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
		this.bindTexture(new ResourceLocation("digcraft:textures/models/gasBurner.png"));
		this.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		if (meta >= 8) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/pan.png"));
			this.model4.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}
		if (te.getStackInSlot(1) != null) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/gasCylinder.png"));
			this.model5.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			if (te.getStackInSlot(1).getItemDamage() < te.getStackInSlot(1).getMaxDamage() && meta % 8 >= 4) {
				if (meta >= 8) {
					this.bindTexture(new ResourceLocation("digcraft:textures/models/gasBurnerFireLow.png"));
					this.model3.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				} else {
					this.bindTexture(new ResourceLocation("digcraft:textures/models/gasBurnerFire.png"));
					this.model2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				}
			}
		}
		ItemStack stack = te.getStackInSlot(0);
		if (stack != null) {
			RenderItem.renderInFrame = true;
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.19F, -0.35F, 0.075F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			GL11.glPopMatrix();
			RenderItem.renderInFrame = false;
		}
		GL11.glPopMatrix();
	}
}
