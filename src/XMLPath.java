import java.io.Serializable;
import java.util.ArrayList;

public class XMLPath implements Serializable {
	
	private Point from;
	private Point to;
	private ArrayList<Point> path;
	
	public XMLPath() {
	}
	
//	public MyPath(Point from, Point to, ArrayList<Point> path) {
//		
//		this.from = from;
//		this.to = to;
//		this.path = path;
//		
//	}

	public Point getFrom() {
		return from;
	}

	public void setFrom(Point from) {
		this.from = from;
	}

	public Point getTo() {
		return to;
	}

	public void setTo(Point to) {
		this.to = to;
	}

	public ArrayList<Point> getPath() {
		return path;
	}

	public void setPath(ArrayList<Point> path) {
		this.path = path;
	}

}
