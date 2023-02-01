package lrn.cc.drill.lesson;

import java.io.StringWriter;
import java.util.List;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;
import com.coderscampus.generator.util.Names;
import com.coderscampus.generator.util.StringUtils_;

public class U3L01 extends GenBase {
	
	public U3L01(GenMeta genMeta) {
		super(genMeta);
	}

    @Override
    public StringWriter generate(StringWriter stringWriter) {
    	String lowerOne = Names.randomName().toLowerCase();
    	String upperOne = StringUtils_.upLow(lowerOne);
    	String lowerSeven = Names.randomName().toLowerCase();
    	String upperSeven = StringUtils_.upLow(lowerSeven);
    	String lowerEight = Names.randomName().toLowerCase();
    	String upperEight = StringUtils_.upLow(lowerEight);
    	double five = 50000*Math.random();
        this.context.put("one", lowerOne);
        this.context.put("upperOne", upperOne);
        this.context.put("two", Names.randomName().toLowerCase());
        this.context.put("three", Names.randomName().toLowerCase());
        this.context.put("four", (int)five);
        this.context.put("five", five);
        this.context.put("six", Names.randomName().toLowerCase());
        this.context.put("seven", lowerSeven);
        this.context.put("upperSeven", upperSeven);
        this.context.put("eight",lowerEight);
        this.context.put("upperEight",upperEight);
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
