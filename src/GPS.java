import java.util.HashMap;

public class GPS {

	HashMap<String, Point> map;
	
	public GPS() {
		NodeInserter inserter = new NodeInserter();
		map = inserter.completeMap();
	}
	
}
