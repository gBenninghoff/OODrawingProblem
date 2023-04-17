package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")

/**
 * @author jonathonwelker
 * The canvas class extends JPanel to create a drawing pane,
 * along with methods and mouse listeners to receive input from the toolbox
 * and draw a specified figure onto the pane
 */

public class Canvas extends JPanel {

	private String figure = "Draw";
	private ArrayList<Object> figureList = new ArrayList<Object>();
	private Shape currShape;
	private Line currLine;
	private Drawing currDraw;
	private int centerX;
	private int centerY;
	private Color color;
	private int index = -1;
	private int strokeSize;

	private MouseListener mouseListener = new MouseListener() {
		

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}
		
		/**
		 * @param MouseEvent e: event that represents the release of the mouse
		 * 
		 * Sets the currLine, currShape, and currDraw to null once the mouse is released
		 * from drawing whatever figure it was drawing
		 * 
		 * This is to make space for a new current figure that will initialize when the mouse 
		 * is dragged
		 */

		@Override
		public void mouseReleased(MouseEvent e) {

			currLine = null;
			currShape = null;
			currDraw = null;

		}
		
		/**
		 * @param MouseEvent e: event that represents the entering of the mouse onto canvas
		 * 
		 * sets cursor to crosshair once this happens
		 */

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		
		/**
		 * @param MouseEvent e: event that represents the exit of the mouse from canvas
		 * 
		 * reverts to default mouse
		 */

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

	};

	MouseMotionListener mouseMotionListener = new MouseMotionListener() {

		
		/**
		 * @param MouseEvent e: event that represents the mouse being clicked
		 * and dragged across the canvas
		 * 
		 * Mouse dragged will either initialize whatever shape is set (by the the buttons from class
		 * toolbox), or manipulate the dimensions of the shape based on the direction of the mouse
		 */
		
		@Override
		public void mouseDragged(MouseEvent e) {

			if (figure != null) { //if no shape has been selected, then initialize shape

				if (currShape == null && currLine == null && currDraw == null) {

					centerX = e.getX();
					centerY = e.getY();

					index++;

					switch (figure) {

					case "Circle":

						currShape = new Circle(centerX, centerY, 1, 1, getColor());
						figureList.add(currShape);
						break;

					case "Square":

						currShape = new Square(centerX, centerY, 1, 1, getColor());
						figureList.add(currShape);
						break;

					case "Triangle":

						currShape = new Triangle(centerX, centerY, 1, 1, getColor());
						figureList.add(currShape);
						break;

					case "Line":

						currLine = new Line(centerX, centerY, e.getX(), e.getY(), getColor(), getStrokeSize());
						figureList.add(currLine);
						break;

					case "Draw":

						currDraw = new Drawing(getColor(), getStrokeSize());
						Point newPoint = new Point(centerX, centerY);
						figureList.add(currDraw);
						currDraw.addPoint(newPoint);
						break;

					}

				} else { //if a shape has already been initialized

					if (figure.equals("Circle") || figure.equals("Square")) {

						int height = Math.abs(centerY - e.getY());
						int width = Math.abs(centerX - e.getX());
						int x;
						int y;

						if (e.getX() < centerX && e.getY() < centerY) { //mouse moving northwest

							x = e.getX();
							y = e.getY();

						} else if (e.getX() < centerX && e.getY() > centerY) { //southwest

							x = e.getX();
							y = e.getY() - height;

						} else if (e.getX() > centerX && e.getY() < centerY) { //northeast

							x = centerX;
							y = centerY - height;

						} else { //southeast

							x = centerX;
							y = centerY;

						}

						currShape.setHeight(height);
						currShape.setWidth(width);
						currShape.setX(x);
						currShape.setY(y);

					} else if (figure.equals("Triangle")) {

						int width;
						int height;

						width = e.getX() - centerX;
						height = e.getY() - centerY;

						currShape.setHeight(height);
						currShape.setWidth(width);

					}

					else if (figure.equals("Line")) {

						currLine.setX2(e.getX());
						currLine.setY2(e.getY());

					} else {

						Point newPoint = new Point(e.getX(), e.getY());
						currDraw.addPoint(new Point(newPoint));

					}
				}

				repaint();
			}

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	};

	/**
	 * @param String figure: a string that represents the state of the figure
	 * 
	 * sets state of String variable figure to draw, triangle, square, circle, or line, or will 
	 * throw an error if receives another input
	 */
	public void setFigure(String figure) {
		if (figure.equals("Draw") || figure.equals("Square") || figure.equals("Triangle") || figure.equals("Line")
				|| figure.equals("Circle")) {
			this.figure = figure;
		} else {
			throw new RuntimeException("Invalid Figure");
		}
	}

	/**
	 * clears the canvas by clearing the stack of figures, and repainting nothing
	 */
	public void clear() {
		figureList.clear();
		repaint();
		index = -1;
	}

	/**
	 * "pops" the top figure off of the figure stack and repainting, thus undoing the most
	 * previous figure drawn
	 */
	public void undo() {

		try {
			figureList.remove(index);
			index--;
			repaint();
		} catch (Exception e) {
			JFrame warningFrame = new JFrame();
			warningFrame.setBounds(100, 100, 225, 50);
			JLabel warningLabel = new JLabel("CANNOT UNDO: No Shapes Added");
			warningLabel.setBounds(50, 0, 200, 45);
			warningFrame.add(warningLabel);
			warningFrame.setVisible(true);
		}
	}

	/**
	 * @return Color
	 * 
	 * returns current color of the canvas variable color, used to color figures being drawn
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param Color color
	 * 
	 * sets the state of the color varibale color, using the input parameter
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * overloads setColor by having a signature w/out parameters, which allows you
	 * to choose a color using a jcolorchooser
	 */
	public void setColor() {
		this.color = JColorChooser.showDialog(null, "Pick Color", Color.BLACK);
	}

	/**
	 * @return int
	 * 
	 * returns the stroke size set by the toolbox
	 */
	public int getStrokeSize() {
		return strokeSize;
	}

	/**
	 * @param int strokeSize
	 * 
	 * uses the int parameter to set the variable strokesize
	 */
	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	/**
	 * saves the canvas and all its drawings onto a buffered image that is exported
	 * as a png using jfilechooser
	 */
	public void saveImage() {

		BufferedImage imageExport = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = imageExport.getGraphics();
		this.paint(g);

		JFileChooser fileChooser = new JFileChooser();

		int saveValue = fileChooser.showSaveDialog(null);

		if (saveValue == JFileChooser.APPROVE_OPTION) {

			try {
				ImageIO.write(imageExport, "png", fileChooser.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * @param Graphics g: used to draw specified figure
	 * 
	 * draws a specified shape using graphics input as well as the shapes draw method
	 */
	@Override
	protected void paintComponent(Graphics g) {

		// for (Drawable d: figureList)

		for (Object obj : figureList) {
			if (obj instanceof Shape) {
				((Shape) obj).draw(g);
			} else if (obj instanceof Line) {
				((Line) obj).draw(g);
			} else {
				((Drawing) obj).draw(g);
			}

		}
	}

	public Canvas() {

		super();
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.addMouseMotionListener(mouseMotionListener);
		this.addMouseListener(mouseListener);

	}

}
