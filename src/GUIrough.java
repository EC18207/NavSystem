
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GridLayout;
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//import java.awt.geom.Point2D.Double;
//import java.awt.image.BufferedImage;
//import java.awt.image.ColorModel;
//import java.awt.image.WritableRaster;
//import java.io.File;
//import java.io.IOException;
//import java.util.Hashtable;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class GUIrough {
//	JFrame current;
//	MapMain map;
//	
//	public  class MapMain extends JPanel {
//	
//		
//		public void paintComponent(Graphics g) { 
//			super.paintComponent(g);
//			
//			
//		 }
//		@Override
//		public void paint(Graphics g ) {
//			super.paint(g);
//			
//			
//		}
//		
//		public void paintnuline(Graphics g, Point in1, Point in2 ) {
//			super.paint(g);
//			g.drawLine((int) in1.getX(), (int) in1.getY(), (int) in2.getX(), (int) in2.getY());
//			
//			
//		}
//		
//
//		
//
//		
//
//	}
//
//	
//
//	public  GUIrough() {
//		JFrame todisplay = new JFrame("Navigation System");
//		this.current = todisplay;
//		todisplay.setSize(500, 250);
//		todisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		MapMain imagholder = new MapMain();
//		this.map =  imagholder;
//		JLabel image = new JLabel();
//		ImageIcon map2draw = new ImageIcon("C:\\Users\\kriscija\\Desktop\\rsz_map.png");
//
//		
//		
//			// TODO Auto-generated catch block
//		
//
//		// constructs bufferedimage, we then modify that and create an imageicon with
//		// it.
////		try {
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		Point2D.Double test1 = new Point2D.Double(57.00, 138.32);
////		Point2D.Double test2 = new Point2D.Double(157.00, 25.00);
//
//
//	
//
////		mainmap.drawpoints(test1, test2);
//		
//// Just Testing stuff
////		System.out.println(mapfin.getIconHeight());
////		System.out.println(mapfin.getIconWidth());
////		mainmap.drawpoints(new Point2D.Double(138.5, 40.0), new Point2D.Double(22.0, 243.3));
//		
//		image.setIcon(map2draw);
//		
//		this.map.add(image);
//		JPanel buttonholder = new JPanel();
//		JPanel plannerheading = new JPanel();
//		String[] choicesto = { "test1", "test2" };
//		String[] choicesfrom = { "test1", "test2" };
//		String[] plannerstart = { "I murdered", "Jeffrey Epstein" };
//		JComboBox<String> planstart = new JComboBox<String>(plannerstart);
//		JComboBox<String> to = new JComboBox<String>(choicesto);
//		JComboBox<String> from = new JComboBox<String>(choicesfrom);
//		JTextField dd = new JTextField();
//		JTextField dt = new JTextField();
//		JButton startlmfao = new JButton("Start individual trip");
//		JButton startbigboi = new JButton("Start Planner");
//		JLabel header = new JLabel("PLAN YOUR TRIP HERE");
//		JLabel dist = new JLabel("todisplaydistance");
//		JLabel time = new JLabel("todisplaytime");
//		JLabel desd = new JLabel("Desired Distance(in miles):");
//		JLabel dest = new JLabel("Desired Time(in minutes):");
//		JLabel dis = new JLabel("Distance(in miles)::");
//		JLabel tim = new JLabel("Time(in minutes):");
//		JLabel tol = new JLabel("To:");
//		JLabel froml = new JLabel("From:");
//		JLabel nulll1 = new JLabel("");
//		JLabel nulll2 = new JLabel("");
//		JLabel nulll3 = new JLabel("");
//		JLabel nulll4 = new JLabel("");
//		JLabel nulll5 = new JLabel("");
//		plannerheading.add(header);
//		JPanel xtrabuttons = new JPanel();
//		xtrabuttons.add(startlmfao);
//		xtrabuttons.add(startbigboi);
//		buttonholder.setLayout(new GridLayout(3, 7));
//		buttonholder.add(tol);
//		buttonholder.add(to);
//		buttonholder.add(dis);
//		buttonholder.add(dist);
//		buttonholder.add(nulll1);
//		buttonholder.add(planstart);
//		buttonholder.add(nulll2);
//		buttonholder.add(nulll3);
//		buttonholder.add(nulll4);
//		buttonholder.add(nulll5);
//		buttonholder.add(desd);
//		buttonholder.add(dd);
//		buttonholder.add(froml);
//		buttonholder.add(from);
//		buttonholder.add(tim);
//		buttonholder.add(time);
//		buttonholder.add(dest);
//		buttonholder.add(dt);
//		todisplay.add(plannerheading, BorderLayout.EAST);
//		todisplay.add(xtrabuttons, BorderLayout.WEST);
//		todisplay.add(buttonholder, BorderLayout.SOUTH);
//		todisplay.add(this.map, BorderLayout.NORTH);
//
//
//		todisplay.pack();
//		todisplay.setVisible(true);
//
//	}
//	public void update(Point in1, Point in2) {
//		this.map.paintnuline(this.map.getGraphics(), in1, in2);
//		this.map.revalidate();
//		this.current.repaint();
//		
//		
//	}
//	
//
//}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIrough {
	BufferedImage mainmap = null;
	boolean hasstarted = false;
	JFrame current = null;
	GPS gps = new GPS();
	JComboBox to;
	JComboBox from;
	static double d_c_f = 0.007142857142857;
	String storeddistance;
	String storedtime;
 
	public class MapMain {
		Graphics g;
		Graphics2D g2;
		BufferedImage tomod;

		public MapMain(BufferedImage map) {
			this.tomod = map;
			this.g = map.getGraphics();
			this.g2 = (Graphics2D) g;
		}

		public BufferedImage drawpoints(Point in1, Point in2) {
			g2.setColor(Color.GREEN);
			g2.drawLine((int) in1.getX(), (int) in1.getY(), (int) in2.getX(), (int) in2.getY());
			g2.setColor(Color.RED);

			g2.fillOval((int) in2.getX(), (int) in2.getY(), 3, 3);
			return this.tomod;

		}

	}

	public void GUIroughres() {
		if (this.hasstarted == true) {
			this.current.dispose();
			this.hasstarted = false;

		}

		JFrame todisplay = new JFrame("Navigation System");
		
		this.current = todisplay;
		todisplay.setSize(500, 250);
		todisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel imagholder = new JPanel();
		JLabel image = new JLabel();
		ImageIcon map2draw = null;
		if (this.mainmap == null) {
			BufferedImage mapfin = null;

			try {
				mapfin = ImageIO.read(new File("Images\\rsz_1rsz_csse230MapImage.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// constructs bufferedimage, we then modify that and create an imageicon with
			// it.
//		try {
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Point2D.Double test1 = new Point2D.Double(57.00, 138.32);
//		Point2D.Double test2 = new Point2D.Double(157.00, 25.00);
			this.mainmap = mapfin;
		}

//		mainmap.drawpoints(test1, test2);
		if (mainmap != null) {
			map2draw = new ImageIcon((mainmap));
			image.setIcon(map2draw);
		}

// Just Testing stuff
//		System.out.println(mapfin.getIconHeight());
//		System.out.println(mapfin.getIconWidth());
		//l
//		mainmap.drawpoints(new Point2D.Double(138.5, 40.0), new Point2D.Double(22.0, 243.3));

		image.setIcon(map2draw);
		imagholder.add(image);
		JPanel buttonholder = new JPanel();
		JPanel plannerheading = new JPanel();
		
		//Add all important destination points to an array for displaying
		String[] choices = new String[gps.getPoints().size()];
		for(int i = 0; i < gps.getPoints().size(); i++) {
			choices[i] = gps.getPoints().get(i).getName();
		}
		
		String[] plannerstart = { "I murdered", "Jeffrey Epstein" };
		JComboBox<String> planstart = new JComboBox<String>(plannerstart);
		JComboBox<String> to = new JComboBox<String>(choices);
		this.to = to;
		JComboBox<String> from = new JComboBox<String>(choices);
		this.from = from;
		JTextField dd = new JTextField();
		JTextField dt = new JTextField();
		JButton startlmfao = new JButton("Start individual trip");
		JButton startbigboi = new JButton("Start Planner");
		JLabel header = new JLabel("PLAN YOUR TRIP HERE");
		JLabel dist = new JLabel(this.storeddistance);
		JLabel time = new JLabel(this.storedtime);
		JLabel desd = new JLabel("Desired Distance(in miles):");
		JLabel dest = new JLabel("Desired Time(in minutes):");
		JLabel dis = new JLabel("Distance(in miles)::");
		JLabel tim = new JLabel("Time(in minutes):");
		JLabel tol = new JLabel("To:");
		JLabel froml = new JLabel("From:");
		JLabel nulll1 = new JLabel("");
		JLabel nulll2 = new JLabel("");
		JLabel nulll3 = new JLabel("");
		JLabel nulll4 = new JLabel("");
		JLabel nulll5 = new JLabel("");
		plannerheading.add(header);
		JPanel xtrabuttons = new JPanel();
		xtrabuttons.add(startlmfao);
		xtrabuttons.add(startbigboi);
		buttonholder.setLayout(new GridLayout(3, 7));
		buttonholder.add(tol);
		buttonholder.add(to);
		buttonholder.add(dis);
		buttonholder.add(dist);
		buttonholder.add(nulll1);
		buttonholder.add(planstart);
		buttonholder.add(nulll2);
		buttonholder.add(nulll3);
		buttonholder.add(nulll4);
		buttonholder.add(nulll5);
		buttonholder.add(desd);
		buttonholder.add(dd);
		buttonholder.add(froml);
		buttonholder.add(from);
		buttonholder.add(tim);
		buttonholder.add(time);
		buttonholder.add(dest);
		buttonholder.add(dt);
		todisplay.add(plannerheading, BorderLayout.EAST);
		todisplay.add(xtrabuttons, BorderLayout.WEST);
		todisplay.add(buttonholder, BorderLayout.SOUTH);
		todisplay.add(imagholder, BorderLayout.NORTH);
		

		startlmfao.addActionListener(new tostartbutton());
			
			

			//Fucking commit again
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String toChoiceStr = (String) to.getSelectedItem(); 
//				String fromChoiceStr = (String) from.getSelectedItem();
//				
//				if (toChoiceStr.equals(fromChoiceStr)) {
//				
//					System.out.println("Incorrect Arguments");
//					return;
//					
//				}
//				
//				Point toChoice = null;
//				Point fromChoice = null;
//				
//				
//				for (int i = 0; i < gps.getPoints().size(); i++) {
//					if (gps.getPoints().get(i).getName().equals(toChoiceStr)) toChoice = gps.getPoints().get(i);
//					if (gps.getPoints().get(i).getName().equals(fromChoiceStr)) fromChoice = gps.getPoints().get(i);
//				}
//				
//				if (fromChoice == null) {
//					System.out.println("From not found");
//					return;
//				}
//				
//				if (toChoice == null) {
//					System.out.println("From not found");
//					return;
//				}
//
//				
//				AStar algo = new AStar();
//				ArrayList<Point> path = algo.findShortestPath(fromChoice, toChoice);
//				
//				System.out.println();
//				
//				System.out.println("From: " + fromChoice.getName() + "    To: " + toChoice.getName());
//				if(path.size() != 0) { System.out.println("Successful Route Found!     Beginning: " + path.get(0).getName() + "  End: " + path.get(path.size()-1).getName()); }
//				//Print Path
//				for(int i = 0; i < path.size()-1; i++) {
//					System.out.println(path.get(i).getName() + " --> ");
//				}
//				System.out.println(path.get(path.size()-1).getName());
//				
//				
//				
//			}
//
//		});

		startbigboi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

			
		});

		todisplay.pack();
		this.hasstarted = true;
		todisplay.setVisible(true);

	}	
	
//		if (this.hasstarted == true) {
//			this.current.dispose();
//			this.hasstarted = false;
//
//		}
//
//		JFrame todisplay = new JFrame("Navigation System");
//		this.current = todisplay;
//		todisplay.setSize(500, 250);
//		todisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel imagholder = new JPanel();
//		JLabel image = new JLabel();
//		ImageIcon map2draw = null;
//		if (this.mainmap == null) {
//			BufferedImage mapfin = null;
//
//			try {
//				mapfin = ImageIO.read(new File("Images\\rsz_1rsz_csse230MapImage.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			// constructs bufferedimage, we then modify that and create an imageicon with
//			// it.
////		try {
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		Point2D.Double test1 = new Point2D.Double(57.00, 138.32);
////		Point2D.Double test2 = new Point2D.Double(157.00, 25.00);
//			this.mainmap = mapfin;
//		}
//
////		mainmap.drawpoints(test1, test2);
//		if (mainmap != null) {
//			map2draw = new ImageIcon((mainmap));
//			image.setIcon(map2draw);
//		}
//
//// Just Testing stuff
////		System.out.println(mapfin.getIconHeight());
////		System.out.println(mapfin.getIconWidth());
////		mainmap.drawpoints(new Point2D.Double(138.5, 40.0), new Point2D.Double(22.0, 243.3));
//
//		image.setIcon(map2draw);
//		imagholder.add(image);
//		JPanel buttonholder = new JPanel();
//		JPanel plannerheading = new JPanel();
//		String[] choicesto = { "test1", "test2" };
//		String[] choicesfrom = { "test1", "test2" };
//		String[] plannerstart = { "I murdered", "Jeffrey Epstein" };
//		JComboBox<String> planstart = new JComboBox<String>(plannerstart);
//		JComboBox<String> to = new JComboBox<String>(choicesto);
//		this.to = to;
//		JComboBox<String> from = new JComboBox<String>(choicesfrom);
//		this.from = from;
//		JTextField dd = new JTextField();
//		JTextField dt = new JTextField();
//		JButton startlmfao = new JButton("Start individual trip");
//		JButton startbigboi = new JButton("Start Planner");
//		JLabel header = new JLabel("PLAN YOUR TRIP HERE");
//		JLabel dist = new JLabel("todisplaydistance");
//		JLabel time = new JLabel("todisplaytime");
//		JLabel desd = new JLabel("Desired Distance(in miles):");
//		JLabel dest = new JLabel("Desired Time(in minutes):");
//		JLabel dis = new JLabel("Distance(in miles)::");
//		JLabel tim = new JLabel("Time(in minutes):");
//		JLabel tol = new JLabel("To:");
//		JLabel froml = new JLabel("From:");
//		JLabel nulll1 = new JLabel("");
//		JLabel nulll2 = new JLabel("");
//		JLabel nulll3 = new JLabel("");
//		JLabel nulll4 = new JLabel("");
//		JLabel nulll5 = new JLabel("");
//		plannerheading.add(header);
//		JPanel xtrabuttons = new JPanel();
//		xtrabuttons.add(startlmfao);
//		xtrabuttons.add(startbigboi);
//		buttonholder.setLayout(new GridLayout(3, 7));
//		buttonholder.add(tol);
//		buttonholder.add(to);
//		buttonholder.add(dis);
//		buttonholder.add(dist);
//		buttonholder.add(nulll1);
//		buttonholder.add(planstart);
//		buttonholder.add(nulll2);
//		buttonholder.add(nulll3);
//		buttonholder.add(nulll4);
//		buttonholder.add(nulll5);
//		buttonholder.add(desd);
//		buttonholder.add(dd);
//		buttonholder.add(froml);
//		buttonholder.add(from);
//		buttonholder.add(tim);
//		buttonholder.add(time);
//		buttonholder.add(dest);
//		buttonholder.add(dt);
//		todisplay.add(plannerheading, BorderLayout.EAST);
//		todisplay.add(xtrabuttons, BorderLayout.WEST);
//		todisplay.add(buttonholder, BorderLayout.SOUTH);
//		todisplay.add(imagholder, BorderLayout.NORTH);
//		startlmfao.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//
//				String toChoice = (String) to.getSelectedItem();
//				String fromChoice = (String) from.getSelectedItem();
//
//				FileReader reader = new FileReader();
//				ArrayList<Point> points = reader.getPoints();
//				if (points.contains(toChoice) && points.contains(fromChoice)) {
//					// aye
//				}
//
//			}
//
//		});
//		
//
//		startlmfao.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String toChoiceStr = (String) to.getSelectedItem(); 
//				String fromChoiceStr = (String) from.getSelectedItem();
//				
//				if (toChoiceStr.equals(fromChoiceStr)) {
//				
//					System.out.println("Incorrect Arguments");
//					return;
//					
//				}
//				
//				FileReader reader = new FileReader();
//				ArrayList<Point> points = reader.getPoints();
//				
//				Point toChoice = null;
//				Point fromChoice = null;
//				
//				for (int i = 0; i < points.size(); i++) {
//					if (points.get(i).getName().equals(toChoiceStr)) toChoice = points.get(i);
//					if (points.get(i).getName().equals(fromChoiceStr)) fromChoice = points.get(i);
//				}
//				
//				AStar algo = new AStar();
//				ArrayList<Point> path = algo.findShortestPath(fromChoice, toChoice);
//				
//				for(int x = 0; x < path.size()-1; x++) {
//					System.out.println(path.get(x).getName() + " --> ");
//				}
//				System.out.println(path.get(path.size()-1).getName());
//				
//				
//			}
//			
//		});
//		
//		startbigboi.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				
//				
//			}
//			
//			
//			
//		});
//
//		todisplay.pack();
//		this.hasstarted = true;
//		todisplay.setVisible(true);
//
//	}
	

	public GUIrough() {
		if (this.hasstarted == true) {
			this.current.dispose();
			this.hasstarted = false;

		}

		JFrame todisplay = new JFrame("Navigation System");
		
		this.current = todisplay;
		todisplay.setSize(500, 250);
		todisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel imagholder = new JPanel();
		JLabel image = new JLabel();
		ImageIcon map2draw = null;
		if (this.mainmap == null) {
			BufferedImage mapfin = null;

			try {
				mapfin = ImageIO.read(new File("Images\\rsz_1rsz_csse230MapImage.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// constructs bufferedimage, we then modify that and create an imageicon with
			// it.
//		try {
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Point2D.Double test1 = new Point2D.Double(57.00, 138.32);
//		Point2D.Double test2 = new Point2D.Double(157.00, 25.00);
			this.mainmap = mapfin;
		}

//		mainmap.drawpoints(test1, test2);
		if (mainmap != null) {
			map2draw = new ImageIcon((mainmap));
			image.setIcon(map2draw);
		}

// Just Testing stuff
//		System.out.println(mapfin.getIconHeight());
//		System.out.println(mapfin.getIconWidth());
		//l
//		mainmap.drawpoints(new Point2D.Double(138.5, 40.0), new Point2D.Double(22.0, 243.3));

		image.setIcon(map2draw);
		imagholder.add(image);
		JPanel buttonholder = new JPanel();
		JPanel plannerheading = new JPanel();
		
		//Add all important destination points to an array for displaying
		String[] choices = new String[gps.getPoints().size()];
		for(int i = 0; i < gps.getPoints().size(); i++) {
			choices[i] = gps.getPoints().get(i).getName();
		}
		
		String[] plannerstart = { "I murdered", "Jeffrey Epstein" };
		JComboBox<String> planstart = new JComboBox<String>(plannerstart);
		JComboBox<String> to = new JComboBox<String>(choices);
		this.to = to;
		JComboBox<String> from = new JComboBox<String>(choices);
		this.from = from;
		JTextField dd = new JTextField();
		JTextField dt = new JTextField();
		JButton startlmfao = new JButton("Start individual trip");
		JButton startbigboi = new JButton("Start Planner");
		JLabel header = new JLabel("PLAN YOUR TRIP HERE");
		JLabel dist = new JLabel("todisplaydistance");
		JLabel time = new JLabel("todisplaytime");
		JLabel desd = new JLabel("Desired Distance(in miles):");
		JLabel dest = new JLabel("Desired Time(in minutes):");
		JLabel dis = new JLabel("Distance(in miles):");
		JLabel tim = new JLabel("Time(in minutes):");
		JLabel tol = new JLabel("To:");
		JLabel froml = new JLabel("From:");
		JLabel nulll1 = new JLabel("");
		JLabel nulll2 = new JLabel("");
		JLabel nulll3 = new JLabel("");
		JLabel nulll4 = new JLabel("");
		JLabel nulll5 = new JLabel("");
		plannerheading.add(header);
		JPanel xtrabuttons = new JPanel();
		xtrabuttons.add(startlmfao);
		xtrabuttons.add(startbigboi);
		buttonholder.setLayout(new GridLayout(3, 7));
		buttonholder.add(tol);
		buttonholder.add(to);
		buttonholder.add(dis);
		buttonholder.add(dist);
		buttonholder.add(nulll1);
		buttonholder.add(planstart);
		buttonholder.add(nulll2);
		buttonholder.add(nulll3);
		buttonholder.add(nulll4);
		buttonholder.add(nulll5);
		buttonholder.add(desd);
		buttonholder.add(dd);
		buttonholder.add(froml);
		buttonholder.add(from);
		buttonholder.add(tim);
		buttonholder.add(time);
		buttonholder.add(dest);
		buttonholder.add(dt);
		todisplay.add(plannerheading, BorderLayout.EAST);
		todisplay.add(xtrabuttons, BorderLayout.WEST);
		todisplay.add(buttonholder, BorderLayout.SOUTH);
		todisplay.add(imagholder, BorderLayout.NORTH);
		this.storeddistance = "todisplaydistance";
		this.storedtime = "todisplaytime";
		

		startlmfao.addActionListener(new tostartbutton());
			
			

			//Fucking commit again
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String toChoiceStr = (String) to.getSelectedItem(); 
//				String fromChoiceStr = (String) from.getSelectedItem();
//				
//				if (toChoiceStr.equals(fromChoiceStr)) {
//				
//					System.out.println("Incorrect Arguments");
//					return;
//					
//				}
//				
//				Point toChoice = null;
//				Point fromChoice = null;
//				
//				
//				for (int i = 0; i < gps.getPoints().size(); i++) {
//					if (gps.getPoints().get(i).getName().equals(toChoiceStr)) toChoice = gps.getPoints().get(i);
//					if (gps.getPoints().get(i).getName().equals(fromChoiceStr)) fromChoice = gps.getPoints().get(i);
//				}
//				
//				if (fromChoice == null) {
//					System.out.println("From not found");
//					return;
//				}
//				
//				if (toChoice == null) {
//					System.out.println("From not found");
//					return;
//				}
//
//				
//				AStar algo = new AStar();
//				ArrayList<Point> path = algo.findShortestPath(fromChoice, toChoice);
//				
//				System.out.println();
//				
//				System.out.println("From: " + fromChoice.getName() + "    To: " + toChoice.getName());
//				if(path.size() != 0) { System.out.println("Successful Route Found!     Beginning: " + path.get(0).getName() + "  End: " + path.get(path.size()-1).getName()); }
//				//Print Path
//				for(int i = 0; i < path.size()-1; i++) {
//					System.out.println(path.get(i).getName() + " --> ");
//				}
//				System.out.println(path.get(path.size()-1).getName());
//				
//				
//				
//			}
//
//		});

		startbigboi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

			
		});

		todisplay.pack();
		this.hasstarted = true;
		todisplay.setVisible(true);

	}

	public void update(ArrayList<Point> todo) {
		if (this.hasstarted == false || this.mainmap == null) {
			this.GUIroughres();

		}
		for (int i = 0; i < todo.size() - 1; i++) {
			this.mainmap = new MapMain(this.mainmap).drawpoints(todo.get(i), todo.get(i + 1));

		}
		double tocon = (todo.size()*d_c_f);
		double conv = 4.656;
		double tocont = (tocon*conv);
		this.storeddistance = String.valueOf(tocon);
		System.out.println(this.storeddistance);
		
		this.storedtime = String.valueOf(tocont);
		System.out.println(this.storedtime);

		this.GUIroughres();
		this.mainmap = null;

	}
	public class tostartbutton implements ActionListener {

		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String toChoiceStr = (String)to.getSelectedItem();
			String fromChoiceStr = (String) from.getSelectedItem();
			
			if (toChoiceStr.equals(fromChoiceStr)) {
			
				System.out.println("Incorrect Arguments");
				return;
				
			}
			
			Point toChoice = null;
			Point fromChoice = null;
			
			
			for (int i = 0; i < gps.getPoints().size(); i++) {
				if (gps.getPoints().get(i).getName().equals(toChoiceStr)) toChoice = gps.getPoints().get(i);
				if (gps.getPoints().get(i).getName().equals(fromChoiceStr)) fromChoice = gps.getPoints().get(i);
			}
			
			if (fromChoice == null) {
				System.out.println("From not found");
				return;
			}
			
			if (toChoice == null) {
				System.out.println("From not found");
				return;
			}

			
			AStar algo = new AStar();
			ArrayList<Point> path = algo.findShortestPath(fromChoice, toChoice);
			
			System.out.println();
			if(path.size() > 0) {
				System.out.println("Path Found.");
			}
			
			System.out.println("From: " + fromChoice.getName() + "    To: " + toChoice.getName());
//			if(path.size() != 0) { System.out.println("Successful Route Found!     Beginning: " + path.get(0).getName() + "  End: " + path.get(path.size()-1).getName()); }
//			//Print Path
//			for(int i = 0; i < path.size()-1; i++) {
//				System.out.println(path.get(i).getName() + " --> ");
//			}
//			System.out.println(path.get(path.size()-1).getName());
			update(path);
			
			
			
			
		}



	}

}
