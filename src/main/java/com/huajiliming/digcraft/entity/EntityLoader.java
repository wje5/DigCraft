package com.huajiliming.digcraft.entity;

import com.huajiliming.digcraft.DigCraft;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;

public class EntityLoader
{
  private static int nextID = 0;
  
  public EntityLoader()
  {
    registerEntity(EntityBlackhole.class, "Blackhole", 64, 3, false);
    registerEntity(EntitySuckingBlock.class, "SuckingBlock", 64, 3, true);
    registerEntity(EntityGrayJadeGolem.class, "GrayJadeGolem", 64, 3, true);
    registerEntity(EntityRitual.class, "Ritual", 64, 3, true);
  }
  
  private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
  {
    EntityRegistry.registerModEntity(entityClass, name, nextID++, DigCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/entity/EntityLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */