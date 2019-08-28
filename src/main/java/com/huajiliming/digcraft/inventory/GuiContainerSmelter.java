package com.huajiliming.digcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiContainerSmelter extends GuiContainer {
	private static final String TEXTURE_PATH = "digcraft:textures/gui/container/smelter.png";
	private static final ResourceLocation TEXTURE = new ResourceLocation("digcraft:textures/gui/container/smelter.png");
	protected ContainerSmelter container;

	public GuiContainerSmelter(ContainerSmelter container) {
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
		if (this.container.hasEnergy()) {
			this.drawTexturedModalRect(offsetX + 58, offsetY + 36, 176, 0, 14, 14);
		}
		if (this.container.smeltTime > -1) {
			int textureWidth = (int) Math.ceil(23.0D * (300 - this.container.smeltTime) / 300.0D);
			this.drawTexturedModalRect(offsetX + 79, offsetY + 35, 176, 14, textureWidth, 14);
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("container.smelter", new Object[0]);
		this.fontRendererObj.drawString(title, (this.xSize - this.fontRendererObj.getStringWidth(title)) / 2, 6,
				4210752);
	}
}