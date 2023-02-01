package lrn.cc.drill.run;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.util.StringUtils_;

import lrn.cc.drill.lesson.*;
import lrn.cc.drill.service.Lessons;

public class Drill {
	public void generate(String lesson) {
		System.out.println("Generating " + lesson);
		String className = "Drill" + lesson.toUpperCase() + "at" + StringUtils_.yyMMddHHmmPrint();
		GenMeta genMeta = new GenMeta(lesson + ".java", "drill", "current", className, null, null, true);
		String message = "Please refresh your project in eclipse and fix "+ className;
		switch (lesson.toLowerCase().trim()) {
		case "u2l03":
			new U2L03(genMeta).generate(null);
			break;
		case "u2l04":
			new U2L04(genMeta).generate(null);
			break;
		case "u2l05":
			new U2L05(genMeta).generate(null);
			break;
		case "u2l06":
			new U2L06(genMeta).generate(null);
			break;
		case "u2l07":
			new U2L07(genMeta).generate(null);
			break;
		case "u2l09":
			new U2L09(genMeta).generate(null);
			break;
		case "u2l10":
			new U2L10(genMeta).generate(null);
			break;
		case "u2l11":
			new U2L11(genMeta).generate(null);
			break;
		case "u2l12":
			new U2L12(genMeta).generate(null);
			break;
		case "u3l01":
			new U3L01(genMeta).generate(null);
			break;
		case "u3l03":
			new U3L03(genMeta).generate(null);
			break;
		case "u3l04":
			new U3L04(genMeta).generate(null);
			break;
		case "u3l05":
			new U3L05(genMeta).generate(null);
			break;
		case "u3l06":
			new U3L06(genMeta).generate(null);
			break;
		case "u3l07":
			new U3L07(genMeta).generate(null);
			break;
		case "u3l08":
			new U3L08(genMeta).generate(null);
			break;
		case "u3l09":
			new U3L09(genMeta).generate(null);
			break;
		case "u3l10":
			new U3L10(genMeta).generate(null);
			break;
		default:
			message = "Couldn't figure out what you wanted to do?\n " + lesson + " is not a lesson";
		}
        System.out.println(message);
	}

}
