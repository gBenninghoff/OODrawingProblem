package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private String shape = "Draw";
	private ArrayList<Object> shapeList = new ArrayList<Object>();
	private Shape currShape;
	private Line currLine;
	private Drawing currDraw;
	private int centerX;
	private int centerY;
	private Color color;
	private int index = -1;
	private int strokeSize;

	private MouseListener ml = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			currLine = null;
			currShape = null;
			currDraw = null;
			index++;

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

	};

	MouseMotionListener mml = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent e) {

			if (shape != null) {

				if (currShape == null && currLine == null && currDraw == null) {

					centerX = e.getX();
					centerY = e.getY();

					switch (shape) {

					case "Circle":

						currShape = new Circle(centerX, centerY, 1, 1, getColor());
						shapeList.add(currShape);
						break;

					case "Square":

						currShape = new Square(centerX, centerY, 1, 1, getColor());
						shapeList.add(currShape);
						break;

					case "Triangle":

						currShape = new Triangle(centerX, centerY, 1, 1, getColor());
						shapeList.add(currShape);
						break;

					case "Line":

						currLine = new Line(centerX, centerY, e.getX(), e.getY(), getColor(), getStrokeSize());
						shapeList.add(currLine);
						break;

					case "Draw":

						currDraw = new Drawing(getColor(), getStrokeSize());
						Point newPoint = new Point(centerX, centerY);
						shapeList.add(currDraw);
						currDraw.addPoint(newPoint);
						break;

					default:
						// Nothing needs to happen here

					}
				} else {

					if (shape.equals("Circle") || shape.equals("Square")) {

						int height = Math.abs(centerY - e.getY());
						int width = Math.abs(centerX - e.getX());
						int x;
						int y;

						if (e.getX() < centerX && e.getY() < centerY) {

							x = e.getX();
							y = e.getY();

						} else if (e.getX() < centerX && e.getY() > centerY) {

							x = e.getX();
							y = e.getY() - height;

						} else if (e.getX() > centerX && e.getY() < centerY) {

							x = centerX;
							y = centerY - height;

						} else {

							x = centerX;
							y = centerY;

						}

						currShape.setHeight(height);
						currShape.setWidth(width);
						currShape.setX(x);
						currShape.setY(y);

					} else if (shape.equals("Triangle")) {

						int width;
						int height;

						width = e.getX() - centerX;
						height = e.getY() - centerY;

						currShape.setHeight(height);
						currShape.setWidth(width);

					}

					else if (shape.equals("Line")) {

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

	public void setShape(String shape) {
		this.shape = shape;
	}

	public void clear() {
		shapeList.clear();
		repaint();
		index = -1;
	}

	public void undo() {

		if (index == -1) {
			JFrame warningFrame = new JFrame();
			warningFrame.setBounds(100, 100, 225, 50);
			JLabel warningLabel = new JLabel("CANNOT UNDO: No Shapes Added");
			warningLabel.setBounds(50, 0, 200, 45);
			warningFrame.add(warningLabel);
			warningFrame.setVisible(true);
		} else {
			shapeList.remove(index);
			index--;
			repaint();
		}

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	public void saveImage(String name) {

		String type = "png";

		BufferedImage imageExport = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = imageExport.getGraphics();
		this.paint(g);
		String path = "/Users/jonathonwelker/desktop/picture." + type;

		try {
			ImageIO.write(imageExport, type, new File(path));
		} catch (Exception e) {
			JFrame warningFrame = new JFrame();
			warningFrame.setBounds(100, 100, 225, 50);
			JLabel warningLabel = new JLabel("Error Exporting File");
			warningLabel.setBounds(50, 0, 200, 45);
			warningFrame.add(warningLabel);
			warningFrame.setVisible(true);
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (Object obj : shapeList) {
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
		this.addMouseMotionListener(mml);
		this.addMouseListener(ml);

	}

}
