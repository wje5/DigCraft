package com.huajiliming.digcraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHammer extends Item {
	public ItemHammer() {
		this.setContainerItem(this);
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		stack.attemptDamageItem(1, itemRand);
		return stack;
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
}
