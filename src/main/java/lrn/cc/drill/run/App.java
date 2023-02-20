package lrn.cc.drill.run;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import lrn.cc.drill.gen.NuTest4Lesson;
import lrn.cc.drill.service.Lessons;

public class App {
	public void launch() {
		Scanner scanner = new Scanner(System.in); // not closed because short lived app
		System.out.println("Do you wish me to open browser to help? \n 'y' for yes, else enter for no");
		Boolean help = scanner.nextLine().toLowerCase().startsWith("y");
		String list = new Lessons().print();
		System.out.println(list);
		System.out.println("Which lesson?");
		String lesson = scanner.nextLine();
		String[] args = lesson.split(" ");
		if (args.length == 1) {
			moveOldFiles();
			new Drill().generate(lesson);
			if (help) {
				new OpenHelp().find(lesson.toUpperCase());
			}
		} else if (args.length == 2 && args[0].equals("nu")) {
			new NuTest4Lesson().generate(args[1]);
		} else {
			System.out.println("Couldn't figure out what you wanted to do. \n\n???");
		}
	}

	private void moveOldFiles() {
		Path sourceDir = Paths.get("src/test/java/lrn/cc/drill/current");
		Path destinationDir = Paths.get("completedDrills");
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDir)) {
			for (Path path : directoryStream) {
				Path d2 = destinationDir.resolve(path.getFileName());
				Files.move(path, d2, StandardCopyOption.REPLACE_EXISTING);
				System.out.print("[Moved " + path.getFileName());
				System.out.println(" to " + destinationDir.toString() + "]\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
