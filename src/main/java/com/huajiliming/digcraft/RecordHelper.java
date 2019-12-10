package com.huajiliming.digcraft;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line.Info;
import javax.sound.sampled.TargetDataLine;

import com.huajiliming.digcraft.block.BlockLoader;
import com.huajiliming.digcraft.config.ConfigLoader;
import com.huajiliming.digcraft.item.ItemLoader;
import com.huajiliming.digcraft.item.ItemMicroPhone;
import com.huajiliming.digcraft.network.MessageSoundDataToServer;
import com.huajiliming.digcraft.network.NetworkHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class RecordHelper extends Thread {
	public static TargetDataLine targetDataLine;
	public static boolean running = false;

	public static void init() {
		try {
			AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			Info[] infos = AudioSystem.getTargetLineInfo(info);
			System.out.println("##########START############");
			for (Info i : infos) {
				System.out.println(i.toString());
			}
//			targetDataLine = (TargetDataLine) AudioSystem.getLine(infos[1]);
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
					ItemStack stack = mc.thePlayer.getHeldItem();
					if (stack != null) {
						Item item = stack.getItem();
						if (item == ItemLoader.microPhone && ((ItemMicroPhone) item).isOn(stack)) {
							NBTTagCompound tag = stack.getTagCompound();
							if (tag.getBoolean("isBinded")) {
								int x = tag.getInteger("bindX");
								int y = tag.getInteger("bindY");
								int z = tag.getInteger("bindZ");
								if (mc.theWorld.getBlock(x, y, z) == BlockLoader.speaker) {
									NetworkHandler.instance
											.sendToServer(new MessageSoundDataToServer(mc.thePlayer.getEntityId(),
													mc.theWorld.provider.dimensionId, x, y, z, buffer));
								}
							}

						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}