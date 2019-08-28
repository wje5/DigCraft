package com.huajiliming.digcraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.world.World;

public class EntitySuckingBlock
  extends EntityFallingBlock
{
  public EntitySuckingBlock(World world)
  {
    super(world);
    this.width = 1.0F;
    this.height = 1.0F;
  }
  
  public EntitySuckingBlock(World world, double x, double y, double z, Block block, int meta)
  {
    super(world, x, y, z, block, meta);
    this.width = 1.0F;
    this.height = 1.0F;
  }
  
  public void onUpdate()
  {
    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;
    this.field_145812_b += 1;
  }
  
  @SideOnly(Side.CLIENT)
  public float getShadowSize()
  {
    return 0.0F;
  }
  
  protected void fall(float high) {}
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/entity/EntitySuckingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */