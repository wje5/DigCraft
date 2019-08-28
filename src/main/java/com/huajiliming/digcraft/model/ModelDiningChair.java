package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDiningChair extends ModelBase {
	private final ModelRenderer bone;

	public ModelDiningChair() {
		textureWidth = 64;
		textureHeight = 64;
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 8, 19, -6.0F, -8.0F, -5.0F, 1, 8, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 8, 0, 5.0F, -8.0F, -5.0F, 1, 8, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 0, 5.0F, -8.0F, 5.0F, 1, 8, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -8.0F, 5.0F, 1, 8, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -9.0F, -6.0F, 12, 1, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 4, 19, 5.0F, -22.0F, 5.0F, 1, 13, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 19, -6.0F, -22.0F, 5.0F, 1, 13, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 17, -5.0F, -13.0F, 5.0F, 10, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 15, -5.0F, -17.0F, 5.0F, 10, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -5.0F, -21.0F, 5.0F, 10, 1, 1, 0.0F));

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