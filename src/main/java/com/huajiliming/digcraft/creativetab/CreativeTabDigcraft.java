package com.huajiliming.digcraft.creativetab;

import com.huajiliming.digcraft.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabDigcraft
  extends CreativeTabs
{
  public CreativeTabDigcraft()
  {
    super("digcraft");
  }
  
  public Item getTabIconItem()
  {
    return Item.getItemFromBlock(BlockLoader.sapphireOre);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/creativetab/CreativeTabDigcraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */