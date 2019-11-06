import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public void fileReadIn(File textFile) {
			Scanner s = null;
		try {
			s = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file!");
			e.printStackTrace();
		}
		
		int lineNumber = 1;
		while(s.hasNext()) {
			String line = s.nextLine();
			System.out.println("Line " + lineNumber + ": " + line);
			lineNumber++;
		}
		
	}
	
	
	
	
	
	
	
}
