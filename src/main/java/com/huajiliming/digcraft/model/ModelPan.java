package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPan extends ModelBase {
	private final ModelRenderer bone;

	public ModelPan() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -5.0F, -2.0F, 8, 1, 8, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 12, -7.0F, -7.0F, -2.0F, 8, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 9, -7.0F, -7.0F, 5.0F, 8, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 8, 11, 0.0F, -7.0F, -1.0F, 1, 2, 6, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 9, -7.0F, -7.0F, -1.0F, 1, 2, 6, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 17, 17, -4.0F, -7.0F, -7.0F, 2, 1, 5, 0.0F));
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