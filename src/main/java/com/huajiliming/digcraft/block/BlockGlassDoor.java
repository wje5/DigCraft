package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.TileEntityGlassDoor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlassDoor extends BlockContainer {
	public BlockGlassDoor() {
		super(Material.glass);
		this.setHardness(1.0F);
		this.setBlockName("glassDoor");
		this.setBlockTextureName("minecraft:glass_pane_top");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 4) {
			meta = world.getBlockMetadata(x, y + 1, z);
			world.setBlockMetadataWithNotify(x, y + 1, z, meta < 6 ? meta + 2 : meta - 2, 2);
		} else if (meta < 8) {
			world.setBlockMetadataWithNotify(x, y, z, meta < 6 ? meta + 2 : meta - 2, 2);
		} else if (meta < 12) {
			switch (meta) {
			case 8:
				meta = world.getBlockMetadata(x + 1, y + 1, z);
				world.setBlockMetadataWithNotify(x + 1, y + 1, z, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 9:
				meta = world.getBlockMetadata(x - 1, y + 1, z);
				world.setBlockMetadataWithNotify(x - 1, y + 1, z, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 10:
				meta = world.getBlockMetadata(x, y + 1, z - 1);
				world.setBlockMetadataWithNotify(x, y + 1, z - 1, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 11:
				meta = world.getBlockMetadata(x, y + 1, z + 1);
				world.setBlockMetadataWithNotify(x, y + 1, z + 1, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			}
		} else {
			switch (meta) {
			case 12:
				meta = world.getBlockMetadata(x + 1, y, z);
				world.setBlockMetadataWithNotify(x + 1, y, z, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 13:
				meta = world.getBlockMetadata(x - 1, y, z);
				world.setBlockMetadataWithNotify(x - 1, y, z, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 14:
				meta = world.getBlockMetadata(x, y, z - 1);
				world.setBlockMetadataWithNotify(x, y, z - 1, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			case 15:
				meta = world.getBlockMetadata(x, y, z + 1);
				world.setBlockMetadataWithNotify(x, y, z + 1, meta < 6 ? meta + 2 : meta - 2, 2);
				break;
			}
		}
		return true;
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
		if (meta < 4) {
			switch (meta) {
			case 0:
				if (world.getBlock(x - 1, y, z) != BlockLoader.glassDoor
						|| world.getBlock(x - 1, y + 1, z) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z) != BlockLoader.glassDoor) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.glassDoor));
					world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x - 1, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				}
				break;
			case 1:
				if (world.getBlock(x + 1, y, z) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z) != BlockLoader.glassDoor
						|| world.getBlock(x + 1, y + 1, z) != BlockLoader.glassDoor) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.glassDoor));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y + 1, z, Blocks.air, 0, 2);
				}
				break;
			case 2:
				if (world.getBlock(x, y, z + 1) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z + 1) != BlockLoader.glassDoor) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.glassDoor));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z + 1, Blocks.air, 0, 2);
				}
				break;
			case 3:
				if (world.getBlock(x, y, z - 1) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z - 1) != BlockLoader.glassDoor
						|| world.getBlock(x, y + 1, z) != BlockLoader.glassDoor) {
					this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.glassDoor));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				}
				break;
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 4) {
			if (meta < 2) {
				this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
			} else {
				this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
			}
		} else if (meta < 8) {
			if (meta % 2 == 0) {
				this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
			} else {
				this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
			}
		} else {
			switch (meta) {
			case 8:
				if (world.getBlockMetadata(x + 1, y + 1, z) >= 6) {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				} else {
					this.setBlockBounds(0.75F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				}
				break;
			case 9:
				if (world.getBlockMetadata(x - 1, y + 1, z) >= 6) {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 0.25F, 1.0F, 0.75F);
				}
				break;
			case 10:
				if (world.getBlockMetadata(x, y + 1, z - 1) >= 6) {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 0.25F);
				}
				break;
			case 11:
				if (world.getBlockMetadata(x, y + 1, z + 1) >= 6) {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.25F, 0.0F, 0.75F, 0.75F, 1.0F, 1.0F);
				}
				break;
			case 12:
				if (world.getBlockMetadata(x + 1, y, z) >= 6) {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				} else {
					this.setBlockBounds(0.75F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				}
				break;
			case 13:
				if (world.getBlockMetadata(x - 1, y, z) >= 6) {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.25F, 0.25F, 1.0F, 0.75F);
				}
				break;
			case 14:
				if (world.getBlockMetadata(x, y, z - 1) >= 6) {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 0.25F);
				}
				break;
			case 15:
				if (world.getBlockMetadata(x, y, z + 1) >= 6) {
					this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.25F, 0.0F, 0.75F, 0.75F, 1.0F, 1.0F);
				}
				break;
			}
//			switch (meta % 4) {
//			case 0:
//				this.setBlockBounds(0.75F, 0.0F, 0.25F, 1.0F, 1.0F, 0.75F);
//				break;
//			case 1:
//				this.setBlockBounds(0.0F, 0.0F, 0.25F, 0.25F, 1.0F, 0.75F);
//				break;
//			case 2:
//				this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 1.0F, 0.25F);
//				break;
//			case 3:
//				this.setBlockBounds(0.25F, 0.0F, 0.75F, 0.75F, 1.0F, 1.0F);
//				break;
//			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (meta >= 12) {
			world.setBlockToAir(x, y - 1, z);
		} else if (meta < 4) {
			switch (meta) {
			case 0:
				world.setBlock(x - 1, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x - 1, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				break;
			case 1:
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x + 1, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x + 1, y + 1, z, Blocks.air, 0, 2);
				break;
			case 2:
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z + 1, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z + 1, Blocks.air, 0, 2);
				break;
			case 3:
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z - 1, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z - 1, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				break;
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 4 ? ItemLoader.glassDoor : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.glassDoor;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGlassDoor();
	}
}
