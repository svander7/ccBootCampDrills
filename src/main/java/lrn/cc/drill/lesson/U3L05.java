package lrn.cc.drill.lesson;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;
import com.coderscampus.generator.util.Names;
import com.coderscampus.generator.util.StringUtils_;

public class U3L05 extends GenBase {

	Random random = new Random();
	
	public U3L05(GenMeta genMeta) {
		super(genMeta);
	}

    @Override
    public StringWriter generate(StringWriter stringWriter) {
    	List<String> keys = new ArrayList<String>();
    	keys.add("one");
    	keys.add("two");
    	keys.add("three");
    	keys.add("four");
    	keys.add("five");
    	List<String> names = new ArrayList<String>();
    	while (names.size()<6) {
    		names.add( Names.randomName().toLowerCase());
    	}
    	List<String> values = new ArrayList<String>();
    	while (values.size()<6) {
    		values.add( Names.randomName().toLowerCase());
    	}
    	List<Integer> all = new ArrayList<Integer>();
    	for(int i=0;i<5;i++) {
    		all.add(i);
    	}
    	Set<Integer> someSet = new HashSet<Integer>();
    	while(someSet.size()<3) {
    		int i = random.nextInt(5);
    		someSet.add(all.get(i));
    	}
    	List<Integer> some =  new ArrayList<Integer>(someSet);
    	List<Integer> others = new ArrayList<Integer>();
    	for(Integer item:all) {
    		if(!someSet.contains(item)) {
    			others.add(item);
    		}
    	}
    	Integer only = random.nextInt(5);
    	String lowerOne = Names.randomName().toLowerCase();
    	String upperOne = StringUtils_.upLow(lowerOne);
        this.context.put("aClass", lowerOne);
        this.context.put("upperClass", upperOne);
        for(int i=0;i<5;i++) {
            this.context.put(keys.get(i), names.get(i));        	
            this.context.put(keys.get(i)+"Value", values.get(i));
        }
        this.context.put("someFirst", values.get(some.get(0)));
        this.context.put("someSecond", values.get(some.get(1)));
        this.context.put("someThird", values.get(some.get(2)));
        this.context.put("otherFirst", values.get(others.get(0)));
        this.context.put("otherSecond", values.get(others.get(1)));
        this.context.put("only", values.get(only));
        this.context.put("someMoreOne", Names.randomName().toLowerCase());
        this.context.put("someMoreTwo", Names.randomName().toLowerCase());
        this.context.put("someMoreThree", Names.randomName().toLowerCase());
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
