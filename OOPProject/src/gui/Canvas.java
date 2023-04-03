package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private String shape;
	private BufferedImage image;

	private MouseListener ml = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			switch (shape) {
			case "Circle":
				drawCircle(e.getX(), e.getY());
				break;
			case "Square":
				drawSquare(e.getX(), e.getY());
				break;
			case "Triangle":
				drawTriangle(e.getX(), e.getY());
			default:
				break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

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

	public Canvas() {

		super();
		this.setBackground(Color.WHITE);
		this.addMouseListener(ml);
		this.setLayout(null);

	}
	
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.BLACK);
//		g.drawRect(1, 1, this.getWidth()-2, this.getHeight()-2);
//		if(image == null) {
//			image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
//			
//		}
//	}

	
	//here is a comment I would like to commit
	public void setShape(String shape) {
		this.shape = shape;
	}

	public void drawCircle(int x, int y) {
		Graphics g = this.getGraphics();
		g.setColor(Color.red);
		g.drawOval(x-50, y-50, 100, 100);
	}

	public void drawSquare(int x, int y) {
		Graphics g = this.getGraphics();
		g.setColor(Color.red);
		g.drawRect(x-50, y-50, 100, 100);
	}

	public void drawTriangle(int x, int y) {
		Graphics g = this.getGraphics();
		g.setColor(Color.red);
//		g.drawPolygon();
	}

}
