package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShoeArc extends ModelBase {
	private final ModelRenderer bone;

	public ModelShoeArc() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 9, -8.0F, -16.0F, 7.0F, 16, 16, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 34, -7.0F, -1.0F, 0.0F, 14, 1, 7, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 26, -7.0F, -16.0F, 0.0F, 14, 1, 7, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -9.0F, 0.0F, 14, 2, 7, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 35, 2, 7.0F, -16.0F, 0.0F, 1, 16, 7, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 35, 35, -8.0F, -16.0F, 0.0F, 1, 16, 7, 0.0F));
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