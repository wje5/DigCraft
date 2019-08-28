package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.DigCraft;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.inventory.GuiElementLoader;
import com.huajiliming.digcraft.tileentity.TileEntitySmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSmelter extends BlockContainer {
	private IIcon top;
	private IIcon sides;
	private IIcon frontOn;
	private IIcon frontOff;

	public BlockSmelter() {
		super(Material.iron);
		this.setBlockName("smelter");
		this.setBlockTextureName("digcraft:smelter");
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 4);
		this.setHardness(7.0F);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xPos,
			float yPos, float zPos) {
		player.openGui(DigCraft.instance, GuiElementLoader.GUI_SMELTER, world, x, y, z);
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		int meta = BlockPistonBase.determineOrientation(world, x, y, z, entity);
		if ((meta == 0) || (meta == 1)) {
			meta = 2;
		}
		meta -= 2;
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.top = iconRegister.registerIcon("digcraft:smelter_top");
		this.sides = iconRegister.registerIcon("digcraft:smelter_sides");
		this.frontOn = iconRegister.registerIcon("digcraft:smelter_front_on");
		this.frontOff = iconRegister.registerIcon("digcraft:smelter_front_off");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		switch (side) {
		case 0:
			return this.sides;
		case 1:
			return this.top;
		}
		int meta = world.getBlockMetadata(x, y, z);
		if (meta % 8 == side - 2) {
			if (meta < 8) {
				return this.frontOff;
			}
			return this.frontOn;
		}
		return this.sides;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		switch (side) {
		case 1:
			return this.top;
		case 3:
			return this.frontOff;
		}
		return this.sides;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntitySmelter tileentity = (TileEntitySmelter) world.getTileEntity(x, y, z);
		if (tileentity != null) {
			for (int i1 = 0; i1 < tileentity.getSizeInventory(); i1++) {
				ItemStack itemstack = tileentity.getStackInSlot(i1);
				if (itemstack != null) {
					Random rand = new Random();
					float f = rand.nextFloat() * 0.8F + 0.1F;
					float f1 = rand.nextFloat() * 0.8F + 0.1F;
					float f2 = rand.nextFloat() * 0.8F + 0.1F;
					while (itemstack.stackSize > 0) {
						int j1 = rand.nextInt(21) + 10;
						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}
						itemstack.stackSize -= j1;

						EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2,
								new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem()
									.setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
						float f3 = 0.05F;
						entityitem.motionX = ((float) rand.nextGaussian() * f3);
						entityitem.motionY = ((float) rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = ((float) rand.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta >= 8) {
			for (int i = 0; i < 3; i++) {
				float f1 = y + 1.0F + rand.nextFloat() * 6.0F / 16.0F;
				world.spawnParticle("smoke", x + 0.5F, f1, z + 0.5F, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySmelter();
	}
}