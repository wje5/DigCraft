package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFridge extends ModelBase {
	private final ModelRenderer bone;

	public ModelFridge() {
		textureWidth = 128;
		textureHeight = 128;
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 64, 64, -7.0F, -2.0F, -8.0F, 15, 1, 16, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 64, 47, -6.0F, -33.0F, -7.0F, 13, 3, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 50, 81, -6.0F, -48.0F, -7.0F, 13, 1, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 3, 1, 7.0F, -1.0F, -8.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 3, 3, -7.0F, -1.0F, -8.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 2, -7.0F, -1.0F, 7.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -1.0F, 7.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 49, 0, -7.0F, -48.0F, 7.0F, 15, 46, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -48.0F, -7.0F, 1, 46, 15, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 32, 32, -7.0F, -48.0F, -7.0F, 1, 46, 15, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 81, 0, -8.0F, -31.0F, -8.0F, 16, 30, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 93, -8.0F, -48.0F, -8.0F, 16, 16, 1, 0.0F));

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