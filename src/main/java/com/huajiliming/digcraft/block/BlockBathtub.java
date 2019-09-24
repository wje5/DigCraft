package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityBathtub;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBathtub extends BlockContainer {
	public BlockBathtub() {
		super(Material.clay);
		this.setHardness(1.0F);
		this.setBlockName("bathtub");
		this.setBlockTextureName("digcraft:toilet");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		ItemStack stack = player.getHeldItem();
		int meta = world.getBlockMetadata(x, y, z);
		if (stack != null) {
			if (stack.getItem() == Items.water_bucket) {
				if (meta < 4) {
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Items.bucket);
					world.setBlockMetadataWithNotify(x, y, z, meta + 4, 2);
					switch (meta) {
					case 0:
						world.setBlockMetadataWithNotify(x - 1, y, z, meta + 12, 2);
						break;
					case 1:
						world.setBlockMetadataWithNotify(x + 1, y, z, meta + 12, 2);
						break;
					case 2:
						world.setBlockMetadataWithNotify(x, y, z + 1, meta + 12, 2);
						break;
					case 3:
						world.setBlockMetadataWithNotify(x, y, z - 1, meta + 12, 2);
						break;
					}
					return true;
				} else if (meta >= 8 && meta < 12) {
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Items.bucket);
					world.setBlockMetadataWithNotify(x, y, z, meta + 4, 2);
					switch (meta) {
					case 0:
						world.setBlockMetadataWithNotify(x + 1, y, z, meta - 4, 2);
						break;
					case 1:
						world.setBlockMetadataWithNotify(x - 1, y, z, meta - 4, 2);
						break;
					case 2:
						world.setBlockMetadataWithNotify(x, y, z - 1, meta - 4, 2);
						break;
					case 3:
						world.setBlockMetadataWithNotify(x, y, z + 1, meta - 4, 2);
						break;
					}
					return true;
				}
			} else if (stack.getItem() == Items.bucket) {
				if (meta >= 4 && meta < 8) {
					if (stack.stackSize > 1) {
						stack.stackSize--;
					} else {
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						if (!player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket))) {
							player.dropPlayerItemWithRandomChoice(new ItemStack(Items.water_bucket), false);
						}
					}
					world.setBlockMetadataWithNotify(x, y, z, meta - 4, 2);
					switch (meta) {
					case 0:
						world.setBlockMetadataWithNotify(x - 1, y, z, meta + 4, 2);
						break;
					case 1:
						world.setBlockMetadataWithNotify(x + 1, y, z, meta + 4, 2);
						break;
					case 2:
						world.setBlockMetadataWithNotify(x, y, z + 1, meta + 4, 2);
						break;
					case 3:
						world.setBlockMetadataWithNotify(x, y, z - 1, meta + 4, 2);
						break;
					}
					return true;
				} else if (meta >= 12) {
					if (stack.stackSize > 1) {
						stack.stackSize--;
					} else {
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						if (!player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket))) {
							player.dropPlayerItemWithRandomChoice(new ItemStack(Items.water_bucket), false);
						}
					}
					world.setBlockMetadataWithNotify(x, y, z, meta - 4, 2);
					switch (meta) {
					case 0:
						world.setBlockMetadataWithNotify(x + 1, y, z, meta + 4, 2);
						break;
					case 1:
						world.setBlockMetadataWithNotify(x - 1, y, z, meta + 4, 2);
						break;
					case 2:
						world.setBlockMetadataWithNotify(x, y, z - 1, meta + 4, 2);
						break;
					case 3:
						world.setBlockMetadataWithNotify(x, y, z + 1, meta + 4, 2);
						break;
					}
					return true;
				}
			}
		}
		return false;
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
				if (world.getBlock(x - 1, y, z) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			case 1:
				if (world.getBlock(x + 1, y, z) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
				if (world.getBlock(x, y, z + 1) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
				}
				break;
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.bathtub) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.bathtub));
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				break;
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta < 8) {
			switch (meta) {
			case 0:
				world.setBlockToAir(x - 1, y, z);
				break;
			case 1:
				world.setBlockToAir(x + 1, y, z);
				break;
			case 2:
				world.setBlockToAir(x, y, z + 1);
				break;
			case 3:
				world.setBlockToAir(x, y, z - 1);
				break;
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.6975F, 1.0F);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 8 ? ItemLoader.bathtub : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.bathtub;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBathtub();
	}
}
