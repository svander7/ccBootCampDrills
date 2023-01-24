package lrn.cc.drill.gen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;

public class LessonTestGen extends GenBase {

	public LessonTestGen(GenMeta genMeta) {
		super(genMeta);
	}

	@Override
	public StringWriter generate(StringWriter stringWriter) {
        this.context.put("uName", this.genMetaList.get(defaultPosition).get("uName"));
        this.context.put("lName", this.genMetaList.get(defaultPosition).get("lName"));
        merge(null);
        write();
        return null;
	}

	@Override
	public void write() {
        System.out.println(genMetaList.get(defaultPosition).getWritePath());Path path = Paths.get(genMetaList.get(defaultPosition).getWritePath());
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(genMetaList.get(defaultPosition).getWritePath())) {
            fileWriter.write(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
