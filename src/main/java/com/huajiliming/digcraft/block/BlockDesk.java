package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.StandardInventoryTileEntity;
import com.huajiliming.digcraft.tileentity.TileEntityDesk;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDesk extends BlockContainer {
	public BlockDesk() {
		super(Material.wood);
		this.setHardness(1.0F);
		this.setBlockName("desk");
		this.setBlockTextureName("digcraft:desk");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		int meta = world.getBlockMetadata(x, y, z);
		int slot = -1;
		TileEntityDesk te = null;
		if (face == 1) {
			switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				te = (TileEntityDesk) world.getTileEntity(x, y, z);
				slot = 3;
				break;
			case 8:
				te = (TileEntityDesk) world.getTileEntity(x + 1, y, z);
				slot = 2;
				break;
			case 11:
				te = (TileEntityDesk) world.getTileEntity(x - 1, y, z);
				slot = 2;
				break;
			case 13:
				te = (TileEntityDesk) world.getTileEntity(x, y, z - 1);
				slot = 2;
				break;
			case 14:
				te = (TileEntityDesk) world.getTileEntity(x, y, z + 1);
				slot = 2;
				break;
			case 9:
				te = (TileEntityDesk) world.getTileEntity(x - 1, y, z);
				slot = 4;
				break;
			case 10:
				te = (TileEntityDesk) world.getTileEntity(x + 1, y, z);
				slot = 4;
				break;
			case 12:
				te = (TileEntityDesk) world.getTileEntity(x, y, z + 1);
				slot = 4;
				break;
			case 15:
				te = (TileEntityDesk) world.getTileEntity(x, y, z - 1);
				slot = 4;
				break;
			}
			if (slot != -1) {
				ItemStack stack = player.getHeldItem();
				if (stack != null) {
					if (te.getStackInSlot(slot) == null) {
						te.setInventorySlotContents(slot, stack);
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						return true;
					}
				} else if (te.getStackInSlot(slot) != null) {
					player.inventory.mainInventory[player.inventory.currentItem] = te.getStackInSlot(slot);
					te.setInventorySlotContents(slot, null);
					return true;
				}
			}
		} else if (meta >= 8) {
			if (posY >= 0.4375 && posY <= 0.8125) {
				switch (meta) {
				case 8:
					if (face == 2 && posX <= 0.875) {
						te = (TileEntityDesk) world.getTileEntity(x + 1, y, z);
						slot = 1;
					}
					break;
				case 9:
					if (face == 2 && posX >= 0.125) {
						te = (TileEntityDesk) world.getTileEntity(x - 1, y, z);
						slot = 0;
					}
					break;
				case 10:
					if (face == 3 && posX >= 0.125) {
						te = (TileEntityDesk) world.getTileEntity(x + 1, y, z);
						slot = 0;
					}
					break;
				case 11:
					if (face == 3 && posX <= 0.875) {
						te = (TileEntityDesk) world.getTileEntity(x - 1, y, z);
						slot = 1;
					}
					break;
				case 12:
					if (face == 4 && posZ >= 0.125) {
						te = (TileEntityDesk) world.getTileEntity(x, y, z + 1);
						slot = 0;
					}
					break;
				case 13:
					if (face == 4 && posZ <= 0.875) {
						te = (TileEntityDesk) world.getTileEntity(x, y, z - 1);
						slot = 1;
					}
					break;
				case 14:
					if (face == 5 && posZ >= 0.125) {
						te = (TileEntityDesk) world.getTileEntity(x, y, z + 1);
						slot = 1;
					}
					break;
				case 15:
					if (face == 5 && posZ <= 0.875) {
						te = (TileEntityDesk) world.getTileEntity(x, y, z - 1);
						slot = 0;
					}
					break;
				}
				if (slot != -1) {
					if (player.isSneaking()) {
						if (slot == 0) {
							te.drawerOpenLeft = !te.drawerOpenLeft;
						} else {
							te.drawerOpenRight = !te.drawerOpenRight;
						}
					} else if ((slot == 0 && te.drawerOpenLeft) || (slot == 1 && te.drawerOpenRight)) {
						ItemStack stack = player.getHeldItem();
						if (stack != null) {
							if (te.getStackInSlot(slot) == null) {
								te.setInventorySlotContents(slot, stack);
								player.inventory.mainInventory[player.inventory.currentItem] = null;
								return true;
							}
						} else if (te.getStackInSlot(slot) != null) {
							player.inventory.mainInventory[player.inventory.currentItem] = te.getStackInSlot(slot);
							te.setInventorySlotContents(slot, null);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 8) {
			switch (meta) {
			case 0:
			case 1:
				world.setBlockToAir(x - 1, y, z);
				world.setBlockToAir(x + 1, y, z);
				break;
			case 2:
			case 3:
				world.setBlockToAir(x, y, z - 1);
				world.setBlockToAir(x, y, z + 1);
				break;
			}
		}
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
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 8) {
			switch (meta) {
			case 0:
			case 1:
				if (world.getBlock(x - 1, y, z) != BlockLoader.desk
						|| world.getBlock(x + 1, y, z) != BlockLoader.desk) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.desk));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.desk
						|| world.getBlock(x, y, z + 1) != BlockLoader.desk) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.desk));
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
				}
				break;
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.desk : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.desk;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityDesk();
	}

}
