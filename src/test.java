import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class represents a canvas on which 40ª40 pixel squares can be drawn.
// The squares are centered around where the user clicks.
public class test extends JPanel implements MouseListener {

	// Keep track of all square center positions
	private Vector squares;

	// Default constructor
	public test() {
		squares = new Vector();
		setBackground(Color.white);
		addMouseListener(this);
	}

	// This is the method that is responsible for displaying the contents of the
	// canvas
	public void paintComponent(Graphics graphics) {
		// Draw the component as before (i.e., default look)
		super.paintComponent(graphics);

		// Now add all of our squares
		graphics.setColor(Color.black);
		Enumeration enumeration = squares.elements();
		while (enumeration.hasMoreElements()) {
			Point center = (Point) (enumeration.nextElement());
			graphics.drawRect(center.x - 20, center.y - 20, 40, 40);
		}
	}

	// These are unused MouseEventHandlers. Note that we could have
	// used an Adapter class here. However, a typical drawing
	// application would make use of these other events as well.
	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseReleased(MouseEvent event) {
	}

	// Store the mouse location when it is pressed
	public void mousePressed(MouseEvent event) {
		squares.add(event.getPoint());
		repaint(); // this will call paintComponent()
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Square Drawing Example");
		frame.getContentPane().add(new test());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}