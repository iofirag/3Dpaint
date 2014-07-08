
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Jama.Matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main{
	
	static int Width = 900;
	static int Height = 500;
	
	static int viewersDistance = 1000;
	static int hatala = 1;
	static int menuSelectedItem;
	static myJPanel pane = new myJPanel();
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
    
    private static void createAndShowGUI() {
      
        final JFrame f = new JFrame("3D shapes");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(pane);
        f.pack();
        f.setVisible(true);
        
        
     // Create the menu bar.
     		JMenuBar menuBar = new JMenuBar();
     // Transforms
     		JMenu transformsMenu = new JMenu("Transforms");
     		JMenuItem transTranslation = new JMenuItem("Translation"); 
     		transTranslation.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     			}
     		});
     		JMenuItem transScaling = new JMenuItem("Scaling"); 
     		transScaling.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 1;
     			}
     		});
     		JMenu transRotation = new JMenu("Rotation");
     		JMenuItem transRotationXY = new JMenuItem("X-Y");
     		transRotationXY.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 2;
     				String result = JOptionPane
    						.showInputDialog("Enter angle for rotation:");
    				pane.angle = Integer.parseInt(result);
     			}
     		});
     		JMenuItem transRotationXZ = new JMenuItem("X-Z");
     		transRotationXZ.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 3;
     				String result = JOptionPane
    						.showInputDialog("Enter angle for rotation:");
    				pane.angle = Integer.parseInt(result);
     			}
     		});
     		JMenuItem transRotationYZ = new JMenuItem("Y-Z");
     		transRotationYZ.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 4;
     				String result = JOptionPane
    						.showInputDialog("Enter angle for rotation:");
    				pane.angle = Integer.parseInt(result);
     			}
     		});
     		transRotation.add(transRotationXY);
     		transRotation.add(transRotationXZ);
     		transRotation.add(transRotationYZ);
     		// **********************


     		transformsMenu.add(transTranslation);
     		transformsMenu.add(transScaling);
     		transformsMenu.add(transRotation);
     	// ************************************************
     		
     	// Perspectives menu	
     		JMenu perspectiveMenu = new JMenu("Select view");
     		JMenuItem persCabinet = new JMenuItem("Cabinet"); 
     		persCabinet.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				hatala = 1;
     				// custom title, custom icon
    				String result = JOptionPane
    						.showInputDialog("Enter angle for perspective:");
    				pane.angle = Integer.parseInt(result);
     				pane.repaint();
     			}
     		});
     		JMenuItem persCavalier = new JMenuItem("Cavalier"); 
     		persCavalier.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				hatala = 2;
     				// custom title, custom icon
    				String result = JOptionPane
    						.showInputDialog("Enter angle for perspective:");
    				pane.angle = Integer.parseInt(result);
     				pane.repaint();
     			}
     		});
     		JMenuItem persPerpective = new JMenuItem("Perpective"); 
     		persPerpective.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				hatala = 3;
     				pane.repaint();
     			}
     		});
     		perspectiveMenu.add(persCabinet);
     		perspectiveMenu.add(persCavalier);
     		perspectiveMenu.add(persPerpective);
     	// ************************************************
     		JMenuItem restart = new JMenu("Restart"); 
     		restart.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				pane.points = new ArrayList<Point3D>() ;
     				pane.points.add(new Point3D (100,100,100));
     				pane.points.add(new Point3D (200,100,100));
     				pane.points.add(new Point3D (100,200,100));
     				pane.points.add(new Point3D (200,200,100));
     				pane.points.add(new Point3D (100,100,200));
     				pane.points.add(new Point3D (200,100,200));
     				pane.points.add(new Point3D (100,200,200));
     				pane.points.add(new Point3D (200,200,200));
     				pane.points.add(new Point3D (300,100,123));
     				pane.points.add(new Point3D (323,123,223));
     				pane.points.add(new Point3D (400,100,173));
     				pane.points.add(new Point3D (350,200,173));
     				pane.polygons3D = new ArrayList<Polygon3D>();
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(0),pane.points.get(2),pane.points.get(3), pane.points.get(1)), Color.WHITE, Color.BLUE));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(2),pane.points.get(6),pane.points.get(7), pane.points.get(3)), Color.WHITE, Color.GREEN));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(1),pane.points.get(3),pane.points.get(7), pane.points.get(5)), Color.WHITE, Color.YELLOW));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(0),pane.points.get(4),pane.points.get(6), pane.points.get(2)), Color.WHITE, Color.GRAY));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(0),pane.points.get(1),pane.points.get(5), pane.points.get(4)), Color.WHITE, Color.ORANGE));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(4),pane.points.get(5),pane.points.get(7), pane.points.get(6)), Color.WHITE, Color.RED));
     		    	
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(10),pane.points.get(9),pane.points.get(8)), Color.WHITE, Color.WHITE));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(9),pane.points.get(10),pane.points.get(11)), Color.WHITE, Color.BLUE));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(8),pane.points.get(9),pane.points.get(11)), Color.WHITE, Color.ORANGE));
     				pane.polygons3D.add(new Polygon3D(Arrays.asList(pane.points.get(8),pane.points.get(10),pane.points.get(11)), Color.WHITE, Color.CYAN));
     		    	pane.repaint();	
     			}
     		});
     	
     		menuBar.add(transformsMenu);
     		menuBar.add(perspectiveMenu);
     		menuBar.add(restart);
     		f.add(menuBar, BorderLayout.NORTH);
    } 
}
    class myJPanel extends JPanel{
    	//mouse var's
    	protected Point currMousePoint;
    	
    	int angle=90;
    	
    	//Lists
    	static List<Point3D> points;
    	static List<Polygon3D> polygons3D ;
    	static List<Polygon2D> polygons2D;
    	
    	
		public myJPanel() {
	    	this.setBackground(Color.BLACK);
	    	//Creating 3D Polygons
	    	points = new ArrayList<Point3D>() ;
	    	points.add(new Point3D (100,100,100));
	    	points.add(new Point3D (200,100,100));
	    	points.add(new Point3D (100,200,100));
	    	points.add(new Point3D (200,200,100));
	    	points.add(new Point3D (100,100,200));
	    	points.add(new Point3D (200,100,200));
	    	points.add(new Point3D (100,200,200));
	    	points.add(new Point3D (200,200,200));
	    	points.add(new Point3D (300,100,123));
	    	points.add(new Point3D (323,123,223));
	    	points.add(new Point3D (400,100,173));
	    	points.add(new Point3D (350,200,173));
	    	polygons3D = new ArrayList<Polygon3D>();
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(2),points.get(3), points.get(1)), Color.WHITE, Color.BLUE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(2),points.get(6),points.get(7), points.get(3)), Color.WHITE, Color.GREEN));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(1),points.get(3),points.get(7), points.get(5)), Color.WHITE, Color.YELLOW));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(4),points.get(6), points.get(2)), Color.WHITE, Color.GRAY));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(1),points.get(5), points.get(4)), Color.WHITE, Color.ORANGE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(4),points.get(5),points.get(7), points.get(6)), Color.WHITE, Color.RED));
	    	
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(10),points.get(9),points.get(8)), Color.WHITE, Color.WHITE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(9),points.get(10),points.get(11)), Color.WHITE, Color.BLUE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(9),points.get(11)), Color.WHITE, Color.ORANGE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(10),points.get(11)), Color.WHITE, Color.CYAN));
	    			

	    	// Mouse listeners
	        addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	            }
	        });
	        addMouseMotionListener(new MouseAdapter() {
	            public void mouseDragged(MouseEvent e) {
	            }
	        });
	        addMouseMotionListener(new MouseAdapter() {
	            public void mouseMoved(MouseEvent e) {
	            }
	        });
	        
			addMouseWheelListener(new MouseWheelListener() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {
					switch (main.menuSelectedItem) { 
					case 1:// Scaling
						double zoom;
						if (e.getWheelRotation() > 0) {
							zoom = 0.9;
						} else {
							zoom = 1.1;
						}
						currMousePoint = new Point(e.getX()-8, e.getY()-53);
						
						//calculate new point of every poligon in the list
						for (Polygon3D p : polygons3D) {
							for (int i = 0; i < p.getPoints().size(); i++) {
	
								// init vector with point parameter
								// Matrix A
								double[][] objectValues = { {
										p.getPoints().get(i).getX(),
										p.getPoints().get(i).getY(), 
										p.getPoints().get(i).getZ(), 
										1 } };
								Matrix object = new Matrix(objectValues);
								double[][] scaleValues = {
										{ zoom, 0, 0, 0 },
										{ 0, zoom, 0 ,0},
										{ 0, 0, zoom, 0},
										{ currMousePoint.x*(1 - zoom) , currMousePoint.y*(1 - zoom), 0, 1}};
								Matrix scale = new Matrix(scaleValues);
								// Matrix A * Matrix B
								Matrix scaleResult = object.times(scale);
								p.getPoints().get(i).setX((int) scaleResult.get(0,0));
								p.getPoints().get(i).setY((int) scaleResult.get(0,1));
								p.getPoints().get(i).setZ((int) scaleResult.get(0,2));
							}
							repaint();
						}
						break;
					case 2:{ // Rotation X-Y
						int teta;
						if (e.getWheelRotation() > 0) {
							teta= angle;
						} else {
							teta= angle*-1;
						}
						
						// find center of img
						Point centerImg = getImageCenter();
						
						//calculate new point of every poligon in the list
						for (Polygon3D p : polygons3D) {
							for (int i = 0; i < p.getPoints().size(); i++) {
	
								// init vector with point parameter
								// Matrix A
								double[][] objectValues = { {
										p.getPoints().get(i).getX(),
										p.getPoints().get(i).getY(), 
										p.getPoints().get(i).getZ(), 
										1 } };
								Matrix object = new Matrix(objectValues);
								double[][] rotateValues = {
										{ Math.cos(Math.toRadians(teta)), -Math.sin(Math.toRadians(teta)), 0, 0 },
										{ Math.sin(Math.toRadians(teta)), Math.cos(Math.toRadians(teta)), 0, 0 },
										{ 0, 0, 1, 0 },
										{-centerImg.x*Math.cos(Math.toRadians(teta)) - centerImg.y*Math.sin(Math.toRadians(teta)) + centerImg.x, 
											centerImg.x* Math.sin(Math.toRadians(teta))- centerImg.y * Math.cos(Math.toRadians(teta)) + centerImg.y ,
											0,
											1}};
								Matrix rotate = new Matrix(rotateValues);
								// Matrix A * Matrix B
								Matrix rotateResult = object.times(rotate);
								
								p.getPoints().get(i).setX((int) rotateResult.get(0,0));
								p.getPoints().get(i).setY((int) rotateResult.get(0,1));
								p.getPoints().get(i).setZ((int) rotateResult.get(0,2));
							}
						}
						repaint();
					}
						break;
					case 3:{	// Rotation X-Z
						int teta;
						if (e.getWheelRotation() > 0) {
							teta= angle;
						} else {
							teta= angle*-1;
						}
						
						// find center of img
						Point centerImg = getImageCenter();
						
						//calculate new point of every poligon in the list
						for (Polygon3D p : polygons3D) {
							for (int i = 0; i < p.getPoints().size(); i++) {
	
								// init vector with point parameter
								// Matrix A
								double[][] objectValues = { {
										p.getPoints().get(i).getX(),
										p.getPoints().get(i).getY(), 
										p.getPoints().get(i).getZ(), 
										1 } };
								Matrix object = new Matrix(objectValues);
								double[][] rotateValues = {
										{ Math.cos(Math.toRadians(teta)), 0, -Math.sin(Math.toRadians(teta)), 0 },
										{ 0, 1, 0, 0 },
										{ Math.sin(Math.toRadians(teta)), 0, Math.cos(Math.toRadians(teta)), 0 },
										{0, 0, 0,1 }};
								Matrix rotate = new Matrix(rotateValues);
								// Matrix A * Matrix B
								Matrix rotateResult = object.times(rotate);
								
								p.getPoints().get(i).setX((int) rotateResult.get(0,0));
								p.getPoints().get(i).setY((int) rotateResult.get(0,1));
								p.getPoints().get(i).setZ((int) rotateResult.get(0,2));
							}
						}
						
						repaint();
					}
						break;
					case 4:{	// Rotation Y-Z
						int teta;
						if (e.getWheelRotation() > 0) {
							teta= angle;
						} else {
							teta= angle*-1;
						}
						
						// find center of img
						Point centerImg = getImageCenter();
						
						//calculate new point of every poligon in the list
						for (Polygon3D p : polygons3D) {
							for (int i = 0; i < p.getPoints().size(); i++) {
	
								// init vector with point parameter
								// Matrix A
								double[][] objectValues = { {
										p.getPoints().get(i).getX(),
										p.getPoints().get(i).getY(), 
										p.getPoints().get(i).getZ(), 
										1 } };
								Matrix object = new Matrix(objectValues);
								double[][] rotateValues = {
										{ 1, 0, 0, 0 },
										{ 0, Math.cos(Math.toRadians(teta)), Math.sin(Math.toRadians(teta)), 0 },
										{ 0, -Math.sin(Math.toRadians(teta)), Math.cos(Math.toRadians(teta)), 0 },
										{0, 0, 0,1 }};
								Matrix rotate = new Matrix(rotateValues);
								// Matrix A * Matrix B
								Matrix rotateResult = object.times(rotate);
								
								p.getPoints().get(i).setX((int) rotateResult.get(0,0));
								p.getPoints().get(i).setY((int) rotateResult.get(0,1));
								p.getPoints().get(i).setZ((int) rotateResult.get(0,2));
							}
						}
						repaint();
					}
						break;
					}
	
				}
			});
	        
	    }
    
	    public Dimension getPreferredSize() {
	        return new Dimension(main.Width,main.Height);
	    }
    
	    //All paint actions will be performed from this function
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		switch (main.hatala) {
		case 1:
			polygons2D = cabinet();
			break;
		case 2:
			polygons2D = cavalier();
			break;
		case 3:
			polygons2D = perspective();
			break;
		}

		for (int i = 0; i < polygons2D.size(); i++) {
			int x[] = polygons2D.get(i).getXarray();
			int y[] = polygons2D.get(i).getYarray();

			g.setColor(polygons2D.get(i).getColor());
			g.drawPolygon(x, y, x.length);
			g.setColor(polygons2D.get(i).getFillColor());
			g.fillPolygon(x, y, x.length);
		}
	}
    
	    public List<Polygon2D> sortbyZindex(List<Polygon2D> polygons){
	    	   
	    	    for (int pass=1; pass < polygons.size(); pass++) {  // count how many times
	    	        // This next loop becomes shorter and shorter
	    	        for (int i=0; i < polygons.size()-pass; i++) {
	    	            if (polygons.get(i).zIndex > polygons.get(i+1).zIndex) {
	    	                // exchange elements
	    	                int temp = polygons.get(i).zIndex;
	    	                polygons.get(i).zIndex = polygons.get(i+1).zIndex; 
	    	                polygons.get(i+1).zIndex  = temp;
	    	            }
	    	        }
	    	    }
	    	    return polygons;
	    }
    
		public List<Polygon2D> cabinet() {
			List<Polygon2D> polygons2d = new ArrayList<Polygon2D>();
			boolean zIndexChosen = false;
			// run on every 3D polygons
			for (int i = 0; i < polygons3D.size(); i++) {
				if (polygons3D.get(i).isVectorV() == true) {
					Polygon2D tmpP = new Polygon2D(polygons3D.get(i).getColor(),
							polygons3D.get(i).getFillColor());
	
					// run on every point in the 3D polygon and calculate new values
					// according to Cabinet
					for (int j = 0; j < polygons3D.get(i).getPoints().size(); j++) {
						int tmpX = polygons3D.get(i).getPoints().get(j).getX();
						int tmpY = polygons3D.get(i).getPoints().get(j).getY();
						int tmpZ = polygons3D.get(i).getPoints().get(j).getZ();
						// Cabinet
						tmpX = (int) (tmpX + 0.5 * tmpZ * Math.cos(angle));
						tmpY = (int) (tmpY + 0.5 * tmpZ * Math.sin(angle));
						tmpP.getPoints().add(new Point(tmpX, tmpY));
	
						if (zIndexChosen == false) {
							tmpP.zIndex = tmpZ;
							zIndexChosen = true;
						}
					}
					polygons2d.add(new Polygon2D(tmpP.getPoints(), tmpP.getColor(),
							tmpP.getFillColor(), tmpP.zIndex));
					zIndexChosen = false;
				}
			}
			// Sort the 2D polygons by their Z index.
			polygons2d = sortbyZindex(polygons2d);
	
			return polygons2d;
		}
	
		
		public List<Polygon2D> cavalier() {
			List<Polygon2D> polygons2d = new ArrayList<Polygon2D>();
			boolean zIndexChosen = false;
			// run on every 3D polygons
			for (int i = 0; i < polygons3D.size(); i++) {
				if (polygons3D.get(i).isVectorV() == true) {
					Polygon2D tmpP = new Polygon2D(polygons3D.get(i).getColor(),
							polygons3D.get(i).getFillColor());
	
					// run on every point in the 3D polygon and calculate new values
					// according to Cavalier
					for (int j = 0; j < polygons3D.get(i).getPoints().size(); j++) {
						int tmpX = polygons3D.get(i).getPoints().get(j).getX();
						int tmpY = polygons3D.get(i).getPoints().get(j).getY();
						int tmpZ = polygons3D.get(i).getPoints().get(j).getZ();
						// Cabinet
						tmpX = (int) (tmpX + tmpZ * Math.cos(angle));
						tmpY = (int) (tmpY + tmpZ * Math.sin(angle));
						tmpP.getPoints().add(new Point(tmpX, tmpY));
	
						if (zIndexChosen == false) {
							tmpP.zIndex = tmpZ;
							zIndexChosen = true;
						}
					}
					polygons2d.add(new Polygon2D(tmpP.getPoints(), tmpP.getColor(),
							tmpP.getFillColor(), tmpP.zIndex));
					zIndexChosen = false;
				}
			}
			// Sort the 2D polygons by their Z index.
			polygons2d = sortbyZindex(polygons2d);
	
			return polygons2d;
		}
		
		
		public List<Polygon2D> perspective(){
			List<Polygon2D> polygons2d = new ArrayList<Polygon2D>();
			
			// run on every 3D polygons
			for (int i = 0; i < polygons3D.size(); i++) {
				//if (polygons3D.get(i).isVectorV() == true) {
					Polygon2D tmpP = new Polygon2D(polygons3D.get(i).getColor(),
							polygons3D.get(i).getFillColor());
	
					// run on every point in the 3D polygon and calculate new values
					for (int j = 0; j < polygons3D.get(i).getPoints().size(); j++) {
						int tmpX = polygons3D.get(i).getPoints().get(j).getX();
						int tmpY = polygons3D.get(i).getPoints().get(j).getY();
						int tmpZ = polygons3D.get(i).getPoints().get(j).getZ();
			
						// Matrix A
						double[][] objectValues = { {
								tmpX,
								tmpY, 
								tmpZ, 
								1 } };
						Matrix object = new Matrix(objectValues);
						double sz = (1/(1+(tmpZ/main.viewersDistance)));
						double[][] scaleValues = {
								{ sz, 0, 0, 0 },
								{ 0, sz, 0 ,0},
								{ 0, 0, 0, 0},
								{ 0 ,0, 0, 1}};
						Matrix scale = new Matrix(scaleValues);

						// Matrix A * Matrix B
						Matrix scaleResult = object.times(scale);
						tmpX=(int) scaleResult.get(0,0);
						tmpY=(int) scaleResult.get(0,1);
						tmpP.getPoints().add(new Point(tmpX, tmpY));
						polygons2d.add(new Polygon2D(tmpP.getPoints(), tmpP.getColor(),
								tmpP.getFillColor(), 0));
					}
				}
			//}
			
			return polygons2d;
		}
		
		public static Point getImageCenter() {
			return new Point (main.Width/2, main.Height/2);
		}
}