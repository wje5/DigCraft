package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArk extends ModelBase {
	private final ModelRenderer bone;

	public ModelArk() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -1.0F, -5.0F, 16, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -8.0F, -16.0F, -5.0F, 16, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 28, -8.0F, -15.0F, -5.0F, 1, 14, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 28, 28, 7.0F, -15.0F, -5.0F, 1, 14, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 44, 44, -1.0F, -15.0F, -5.0F, 2, 14, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 55, -7.0F, -15.0F, 7.0F, 14, 14, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 56, 28, -7.0F, -15.0F, -5.0F, 6, 14, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 30, 55, 1.0F, -15.0F, -5.0F, 6, 14, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 2, -3.0F, -11.0F, -6.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 0, 2.0F, -11.0F, -6.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 6, -3.0F, -7.0F, -6.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 7, 1, 2.0F, -7.0F, -6.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -11.0F, -7.0F, 1, 5, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 4, 2.0F, -11.0F, -7.0F, 1, 5, 1, 0.0F));
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