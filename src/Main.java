

import java.awt.geom.Point2D;

public class Main {
	
	public static void main(String[] args) {
		GUIrough todisp = new GUIrough();
		Point2D.Double in1 = new Point2D.Double(56.00, 37.00);
		Point2D.Double in2 = new Point2D.Double(156.00, 136.00);
		todisp.update(in1, in2);
	}

}
