import java.util.ArrayList;
import java.util.HashMap;

public class AStar {
	
	public AStar() {
		
	}
	
	public ArrayList<Point> findShortestPath(Point from, Point to) {
		System.out.println("From: " + from.getName());
		System.out.println("To: " + to.getName());
		System.out.println();
		ArrayList<String> open = new ArrayList<String>();
		ArrayList<String> closed = new ArrayList<String>();
		
		ArrayList<Point> travel = new ArrayList<Point>();
		
		HashMap<String, Node> values = new HashMap<String, Node>();
		PriorityQueue q = new PriorityQueue();

		Node startNode = new Node(from);
		values.put(startNode.point.getName(), startNode);
		startNode.calcH(to);
		
		open.add(startNode.point.getName());
		q.add(startNode);
		 
		boolean flag = false;
		
		while(true) {
			if(flag == true) {
				if((q.peek() == null) || (q.peek().g >= values.get(to.getName()).f)) {
					break;
				}
			}
			Node current = q.poll();
			//System.out.println("Current Node: " + current.point.getName());
			boolean isDestination = current.point.getName().equals(to.getName());
			if(isDestination) { flag = true; }
			
			for(Point p : current.point.getPoints().keySet()) {
				if(!closed.contains(p.getName())) {
					
				if(!open.contains(p.getName())) {
					open.add(p.getName());
					Node newNode = new Node(p);
					newNode.calcH(to);
					values.put(p.getName(), newNode);
					q.add(newNode);
				}
				
				Node val = values.get(p.getName());
				
				double calcedG = current.point.getPoints().get(p) + current.g;
				double calcedF = calcedG + val.h;
				if(calcedF < val.f) {
					val.setG(calcedG);
					val.calcF();
					val.setPrevNode(current.point);
					q.remove(val.point.getName());
					q.add(val);
				}
				
				}
				
			}
			
			if(!isDestination) {
				closed.add(current.point.getName());
				open.remove(open.indexOf(current.point.getName()));
			}
			
		}
		
		System.out.println("From: " + from.getName() + "     To: " + to.getName());
		System.out.println("Open: " + open.toString());
		System.out.println("Closed: " + closed.toString());
		System.out.println("Node: " + to.getName() + "-" + values.get(to.getName()).g + "-" + values.get(to.getName()).f + "-" + values.get(to.getName()).prevNode.getName() + "   Final Priority Queue: " + q.toString());
		
		Point location = values.get(to.getName()).point;
		
		while(location != null) {
			travel.add(0, location);
			location = values.get(location.getName()).prevNode;
		}
		
		return travel;	
		
		
	}
	
	
	

}