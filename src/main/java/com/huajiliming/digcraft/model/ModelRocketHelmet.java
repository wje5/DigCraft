package com.huajiliming.digcraft.model;

import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelRocketHelmet
  extends ModelBiped
{
  public ModelRocketHelmet()
  {
    this.textureWidth = 128;
    this.textureHeight = 128;
    this.bipedBody = new ModelRenderer(this);
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 18, -7.0F, -16.0F, -7.0F, 1, 1, 13, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 41, 6.0F, -16.0F, -8.0F, 1, 1, 13, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 20, -7.0F, -16.0F, -8.0F, 13, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 22, -6.0F, -16.0F, 5.0F, 13, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 26, -5.0F, -17.0F, 4.0F, 11, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 24, -6.0F, -17.0F, -7.0F, 11, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 42, 43, 5.0F, -17.0F, -7.0F, 1, 1, 11, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 15, 41, -6.0F, -17.0F, -6.0F, 1, 1, 11, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 48, 55, -5.0F, -18.0F, -5.0F, 1, 1, 9, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 42, -4.0F, -18.0F, 3.0F, 9, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 28, -5.0F, -18.0F, -6.0F, 9, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 55, 4.0F, -18.0F, -6.0F, 1, 1, 9, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 17, -4.0F, -19.0F, -5.0F, 7, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 9, 3.0F, -19.0F, -5.0F, 1, 1, 7, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 6, -3.0F, -19.0F, 2.0F, 7, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -4.0F, -19.0F, -4.0F, 1, 1, 7, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 21, 2.0F, -20.0F, -4.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 8, -3.0F, -20.0F, -4.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 10, -2.0F, -20.0F, 1.0F, 5, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 0, -3.0F, -20.0F, -3.0F, 1, 1, 5, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 9, 4, 1.0F, -21.0F, -3.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 9, 13, -2.0F, -21.0F, -3.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 12, -1.0F, -21.0F, 0.0F, 3, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 9, 0, -2.0F, -21.0F, -2.0F, 1, 1, 3, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 9, 10, -1.0F, -22.0F, -2.0F, 2, 1, 2, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 18, -7.0F, -15.0F, 6.0F, 15, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 55, 18, -8.0F, -15.0F, -9.0F, 15, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 0, 7.0F, -15.0F, -9.0F, 1, 1, 15, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 25, 40, -8.0F, -15.0F, -8.0F, 1, 1, 15, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 22, -9.0F, -14.0F, -9.0F, 1, 1, 17, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 42, 40, -8.0F, -14.0F, 7.0F, 17, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 36, -9.0F, -14.0F, -10.0F, 17, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 0, 8.0F, -14.0F, -10.0F, 1, 1, 17, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 21, 9.0F, -13.0F, -11.0F, 1, 1, 19, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 1, -10.0F, -13.0F, -10.0F, 1, 1, 19, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 34, -9.0F, -13.0F, 8.0F, 19, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 40, 32, -10.0F, -13.0F, -11.0F, 19, 1, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 12, 21, 3.0F, -18.0F, -5.0F, 1, 10, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 0, 27, 3.0F, -18.0F, 2.0F, 1, 10, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 25, 21, -4.0F, -18.0F, 2.0F, 1, 10, 1, 0.0F));
    this.bipedBody.cubeList.add(new ModelBox(this.bipedBody, 21, 22, -4.0F, -18.0F, -5.0F, 1, 10, 1, 0.0F));
    
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


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/model/ModelRocketHelmet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */