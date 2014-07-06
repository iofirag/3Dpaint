import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Poligon {
	private List<Point> points;
	private Point vectorN;
	private boolean vectorV;   //vectorN * vectorV
	private Color color;
	
public Poligon(List<Point> p, Color c) {
this.points = p;
this.color = c;

}
}
