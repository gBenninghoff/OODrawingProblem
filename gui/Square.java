package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author: jonathonwelker
 * 
 * Class Square extends Shape to allow the user to draw a square or rectangle on the canvas
 */
public class Square extends Shape implements Drawable {

	public Square(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);

	}

	/**
	 * @param Graphics g: used to draw sqaure
	 * 
	 * allows user to draw a sqaure/rectangle using fillRect() and the x, y, width, and heigh parameters
	 * from it constructor
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}

}
