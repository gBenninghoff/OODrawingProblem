package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This is the class to implement the square
 * @author Jon
 *
 */
public class Square extends Shape {

	/**
	 * Sets the parameters of the square
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public Square(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}

}
