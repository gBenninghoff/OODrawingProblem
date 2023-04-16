package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
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

		@Override
		public void mouseReleased(MouseEvent e) {

			currLine = null;
			currShape = null;
			currDraw = null;

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

	MouseMotionListener mouseMotionListener = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent e) {

			if (figure != null) {

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
				} else {

					if (figure.equals("Circle") || figure.equals("Square")) {

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

	public void setFigure(String figure) {
		this.figure = figure;
	}

	public void clear() {
		figureList.clear();
		repaint();
		index = -1;
	}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor() {
		this.color = JColorChooser.showDialog(null, "Pick Color", Color.BLACK);
	}

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}
	
	public void saveImage() throws IOException {

		String type = "png";

		BufferedImage imageExport = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = imageExport.getGraphics();
		this.paint(g);
		String path = "/Users/jonathonwelker/desktop/picture." + type;

		ImageIO.write(imageExport, type, new File(path));
	}

	@Override
	protected void paintComponent(Graphics g) {
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
