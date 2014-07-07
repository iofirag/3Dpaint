/*This application was created by Ofir Aghai & Vidran Abdovich , 22/4/2014
 * as part of a Graphics programming course.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Jama.Matrix;

public class myJPanelOLD extends JPanel {
	private BufferedImage canvas;

	// Max values can draw on canvas
    int MAX_DRAW_X = 0;
    int MAX_DRAW_Y = 0;

	public myJPanelOLD(int width, int height) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		// using auto the function getPreferredSize() so we don't call it
		MAX_DRAW_X = canvas.getWidth()-1;		//fix
	    MAX_DRAW_Y = canvas.getHeight()-24;		//fix
	    fillCanvas();
	}

	// *******override***********************************************
	/* open the pane in the size we want */
	public Dimension getPreferredSize() {
		return new Dimension(canvas.getWidth(), canvas.getHeight());
	}

	/* draw on the pane (NEEDED) */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(canvas, null, null);
	}

	// ********************************************************

	public void fillCanvas() {
		
		repaint();
	}


	/* getter & setter */
	public BufferedImage getCanvas() {
		return canvas;
	}
	public void setCanvas(BufferedImage canvas) {
		this.canvas = canvas;
	}

}