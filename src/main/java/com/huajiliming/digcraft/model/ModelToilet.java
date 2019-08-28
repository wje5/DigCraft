package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelToilet extends ModelBase {
	private final ModelRenderer bone;

	public ModelToilet() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 13, -4.0F, -2.0F, -5.0F, 8, 2, 11, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 30, 42, -6.0F, -14.0F, 6.0F, 12, 11, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 25, 25, -6.0F, -7.0F, -7.0F, 2, 4, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 29, 4.0F, -7.0F, -7.0F, 2, 4, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 46, -5.0F, -7.0F, 5.0F, 10, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 17, 26, -4.0F, -7.0F, -7.0F, 8, 4, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 32, 0, -4.0F, -4.0F, -6.0F, 3, 1, 11, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 33, 12, 1.0F, -4.0F, -6.0F, 3, 1, 11, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -4.0F, 3.0F, 2, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 27, 13, -1.0F, -4.0F, -6.0F, 2, 1, 6, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -1.0F, -15.0F, 6.0F, 2, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 42, 24, -6.0F, -18.0F, 5.0F, 12, 11, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, -3.0F, -6.0F, 10, 1, 12, 0.0F));
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