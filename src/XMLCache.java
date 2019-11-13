import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLCache {
	
	public ArrayList<Point> getPathIfPossible(Point from, Point to) {
		
		ArrayList<XMLPath> paths = read(new File("./cache.xml"));
		
		if (paths == null) {
			return null;
		}
		
		for (int i = 0; i < paths.size(); i++) {
			
			XMLPath cP = paths.get(i);
			if (cP == null) return null;
			if (cP.getFrom().equals(from) && cP.getTo().equals(to)) { 
				return cP.getPath();
			}
			if (cP.getFrom().equals(to) && cP.getTo().equals(from)) {
				return cP.getPath();
			}
			
		}
		
		return null;
		
	}
	
	public void clearCache() {
		File cache = new File("./cache.xml");
		cache.delete();
	}
	
	public void addPath(Point from, Point to, ArrayList<Point> path) {
		
		write(from, to, path, new File("./cache.xml"));
		
	}
	
	public ArrayList<XMLPath> read(File fis) {
		
		try {
			XMLDecoder xdc = new XMLDecoder(new FileInputStream(fis));
			ArrayList<XMLPath> temp = (ArrayList<XMLPath>) xdc.readObject();
			return temp;
		} 
		
		catch(Exception e) {
			System.out.println("Cache File not found");
			return null;
		}
		
	}
	
	public void write(Point to, Point from, ArrayList<Point> path, File fos) {
		
		if (read(fos) != null) {
			
			ArrayList<XMLPath> paths = read(fos);
			XMLPath temp = new XMLPath();
			temp.setTo(to);
			temp.setFrom(from);
			temp.setPath(path);
			
			if (paths.contains(temp)) {
				return;
			}
			
			paths.add(temp);
			
			try {
				XMLEncoder xec = new XMLEncoder(new FileOutputStream(fos));
				xec.writeObject(paths);
				
				xec.close();
			} 
			
			catch(Exception e) {
				System.out.println("Cache File not found");
			}
			
		} 
		
		else {
			
			try {
				XMLEncoder xec = new XMLEncoder(new FileOutputStream(fos));
				ArrayList<XMLPath> paths = new ArrayList<XMLPath>();
				XMLPath temp = new XMLPath();
				temp.setTo(to);
				temp.setFrom(from);
				temp.setPath(path);
				paths.add(temp);
				xec.writeObject(paths);
				
				xec.close();
			} 
			
			catch(Exception e) {
				System.out.println("Cache File not found");
			}
			
		}
		
	}
	
}

