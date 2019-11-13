import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

//import java.beans.XMLEncoder;
//import java.beans.XMLDecoder;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//
//public class XMLCache {
//	
//	public static void main(String[] args) {
//		testXML();
//	}
//	
//	private static void testXML() {
//
//		try {
//			XMLEncoder xec = new XMLEncoder(new FileOutputStream(new File("./cache.xml")));
//			HashMap<String, Integer> hash = new HashMap<String, Integer>();
//			hash.put("Hello", 12);
//			xec.writeObject(hash);
//			
//			XMLDecoder xdc = new XMLDecoder(new FileInputStream(new File("./cache.xml")));
//			
//		} catch (Exception e) {
//			System.out.println("Something wrong");
//		}
//		
//	}
//
//	public void writeNewPath(Point from, Point to, ArrayList<Point> path) {
//		
////		try {
////			MyPath newPath = new MyPath(from, to, path);
////			String pathString = newPath.toString();
////			FileOutputStream fos = new FileOutputStream(new File("./cache.xml"));
////			XMLEncoder xec = new XMLEncoder(fos);
////			xec.writeObject(pathString);
////			xec.close();
////			fos.close();
////		} catch(Exception e) {
////			System.out.println("Nope");
////		}
//		
//		try {
//			XMLEncoder xec = new XMLEncoder(new FileOutputStream(new File("./cache.xml")));
//			xec.writeObject(new MyPath(from, to, path));
//			xec.writeObject()
//		} catch (Exception e) {
//			System.out.println("Something wrong");
//		}
//		
//	}
//	
//	public ArrayList<Point> findPath(Point from, Point to) {
//		
//		try {
//			
//			FileInputStream fis = new FileInputStream(new File("./cache.xml"));
//			XMLDecoder xdc = new XMLDecoder(fis);
//			
//			while (xdc.readObject() != null) {
//				
//				MyPath p = (MyPath) xdc.readObject();
//				if (p.getFrom().equals(from) && p.getTo().equals(to)) {
//					return p.getPath();
//				}
//				if (p.getFrom().equals(to) && p.getTo().equals(from)) {
//					return p.getPath();
//				
//				}
//			}
//			fis.close();
//			xdc.close();
//			
//			return null;
//			
//		} catch(Exception e) {
//			
//			return null;
//		
//		}
//		
//	}
//	
//}


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
	
//	public void clearCache() {
//		File cache = new File("./cache.xml");
//		cache.delete();
//	}
	
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
				System.out.println(paths);
				
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

