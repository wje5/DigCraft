package com.huajiliming.digcraft;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import com.huajiliming.digcraft.config.ConfigLoader;
import com.huajiliming.digcraft.network.MessageSoundDataToServer;
import com.huajiliming.digcraft.network.NetworkHandler;

import net.minecraft.client.Minecraft;

public class RecordHelper extends Thread {
	public static TargetDataLine targetDataLine;
	public static boolean running = false;

	public static void init() {
		try {
			AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);
			targetDataLine.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		running = true;
		new RecordHelper().start();
	}

	@Override
	public void run() {
		int nByte = 0;
		byte[] buffer = new byte[ConfigLoader.recBufferSize];
		while (running) {
			try {
				nByte = targetDataLine.read(buffer, 0, ConfigLoader.recBufferSize);
				Minecraft mc = Minecraft.getMinecraft();
				if (mc.theWorld != null && mc.thePlayer != null) {
					NetworkHandler.instance.sendToServer(
							new MessageSoundDataToServer(mc.thePlayer.getEntityId(), mc.theWorld.provider.dimensionId,
									mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, buffer));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}