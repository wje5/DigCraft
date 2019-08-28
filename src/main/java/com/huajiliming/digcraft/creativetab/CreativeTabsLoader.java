package com.huajiliming.digcraft.creativetab;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader
{
  public static CreativeTabs tabDigcraft;
  
  public CreativeTabsLoader(FMLPreInitializationEvent event)
  {
    tabDigcraft = new CreativeTabDigcraft();
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/creativetab/CreativeTabsLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */