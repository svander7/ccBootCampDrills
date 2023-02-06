package lrn.cc.drill.lesson;

import java.io.StringWriter;
import java.util.Random;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;
import com.coderscampus.generator.util.Names;
import com.coderscampus.generator.util.StringUtils_;

public class U3L10 extends GenBase {
	Random random = new Random();
	
	public U3L10(GenMeta genMeta) {
		super(genMeta);
	}

    @Override
    public StringWriter generate(StringWriter stringWriter) {
    	String lowerOne = Names.randomName().toLowerCase();
    	String upperOne = StringUtils_.upLow(lowerOne);
        this.context.put("aClass", lowerOne);
        this.context.put("upperClass", upperOne);
        this.context.put("one", Names.randomName().toLowerCase());
        this.context.put("two", Names.randomName().toLowerCase());
        this.context.put("three", Names.randomName().toLowerCase());
        this.context.put("four", Names.randomName().toLowerCase());
        this.context.put("five", Names.randomName().toLowerCase());
        this.context.put("oneValue", Names.randomName().toLowerCase());
        this.context.put("threeValue", random.nextInt(1000));
        this.context.put("twoValue", Names.randomName().toLowerCase());
        this.context.put("fourValue", random.nextBoolean());
        this.context.put("fiveValue", Names.randomName().toLowerCase());
        this.context.put("six", StringUtils_.upLow(""+context.get("two")));
        this.context.put("seven", StringUtils_.upLow(""+context.get("three")));
        this.context.put("eight", StringUtils_.upLow(""+context.get("one")));
        this.context.put("nine", StringUtils_.upLow(""+context.get("four")));
        this.context.put("ten", StringUtils_.upLow(""+context.get("five")));
        this.context.put("ClassName", this.genMetaList.get(defaultPosition).getName());
        this.context.put("package", this.genMetaList.get(defaultPosition).getPakage());
        merge( null);
        write();
        return writer;
    }

    public void write(){
        this.writeJava(writer.toString());
    }
}
