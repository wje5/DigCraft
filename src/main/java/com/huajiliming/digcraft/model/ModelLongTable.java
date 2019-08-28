package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLongTable extends ModelBase {
	private final ModelRenderer bone;

	public ModelLongTable() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 1, -19.0F, -16.0F, -6.0F, 38, 1, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 26, 15.0F, -15.0F, -4.0F, 1, 15, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 19, 25, 15.0F, -15.0F, 3.0F, 1, 15, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 15, 25, -16.0F, -15.0F, 3.0F, 1, 15, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 23, 18, -16.0F, -15.0F, -4.0F, 1, 15, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -15.0F, -13.0F, -4.0F, 30, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 14, -15.0F, -13.0F, 3.0F, 30, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 9, 18, 15.0F, -13.0F, -3.0F, 1, 1, 6, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 18, -16.0F, -13.0F, -4.0F, 1, 1, 7, 0.0F));

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