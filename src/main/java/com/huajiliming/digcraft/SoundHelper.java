package com.huajiliming.digcraft;

import java.util.concurrent.LinkedBlockingQueue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;
import javax.sound.sampled.SourceDataLine;

public class SoundHelper extends Thread {
	public volatile boolean running = false;

	public SourceDataLine sourceDataLine;

	public LinkedBlockingQueue<Byte> queue = new LinkedBlockingQueue<Byte>();

	public void init() {
		try {
			AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			this.sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			this.sourceDataLine.open(audioFormat);
			this.sourceDataLine.start();
			FloatControl fc = (FloatControl) this.sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
			double value = 2;
			float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
			fc.setValue(dB);
			running = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		this.running = false;
		this.sourceDataLine.close();
	}

	@Override
	public void run() {
		this.init();
		while (running) {
			try {
				if (this.sourceDataLine.available() >= 4) {
					this.sourceDataLine.write(new byte[] { queue.take(), queue.take(), queue.take(), queue.take() }, 0,
							4);
				} else {
					for (int i = 0; i < 4; i++) {
						queue.take();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.run();
	}

	public void setVol(Float vol) {
		vol = vol < 0.0F ? 0.0F : vol > 1.0F ? 1.0F : vol;
		if (this.sourceDataLine != null && this.sourceDataLine.isControlSupported(Type.MASTER_GAIN)) {
			FloatControl c = (FloatControl) this.sourceDataLine.getControl(Type.MASTER_GAIN);
			c.setValue(85.0F * vol - 80.0F);
		}
	}
}
