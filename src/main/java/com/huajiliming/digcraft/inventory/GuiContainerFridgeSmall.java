package com.huajiliming.digcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiContainerFridgeSmall extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation("digcraft:textures/gui/container/ambry.png");
	protected ContainerFridgeSmall container;

	public GuiContainerFridgeSmall(ContainerFridgeSmall container) {
		super(container);
		this.xSize = 176;
		this.ySize = 166;
		this.container = container;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int offsetX = (this.width - this.xSize) / 2;
		int offsetY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("container.fridge", new Object[0]);
		this.fontRendererObj.drawString(title, (this.xSize - this.fontRendererObj.getStringWidth(title)) / 2, 6,
				4210752);
	}
}