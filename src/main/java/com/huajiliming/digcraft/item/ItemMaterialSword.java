package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemSword;

public class ItemMaterialSword
  extends ItemSword
{
  public ItemMaterialSword(ItemMaterial item)
  {
    super(item.toolMaterial);
    setUnlocalizedName(item.name + "Sword");
    setTextureName("digcraft:" + item.name + "Sword");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterialSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */