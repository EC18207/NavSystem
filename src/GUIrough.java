
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.Icon;
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
	static double d_c_f = 0.0058823529411764705; //old conversion: 0.007142857142857
	JLabel dist;
	JLabel time;
	double pland;
	double plant;
	JTextField dd;
	JTextField dt;
	JComboBox startloc;
	JPanel display;
	JLabel directimage;
	BufferedImage permanentmap;

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
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.MAGENTA);
			g2.drawLine((int) in1.getX(), (int) in1.getY(), (int) in2.getX(), (int) in2.getY());
//			g2.fillOval((int)in1.x, (int)in1.y, 3, 3);

			return this.tomod;

		}

		public BufferedImage highpoints(Point in1) {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.CYAN);
			g2.fillOval((int) in1.getX() - 4, (int) in1.getY() - 4, 8, 8);

			return this.tomod;

		}

		public BufferedImage highpointsstart(Point in1) {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.magenta);
			g2.fillOval((int) in1.getX() - 4, (int) in1.getY() - 4, 8, 8);

			return this.tomod;

		}
	}

	private static double round2(double value) {
		BigDecimal toround = new BigDecimal(String.valueOf(value));
		toround = toround.setScale(2, RoundingMode.HALF_UP);
		return toround.doubleValue();
	}

	public GUIrough() {
		try {
			this.permanentmap = ImageIO.read(new File("Images\\MapImage.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.mainmap = this.permanentmap;

		JFrame todisplay = new JFrame("Navigation System");
		todisplay.setPreferredSize(new Dimension(750, 750));

		this.current = todisplay;
		
		todisplay.setSize(500, 250);
		todisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		todisplay.getContentPane().setBackground(Color.black);
		JPanel imagholder = new JPanel();
		this.display = imagholder;
		JLabel image = new JLabel();
		this.directimage = image;
		ImageIcon map2draw = null;
		if (this.mainmap == null) {
			BufferedImage mapfin = null;

			try {
				mapfin = ImageIO.read(new File("Images\\MapImage.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.mainmap = mapfin;
		}

		if (mainmap != null) {
			map2draw = new ImageIcon((mainmap));
			image.setIcon(map2draw);
		}

		image.setIcon(map2draw);
		imagholder.add(image);
		JPanel buttonholder = new JPanel();
		JPanel plannerheading = new JPanel();

		// Add all important destination points to an array for displaying
		String[] choices = new String[gps.getPoints().size()];
		for (int i = 0; i < gps.getPoints().size(); i++) {
			choices[i] = gps.getPoints().get(i).getName();
		}

		JComboBox<String> planstart = new JComboBox<String>(choices);
		this.startloc = planstart;
		JComboBox<String> to = new JComboBox<String>(choices);
		this.to = to;
		JComboBox<String> from = new JComboBox<String>(choices);
		this.from = from;
		JTextField dd = new JTextField();
		this.dd = dd;
		JTextField dt = new JTextField();
		this.dt = dt;
		JButton startlmfao = new JButton("Start individual trip");
		JButton startbigboi = new JButton("Start Planner");
		JLabel header = new JLabel("PLAN YOUR TRIP HERE");
		JLabel dist = new JLabel("todisplaydistance");
		this.dist = dist;
		JLabel time = new JLabel("todisplaytime");
		this.time = time;
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

		startlmfao.addActionListener(new tostartbutton());

		startbigboi.addActionListener(new planbutton());

		todisplay.pack();
		this.hasstarted = true;
		todisplay.setVisible(true);

	}

	public void update(ArrayList<Point> todo) {
		try {
			this.mainmap = ImageIO.read(new File("Images\\MapImage.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < todo.size() - 1; i++) {
			this.mainmap = new MapMain(this.mainmap).drawpoints(todo.get(i), todo.get(i + 1));

		}
		double tocon = (todo.size() * d_c_f);
		double conv = 4.656;
		double tocont = (tocon * conv);
		String todisplaydistance = (String.valueOf(round2(tocon)));

		String todisplaytime = String.valueOf(round2(tocont));

		this.dist.setText(todisplaydistance);
		this.time.setText(todisplaytime);

		ImageIcon newdisplay = new ImageIcon(this.mainmap);
		this.directimage.setIcon(newdisplay);
		this.dist.revalidate();
		this.dist.repaint();
		this.time.revalidate();
		this.time.repaint();
		this.display.revalidate();
		this.display.repaint();

//		this.GUIroughres();

	}

	public void highlight(ArrayList<Point> todo) {

		try {
			this.mainmap = ImageIO.read(new File("Images\\MapImage.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.mainmap = new MapMain(this.mainmap).highpointsstart(todo.get(0));

		
		for (int i = 1; i < todo.size(); i++) {
			this.mainmap = new MapMain(this.mainmap).highpoints(todo.get(i));

		}
		ImageIcon newdisplay = new ImageIcon(this.mainmap);
		this.directimage.setIcon(newdisplay);
		this.display.revalidate();
		this.display.repaint();

//		this.GUIroughres();

	}

	public class planbutton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String dist = dd.getText();
			if (dist.equals("")) {
				pland = 0;
			} else {
				pland = Integer.parseInt(dist);
			}
			String tim = dt.getText();
			if (tim.contentEquals("")) {
				plant = 0;
			} else {
				plant = Integer.parseInt(tim);
			}

			String startLocation = (String) startloc.getSelectedItem();

			AStar algo = new AStar();
			ArrayList<Point> possiblePaths = algo.findAllPossible(gps.getMap().get(startLocation), gps.getPoints(),
					pland, plant);
			
			possiblePaths.add(0,gps.getMap().get(startLocation));
			highlight(possiblePaths);
			
		}

	}

	public class tostartbutton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String toChoiceStr = (String) to.getSelectedItem();
			String fromChoiceStr = (String) from.getSelectedItem();
			if (toChoiceStr.equals("Shadow Asylum Haunted House")
					&& fromChoiceStr.equals("Shadow Asylum Haunted House")) {
				JFrame spooky = new JFrame();
				JPanel todiss = new JPanel();
				Image spoo = null;
				try {
					spoo = ImageIO.read(new File("Images\\ignore.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (spoo != null) {
					ImageIcon esteregg = new ImageIcon(spoo);
					JLabel ester = new JLabel();
					ester.setIcon(esteregg);
					todiss.add(ester);
					spooky.add(todiss, BorderLayout.NORTH);
					spooky.pack();
					spooky.setVisible(true);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					spooky.dispose();

				}

			}

			if (toChoiceStr.equals(fromChoiceStr)) {

				System.out.println("Incorrect Arguments");
				return;

			}

			Point toChoice = null;
			Point fromChoice = null;

			for (int i = 0; i < gps.getPoints().size(); i++) {
				if (gps.getPoints().get(i).getName().equals(toChoiceStr))
					toChoice = gps.getPoints().get(i);
				if (gps.getPoints().get(i).getName().equals(fromChoiceStr))
					fromChoice = gps.getPoints().get(i);
			}

			if (fromChoice == null) {
				System.out.println("From not found");
				return;
			}

			if (toChoice == null) {
				System.out.println("From not found");
				return;
			}

			XMLCache cache = new XMLCache();
			ArrayList<Point> temp = cache.getPathIfPossible(fromChoice, toChoice);
			if(temp != null) {
				update(temp);
			} else {
				AStar algo = new AStar();
				ArrayList<Point> path = algo.findShortestPath(fromChoice, toChoice);
				cache.addPath(fromChoice, toChoice, path);
				if(path.size() > 0) {
					update(path);
				}
			}

		}

	}

}
