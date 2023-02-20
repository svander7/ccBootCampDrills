package com.coderscampus.generator.domain;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.coderscampus.generator.Cnst;
import com.coderscampus.generator.util.InternalWriteFolder;
import com.coderscampus.generator.util.StringUtils_;

public class GenMeta {
	private String sourcePath;
	private String javaPackageSubject;
	private String javaPackageSuffix;
	private String name;
	private String writePath;
	private String pakage;
	private String externalPath;
	private String internalPath;
	private Map<String, Object> other = new HashMap<String, Object>();

	public Path getSubPath() {
		return subPath;
	}

	private Path subPath;
	private boolean isJava;

	public GenMeta(String sourcePath) {
		if (StringUtils.isBlank(sourcePath)) {
			throw new IllegalArgumentException(
					"sourcePath cannot be null. This is the name of your template file, without the .vm suffix`");
		}
		this.sourcePath = sourcePath;
	}

	public GenMeta(String sourcePath, String javaPackageSubject, String javaPackageSuffix, String name,
			String externalPath, InternalWriteFolder internalPath, boolean isTest) {
		super();
		if (StringUtils.isBlank(javaPackageSubject)) {
			throw new IllegalArgumentException(
					"javaPackageSubject cannot be null. Example would be `foo` in `com.coderscampus.foo.service`");
		}
		if (StringUtils.isBlank(javaPackageSuffix)) {
			throw new IllegalArgumentException(
					"javaPackageSuffix cannot be null. Example would be `service` in `com.coderscampus.foo.service`");
		}
		this.sourcePath = sourcePath;
		this.javaPackageSubject = javaPackageSubject;
		this.javaPackageSuffix = javaPackageSuffix;
		this.name = name;
		this.externalPath = null == externalPath ? "" : externalPath;
		this.internalPath = null == internalPath ? "" : "generated/" + StringUtils_.yyMMddHHmmss(new Date()) + "/";
		genJavaWritePath(isTest);
	}

	public GenMeta(String sourcePath, String fileName, String externalPath, InternalWriteFolder internalPath,
			Path subPath) {
		this.sourcePath = sourcePath;
		this.name = fileName;
		this.externalPath = null == externalPath ? "" : externalPath;
		this.internalPath = null == internalPath ? "" : "generated/" + StringUtils_.yyMMddHHmmss(new Date()) + "/";
		this.subPath = subPath==null?Paths.get(""):subPath;
		genWritePath();
	}

	public Object get(String string) {
		if (this.other.keySet().contains(string)) {
			return this.other.get(string);
		}
		return null;
	}

	public void put(String string, Object object) {
		this.other.put(string, object);
	}

	public String getWritePath() {
		return writePath;
	}

	public String getPakage() {
		return pakage;
	}

	public boolean isJava() {
		return isJava;
	}

	public String getExternalPath() {
		return externalPath;
	}

	public void setInternalPath(String internalPath) {
		this.internalPath = internalPath;
	}

	private void genWritePath() {
		String dirs = externalPath + internalPath + subPath;
		this.writePath = dirs + "/" + name;
	}

	private void genJavaWritePath(boolean isTest) {
		this.pakage = Cnst.PKG_BASE + "." + javaPackageSubject + "." + javaPackageSuffix;
		String dirs = externalPath + internalPath + StringUtils_.dotPathToSlashPath(Cnst.JAVA_FOLDER + pakage);
		if(!isTest) {
			dirs = dirs.replace("test", "main");
		}
		this.writePath = dirs + "/" + name + ".java";
	}

	public GenMeta(String sourcePath, String name) {
		super();
		this.sourcePath = sourcePath;
		this.name = name;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public String getJavaPackageSubject() {
		return javaPackageSubject;
	}

	public String getJavaPackageSuffix() {
		return javaPackageSuffix;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GenMeta [sourcePath=" + sourcePath + ", javaPackageSubject=" + javaPackageSubject
				+ ", javaPackageSuffix=" + javaPackageSuffix + ", name=" + name + ", writePath=" + writePath
				+ ", pakage=" + pakage + ", isJava=" + isJava + "]";
	}

}
