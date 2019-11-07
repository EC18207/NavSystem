
public class Node {

	Point point = null;
	double g = 0;
	double h = -1;
	double f = -1;
	Point prevNode = null;
	
	public Node(Point physicalNode) {
		this.point = physicalNode;
	} 

	public void setG(double calcedG) {
		this.g = calcedG;
	}
	public void calcH(Point p) {
		double x = p.getX() - this.point.getX();
		double y = p.getY() - this.point.getY();
		this.h = Math.sqrt((x*x)+(y*y));
	}
	public void calcF() {
		this.f = 10*(this.g + this.h);
	}
	public void setPrevNode(Point name) {
		this.prevNode = name;
	}
	
}
