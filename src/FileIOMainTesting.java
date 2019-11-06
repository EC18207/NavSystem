import java.io.File;

public class FileIOMainTesting {

	public static void main(String[] args) {
		
		File f = new File("MapBlock\\Coordinates.txt");
		
		FileReader r = new FileReader();
		
		r.fileReadIn(f);
	}
	
}
