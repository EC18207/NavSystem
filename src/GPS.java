import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GPS {

	HashMap<String, Point> map;
	ArrayList<Point> points;

	public GPS() {
		NodeInserter inserter = new NodeInserter();
		map = inserter.getNodes();
		points = inserter.getImportantPoints();
	}

	public HashMap<String, Point> getMap() {
		return map;
	} 

	public ArrayList<Point> getPoints() {
		return points;
	}

	public ArrayList<Point> findShortestPath(Point from, Point to) {
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

		while (true) {
			if (flag == true) {
				if ((q.peek() == null) || (q.peek().f >= values.get(to.getName()).f)) {
					break;
				}
			}
			Node current = q.poll();
			boolean isDestination = current.point.getName().equals(to.getName());
			if (isDestination) {
				flag = true;
			}

			for (Point p : current.point.getPoints().keySet()) {
				if (!closed.contains(p.getName())) {

					if (!open.contains(p.getName())) {
						open.add(p.getName());
						Node newNode = new Node(p);
						newNode.calcH(to);
						values.put(p.getName(), newNode);
						q.add(newNode);
					}

					Node val = values.get(p.getName());

					double calcedG = current.point.getPoints().get(p).val + current.g;
					double calcedF = 10 * (calcedG + val.h);
					if (calcedF < val.f || val.f < 0) {
						val.setG(calcedG);
						val.calcF();
						val.setPrevNode(current.point);
						q.shiftUpNode(q.indexOf(val));
					}

				}

			}

			if (!isDestination) {
				closed.add(current.point.getName());
				open.remove(open.indexOf(current.point.getName()));
			}

		}

		Point location = values.get(to.getName()).point;

		while (location != null) {
			travel.add(0, location);
			location = values.get(location.getName()).prevNode;
		}

		return travel;

	}

	public ArrayList<Point> findAllPossible(Point from, ArrayList<Point> destinations, double distance, double time) {
		ArrayList<Point> possiblePaths = new ArrayList<Point>();

		if ((distance <= 0) && (time <= 0)) {
			return possiblePaths;
		}

		double distConversion = 0.007142857142857;
		double timeConversion = 4.656;

		int i = 0;
		while (i < destinations.size()) {
			boolean flag = false;
			Point dest = destinations.get(i);
			if (!dest.equals(from)) {

				double x = dest.getX() - from.getX();
				double y = dest.getY() - from.getY();

				double straightLineDistance = Math.sqrt((x * x) + (y * y)) * distConversion;

				if (distance > 0) {
					if (straightLineDistance > distance) {
						flag = true;
					}
				} else {
					if ((straightLineDistance * timeConversion) > time) {
						flag = true;
					}
				}

				if (!flag) {
					double distToNode = findShortestPath(from, dest).size() * distConversion;
					double timeToNode = distToNode * timeConversion;

					if ((distance > 0) && (time > 0)) {
						if (distToNode <= distance && timeToNode <= time) {
							possiblePaths.add(dest);
						}
					} else if (distance > 0) {
						if (distToNode <= distance) {
							possiblePaths.add(dest);
						}
					} else {
						if (timeToNode <= time) {
							possiblePaths.add(dest);
						}
					}
				}

			}
			i++;
		}

		return possiblePaths;

	}
	
	public String getDescription(String loc) {
		File textFile = new File("MapBlock\\Descriptions.txt");
		
		Scanner s = null;
		try {
			s = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file!");
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			
			String line = s.nextLine();
			String substring = "";
			int count = 0;
			int i = 0;
			while(i < line.length() && count < 2) {
				if(line.charAt(i) == ',') {
					if(count == 0) {
						if(!substring.toLowerCase().equals(loc.toLowerCase())) { break; }
						substring = substring + " -   ";
						count++;
						i++;
					} else {
						return substring;
					}
				} else {
					substring = substring + line.charAt(i);
					i++;
				}
			}
			
		}
		
		return "No Description Available.";
	}

}
