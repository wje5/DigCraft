package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemPickaxe;

public class ItemMaterialPickaxe
  extends ItemPickaxe
{
  public ItemMaterialPickaxe(ItemMaterial item)
  {
    super(item.toolMaterial);
    setUnlocalizedName(item.name + "Pickaxe");
    setTextureName("digcraft:" + item.name + "Pickaxe");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterialPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */