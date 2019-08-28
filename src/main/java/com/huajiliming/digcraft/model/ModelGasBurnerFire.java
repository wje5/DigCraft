package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGasBurnerFire extends ModelBase {
	private final ModelRenderer bone;

	public ModelGasBurnerFire() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 12, 12, -6.0F, -11.0F, 2.0F, 6, 9, 0, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -11.0F, -1.0F, 0, 9, 6, 0.0F));
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