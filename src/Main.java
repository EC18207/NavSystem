

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		GUIrough todisp = new GUIrough();

		Point in1 = new Point(0, 0);
		Point in2 = new Point(todisp.mainmap.getWidth(), 136);
		Point in3 = new Point(0,todisp.mainmap.getHeight());
		Point in4 = new Point(45, 139);
		Point in5 = new Point(23, 78);
		ArrayList<Point> test = new ArrayList<Point>();
		test.add(in1);
		test.add(in2);
		test.add(in3);
		test.add(in4);
		test.add(in5);
		todisp.update(test); 
	}

}
