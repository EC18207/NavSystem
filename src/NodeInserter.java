import java.util.ArrayList;
import java.util.HashMap;

public class NodeInserter {
	
	HashMap<String, Point> nodes = new HashMap<String, Point>();

	public void insertNodes(ArrayList<Block> blocks, ArrayList<Point> points) {
		//width: 620
		//height: 531
		int w = 620;
		int h = 531;
		int x = 0;
		int y = 0;
		boolean flag = false;
		
		while(x < w+1) {
			
			for(y = 0; y < h+1; y++) {
				
				int i = 0;
				while(i < blocks.size()) {
					Block temp = blocks.get(i);
					
					if(x >= temp.x1 && x <= temp.x2 && y >= temp.y1 && y <= temp.y2) {
						flag = true;
						break;
					}
					
					i++;
				}
				
				if(!flag) {
					String s = "X" + x + "Y" + y;
					nodes.put(s, new Point(x,y,s));
				} else {
					flag = false;
				}
				
			}
			
			x++;
			
		}
		
		
		
	}
	
	public HashMap<String, Point> getNodes() {
		return nodes;
	}
	
}
