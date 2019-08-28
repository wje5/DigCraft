package com.huajiliming.digcraft.potioneffect;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionArmorReduction extends Potion {
	public PotionArmorReduction(int id) {
		super(id, true, 8323072);
		this.setPotionName("potion.armorreduction");
		this.setIconIndex(0, 0);
	}

	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.getTextureManager().bindTexture(new ResourceLocation("happypvp:textures/gui/potion.png"));
		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 18, 18);
	}
}
