package com.huajiliming.digcraft.network;

import com.huajiliming.digcraft.item.ItemStandardBook;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageBookPage implements IMessage {
	private int page;

	public MessageBookPage() {

	}

	public MessageBookPage(int page) {
		this.page = page;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.page = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.page);
	}

	public static class PocketHandler implements IMessageHandler<MessageBookPage, IMessage> {
		@Override
		public IMessage onMessage(MessageBookPage message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			ItemStack stack = player.getHeldItem();
			if (stack != null && stack.getItem() instanceof ItemStandardBook) {
				NBTTagCompound tag = stack.getTagCompound();
				if (tag == null) {
					tag = new NBTTagCompound();
				}
				tag.setInteger("page", message.page);
				stack.setTagCompound(tag);
			}
			return null;
		}
	}
}
