package lrn.cc.drill.gen;

import com.coderscampus.generator.domain.GenMeta;

public class NuTest4Lesson {

	public void generate(String lesson) {
		GenMeta templateGenMeta = new GenMeta("lesson.template", lesson.toLowerCase() + ".java.vm",
				"src/main/resources/template", null, null);
		templateGenMeta.put("lesson", lesson);
		templateGenMeta.put("uName", lesson.toUpperCase());
		templateGenMeta.put("lName", lesson.toLowerCase());
		templateGenMeta.put("lesson", lesson);
		new LessonTemplateGen(templateGenMeta).generate(null);
		GenMeta testGenMeta = new GenMeta("lesson.gen.java", "drill", "lesson", lesson.toUpperCase(), null, null,
				false);
		testGenMeta.put("lesson", lesson);
		testGenMeta.put("uName", lesson.toUpperCase());
		testGenMeta.put("lName", lesson.toLowerCase());
		new LessonTestGen(testGenMeta).generate(null);
	}

}
