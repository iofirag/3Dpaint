
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
      
        JFrame f = new JFrame("3D shapes");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    } 
}

class MyPanel extends JPanel {
	int hatala = 0;
	//Lists
		static List<Point3D> points;
		static List<Polygon3D> polygons3D ;
		static List<Polygon2D> polygons2D;

    public MyPanel() {
    	this.setBackground(Color.MAGENTA);
    	
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
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(2),points.get(3), points.get(1)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(1),points.get(3),points.get(7), points.get(5)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(4),points.get(6), points.get(2)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(0),points.get(1),points.get(5), points.get(4)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(2),points.get(6),points.get(7), points.get(3)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(4),points.get(5),points.get(7), points.get(6)), Color.RED, Color.RED));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(10),points.get(9),points.get(8)), Color.BLUE, Color.BLUE));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(9),points.get(10),points.get(11)), Color.BLUE, Color.BLUE));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(9),points.get(11)), Color.BLUE, Color.BLUE));
    	polygons3D.add(new Polygon3D(Arrays.asList(points.get(8),points.get(10),points.get(11)), Color.BLUE, Color.BLUE));

    	switch(hatala){
    	case 1:{		//Cavalier
    			polygons2D = new ArrayList<Polygon2D>();
    			int angle = 45;
    			boolean zIndexChosen = false;
    			for (int i=0 ; i<polygons3D.size() ; i++){
    				Polygon2D tmpP = new Polygon2D(polygons3D.get(i).getColor() , polygons3D.get(i).getFillColor());
    				for (int j=0 ; i<polygons3D.get(i).getPoints().size() ; i++){
    					int tmpX = polygons3D.get(i).getPoints().get(j).getX();
    					int tmpY = polygons3D.get(i).getPoints().get(j).getY();
    					int tmpZ = polygons3D.get(i).getPoints().get(j).getZ();
    					//Cavalier
    					tmpX = (int) (tmpX + tmpZ * Math.cos(angle));
    					tmpY = (int) (tmpY + tmpZ * Math.sin(angle));
    					tmpP.getPoints().add(new Point(tmpX,tmpY));
    					
    					if (zIndexChosen==false){
    					tmpP.zIndex = tmpZ;
    					zIndexChosen = true;
    					}
    				}
					polygons2D.add(new Polygon2D(tmpP.getPoints(), tmpP.getColor(), tmpP.getFillColor(), tmpP.zIndex));
    				zIndexChosen = false;
    			}
    		}
    	case 2: {
    		
    	}
    	case 3:{
    		
    	}
    	}
    	
    	// Mouse listeners
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
               
            }
        });
        
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(900,500);
    }
    
    //All paint actions will be performed from this function
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        
        /*int[] xPoints = {100,50,15,470};
        int[] yPoints = {100,200,200,140};
        g.setColor(Color.RED);
        g.drawPolygon(xPoints, yPoints, 4);
        g.setColor(Color.ORANGE);
        g.fillPolygon(xPoints, yPoints, 4);*/
        
    }  
}