/*This application was created by Ofir Aghai & Vidran Abdovich , 22/4/2014
 * as part of a Graphics programming course.
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

import Jama.Matrix;

public class main {
	// Window size
	static final int WIDTH = 900; // x
	static final int HEIGHT = 500; // y

	// panel
	static myJPanel pane;
	
	// Mouse variables
	static Point pointPressed = null;
	static Point pointRelease = null;
	static int lastDrag_x = 0;
	static int lastDrag_y = 0;
	static Point currMousePoint= null; 
//	static boolean MouseExitFromWindow = false;

	// item & color user choose
	static int itemChecked = 1; // Transforms:
								// 5= Shift
								// 6= Scale
								// 7= Rotating
								// 8= Mirroring
								// 9= Cut


	public static void main(String[] args) {
		// see all the properties in java
		System.getProperties().list(System.out);

		/* java window - the container managed the frame */
		JFrame frame = new JFrame("Direct draw demo");

		/* specific frame */
		pane = new myJPanel(WIDTH, HEIGHT);

		// ******************************************************************

		frame.add(pane);
		// to show at least the panel data
		frame.pack();
		/* Resizability */
		frame.setResizable(true);
		/* close all app in close button */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		// File Menu

		
		// Transforms
		JMenu transformsMenu = new JMenu("Transforms");
		JMenuItem transTranslation = new JMenuItem("Translation"); 
		transTranslation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 5;
			}
		});
		JMenuItem transScaling = new JMenuItem("Scaling"); 
		transScaling.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 6;
			}
		});
		JMenuItem transRotation = new JMenuItem("Rotation"); 
		transRotation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 7;
			}
		});

		JMenu transMirror = new JMenu("Mirror"); 
		JMenuItem transMirrorX = new JMenuItem("Mirror X");
		transMirrorX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 9;
			}
		});
		JMenuItem transMirrorY = new JMenuItem("Mirror Y");
		transMirrorY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 10;
			}
		});
		JMenuItem transMirrorXY = new JMenuItem("Mirror XY");
		transMirrorXY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemChecked = 11;

			}
		});
		transMirror.add(transMirrorX);
		transMirror.add(transMirrorY);
		transMirror.add(transMirrorXY);
		
		// ************************************************
		
		
		transformsMenu.add(transTranslation);
		transformsMenu.add(transScaling);
		transformsMenu.add(transRotation);
		transformsMenu.add(transMirror);

		// ************************************************

		// Help
		JMenu helpMenu = new JMenu("Help");
		JMenuItem instructions = new JMenuItem("Instructions");
		instructions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Instructions:\n\n" +
						"Opening file:\n" +
						"   open 'boat.txt' from 'pictures' directory.\n\n\n" +
						"" +
						"Transforming:\n" +
						"" +
						"   Translation-\n" +
						"   click with mouse and drag it.\n\n" +
						"" +
						"   Scaling-\n" +
						"   Use with mouse wheel for zoom-in and zoom-out.\n\n" +
						"" +
						"   Rotation-\n" +
						"   Use with mouse wheel for rotate+20 and rotate-20.\n\n" +
						"" +
						"   Shearing X or Y-\n" +
						"   Use with mouse wheel for shearing over X or Y.\n\n" +
						"");
			}
		});
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "About:\n\n" +
						"Ofir Aghai\n" +
						"Vidran Abdovich\n\n" +
						"" +
						"have fun!");
			}
		});
		helpMenu.add(instructions);
		helpMenu.add(about);

		// *********************************************


		menuBar.add(transformsMenu);
		menuBar.add(helpMenu);

		pane.setLayout(new BorderLayout());
		frame.add(menuBar, BorderLayout.NORTH);
		/** End menu's *******************************************************/

		// visibility
		frame.setVisible(true);

		// Mouse Listeners
		frame.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				switch (itemChecked) {
				case 6: // Scaling 
					break;
				case 7: // rotate
					break;
				case 12:	//shearing X
					break;
				case 13:	//shearing Y
					break;
				}
			}
		});
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				pointRelease = new Point(e.getPoint().x - 8,
						e.getPoint().y - 53);
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				pointPressed = new Point(e.getPoint().x - 8,
						e.getPoint().y - 53);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// MouseExitFromWindow=true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// MouseExitFromWindow=false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		// mouse motion
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				currMousePoint = new Point(e.getX()-8, e.getY()-53);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				lastDrag_x = (int) e.getPoint().getX() - 8; // Fix
				lastDrag_y = (int) e.getPoint().getY() - 53; // Fix

				// Shift transformation
				switch (itemChecked) {
				case 5:
					int dragDx = lastDrag_x - pointPressed.x;
					int dragDy = lastDrag_y - pointPressed.y;
					pointPressed.x = lastDrag_x;
					pointPressed.y = lastDrag_y;
				}
			}
		});
		
		//****************************************************************************************************************
		
		Polygon

	}

	public static Point getImageCenter() {
		return new Point (WIDTH/2, HEIGHT/2);
	}
}