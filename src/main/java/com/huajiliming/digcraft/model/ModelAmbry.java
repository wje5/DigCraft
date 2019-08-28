package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmbry extends ModelBase {
	private final ModelRenderer bone;

	public ModelAmbry() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 14, -8.0F, -1.0F, -5.0F, 16, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -16.0F, -5.0F, 16, 1, 13, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 52, 28, -8.0F, -15.0F, 7.0F, 16, 14, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 52, 52, -8.0F, -16.0F, -6.0F, 16, 16, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 26, 28, -8.0F, -15.0F, -5.0F, 1, 14, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 28, 7.0F, -15.0F, -5.0F, 1, 14, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -11.0F, -8.0F, 1, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 0, -6.0F, -6.0F, -7.0F, 1, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 4, -6.0F, -11.0F, -7.0F, 1, 1, 1, 0.0F));
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