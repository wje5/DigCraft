package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDrawer extends ModelBase {
	private final ModelRenderer bone;

	public ModelDrawer() {
		textureWidth = 64;
		textureHeight = 64;
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 30, 14, -7.0F, -6.0F, 6.0F, 14, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 15, 20, -7.0F, -6.0F, -7.0F, 1, 6, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, 6.0F, -6.0F, -7.0F, 1, 6, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -1.0F, -7.0F, 12, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 30, 21, -6.0F, -6.0F, -7.0F, 12, 5, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -4.0F, -8.0F, 2, 2, 1, 0.0F));

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}