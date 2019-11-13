import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DescReader {

	String loc = null;
	
	public DescReader(String loc) {
		this.loc = loc;
	}
	
	public String getDescription() {
		File textFile = new File("MapBlock\\Descriptions.txt");
		
		Scanner s = null;
		try {
			s = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file!");
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			
			String line = s.nextLine();
			String substring = "";
			int count = 0;
			int i = 0;
			while(i < line.length() && count < 2) {
				if(line.charAt(i) == ',') {
					if(count == 0) {
						if(!substring.equals(this.loc)) { break; }
						substring = substring + " -   ";
						count++;
						i++;
					} else {
						return substring;
					}
				} else {
					substring = substring + line.charAt(i);
					i++;
				}
			}
			
		}
		
		return "No Description Available.";
	}
	
}
