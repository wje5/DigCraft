package com.huajiliming.digcraft.worldstorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class GolemWorldSavedData
  extends WorldSavedData
{
  private int summonTime;
  
  public GolemWorldSavedData(String name)
  {
    super(name);
  }
  
  public int addSummonTime()
  {
    this.summonTime += 1;
    markDirty();
    return this.summonTime;
  }
  
  public void readFromNBT(NBTTagCompound tag)
  {
    this.summonTime = tag.getInteger("summonTime");
  }
  
  public void writeToNBT(NBTTagCompound tag)
  {
    tag.setInteger("summonTime", this.summonTime);
  }
  
  public static GolemWorldSavedData getGlobal(World world)
  {
    WorldSavedData data = world.mapStorage.loadData(GolemWorldSavedData.class, "DigcraftGolemGlobal");
    if (data == null)
    {
      data = new GolemWorldSavedData("DigcraftGolemGlobal");
      world.mapStorage.setData("DigcraftGolemGlobal", data);
    }
    return (GolemWorldSavedData)data;
  }
}


/* Location:              /Volumes/NO NAME/digcraft-pretest4-deobf.jar!/com/huajiliming/digcraft/worldstorage/GolemWorldSavedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */