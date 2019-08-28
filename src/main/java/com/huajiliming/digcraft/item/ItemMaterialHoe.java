package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemHoe;

public class ItemMaterialHoe
  extends ItemHoe
{
  public ItemMaterialHoe(ItemMaterial item)
  {
    super(item.toolMaterial);
    setUnlocalizedName(item.name + "Hoe");
    setTextureName("digcraft:" + item.name + "Hoe");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterialHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */