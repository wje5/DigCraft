package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBathtub extends ModelBase {
	private final ModelRenderer bone;

	public ModelBathtub() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -1.0F, -6.0F, 28, 1, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 46, 25, -7.0F, -5.0F, -6.0F, 1, 4, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 40, 43, 22.0F, -5.0F, -6.0F, 1, 4, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 32, -6.0F, -5.0F, -7.0F, 28, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 27, -6.0F, -5.0F, 6.0F, 28, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 37, -7.0F, -11.0F, -7.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 8, 0, 22.0F, -11.0F, -7.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 22.0F, -11.0F, 6.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 4, -7.0F, -11.0F, 6.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -6.0F, -11.0F, -8.0F, 28, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 20, -6.0F, -11.0F, 7.0F, 28, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 37, -8.0F, -11.0F, -6.0F, 1, 6, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 26, 37, 23.0F, -11.0F, -6.0F, 1, 6, 12, 0.0F));
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