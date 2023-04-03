package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int x;
	private int y;
	private int width;
	private int height;

	public Square(int x, int y, int width, int height) {

		super(x, y, width, height);

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g, Color color) {

		g.drawRect(x, y, width, height);
		g.setColor(color);

	}

}
