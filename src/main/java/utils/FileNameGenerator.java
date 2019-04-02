package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameGenerator {	
	
	public String getFileName()
	{
		return createFileName();
	}
	
	//generates new file with given timestamp
	private String createFileName() {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		return timeStamp+"_results.txt";
	}

}
