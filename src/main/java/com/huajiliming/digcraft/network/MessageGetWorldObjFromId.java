package com.huajiliming.digcraft.network;

import com.huajiliming.digcraft.tileentity.IBindableTE;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

public class MessageGetWorldObjFromId implements IMessage {
	private int x;
	private int y;
	private int z;
	private int id;

	public MessageGetWorldObjFromId() {

	}

	public MessageGetWorldObjFromId(int id, int x, int y, int z) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.id);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
	}

	public static class PocketHandler implements IMessageHandler<MessageGetWorldObjFromId, IMessage> {
		@Override
		public IMessage onMessage(MessageGetWorldObjFromId message, MessageContext ctx) {
			String name = MinecraftServer.getServer().worldServerForDimension(message.id).provider.getDimensionName();
			return new ReplyMessage(name, message.x, message.y, message.z);
		}
	}

	public static class ReplyMessage implements IMessage {
		private int x;
		private int y;
		private int z;
		private String name;

		public ReplyMessage() {

		}

		public ReplyMessage(String name, int x, int y, int z) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void fromBytes(ByteBuf buf) {
			this.x = buf.readInt();
			this.y = buf.readInt();
			this.z = buf.readInt();
			byte[] bytes = new byte[buf.readInt()];
			buf.readBytes(bytes);
			this.name = new String(bytes);
		}

		@Override
		public void toBytes(ByteBuf buf) {
			buf.writeInt(this.x);
			buf.writeInt(this.y);
			buf.writeInt(this.z);
			byte[] bytes = this.name.getBytes();
			buf.writeInt(bytes.length);
			buf.writeBytes(bytes);
		}

		public static class PocketHandler implements IMessageHandler<ReplyMessage, IMessage> {
			@Override
			public IMessage onMessage(ReplyMessage message, MessageContext ctx) {
				((IBindableTE) Minecraft.getMinecraft().theWorld.getTileEntity(message.x, message.y, message.z))
						.setBindWorldName(message.name);
				return null;
			}
		}
	}
}
