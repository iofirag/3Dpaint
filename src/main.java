/*Graphics programming , exercise 3.
 * Created by Ofir Aghai and Vidran Abdovich
 * Date : 11/7/2014
 */
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main extends JPanel{
	
	static int Width = 900;
	static int Height = 500;
	
	
	static int viewersDistance = -1000;   //Cop value
	static int projection = 1;
	static int menuSelectedItem;
	static boolean fill = true;
	
	//static myJPanel pane = new myJPanel();
	static main m = new main();
	public static boolean init=false;
	
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
        f.add(m);
        f.pack();
        f.setVisible(true);
        
        
     // Create the menu bar
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
    				angle = Integer.parseInt(result);
     			}
     		});
     		JMenuItem transRotationXZ = new JMenuItem("X-Z");
     		transRotationXZ.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 3;
     				String result = JOptionPane
    						.showInputDialog("Enter angle for rotation:");
    				angle = Integer.parseInt(result);
     			}
     		});
     		JMenuItem transRotationYZ = new JMenuItem("Y-Z");
     		transRotationYZ.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				menuSelectedItem = 4;
     				String result = JOptionPane
    						.showInputDialog("Enter angle for rotation:");
    				angle = Integer.parseInt(result);
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
     				projection = 1;
     				// custom title, custom icon
    				String result = JOptionPane
    						.showInputDialog("Enter angle for perspective:");
    				angle = Integer.parseInt(result);
     				m.repaint();
     			}
     		});
     		JMenuItem persCavalier = new JMenuItem("Cavalier"); 
     		persCavalier.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				projection = 2;
     				// custom title, custom icon
    				String result = JOptionPane
    						.showInputDialog("Enter angle for perspective:");
    				angle = Integer.parseInt(result);
     				m.repaint();
     			}
     		});
     		JMenuItem persPerpective = new JMenuItem("Perpective"); 
     		persPerpective.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				projection = 3;
     				m.repaint();
     			}
     		});
     		perspectiveMenu.add(persCabinet);
     		perspectiveMenu.add(persCavalier);
     		perspectiveMenu.add(persPerpective);
     	// ************************************************
     	// Fill menu	
     		JMenu poligonsFillMenu = new JMenu("Fill");
     		JMenuItem autoFill = new JMenuItem("Fill polygons"); 
     		autoFill.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				fill = true;
     				m.repaint();
     			}
     		});
     		JMenuItem transparentFill = new JMenuItem("Remove Fill"); 
     		transparentFill.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				fill = false;
     				m.repaint();
     			}
     		});
     		poligonsFillMenu.add(autoFill);
     		poligonsFillMenu.add(transparentFill);
     	// ************************************************
     		JMenu restart = new JMenu("Restart"); 
     		restart.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				// When clicking 'restart' in the menu, we need to 
				//initialize all parameters to its original values
				public void mouseClicked(MouseEvent e) {
					init=true;
     				projection=1;
     				menuSelectedItem = 0;
     				m.angle = 90;
     		    	m.repaint();
					
				}
			});
     		JMenu helpMenu = new JMenu("Help");
    		JMenuItem instructions = new JMenuItem("Instructions");
    		instructions.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				JOptionPane.showMessageDialog(null, "Instructions:\n\n" +

    						"How to use the transformations?:\n" +
    						"" +
    						"   Translation-\n" +
    						"   click with the mouse and drag it.\n\n" +
    						"" +
    						"   Scaling-\n" +
    						"   Use with mouse wheel for zoom-in and zoom-out.\n\n" +
    						"" +
    						"   Rotation-\n" +
    						"   To rotate right : Mouse wheel in.\n" +
    						"   To rotate left : Mouse wheel out.\n" +
    						"" +
    						
    						"");
    			}
    		});
    		JMenuItem about = new JMenuItem("About");
    		about.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				JOptionPane.showMessageDialog(null, "About:\n\n" +
    						"Computers graphics ex3, Created by:\n"+
    						"Ofir Aghai\n" +
    						"Vidran Abdovich\n\n" +
    						"" +
    						"Have fun!");
    			}
    		});
    		helpMenu.add(instructions);
    		helpMenu.add(about);
     		menuBar.add(transformsMenu);
     		menuBar.add(perspectiveMenu);
     		menuBar.add(poligonsFillMenu);
     		menuBar.add(restart);
     		menuBar.add(helpMenu);
     		f.add(menuBar, BorderLayout.NORTH);
    } 


    	//mouse variables
    	protected Point currMousePoint;
		protected Point lastDrag;
		protected Point pointPressed;
    	
    	static int angle=90;
    	
    	//Lists to hold points and polygons
    	static List<Point3D> points;
    	static List<Polygon3D> polygons3D;
    	static List<Polygon2D> polygons2D;
    	
    	//Initialization function that creates a list of 3D Polygons
    	public void init(){
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
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(4),points.get(6), points.get(2)), Color.WHITE, Color.GRAY));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(1),points.get(3),points.get(7), points.get(5)), Color.WHITE, Color.YELLOW));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(2),points.get(6),points.get(7), points.get(3)), Color.WHITE, Color.GREEN));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(1),points.get(5), points.get(4)), Color.WHITE, Color.ORANGE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(4),points.get(5),points.get(7), points.get(6)), Color.WHITE, Color.RED));
	    	
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(10),points.get(9),points.get(8)), Color.WHITE, Color.WHITE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(9),points.get(10),points.get(11)), Color.WHITE, Color.BLUE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(9),points.get(11)), Color.WHITE, Color.ORANGE));
	    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(10),points.get(11)), Color.WHITE, Color.CYAN));
	    	}
    	
		public main() {
	    	this.setBackground(Color.BLACK);
	    	//Creating 3D Polygons and adding them to polygons3D list
	    	init();
	    	// Mouse listeners
	        addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	            	pointPressed = new Point(e.getPoint().x - 8,e.getPoint().y - 53);
	            }
	        });
	        addMouseMotionListener(new MouseAdapter() {
	            public void mouseDragged(MouseEvent e) {
	            	lastDrag = new Point(e.getPoint().x - 8,e.getPoint().y - 53);

					// Shift transformation
					int dragDx = lastDrag.x - pointPressed.x;
					int dragDy = lastDrag.y - pointPressed.y;
					pointPressed.x = lastDrag.x;
					pointPressed.y = lastDrag.y;

					for (int i = 0; i < polygons3D.size(); i++) {
						// Change current polygon coordinations
						for (int j = 0; j < polygons3D.get(i).getPoints().size(); j++) {
							polygons3D.get(i).getPoints().get(j).setX(polygons3D.get(i).getPoints().get(j).getX() +dragDx  );
							polygons3D.get(i).getPoints().get(j).setY(polygons3D.get(i).getPoints().get(j).getY() +dragDy  );
						}
						polygons3D.get(i).setVectorN();
						polygons3D.get(i).setVectorV();
						repaint();
					}
	            }
	        });
	        addMouseMotionListener(new MouseAdapter() {
	            public void mouseMoved(MouseEvent e) {
	            }
	        });
	        
			addMouseWheelListener(new MouseWheelListener() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {
					switch (menuSelectedItem) { 
					case 1:					// Scaling
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
	
								// initialize vector with point parameters
								// Matrix A
								double[][] objectValues = { {
										p.getPoints().get(i).getX(),
										p.getPoints().get(i).getY(), 
										p.getPoints().get(i).getZ(), 
										1 } };
								Matrix object = new Matrix(objectValues);
								//Matrix B
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
							//Re-calculate vectorN and vectorV values in the 3D polygon
							p.setVectorN();
							p.setVectorV();
							repaint();
						}
						break;
					case 2:{			 // Rotation X-Y
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
								//Matrix B
								double[][] rotateValues = {
										{ Math.cos(Math.toRadians(teta)), -Math.sin(Math.toRadians(teta)), 0, 0 },
										{ Math.sin(Math.toRadians(teta)), Math.cos(Math.toRadians(teta)), 0, 0 },
										{ 0, 0, 1, 0 },
										{0, 0, 0,1 }};

								Matrix rotate = new Matrix(rotateValues);
								// Matrix A * Matrix B
								Matrix rotateResult = object.times(rotate);
								
								p.getPoints().get(i).setX((int) rotateResult.get(0,0));
								p.getPoints().get(i).setY((int) rotateResult.get(0,1));
								p.getPoints().get(i).setZ((int) rotateResult.get(0,2));
							}
							//Re-calculate vectorN and vectorV values in the 3D polygon
							p.setVectorN();
							p.setVectorV();
							repaint();
						}
						
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
								//Matrix B
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
							//Re-calculate vectorN and vectorV values in the 3D polygon
							p.setVectorN();
							p.setVectorV();
							repaint();
						}
						
					}
						break;
					case 4:{				// Rotation Y-Z
						int teta;
						if (e.getWheelRotation() > 0) {
							teta = angle;
						} else {
							teta = angle*-1;
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
							//Re-calculate vectorN and vectorV values in the 3D polygon
							p.setVectorN();
							p.setVectorV();
							repaint();
						}
					}
						break;
					}
	
				}
			});
	        
	    }
    
		//Function that sets the dimensions of the frame
	    public Dimension getPreferredSize() {
	        return new Dimension(Width,Height);
	    }
    
	//All paint actions will be performed from this function
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (init==true){
			m.init();
			init = false;
		}
		
		//Create a 2D polygons list according to the value that is stored in 'Projection' parameter
		switch (projection) {
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
			//If the user chose from the menu to fill the polygons , then fill them with color. 
			if (fill){
				g.setColor(polygons2D.get(i).getFillColor());
				g.fillPolygon(x, y, x.length);
			}
		}
	}
    	// This function gets a List of 2D Polygons and sorts it by the polygon's Z index parameter
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
	    
	    
	    //This function applies the Cabinet view
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
	
		//This function applies the Cavalier view
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
		
		//This function applies the Perspective view
		public List<Polygon2D> perspective(){
			List<Polygon2D> polygons2d = new ArrayList<Polygon2D>();
			
			// run on every 3D polygons
			for (int i = 0; i < polygons3D.size(); i++) {
				if (polygons3D.get(i).isVectorV() == true) {
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
						double sz = (1/(1+(tmpZ/viewersDistance)));
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
			}
			
			return polygons2d;
		}
		
		public static Point getImageCenter() {
			return new Point (Width/2, Height/2);
		}
}