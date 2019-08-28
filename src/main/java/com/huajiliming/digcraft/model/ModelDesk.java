package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDesk extends ModelBase {
	private final ModelRenderer bone;

	public ModelDesk() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 32, 57, -23.0F, -13.0F, -7.0F, 1, 13, 15, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 46, 22.0F, -13.0F, -7.0F, 1, 13, 15, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -24.0F, -14.0F, -8.0F, 48, 1, 16, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 17, -22.0F, -13.0F, 7.0F, 44, 13, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 42, 42, 8.0F, -7.0F, -7.0F, 14, 1, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 31, -22.0F, -7.0F, -7.0F, 14, 1, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 74, 7.0F, -13.0F, -7.0F, 1, 7, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 64, 64, -8.0F, -13.0F, -7.0F, 1, 7, 14, 0.0F));
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