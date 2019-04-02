package utils;

import java.io.File;

public class FilePathFinder {
	
	public FilePathFinder() {
	
	}
	 
	public String getFilePath(String fileName) {
		
		return new File(fileName).getAbsolutePath();
	}

}
