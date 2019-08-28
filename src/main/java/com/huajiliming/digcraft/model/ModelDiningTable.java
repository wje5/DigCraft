package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDiningTable extends ModelBase {
	private final ModelRenderer bone;

	public ModelDiningTable() {
		textureWidth = 128;
		textureHeight = 128;
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -24.0F, -16.0F, -8.0F, 32, 1, 32, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -10.0F, -15.0F, 6.0F, 4, 14, 4, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 33, -13.0F, -1.0F, 3.0F, 10, 1, 10, 0.0F));

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