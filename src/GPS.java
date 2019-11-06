import java.util.ArrayList;
import java.util.HashMap;

public class GPS {

	HashMap<String, Point> map;
	ArrayList<Point> points;
	
	public GPS() {
		NodeInserter inserter = new NodeInserter();
		map = inserter.completeMap();
		points = inserter.getImportantPoints();
		
		GUIrough gui = new GUIrough();
	}
	
	public HashMap<String, Point> getMap() {
		return map;
	} 
	
}
