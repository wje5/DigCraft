package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBedsideTable extends ModelBase {
	private final ModelRenderer bone;

	public ModelBedsideTable() {
		textureWidth = 128;
		textureHeight = 128;
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 6, 1, -8.0F, -1.0F, 6.0F, 2, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 6.0F, -1.0F, 6.0F, 2, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 3, 6.0F, -1.0F, -7.0F, 2, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -1.0F, -7.0F, 2, 1, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -2.0F, -7.0F, 16, 1, 15, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 31, -7.0F, -9.0F, -7.0F, 14, 1, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -7.0F, -16.0F, -7.0F, 14, 1, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 47, 0, -8.0F, -16.0F, 7.0F, 16, 14, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 46, 7.0F, -16.0F, -7.0F, 1, 14, 14, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 42, 42, -8.0F, -16.0F, -7.0F, 1, 14, 14, 0.0F));
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