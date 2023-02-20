package com.coderscampus.generator.util;

import java.util.List;
import java.util.Random;

import com.coderscampus.generator.Cnst;

public class Names {
	private static List<String> names;
	private static String taken = "";

	public static String get(int i) {
		if (names == null) {
			initialize();
		}
		return names.get(i);
	}

	public static String randomName() {
		if (names == null) {
			initialize();
		}
		Random random = new Random();
		int i = random.nextInt(names.size());
		String trialName = names.get(i);
		// dedupe until jvm exits
		while(taken.contains(trialName)) {
			i = random.nextInt(names.size());
			trialName = names.get(i);
		}
		taken = taken + " " + trialName;
		return trialName;
	}

	public static final String upLow(String str) {
		if (str == null || str.length() == 0)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private static void initialize() {
		names = new NamesFileReader().readFile(Cnst.NAMES_PATH);
	}

}
