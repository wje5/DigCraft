package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.item.ItemLoader;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class GuiThrustMeter extends Gui {
	private Minecraft mc;
	private static final ResourceLocation texture = new ResourceLocation("digcraft:textures/gui/HUD.png");

	public GuiThrustMeter(Minecraft mc) {
		this.mc = mc;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event) {
		if ((event.isCanceled()) || (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)) {
			return;
		}
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if ((player.getCurrentArmor(0) != null)
				&& (player.getCurrentArmor(0).getItem() == ItemLoader.meteoricSteelBoots)
				&& (player.getCurrentArmor(1) != null)
				&& (player.getCurrentArmor(1).getItem() == ItemLoader.meteoricSteelLeggings)
				&& (player.getCurrentArmor(2) != null)
				&& (player.getCurrentArmor(2).getItem() == ItemLoader.meteoricSteelChestplate)
				&& (player.getCurrentArmor(3) != null)
				&& (player.getCurrentArmor(3).getItem() == ItemLoader.meteoricSteelHelmet)) {
			ItemStack stack = player.getCurrentArmor(3);
			if (stack.hasTagCompound()) {
				NBTTagCompound tag = stack.getTagCompound();
				if (tag.hasKey("thrust")) {
					this.doRender(tag.getDouble("thrust"), event, player.posY - 1.62);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private void doRender(double thrust, RenderGameOverlayEvent event, double altitude) {
		if (this.mc != null) {
			int left = event.resolution.getScaledWidth() / 2 - 195;
			int top = event.resolution.getScaledHeight() / 2 + 30;
			this.mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(left, top, 0, 0, 8, 81);
			this.drawTexturedModalRect(left - 3, (int) (top + 78 - thrust / 0.005D), 8, 0, 14, 5);
			this.drawTexturedModalRect(left + 20, top + 64, 22, 0, 49, 18);
			this.drawTexturedModalRect(left + 21, top + 65, 71, (int) (altitude % 10000 / 62.5D), 11, 16);
			this.drawTexturedModalRect(left + 33, top + 65, 71, (int) (altitude % 1000 / 6.25D), 11, 16);
			this.drawTexturedModalRect(left + 45, top + 65, 71, (int) (altitude % 100 * 1.6D), 11, 16);
			this.drawTexturedModalRect(left + 57, top + 65, 71, (int) (altitude % 10 * 16.0D), 11, 16);
			this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
		}
	}
}
