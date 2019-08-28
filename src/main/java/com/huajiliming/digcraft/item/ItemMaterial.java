package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemMaterial
  extends Item
{
  public Item.ToolMaterial toolMaterial;
  public String name;
  public boolean isMetal;
  public int level;
  public int hardness;
  public float atk;
  
  public ItemMaterial(String name, boolean isMetal, int level, int maxUse, float efficiency, float atk, int enchantability, int hardness)
  {
    this.name = name;
    this.isMetal = isMetal;
    this.level = level;
    this.hardness = hardness;
    this.atk = atk;
    setUnlocalizedName(this.name);
    setTextureName("digcraft:" + this.name);
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
    this.toolMaterial = EnumHelper.addToolMaterial(this.name, level, maxUse, efficiency, atk, enchantability);
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */