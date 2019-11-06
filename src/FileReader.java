import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	ArrayList<Block> blocks;
	ArrayList<Point> points;
	
	public FileReader() {
		this.blocks = new ArrayList<Block>();
		this.points = new ArrayList<Point>();
	}
	 
	public void fileReadIn(File textFile) {
			Scanner s = null;
		try {
			s = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file!");
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			
			String line = s.nextLine();
			
			if(line.charAt(0) == 'b') {
				makeBlock(line);
			}
			
			if(line.charAt(0) == 'p') {
				makePoint(line);
			}
			
		}
		
	}
	
	public void makeBlock(String line) {
		int x = 0;
		int y = 0;
		int x2 = 0;
		int y2 = 0;
		
		int count = 0;
		int i = 2;
		String n = "";
		
		while(count != 4 && i < line.length()) {
			
			if(line.charAt(i) == ',') {
				count++;
				
				if(count == 1) {
					x = Integer.parseInt(n);
					n = "";
					i++;
				} else if (count == 2) {
					y = Integer.parseInt(n);
					n = "";
					i++;
				} else if (count == 3) {
					x2 = Integer.parseInt(n);
					n = "";
					i++;
				} else if (count == 4) {
					y2 = Integer.parseInt(n);
					break;
				} else {
					System.out.println("Ya fucked it");
				}
				
			} else {
				n = n + line.charAt(i);
				i++;
			}
			
		}
		
		this.blocks.add(new Block(x,y,x2,y2));
	}
	
	public void makePoint(String line) {
		int x = 0;
		int y = 0;
		String name = "";
		
		int count = 0;
		int i = 2;
		String n = "";
		
		while(count != 3 && i < line.length()) {
			
			if(line.charAt(i) == ',') {
				count++;
				
				if(count == 1) {
					x = Integer.parseInt(n);
					n = "";
					i++;
				} else if (count == 2) {
					y = Integer.parseInt(n);
					n = "";
					i++;
				} else if (count == 3) {
					name = n;
					break;
				} else {
					System.out.println("Ya fucked it");
				}
				
			} else {
				n = n + line.charAt(i);
				i++;
			}
			
		}
		
		this.points.add(new Point(x,y,name));
		
	}
	
	public ArrayList<Block> getBlocks() {
		return this.blocks;
	}
	
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	
	
	
	
}
