package com.huajiliming.digcraft.network;

import com.huajiliming.digcraft.config.ConfigLoader;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class MessageSoundDataToServer implements IMessage {
	private int lineId;
	private int dim;
	private double x;
	private double y;
	private double z;
	private byte[] data;

	public MessageSoundDataToServer() {

	}

	public MessageSoundDataToServer(int lineId, int dim, double x, double y, double z, byte[] data) {
		this.lineId = lineId;
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.lineId = buf.readInt();
		this.dim = buf.readInt();
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.z = buf.readDouble();
		this.data = new byte[ConfigLoader.recBufferSize];
		buf.readBytes(this.data);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.lineId);
		buf.writeInt(this.dim);
		buf.writeDouble(this.x);
		buf.writeDouble(this.y);
		buf.writeDouble(this.z);
		buf.writeBytes(this.data);
	}

	public static class PocketHandler implements IMessageHandler<MessageSoundDataToServer, IMessage> {
		@Override
		public IMessage onMessage(MessageSoundDataToServer message, MessageContext ctx) {
			NetworkHandler.instance.sendToAll(new MessageSoundDataToClient(message.lineId, message.dim, message.x,
					message.y, message.z, message.data));
			return null;
		}
	}
}
