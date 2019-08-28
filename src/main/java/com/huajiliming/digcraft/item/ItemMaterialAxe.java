package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemAxe;

public class ItemMaterialAxe
  extends ItemAxe
{
  public ItemMaterialAxe(ItemMaterial item)
  {
    super(item.toolMaterial);
    setUnlocalizedName(item.name + "Axe");
    setTextureName("digcraft:" + item.name + "Axe");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterialAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */