package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLongSofa extends ModelBase {
	private final ModelRenderer bone;

	public ModelLongSofa() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -7.0F, -6.0F, 32, 4, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 18, 30, -19.0F, -3.0F, 4.0F, 2, 3, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 30, 17.0F, -3.0F, -6.0F, 2, 3, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 17.0F, -3.0F, 4.0F, 2, 3, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -19.0F, -3.0F, -6.0F, 2, 3, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 30, 31, -19.0F, -13.0F, -6.0F, 3, 10, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 30, 16.0F, -13.0F, -6.0F, 3, 10, 12, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 17, -16.0F, -17.0F, 3.0F, 32, 10, 3, 0.0F));

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