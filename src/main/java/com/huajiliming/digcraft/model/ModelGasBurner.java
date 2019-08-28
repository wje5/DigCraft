package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGasBurner extends ModelBase {
	private final ModelRenderer bone;

	public ModelGasBurner() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -1.0F, -5.0F, 16, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, 2.0F, -4.0F, -6.0F, 1, 3, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 17, 7.0F, -4.0F, -6.0F, 1, 3, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 5, 19, 4.0F, -3.0F, -7.0F, 2, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 4, 3.0F, -4.0F, -6.0F, 4, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -4.0F, 7.0F, 4, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 14, -8.0F, -2.0F, 6.0F, 10, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 32, 23, -8.0F, -2.0F, -3.0F, 10, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 32, 14, -8.0F, -2.0F, -2.0F, 1, 1, 8, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 31, 1.0F, -2.0F, -2.0F, 1, 1, 8, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 8, 1.0F, -4.0F, 1.0F, 1, 2, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 6, 8, -8.0F, -4.0F, 1.0F, 1, 2, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -4.0F, -4.0F, -3.0F, 2, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 17, -4.0F, -4.0F, 6.0F, 2, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 6, 17, -4.0F, -4.0F, 5.0F, 2, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 19, -4.0F, -4.0F, -2.0F, 2, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 16, 16, 0.0F, -4.0F, 1.0F, 1, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 6, 14, -7.0F, -4.0F, 1.0F, 1, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 32, 25, -5.0F, -2.0F, 0.0F, 4, 1, 4, 0.0F));
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