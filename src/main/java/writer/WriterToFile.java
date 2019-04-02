package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterToFile {
	 
	Writer output;
	
	public void CreateFileTemplate(String fileName) {
		try {
			 
			String header = "Title" + "\t-\t" + "Status" + "\t-\t"+ "Url"; 
			File file = new File(fileName); 
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(header);
			bw.write("\n");
			bw.close();  
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void AppendNewLine(String fileName, String line)
	{
		try {  
			output = new BufferedWriter(new FileWriter(fileName,true));  //clears file every time
			output.append(line);
			output.append("\n");
			output.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
