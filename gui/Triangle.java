package gui;

import java.awt.*;

/**
 * @author: jonathonwelker
 * 
 * Class Triangle extends shape to allow a user to draw an equilateral or isosceles triangle
 */

public class Triangle extends Shape implements Drawable {

	public Triangle(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);

	}

	/**
	 * @param Graphics g: used to draw triangle
	 * 
	 * allows user to draw triangle using drawPolygon() that specifies the three points 
	 * of a triangle according to the movements of the users computer mouse on canvas
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillPolygon(
				new int[] { ((int) (getX() + 0.5 * (getWidth()))), ((int) (getX() + getWidth())), ((int) (getX())) },
				new int[] { ((int) (getY())), ((int) (getY() + getHeight())), ((int) (getY() + getHeight())) }, 3);
	}

}
