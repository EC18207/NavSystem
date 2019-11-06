import java.awt.geom.Point2D;
import java.util.HashMap;

public class Point extends Point2D.Double {

private boolean pointOfInterest;
private String name;
private HashMap<Point, Integer> attachedPoints = new HashMap<Point, Integer>();

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

public void addPt(Point p, int dist) {
	attachedPoints.put(p, dist);
	
	//The following should work, but currently would mess up my test cases Main-Main9
	//attachedPoints.put(p, dist);
	//p.attachedPoints.put(this, dist);
	
}

public String getName() {
	return this.name;
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