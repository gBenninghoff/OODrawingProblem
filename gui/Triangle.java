package gui;

import java.awt.*;

public class Triangle extends Shape {

	public Triangle(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillPolygon(
				new int[] { ((int) (getX() + 0.5 * (getWidth()))), ((int) (getX() + getWidth())), ((int) (getX())) },
				new int[] { ((int) (getY())), ((int) (getY() + getHeight())), ((int) (getY() + getHeight())) }, 3);
	}

}
