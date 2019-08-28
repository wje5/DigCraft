package com.huajiliming.digcraft.block;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.item.ItemMaterial;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockMaterialOre
  extends Block
{
  public ItemMaterial material;
  
  public BlockMaterialOre(ItemMaterial material)
  {
    super(Material.rock);
    this.material = material;
    setBlockName(this.material.name + "Ore");
    setBlockTextureName("digcraft:" + this.material.name + "Ore");
    setResistance(15.0F);
    setStepSound(Block.soundTypeStone);
    setHarvestLevel("pickaxe", this.material.level - 1);
    setHardness(this.material.hardness - 2);
    setCreativeTab(CreativeTabsLoader.tabDigcraft);
  }
  
  public Item getItemDropped(int metadata, Random rand, int fortune)
  {
    return this.material.isMetal ? Item.getItemFromBlock(this) : this.material;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/block/BlockMaterialOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */