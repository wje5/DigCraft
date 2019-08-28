package com.huajiliming.digcraft.model;

import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelRocketBoot
  extends ModelBiped
{
  public ModelRocketBoot()
  {
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.bipedBody = new ModelRenderer(this);
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 35, 26, -8.0F, 29.0F, 6.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 31, 33, -8.0F, 29.0F, 3.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 35, -7.0F, 29.0F, 3.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 33, -5.0F, 29.0F, 4.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 7, 0, -4.0F, 30.0F, 3.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 12, 25, -8.0F, 30.0F, 2.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 7, 6, -9.0F, 30.0F, 2.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 14, -9.0F, 30.0F, 7.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 25, -9.0F, 31.0F, 7.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -4.0F, 31.0F, 3.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 24, 25, -8.0F, 31.0F, 2.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 7, 18, -9.0F, 31.0F, 2.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 18, -9.0F, 31.0F, -5.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 12, -4.0F, 31.0F, -9.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 29, -8.0F, 31.0F, -10.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 18, -9.0F, 31.0F, -10.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 35, -8.0F, 29.0F, -6.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 16, 31, -8.0F, 29.0F, -9.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 33, 10, -7.0F, 29.0F, -9.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 26, 30, -5.0F, 29.0F, -8.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 6, -4.0F, 30.0F, -9.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 12, -8.0F, 30.0F, -10.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 0, -9.0F, 30.0F, -10.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 27, -9.0F, 30.0F, -5.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 2, 3.0F, 31.0F, -5.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 8, 3.0F, 30.0F, -5.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 14, 1, 3.0F, 30.0F, -10.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 20, 4.0F, 30.0F, -10.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 14, 7, 8.0F, 30.0F, -9.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 31, 7.0F, 29.0F, -8.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 26, 34, 5.0F, 29.0F, -9.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 31, 4.0F, 29.0F, -9.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 32, 23, 4.0F, 29.0F, -6.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 19, 3.0F, 31.0F, -10.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 24, 27, 4.0F, 31.0F, -10.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 14, 19, 8.0F, 31.0F, -9.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 13, 8.0F, 31.0F, 3.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 12, 27, 4.0F, 30.0F, 2.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 7, 12, 8.0F, 30.0F, 3.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 29, 7.0F, 29.0F, 4.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 33, 4, 5.0F, 29.0F, 3.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 31, 29, 4.0F, 29.0F, 3.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 33, 16, 4.0F, 29.0F, 6.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 14, 13, 3.0F, 31.0F, 2.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 12, 29, 4.0F, 31.0F, 2.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 0, 3.0F, 31.0F, 7.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 28, 6, 3.0F, 30.0F, 7.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 7, 3.0F, 30.0F, 2.0F, 1, 1, 5, 0.0F));
    
    this.bipedHead = new ModelRenderer(this);
    this.bipedCloak = new ModelRenderer(this);
    this.bipedEars = new ModelRenderer(this);
    this.bipedHeadwear = new ModelRenderer(this);
    this.bipedLeftArm = new ModelRenderer(this);
    this.bipedLeftLeg = new ModelRenderer(this);
    this.bipedRightArm = new ModelRenderer(this);
    this.bipedRightLeg = new ModelRenderer(this);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
  {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/model/ModelRocketBoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */