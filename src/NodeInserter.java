import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeInserter {
	
	HashMap<String, Point> nodes = new HashMap<String, Point>();
	
	String fileDirectory = "MapBlock\\Coordinates.txt";
	
	public HashMap<String, Point> fillMap() {
		FileReader r = new FileReader();
		
		File f = new File(fileDirectory);
		
		r.fileReadIn(f);
		
		insertNodes(r.getBlocks(), r.getPoints());
		
		return nodes;

	}

	public void insertNodes(ArrayList<Block> blocks, ArrayList<Point> points) {
				
		fillMap(blocks);
		
		connectMap();
		
		placeImportantPoints(points);
		
	}
	
	public void placeImportantPoints(ArrayList<Point> points) {
		int i = 0;
		while(i < points.size()) {
			Point temp = points.get(i);
			
			String s = "X" + temp.x + "Y" + temp.y;
			
			Point nodeInMap = nodes.get(s);
			if(nodeInMap != null) {
				nodes.remove(s);
				nodeInMap.setName(temp.getName());
				nodes.put(temp.getName(), nodeInMap);
			}
			
			points.set(i, nodeInMap);
			
			i++;
			
		}
	}
	
	public void connectMap() {
		int w = 620;
		int h = 531;
		int x = 0;
		int y = 0;
		
		while(x < w+1) {
			
			for(y = 0; y < h+1; y++) {
				
				String s = "X" + x + "Y" + y;
				Point node = nodes.get(s);
				if(node == null) { break; }
				
				String topS = "X" + (x) + "Y" + (y-1);
				String rightS = "X" + (x+1) + "Y" + (y);
				String leftS = "X" + (x-1) + "Y" + (y);
				String bottomS = "X" + (x) + "Y" + (y+1);
				
				Point top = nodes.get(topS);
				Point right = nodes.get(rightS);
				Point left = nodes.get(leftS);
				Point bottom = nodes.get(bottomS);
				
				if(top != null) {
					node.addPt(top, 1);
				}
				if(right != null) {
					node.addPt(right, 1);
				}
				if(left != null) {
					node.addPt(left, 1);
				}
				if(bottom != null) {
					node.addPt(bottom, 1);
				}
				
			}
			
			x++;
			
		}
	}
	
	public void fillMap(ArrayList<Block> blocks) {
		//width: 620
		//height: 531
		int w = 620;
		int h = 531;
		int x = 0;
		int y = 0;
		boolean flag = false;
		
		//Insert Nodes
		while(x < w+1) {
			
			for(y = 0; y < h+1; y++) {
				
				int i = 0;
				while(i < blocks.size()) {
					int[] temp = blocks.get(i).getBlock();
					
					if(x >= temp[0] && x <= temp[2] && y >= temp[1] && y <= temp[3]) {
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
