package com.huajiliming.digcraft.render;

import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.model.ModelCrucible;
import com.huajiliming.digcraft.model.ModelCrucibleFilled;
import com.huajiliming.digcraft.tileentity.TileEntityCrucible;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderCrucible extends TileEntitySpecialRenderer {
	private ModelCrucible model = new ModelCrucible();
	private ModelCrucibleFilled model2 = new ModelCrucibleFilled();
	private RenderItem itemRenderer;

	public RenderCrucible() {
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
		TileEntityCrucible te = (TileEntityCrucible) tileentity;
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
		if (meta % 8 < 4) {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/crucible.png"));
			this.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else {
			this.bindTexture(new ResourceLocation("digcraft:textures/models/crucibleFilled.png"));
			this.model2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}
		if (meta >= 8) {
			RenderItem.renderInFrame = true;
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.5F, 0.0F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			EntityItem entity = new EntityItem(tileentity.getWorldObj(), 0.0D, 0.0D, 0.0D,
					new ItemStack(Blocks.iron_ore));
			entity.hoverStart = 0.0F;
			this.itemRenderer.doRender(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			GL11.glPopMatrix();
			RenderItem.renderInFrame = false;
		}
		GL11.glPopMatrix();
	}
}
