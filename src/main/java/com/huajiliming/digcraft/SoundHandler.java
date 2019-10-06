package com.huajiliming.digcraft;

import java.util.HashMap;

public class SoundHandler {
	public static SoundHandler instance = new SoundHandler();
	private HashMap<Integer, SoundHelper> datalines = new HashMap<Integer, SoundHelper>();

	public SoundHelper startLine(int id) {
		SoundHelper helper = new SoundHelper();
		helper.start();
		this.datalines.put(id, helper);
		return helper;
	}

	public void stopLine(int id) {
		SoundHelper helper = this.getLine(id);
		helper.close();
		this.datalines.remove(id);
	}

	public SoundHelper getLine(int id) {
		return this.datalines.get(id);
	}
}
