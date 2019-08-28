package com.huajiliming.digcraft.block;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import com.huajiliming.digcraft.creativetab.CreativeTabsLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.IBindableTE;
import com.huajiliming.digcraft.tileentity.TileEntityWallSwitch;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWallSwitch extends BlockContainer implements IBindable {
	public BlockWallSwitch() {
		super(Material.circuits);
		this.setHardness(1.0F);
		this.setBlockName("wallSwitch");
		this.setBlockTextureName("digcraft:wallSwitch");
		this.setCreativeTab(CreativeTabsLoader.tabDigcraft);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float posX,
			float posY, float posZ) {
		if (player.getHeldItem() != null && player.getHeldItem().getItem() == ItemLoader.spanner) {
			return false;
		}
		((TileEntityWallSwitch) world.getTileEntity(x, y, z)).activate();
		return true;
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int face, float posX, float posY, float posZ, int meta) {
		if ((face == 0) || (face == 1)) {
			face = 2;
		}
		face -= 2;
		world.setBlockMetadataWithNotify(x, y, z, face, 2);
		return face;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block p_149695_5_) {
		if (this.canPlaceBlockAt(world, x, y, z)) {
			int meta = world.getBlockMetadata(x, y, z) % 4;
			boolean flag = false;
			if (!world.isSideSolid(x - 1, y, z, EAST) && meta == 3) {
				flag = true;
			}
			if (!world.isSideSolid(x + 1, y, z, WEST) && meta == 2) {
				flag = true;
			}
			if (!world.isSideSolid(x, y, z - 1, SOUTH) && meta == 1) {
				flag = true;
			}
			if (!world.isSideSolid(x, y, z + 1, NORTH) && meta == 0) {
				flag = true;
			}
			if (flag) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);
			}
		} else {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	}

	private boolean canPlace(World world, int x, int y, int z) {
		if (World.doesBlockHaveSolidTopSurface(world, x, y, z)) {
			return true;
		} else {
			Block block = world.getBlock(x, y, z);
			return block.canPlaceTorchOnTop(world, x, y, z);
		}
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int p_149707_5_) {
		ForgeDirection dir = ForgeDirection.getOrientation(p_149707_5_);
		return (dir == NORTH && world.isSideSolid(x, y, z + 1, NORTH))
				|| (dir == SOUTH && world.isSideSolid(x, y, z - 1, SOUTH))
				|| (dir == WEST && world.isSideSolid(x + 1, y, z, WEST))
				|| (dir == EAST && world.isSideSolid(x - 1, y, z, EAST));
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return (world.isSideSolid(x - 1, y, z, EAST)) || (world.isSideSolid(x + 1, y, z, WEST))
				|| (world.isSideSolid(x, y, z - 1, SOUTH)) || (world.isSideSolid(x, y, z + 1, NORTH));
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta) {
		case 0:
		case 8:
			this.setBlockBounds(0.375F, 0.3125F, 0.875F, 0.625F, 0.6875F, 1.0F);
			break;
		case 1:
		case 9:
			this.setBlockBounds(0.375F, 0.3125F, 0.0F, 0.625F, 0.6875F, 0.125F);
			break;
		case 2:
		case 10:
			this.setBlockBounds(0.875F, 0.3125F, 0.375F, 1.0F, 0.6875F, 0.625F);
			break;
		case 3:
		case 11:
			this.setBlockBounds(0.0F, 0.3125F, 0.375F, 0.125F, 0.6875F, 0.625F);
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
		return new TileEntityWallSwitch();
	}

	@Override
	public boolean canBind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ) {
		Block block = bindWorld.getBlock(bindX, bindY, bindZ);
		return block == BlockLoader.fluorescentLamp || block == BlockLoader.fluorescentLampLight;
	}

	@Override
	public void bind(World world, int x, int y, int z, World bindWorld, int bindX, int bindY, int bindZ) {
		((IBindableTE) world.getTileEntity(x, y, z)).bind(bindWorld, bindX, bindY, bindZ);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		this.unBind(world, x, y, z);
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public void unBind(World world, int x, int y, int z) {
		((IBindableTE) world.getTileEntity(x, y, z)).unBind();
	}
}