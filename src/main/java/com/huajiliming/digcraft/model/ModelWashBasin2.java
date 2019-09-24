package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWashBasin2 extends ModelBase {
	private final ModelRenderer bone;

	public ModelWashBasin2() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -1.0F, -5.0F, 32, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -8.0F, -7.0F, 5.0F, 32, 6, 3, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 23, -6.0F, -7.0F, -8.0F, 28, 3, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 30, 35, -8.0F, -7.0F, -8.0F, 2, 3, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 35, 22.0F, -7.0F, -8.0F, 2, 3, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 4, 8.0F, -10.0F, 7.0F, 1, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 47, 37, 8.0F, -10.0F, 1.0F, 1, 1, 6, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 9, 8.0F, -9.0F, 1.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 7, 7, 11.0F, -9.0F, 6.0F, 1, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 7, 10, 11.0F, -9.0F, 5.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 8, 4, 5.0F, -9.0F, 6.0F, 1, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 9, 0, 5.0F, -9.0F, 5.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -2.0F, -1.0F, 3, 1, 3, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 17, 35, -8.0F, -2.0F, -6.0F, 2, 1, 11, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 32, -6.0F, -2.0F, -6.0F, 28, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 51, 22.0F, -2.0F, -6.0F, 2, 1, 11, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 48, 48, -8.0F, -4.0F, -7.0F, 2, 2, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 48, 23, 22.0F, -4.0F, -7.0F, 2, 2, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 28, -6.0F, -4.0F, -7.0F, 28, 2, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 4, 8.0F, -8.0F, 1.0F, 1, 6, 1, 0.0F));
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