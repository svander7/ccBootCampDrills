package com.coderscampus.generator.util;

import java.io.File;

public class FileDelete {
	public static void delete(String path){
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
	}

}
