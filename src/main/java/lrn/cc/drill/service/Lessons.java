package lrn.cc.drill.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.coderscampus.generator.Cnst;

import lrn.cc.drill.domain.Lesson;

public class Lessons {
	private List<Lesson> lessons = null;

	public List<Lesson> get() {
		initialize();
		return lessons;
	}

	public String print() {
			initialize();
			return lessons.stream().map(Lesson::getKey).collect(Collectors.joining(" "));
	}

	private void initialize() {
		if (lessons != null) {
			return;
		}
		lessons = new ArrayList<Lesson>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(Cnst.LESSONS_PATH));
			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				lessons.add(new Lesson(line));
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
	}
}
