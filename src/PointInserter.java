import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PointInserter {
	
	HashMap<String, Point> nodes = new HashMap<String, Point>();
	ArrayList<Point> importantPoints;
	
	String fileDirectory = "MapBlock\\Coordinates.txt";
	
	public PointInserter() {
		completeMap();
	}
	
	public void completeMap() {
		FileReader r = new FileReader();
		
		File f = new File(fileDirectory);
		
		r.fileReadIn(f);
		
		importantPoints = r.getPoints();
		
		insertNodes(r.getBlocks(), importantPoints);

	}
 
	public void insertNodes(ArrayList<Block> blocks, ArrayList<Point> points) {
				
		fillMap(blocks);
		
		connectMap();
		
		placeImportantPoints(points);
		
	}
	
	public void placeImportantPoints(ArrayList<Point> points) {
		for(int i = 0; i < points.size(); i++) {
			Point temp = points.get(0);
			int xval = (int) temp.x;
			int yval = (int) temp.y;
			String s = "X" + xval + "Y" + yval;
			
			Point nodeInMap = nodes.get(s);
			if(nodeInMap != null) {
				nodes.remove(s);
				nodeInMap.setName(temp.getName());
				nodes.put(temp.getName(), nodeInMap);
				points.remove(temp);
				points.add(nodeInMap);
			}
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
	
	public ArrayList<Point> getImportantPoints() {
		return importantPoints;
	}
	
}
