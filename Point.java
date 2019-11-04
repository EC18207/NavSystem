import java.awt.geom.Point2D;
import java.util.HashMap;

public class Point extends Point2D.Double {
	
	private boolean pointOfInterest;
	private String name;
	private HashMap<Point, Integer> attachedPoints;
	
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
	public HashMap<Point, Integer> getPoints() {
		return attachedPoints;
	}

	@Override
	public double getX() {
		return super.x;
	}

	@Override
	public double getY() {
		return super.y;
	}

	@Override
	public void setLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
}
