package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;


/**
 * @author: jonathonwelker
 * 
 * Class Line creates allows a user to draw a straight line
 * using two x/y coordinates that are received by the constructor
 */
public class Line implements Drawable{

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	private int strokeSize;

	/**
	 * @param int x1, int y1, int x2, int y2 serve as the pair of x/y coordinates by which the
	 * line is drawn
	 * @param Color color: specifies color of the line
	 * @param int strokeSize: thickness of the line
	 * 
	 * constructor that initializes its parameter values
	 */
	public Line(int x1, int y1, int x2, int y2, Color color, int strokeSize) {

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y1;
		this.color = color;
		this.strokeSize = strokeSize;

	}

	//getters and setters for each variable initialized by constructor
	
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
	 * @param Graphics g: used to draw line
	 * 
	 * allows user to draw a line using the paramters set by the constuctor or
	 * modified with the getters and setters
	 */
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(strokeSize));
		g2.setColor(color);
		g2.drawLine(x1, y1, x2, y2);

	}

}
