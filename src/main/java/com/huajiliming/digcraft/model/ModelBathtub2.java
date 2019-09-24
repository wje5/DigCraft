package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBathtub2 extends ModelBase {
	private final ModelRenderer bone;

	public ModelBathtub2() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 13, -6.0F, -1.0F, -6.0F, 28, 1, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 58, 26, -7.0F, -5.0F, -6.0F, 1, 4, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 26, 54, 22.0F, -5.0F, -6.0F, 1, 4, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 40, -6.0F, -5.0F, -7.0F, 28, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 45, -6.0F, -5.0F, 6.0F, 28, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 8, 0, -7.0F, -11.0F, -7.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 4, 22.0F, -11.0F, -7.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 13, 22.0F, -11.0F, 6.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -11.0F, 6.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 33, -6.0F, -11.0F, -8.0F, 28, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 26, -6.0F, -11.0F, 7.0F, 28, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 46, 46, -8.0F, -11.0F, -6.0F, 1, 6, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 54, 23.0F, -11.0F, -6.0F, 1, 6, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -8.0F, -6.0F, 30, 1, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 52, -6.0F, -8.0F, -7.0F, 28, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 50, -6.0F, -8.0F, 6.0F, 28, 1, 1, 0.0F));
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