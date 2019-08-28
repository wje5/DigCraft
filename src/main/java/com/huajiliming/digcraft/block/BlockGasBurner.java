package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.StandardInventoryTileEntity;
import com.huajiliming.digcraft.tileentity.TileEntityGasBurner;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGasBurner extends BlockContainer {
	public BlockGasBurner() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setBlockName("gasBurner");
		this.setBlockTextureName("digcraft:gasBurner");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta % 4 == face - 2) {
			if (meta % 8 >= 4) {
				meta -= 4;
			} else {
				meta += 4;
			}
			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			return true;
		} else if (face == 1) {
			TileEntityGasBurner te = (TileEntityGasBurner) world.getTileEntity(x, y, z);
			ItemStack stack = player.getHeldItem();
			if (stack != null && meta >= 8) {
				if (te.tryPutItem(stack)) {
//					player.inventory.mainInventory[player.inventory.currentItem] = null;
					stack.stackSize--;
					return true;
				}
			}
			if (stack == null && meta >= 8 && te.getStackInSlot(0) == null) {
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(ItemLoader.pan);
				world.setBlockMetadataWithNotify(x, y, z, meta - 8, 2);
				return true;
			}
			if (stack == null && meta % 8 < 4 && te.getStackInSlot(0) == null) {
				player.inventory.mainInventory[player.inventory.currentItem] = te.getStackInSlot(1);
				te.setInventorySlotContents(1, null);
				return true;
			}
			if (stack == null) {
				player.inventory.mainInventory[player.inventory.currentItem] = te.takeItem();
				return true;
			}
		}
		return false;
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
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		StandardInventoryTileEntity tileentity = (StandardInventoryTileEntity) world.getTileEntity(x, y, z);
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
		if (meta >= 8) {
			Random rand = new Random();
			float f = rand.nextFloat() * 0.8F + 0.1F;
			float f1 = rand.nextFloat() * 0.8F + 0.1F;
			float f2 = rand.nextFloat() * 0.8F + 0.1F;
			EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(ItemLoader.pan));
			float f3 = 0.05F;
			entityitem.motionX = ((float) rand.nextGaussian() * f3);
			entityitem.motionY = ((float) rand.nextGaussian() * f3 + 0.2F);
			entityitem.motionZ = ((float) rand.nextGaussian() * f3);
			world.spawnEntityInWorld(entityitem);
		}
		super.breakBlock(world, x, y, z, block, meta);
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
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGasBurner();
	}
}
