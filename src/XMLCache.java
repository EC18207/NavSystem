import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class XMLCache {
	
	public static void main(String[] args) {
		
		
	}
	
	public void writeNewPath(Point from, Point to, ArrayList<Point> path) {
		
		MyPath newPath = new MyPath(from, to, path);
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("./cache.txt"));
			XMLEncoder xec = new XMLEncoder(fos);
			xec.writeObject(newPath);
			xec.close();
		} catch(Exception e) {
			System.out.println("Nope");
		}
		
	}
	
	public ArrayList<Point> findPath(Point from, Point to) {
		
		try {
			
			FileInputStream fis = new FileInputStream(new File("./cache.txt"));
			XMLDecoder xdc = new XMLDecoder(fis);
			
			while (xdc.readObject() != null) {
				MyPath p = (MyPath) xdc.readObject();
				if (p.getFrom().equals(from) && p.getTo().equals(to)) {
					return p.getPath();
				}
			}
			
			return new ArrayList<>();
			
		} catch(Exception e) {
			
			return new ArrayList<>();
		
		}
		
	}
	
}
