package com.huajiliming.digcraft.potioneffect;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.potion.Potion;

public class PotionLoader
{
  public static Potion armorReduction;
  public static int nextID = 24;
  
  public PotionLoader(FMLPreInitializationEvent event)
  {
    armorReduction = new PotionArmorReduction(nextID++);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/potioneffect/PotionLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */