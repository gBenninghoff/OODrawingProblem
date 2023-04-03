package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private String shape;
	private BufferedImage image;
	private Color color;


	private MouseListener ml = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			switch (shape) {
			case "Circle":
					Circle circle = new Circle(e.getX()-50, e.getY()-50, 100, 100);
//					circle.draw(getGraphics(), color);
					//stack.
					break;
			case "Square":
					Square square = new Square(e.getX()-50, e.getY()-50, 100, 100);
//					square.draw(getGraphics(), color);
					break;
			case "Triangle":
					
			default:
				break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {

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

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Shape s : shapes) {
			s.draw(g, color);
		}
		
	}

}//comment 3?
