/*Graphics programming , exercise 3.
 * Created by Ofir Aghai and Vidran Abdovich
 * Date : 11/7/2014
 */

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Polygon2D{
	private List<Point> points;
	private Color color;
	private Color fillColor;
	int zIndex;
	
	public Polygon2D(List<Point> points, Color color, Color fillColor, int zIndex) {
		super();
		this.points = points;
		this.color = color;
		this.fillColor = fillColor;
		this.zIndex = zIndex;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
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

	public int getzIndex() {
		return zIndex;
	}

	public void setzIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	public Polygon2D(Color color, Color fillColor) {
		super();
		this.color = color;
		this.fillColor = fillColor;
		this.points = new ArrayList<Point>();
	}

	public int[] getXarray() {
		int x[] = new int[this.points.size()];
		for (int i=0; i<points.size(); i++){
			x[i] = (int) points.get(i).getX();		
		}
		return x;
	}

	public int[] getYarray() {
		int y[] = new int[this.points.size()];
		for (int i=0; i<points.size(); i++){
			y[i] = (int) points.get(i).getY();		
		}
		return y;
	}


	
	

}
