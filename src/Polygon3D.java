import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Polygon3D {
	private List<Point3D> points;
	private Point3D vectorN;		//Normal Vector
	private boolean vectorV;   //Visibility = vectorN * vectorV
	private Color color;
	private Color fillColor;
	
	//Constructor
	public Polygon3D(List<Point3D> p, Color c, Color fc) {
	this.points = p;
	this.color = c;
	this.fillColor = fc;
	//After initializing the parameters, calculate the Normal Vector
	vectorN = calculateNormal();
	// Then calculate visibility
	vectorV = calculateVisibility();
	}
	
	
	
	
	public List<Point3D> getPoints() {
		return points;
	}
	public void setPoints(List<Point3D> points) {
		this.points = points;
	}
	public Point3D getVectorN() {
		return vectorN;
	}
	public void setVectorN(Point3D vectorN) {
		this.vectorN = vectorN;
	}
	public boolean isVectorV() {
		return vectorV;
	}
	public void setVectorV(boolean vectorV) {
		this.vectorV = vectorV;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	
	private boolean calculateVisibility() {
		// VectorNormal * (P0.x, P0.y , P0,z -1000 ) 
		int scalarResult = (vectorN.getX() * points.get(0).getX()) + (vectorN.getY() * points.get(0).getY()) + (vectorN.getZ() * (points.get(0).getZ()+1000));
		if (scalarResult>0)
			return true;
		else
		return false;
	}
	private Point3D calculateNormal() {
		// (X2-X1, Y2-Y1, Z2-Z1)  x  (X3-X2, Y3-Y2, Z3-Z2) = (x , y , z)
		int normalVectorLeftSegment[] = {points.get(1).getX() - points.get(0).getX(),
										 points.get(1).getY() - points.get(0).getY(),
										 points.get(1).getZ() - points.get(0).getZ()};
		
		int normalVectorRightSegment[] = {points.get(2).getX() - points.get(1).getX(),
										  points.get(2).getY() - points.get(1).getY(),
										  points.get(2).getZ() - points.get(1).getZ()};
		
		Point3D normalPoint = new Point3D(normalVectorLeftSegment[1] * normalVectorRightSegment[2] - normalVectorLeftSegment[2] * normalVectorRightSegment[1],
										  normalVectorLeftSegment[2] * normalVectorRightSegment[0] - normalVectorLeftSegment[0] * normalVectorRightSegment[2],
										  normalVectorLeftSegment[0] * normalVectorRightSegment[1] - normalVectorLeftSegment[1] * normalVectorRightSegment[0]);

		return normalPoint;
	}
	
}
