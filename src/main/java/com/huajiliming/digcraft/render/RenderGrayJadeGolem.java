package com.huajiliming.digcraft.render;

import com.huajiliming.digcraft.entity.EntityGrayJadeGolem;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGrayJadeGolem
  extends RenderIronGolem
{
  private static final ResourceLocation grayJadeGolemTextures = new ResourceLocation("digcraft:textures/entity/grayJadeGolem.png");
  
  protected void preRenderCallback(EntityLivingBase entity, float partialTickTime)
  {
    float scale = ((EntityGrayJadeGolem)entity).getDataWatcher().getWatchableObjectInt(17) * 0.1F;
    GL11.glScalef(scale, scale, scale);
    super.preRenderCallback(entity, partialTickTime);
  }
  
  protected ResourceLocation getEntityTexture(EntityIronGolem entity)
  {
    return grayJadeGolemTextures;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/render/RenderGrayJadeGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */