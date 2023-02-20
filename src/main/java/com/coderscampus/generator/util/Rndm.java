package com.coderscampus.generator.util;

import java.util.Random;

public class Rndm {

	public static boolean threeTenthsChance() {
		Random random = new Random();
		int result = random.nextInt(10);
		if (result < 3) {
			return true;
		}
		return false;
	}
	
	public static String nameMainClass() {
		if (!threeTenthsChance()) {
			return "App";
		} else if (!Rndm.threeTenthsChance()) {
			return "Launcher";
		} else {
			return "Main";
		}

	}

	public static String seedExecMethodName() {
		Random random = new Random();
		int result = random.nextInt(6);
		String seed = "goForth";
		switch (result) {
		case 0:
			seed = "execute";
			break;
		case 1:
			seed = "exec";
			break;
		case 2:
			seed = "go";
			break;
		case 3:
			seed = "do";
			break;
		case 4:
			seed = "start";
			break;
		case 5:
			seed = "begin";
			break;
		case 6:
			seed = "commence";
			break;
		}
		return seed;
	}

}
