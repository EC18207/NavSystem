import java.util.HashMap;

public class GPS {

	HashMap<String, Point> map;
	
	public GPS() {
		NodeInserter inserter = new NodeInserter();
		map = inserter.completeMap();
		
		GUIrough gui = new GUIrough();
	}
	
	public HashMap<String, Point> getMap() {
		return map;
	} 
	
}
