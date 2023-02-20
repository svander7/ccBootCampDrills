package com.coderscampus.generator.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NamesFileReader {

	public List<String> readFile(String filePath) {
		BufferedReader reader = null;
		List<String> contents = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				if(!line.isBlank() && !line.isEmpty()&& line.contains("noun")) {
					contents.add(line.substring(0, line.indexOf("\t")).trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return contents;
	}
}
