package com.coderscampus.generator.service;

import java.io.StringWriter;

public interface Gen {
    public StringWriter generate(StringWriter stringWriter);
    public void write();
    public void merge(StringWriter stringWriter);
}
