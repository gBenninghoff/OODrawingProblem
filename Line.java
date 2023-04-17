package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;

/**
 * This is the implementation of the line 
 * @author Jon
 *
 */
public class Line {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	private int strokeSize;

	/**
	 * This constructor sets the initial state of the line
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @param strokeSize
	 */
	public Line(int x1, int y1, int x2, int y2, Color color, int strokeSize) {

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y1;
		this.color = color;
		this.strokeSize = strokeSize;

	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(strokeSize));
		g2.setColor(color);
		g2.drawLine(x1, y1, x2, y2);

	}

}
