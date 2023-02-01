package lrn.cc.drill.run;

import java.util.Scanner;

import lrn.cc.drill.gen.NuTest4Lesson;
import lrn.cc.drill.service.Lessons;

public class App {
	public void launch() {
		printBranchReminder("whateverTheRightBranchIs");
		String foo = new Lessons().print();
		System.out.println(foo);
		System.out.println("what lesson?");
		Scanner scanner = new Scanner(System.in);
		String lesson = scanner.nextLine();
		String[] args = lesson.split(" ");
		if(args.length==1) {
			new Drill().generate(lesson);
		} else if (args.length==2 && args[0].equals("nu")){
			new NuTest4Lesson().generate(args[1]);
		} else {
			System.out.println("Couldn't figure out what you wanted to do. \n\n???");
		}
	}	
	
	private void printBranchReminder(String branch) {
		String message = "IF YOU ARE NOT ON THE " + branch + " BRANCH please terminate this and checkout that branch first!";
//		System.err.println(message);
	}

}
