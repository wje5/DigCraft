package com.huajiliming.digcraft.block;

import java.util.Random;

import com.huajiliming.digcraft.DigCraft;
import com.huajiliming.digcraft.inventory.GuiElementLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.StandardInventoryTileEntity;
import com.huajiliming.digcraft.tileentity.TileEntityFridge;

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
import net.minecraft.world.World;

public class BlockFridge extends BlockContainer {
	public BlockFridge() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setBlockName("fridge");
		this.setBlockTextureName("digcraft:fridge");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xPos,
			float yPos, float zPos) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 4) {
			player.openGui(DigCraft.instance, GuiElementLoader.GUI_FRIDGEBIG, world, x, y, z);
		} else if (meta < 8) {
			player.openGui(DigCraft.instance, GuiElementLoader.GUI_FRIDGEBIG, world, x, y - 1, z);
		} else {
			player.openGui(DigCraft.instance, GuiElementLoader.GUI_FRIDGESMALL, world, x, y - 2, z);
		}

		return true;
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
		if (meta < 4) {
			world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
			world.setBlock(x, y + 2, z, Blocks.air, 0, 2);
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
		if (meta < 4) {
			if (world.getBlock(x, y + 1, z) != BlockLoader.fridge
					|| world.getBlock(x, y + 2, z) != BlockLoader.fridge) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.fridge));
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y + 2, z, Blocks.air, 0, 2);
			}
		} else if (meta < 8) {
			if (world.getBlock(x, y + 1, z) != BlockLoader.fridge
					|| world.getBlock(x, y - 1, z) != BlockLoader.fridge) {
				world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				world.setBlock(x, y, z, Blocks.air, 0, 2);
				world.setBlock(x, y - 1, z, Blocks.air, 0, 2);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(ItemLoader.fridge));
			}
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return meta < 4 ? ItemLoader.fridge : null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return ItemLoader.fridge;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFridge();
	}
}
