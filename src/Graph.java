import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Graph {
	
	HashSet<Point> points;
	int size;
	
	public Graph() {
		setupGraph();
		this.size = 0;
		setupGraph();
	}
	
	private void setupGraph() {
		
		Scanner x;
		
		try {
			x = new Scanner(new File("NavigationSystempoints.txt"));
//			while (x.hasNextLine()) {
//				x.next();
//			}
			System.out.println(x.nextLine());
			x.close();
		} catch(Exception e) {
			System.out.println("File not found Error");
		}
		
		
	}

	public ArrayList<Point> dijkstraSearch(Point start, int distance) {
		
		return null;
		
	}
	
	public void dijkstraSearch(Point from, Point to) {
		
	}
	
	public void aStarSearch(Point from, Point to) {
		
	}
	
	//public ArrayList<Point> tripPlanner(Point start, int distance) {
		
		
		
	//}
	
//	public boolean addPoint(Point p) {
//		
//		points.add(p);
//		System.out.println(points);
//		return true;
//		
//	}
//	
//	public boolean addPoint(int x, int y) {
//		
//		points.add(new Point(x, y));
//		
//		System.out.println(points);
//		return true;
//		
//	}
//	
//	public boolean addImportantPoint(int x, int y, String name) {
//		
//		points.add(new Point(x, y, name));
//		
//		System.out.println(points);
//		return true;
//		
//	}

}
