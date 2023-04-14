package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	public Square(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}

}
