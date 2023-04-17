package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author: jonathonwelker
 * 
 * Class Circle extends shape to allow a user to draw circle or oval
 */
public class Circle extends Shape implements Drawable {

	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	/**
	 * @param Graphics g: used to draw circle
	 * 
	 * allows user to draw circle using fillOval() with the specified
	 * x/y coordinate and l/w from its constructor
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());

	}

}
