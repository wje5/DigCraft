package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.tileentity.TileEntityShoeArc;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockShoeArc extends BlockContainer {
	public BlockShoeArc() {
		super(Material.wood);
		this.setHardness(1.0F);
		this.setBlockName("shoeArc");
		this.setBlockTextureName("digcraft:shoeArc");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == face - 2) {
			int slot;
			if (posY >= 0.0625 && posY <= 0.4375) {
				slot = 0;
			} else if (posY >= 0.5625 && posY <= 0.9375) {
				slot = 1;
			} else {
				return false;
			}
			ItemStack stack = player.getHeldItem();
			if (stack != null) {
				Item item = stack.getItem();
				if (item instanceof ItemArmor && ((ItemArmor) item).armorType == 3) {
					TileEntityShoeArc te = (TileEntityShoeArc) world.getTileEntity(x, y, z);
					if (te.getStackInSlot(slot) == null) {
						te.setInventorySlotContents(slot, stack);
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						return true;
					}
				}
			} else {
				TileEntityShoeArc te = (TileEntityShoeArc) world.getTileEntity(x, y, z);
				if (te.getStackInSlot(slot) != null) {
					player.inventory.mainInventory[player.inventory.currentItem] = te.getStackInSlot(slot);
					te.setInventorySlotContents(slot, null);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityShoeArc tileentity = (TileEntityShoeArc) world.getTileEntity(x, y, z);
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
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		int meta = BlockPistonBase.determineOrientation(world, x, y, z, entity);
		if ((meta == 0) || (meta == 1)) {
			meta = 2;
		}
		meta -= 2;
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			break;
		case 2:
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			break;
		}
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityShoeArc();
	}
}
