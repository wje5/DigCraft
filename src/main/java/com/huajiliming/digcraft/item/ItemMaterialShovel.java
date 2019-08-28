package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemSpade;

public class ItemMaterialShovel
  extends ItemSpade
{
  public ItemMaterialShovel(ItemMaterial item)
  {
    super(item.toolMaterial);
    setUnlocalizedName(item.name + "Shovel");
    setTextureName("digcraft:" + item.name + "Shovel");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterialShovel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */