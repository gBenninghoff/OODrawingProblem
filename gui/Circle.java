package gui;

import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Shape {

	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());

	}

}
