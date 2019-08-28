package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.entity.EntityBlackhole;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlackhole
  extends Item
{
  public ItemBlackhole()
  {
    setUnlocalizedName("blackhole");
    setTextureName("digcraft:blackhole");
    setMaxStackSize(1);
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face, float xPos, float yPos, float zPos)
  {
    if (!world.isRemote)
    {
      Entity blackhole = new EntityBlackhole(world);
      switch (face)
      {
      case 0: 
        blackhole.setPosition(x + 0.5F, y - 0.5F, z + 0.5F);
        break;
      case 1: 
        blackhole.setPosition(x + 0.5F, y + 1.5F, z + 0.5F);
        break;
      case 2: 
        blackhole.setPosition(x + 0.5F, y + 0.5F, z - 0.5F);
        break;
      case 3: 
        blackhole.setPosition(x + 0.5F, y + 0.5F, z + 1.5F);
        break;
      case 4: 
        blackhole.setPosition(x - 0.5F, y + 0.5F, z + 0.5F);
        break;
      case 5: 
        blackhole.setPosition(x + 1.5F, y + 0.5F, z + 0.5F);
      }
      world.spawnEntityInWorld(blackhole);
    }
    return true;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemBlackhole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */