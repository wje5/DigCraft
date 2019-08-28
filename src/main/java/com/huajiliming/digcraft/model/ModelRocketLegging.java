package com.huajiliming.digcraft.model;

import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelRocketLegging
  extends ModelBiped
{
  public ModelRocketLegging()
  {
    this.textureWidth = 32;
    this.textureHeight = 32;
    this.bipedBody = new ModelRenderer(this);
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -1.0F, 28.0F, -17.0F, 1, 1, 6, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 0, -1.0F, 27.0F, -16.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 15, 0, -1.0F, 26.0F, -15.0F, 1, 1, 4, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 7, 18, -1.0F, 25.0F, -14.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -1.0F, 24.0F, -13.0F, 1, 1, 2, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 2, -1.0F, 23.0F, -12.0F, 1, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 13, 14, 10.0F, 28.0F, -1.0F, 6, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 16, 6, 10.0F, 27.0F, -1.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 15, 20, 10.0F, 26.0F, -1.0F, 4, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 21, 10.0F, 25.0F, -1.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 9, 10.0F, 24.0F, -1.0F, 2, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 12, 10.0F, 23.0F, -1.0F, 1, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 12, -16.0F, 28.0F, -1.0F, 6, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 6, 16, -15.0F, 27.0F, -1.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 16, 8, -14.0F, 26.0F, -1.0F, 4, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 20, 16, -13.0F, 25.0F, -1.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 8, -12.0F, 24.0F, -1.0F, 2, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 10, -11.0F, 23.0F, -1.0F, 1, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 8, -1.0F, 28.0F, 9.0F, 1, 1, 6, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 9, 6, -1.0F, 27.0F, 9.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 15, -1.0F, 26.0F, 9.0F, 1, 1, 4, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 15, 16, -1.0F, 25.0F, 9.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 4, -1.0F, 24.0F, 9.0F, 1, 1, 2, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 8, 0, -1.0F, 23.0F, 9.0F, 1, 1, 1, 0.0F));
    
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


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/model/ModelRocketLegging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */