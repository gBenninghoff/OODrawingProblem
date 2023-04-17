package gui;

import java.awt.Color;
import java.awt.Graphics;


/**
 * This is the class that defines how the circle is created
 * @author Jon
 *
 */
public class Circle extends Shape {

	/**
	 * This builds the x, y, height, and color from the shape class 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());

	}

}
