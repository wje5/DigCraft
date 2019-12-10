package com.huajiliming.digcraft.network;

import com.huajiliming.digcraft.SoundHandler;
import com.huajiliming.digcraft.SoundHelper;
import com.huajiliming.digcraft.config.ConfigLoader;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class MessageSoundDataToClient implements IMessage {
	private int lineId;
	private int dim;
	private double x;
	private double y;
	private double z;
	private byte[] data;

	public MessageSoundDataToClient() {

	}

	public MessageSoundDataToClient(int lineId, int dim, double x, double y, double z, byte[] data) {
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

	public static class PocketHandler implements IMessageHandler<MessageSoundDataToClient, IMessage> {
		@Override
		public IMessage onMessage(MessageSoundDataToClient message, MessageContext ctx) {
			SoundHelper helper = SoundHandler.instance.getLine(message.lineId);
			if (helper == null) {
				helper = SoundHandler.instance.startLine(message.lineId);
			}
			helper.setVol((float) (0.01F
					* (100.0D - Minecraft.getMinecraft().thePlayer.getDistance(message.x, message.y, message.z))));
			for (byte data : message.data) {
				try {
					helper.queue.put(data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}
}
