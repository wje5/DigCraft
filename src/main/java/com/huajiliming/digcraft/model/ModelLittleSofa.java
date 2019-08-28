package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLittleSofa extends ModelBase {
	private final ModelRenderer bone;

	public ModelLittleSofa() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 7, 7.0F, -3.0F, -8.0F, 1, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 0, -8.0F, -3.0F, -8.0F, 1, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 3, 4, -8.0F, -3.0F, 7.0F, 1, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 1, 7.0F, -3.0F, 7.0F, 1, 3, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -6.0F, -7.0F, -8.0F, 12, 4, 16, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 20, 31, 6.0F, -13.0F, -8.0F, 2, 10, 16, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 21, -8.0F, -13.0F, -8.0F, 2, 10, 16, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 40, 0, -6.0F, -16.0F, 5.0F, 12, 9, 3, 0.0F));
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