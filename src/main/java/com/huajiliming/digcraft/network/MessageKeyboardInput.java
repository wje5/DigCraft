package com.huajiliming.digcraft.network;

import com.huajiliming.digcraft.item.ItemLoader;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageKeyboardInput implements IMessage {
	private int keyId;

	public MessageKeyboardInput() {

	}

	public MessageKeyboardInput(int id) {
		this.keyId = id;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.keyId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.keyId);
	}

	public static class PocketHandler implements IMessageHandler<MessageKeyboardInput, IMessage> {
		@Override
		public IMessage onMessage(MessageKeyboardInput message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			if ((player.getCurrentArmor(0) != null)
					&& (player.getCurrentArmor(0).getItem() == ItemLoader.meteoricSteelBoots)
					&& (player.getCurrentArmor(1) != null)
					&& (player.getCurrentArmor(1).getItem() == ItemLoader.meteoricSteelLeggings)
					&& (player.getCurrentArmor(2) != null)
					&& (player.getCurrentArmor(2).getItem() == ItemLoader.meteoricSteelChestplate)
					&& (player.getCurrentArmor(3) != null)
					&& (player.getCurrentArmor(3).getItem() == ItemLoader.meteoricSteelHelmet)) {
				NBTTagCompound tag;
				ItemStack stack = player.getCurrentArmor(3);
				if (!stack.hasTagCompound()) {
					tag = new NBTTagCompound();
				} else {
					tag = stack.getTagCompound();
				}
				double thrust = 0.0D;
				if (tag.hasKey("thrust")) {
					thrust = tag.getDouble("thrust");
				}
				if (message.keyId == 0) {
					thrust = Math.min(thrust + 0.0125D, 0.4D);
				} else {
					thrust = Math.max(thrust - 0.0125D, 0.0D);
				}
				tag.setDouble("thrust", thrust);
				stack.setTagCompound(tag);
			}
			return null;
		}
	}
}
