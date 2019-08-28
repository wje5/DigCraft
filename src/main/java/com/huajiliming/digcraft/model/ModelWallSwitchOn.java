package com.huajiliming.digcraft.model;
//Made with Blockbench

//Paste this code into your mod.

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWallSwitchOn extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelWallSwitchOn() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -11.0F, 7.0F, 4, 6, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 9, -2.0F, -6.0F, 6.0F, 4, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 0, 7, -2.0F, -11.0F, 6.0F, 4, 1, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 10, 5, 1.0F, -10.0F, 6.0F, 1, 4, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 10, 0, -2.0F, -10.0F, 6.0F, 1, 4, 1, 0.0F));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 16.0F, 6.0F);
		this.setRotationAngle(bone2, 0.35F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 9, 10, -1.0F, -24.0F, 8.0F, 2, 4, 1, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}