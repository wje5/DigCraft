package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemGrayJadeDagger
  extends ItemSword
{
  public ItemGrayJadeDagger()
  {
    super(EnumHelper.addToolMaterial("grayJade", 24, 34000, 29.0F, 20.0F, 28));
    setUnlocalizedName("grayJadeDagger");
    setTextureName("digcraft:grayJadeDagger");
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
  
  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
  {
    return stack;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/item/ItemGrayJadeDagger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */