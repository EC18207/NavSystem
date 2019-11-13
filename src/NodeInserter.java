import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class NodeInserter {

	HashMap<String, Point> nodes = new HashMap<String, Point>();
	ArrayList<Point> importantPoints;

	public BufferedImage img = null;
	String imageDirectory = "Images\\MapImageReadingFile.png";

	String fileDirectory = "MapBlock\\Coordinates.txt";

	public NodeInserter() {
		File f = new File(imageDirectory);
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (img != null) {
			completeMap();
		}
	}

	public void completeMap() {
		FileReader r = new FileReader();

		File t = new File(fileDirectory);

		r.fileReadIn(t);

		importantPoints = r.getPoints();

		insertNodes(importantPoints);

	}

	public void insertNodes(ArrayList<Point> points) {

		fillMap();

		connectMap();

		placeImportantPoints(points);

	}

	public void placeImportantPoints(ArrayList<Point> points) {
		for (int i = 0; i < points.size(); i++) {
			Point temp = points.get(0);
			int xval = (int) temp.x;
			int yval = (int) temp.y;
			String s = "X" + xval + "Y" + yval;

			Point nodeInMap = nodes.get(s);
			if (nodeInMap != null) {
				nodes.remove(s);
				nodeInMap.setName(temp.getName());
				nodes.put(temp.getName(), nodeInMap);
				points.remove(temp);
				points.add(nodeInMap);
			} else {
				System.out.println("Could not find: " + temp.getName() + " in the map.");
				points.remove(temp);
			}
		}
	}

	public void connectMap() {
		int x = 0;
		int y = 0;

		while (x < img.getWidth()) {

			for (y = 0; y < img.getHeight(); y++) {

				String s = "X" + x + "Y" + y;
				Point node = nodes.get(s);
				if (node != null) {
					String topS = "X" + (x) + "Y" + (y - 1);
					String rightS = "X" + (x + 1) + "Y" + (y);
					String leftS = "X" + (x - 1) + "Y" + (y);
					String bottomS = "X" + (x) + "Y" + (y + 1);
					String topLeftS = "X" + (x - 1) + "Y" + (y - 1);
					String topRightS = "X" + (x + 1) + "Y" + (y - 1);
					String bottomLeftS = "X" + (x - 1) + "Y" + (y + 1);
					String bottomRightS = "X" + (x + 1) + "Y" + (y + 1);

					Point top = nodes.get(topS);
					Point right = nodes.get(rightS);
					Point left = nodes.get(leftS);
					Point bottom = nodes.get(bottomS);
					Point topL = nodes.get(topLeftS);
					Point topR = nodes.get(topRightS);
					Point bottomL = nodes.get(bottomLeftS);
					Point bottomR = nodes.get(bottomRightS);

					if (top != null) {
						node.addPt(top, 1);
					}
					if (right != null) {
						node.addPt(right, 1);
					}
					if (left != null) {
						node.addPt(left, 1);
					}
					if (bottom != null) {
						node.addPt(bottom, 1);
					}
					if (topL != null) {
						node.addPt(topL, 1.414);
					}
					if (topR != null) {
						node.addPt(topR, 1.414);
					}
					if (bottomL != null) {
						node.addPt(bottomL, 1.414);
					}
					if (bottomR != null) {
						node.addPt(bottomR, 1.414);
					}
				}

			}

			x++;

		}
	}

	public void fillMap() {

		int x = 0;
		int y = 0;

		while (x < img.getWidth()) {

			for (y = 0; y < img.getHeight(); y++) {

				int color = img.getRGB(x, y);
				int red = (color & 0x00ff0000) >> 16;
				int green = (color & 0x0000ff00) >> 8;
				int blue = (color & 0x000000ff);

				boolean black = (red < 5) && (green < 5) && (blue < 5);

				if (black) {
					String s = "X" + x + "Y" + y;
					nodes.put(s, new Point(x, y, s));
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
