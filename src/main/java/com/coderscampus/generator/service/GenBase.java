package com.coderscampus.generator.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.coderscampus.generator.Cnst;
import com.coderscampus.generator.domain.GenMeta;
import com.thedeanda.lorem.LoremIpsum;

public abstract class GenBase implements Gen {

    protected LoremIpsum loremIpsum = new LoremIpsum();
    protected StringWriter writer = new StringWriter();
    protected VelocityContext context;
    protected Template template;
    protected List<GenMeta> genMetaList;
    protected int defaultPosition;

    public GenBase(GenMeta genMeta) {
    	super();
    	List<GenMeta> genMetaList = new ArrayList<GenMeta>();
    	genMetaList.add(genMeta);
        Velocity.init();
        this.context = new VelocityContext();
        this.defaultPosition = 0;
        this.template = getTemplate(genMetaList);
        this.genMetaList = genMetaList;
    }
    
    public GenBase(List<GenMeta> genMetaList, int defaultPosition) {
        super();
        Velocity.init();
        this.context = new VelocityContext();
        this.defaultPosition = defaultPosition;
        this.template = getTemplate(genMetaList);
        this.genMetaList = genMetaList;
    }

    public void merge(StringWriter stringWriter) {
        this.writer = null==stringWriter?this.writer:stringWriter;
        template.merge(context, writer);
    }

    protected Template getTemplate(List<GenMeta> genMetaList) {
        Template template = null;
        try {
            template = Velocity.getTemplate(Cnst.TEMPLATE_FOLDER + genMetaList.get(defaultPosition).getSourcePath() + ".vm");
        } catch (ResourceNotFoundException rnfe) {
            // couldn't find the template
        } catch (ParseErrorException pee) {
            // syntax error: problem parsing the template
        } catch (MethodInvocationException mie) {
            // something invoked in the template
            // threw an exception
        } catch (Exception e) {
            System.err.print(e);
            System.exit(0);
        }
        return template;

    }


    public void writeJava(String content) {
        Path path = Paths.get(genMetaList.get(defaultPosition).getWritePath());
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(genMetaList.get(defaultPosition).getWritePath())) {
            fileWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
