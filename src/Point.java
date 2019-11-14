import java.awt.geom.Point2D;
import java.util.HashMap;
/* Creates a point that is read in from a text file of places of interest*/ 
public class Point extends Point2D.Double {

	private boolean pointOfInterest;
	private String name;
	private HashMap<Point, DoubleVal> attachedPoints = new HashMap<Point, DoubleVal>();

	public Point() {
	}

	// Default point constructor for unimportant points
	public Point(int x, int y) {
		super(x, y);
		pointOfInterest = false;
	}

	// Point constructor to create pointOfInterest
	public Point(int x, int y, String name) {
		super.x = x;
		super.y = y;
		this.name = name;
		this.pointOfInterest = true;
	}

	// Return the points attached to current point
	public HashMap<Point, DoubleVal> getPoints() {
		return attachedPoints;
	}

	public void addPt(Point p, double dist) {
		attachedPoints.put(p, new DoubleVal(dist));

	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	@Override
	public double getX() {
		return super.x;
	}

	@Override
	public double getY() {
		return super.y;
	}

	public String attachedPointsToString() {
		String s = "[";
		for(Point p : attachedPoints.keySet()) {
			s = s + p.getName() + ", ";
		}
		s = s + "]";
		return s;
	}

	@Override
	public void setLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}

	
	//DoubleVal contains the cost between nodes. A double variable is stored. 
	public class DoubleVal {

		double val = 0;

		public DoubleVal(double value) {
			this.val = value;
		}

		public void setVal(double value) {
			this.val = value;
		}

		public double getVal() {
			return this.val;
		}

	}
}