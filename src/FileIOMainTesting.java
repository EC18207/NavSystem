import java.io.File;
import java.util.ArrayList;

public class FileIOMainTesting {

	public static void main(String[] args) {
		
		File f = new File("MapBlock\\Coordinates.txt");
		
		FileReader r = new FileReader();
		
		r.fileReadIn(f);
		
		ArrayList<Block> b = r.getBlocks();
		ArrayList<Point> p = r.getPoints();
		
		int i = 0;
		while(i < b.size()) {
			System.out.println("Block: "  + b.get(i).x1 + ", " + b.get(i).y1 + ", " + b.get(i).x2 + ", " + b.get(i).y2);
			i++;
		}
		i = 0;
		while(i < p.size()) {
			System.out.println("Point- " + p.get(i).getName() + ": " + p.get(i).x + ", " + p.get(i).y);
			i++;
		}
	}
	
}
