package com.huajiliming.digcraft.model;

import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelRocketChestplate
  extends ModelBiped
{
  public ModelRocketChestplate()
  {
    this.textureWidth = 128;
    this.textureHeight = 128;
    this.bipedBody = new ModelRenderer(this);
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 22, 9.0F, -12.0F, -10.0F, 1, 41, 19, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 22, -10.0F, -12.0F, -11.0F, 1, 41, 19, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 80, 42, -9.0F, -12.0F, -11.0F, 19, 41, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 80, 0, -10.0F, -12.0F, 8.0F, 19, 41, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -10.0F, 28.0F, -11.0F, 20, 1, 20, 0.0F));
    
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


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/model/ModelRocketChestplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */