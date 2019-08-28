package com.huajiliming.digcraft.item;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.tileentity.TileEntityCastingTable;
import com.huajiliming.digcraft.tileentity.TileEntityCrucible;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class ItemCrucibleSpoon extends Item {
	private IIcon empty;
	private IIcon filled;

	public ItemCrucibleSpoon() {
		this.setUnlocalizedName("crucibleSpoon");
		this.setTextureName("digcraft:crucibleSpoon");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int face,
			float xPos, float yPos, float zPos) {
		if (!world.isRemote) {
			if (stack.getItemDamage() == 0) {
				if (world.getBlock(x, y, z) == BlockLoader.crucible) {
					TileEntityCrucible te = (TileEntityCrucible) world.getTileEntity(x, y, z);
					if (te != null) {
						FluidStack tank = te.drain(ForgeDirection.getOrientation(face), 144, false);
						if (tank != null && tank.amount == 144) {
							stack.setItemDamage(1);
							te.drain(ForgeDirection.getOrientation(face), 144, true);
							return true;
						}
					}
				}
			} else {
				if (world.getBlock(x, y, z) == BlockLoader.castingTable) {
					TileEntityCastingTable te = (TileEntityCastingTable) world.getTileEntity(x, y, z);
					if (te != null) {
						if (te.tryFill()) {
							stack.setItemDamage(0);
							return true;
						}
					}

				}
			}
		}
		return false;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.empty = register.registerIcon("digcraft:crucibleSpoon");
		this.filled = register.registerIcon("digcraft:crucibleSpoonFilled");
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		return damage == 1 ? this.filled : this.empty;
	}
}