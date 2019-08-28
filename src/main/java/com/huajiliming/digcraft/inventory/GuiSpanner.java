package com.huajiliming.digcraft.inventory;

import com.huajiliming.digcraft.block.IBindable;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.tileentity.IBindableTE;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class GuiSpanner extends Gui {
	private Minecraft mc;
	private static final ResourceLocation texture = new ResourceLocation("digcraft:textures/gui/HUD.png");

	public GuiSpanner(Minecraft mc) {
		this.mc = mc;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event) {
		if ((event.isCanceled()) || (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)) {
			return;
		}
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player.getHeldItem() != null && player.getHeldItem().getItem() == ItemLoader.spanner) {
			Block block = player.worldObj.getBlock(mc.objectMouseOver.blockX, mc.objectMouseOver.blockY,
					mc.objectMouseOver.blockZ);
			if (block instanceof IBindable) {
				this.doRender(event, (IBindableTE) player.worldObj.getTileEntity(mc.objectMouseOver.blockX,
						mc.objectMouseOver.blockY, mc.objectMouseOver.blockZ));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private void doRender(RenderGameOverlayEvent event, IBindableTE te) {
		if (this.mc != null) {
			ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
			int left = res.getScaledWidth() / 2;
			int top = res.getScaledHeight() / 2 - 24;
			this.mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(left, top, 82, 0, 84, 24);
			if (te.isBind()) {
				String text = StatCollector.translateToLocal("hud.bindedPos") + te.getBind()[0] + "-" + te.getBind()[1]
						+ "-" + te.getBind()[2];
				this.mc.fontRenderer.drawString(text, left + 90, top - 15, 0x808080);
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				text = te.getBindWorldName();
				this.mc.fontRenderer.drawString(text, left + 90, top - 5, 0x808080);
			} else {
				String text = StatCollector.translateToLocal("hud.unbinded");
				Minecraft.getMinecraft().fontRenderer.drawString(text, left + 90, top - 15, 0x808080);
			}
			this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
		}
	}
}
