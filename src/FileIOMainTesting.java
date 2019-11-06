import java.io.File;
import java.util.ArrayList;

public class FileIOMainTesting {

	public static void main(String[] args) {
		
		File f = new File("MapBlock\\Coordinates.txt");
		
		FileReader r = new FileReader();
		
		r.fileReadIn(f);
		
		ArrayList<Block> b = r.getBlocks();
		
		int i = 0;
		while(i < b.size()) {
			System.out.println(b.get(i).x1 + ", " + b.get(i).y2 + ", " + b.get(i).x2 + ", " + b.get(i).y2 + ", ");
			i++;
		}
	}
	
}
