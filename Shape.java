package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This abstract class sets the main components used in every shape
 * @author Jon
 *
 */
public abstract class Shape {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	/**
	 * This constructor sets the default of every shape with the x,y,height, and color
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public Shape(int x, int y, int width, int height, Color color) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	/**
	 * To get the current x value
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * To set a new x value
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the current y
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set a new y value
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * This gets the current set width of the shape
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * This is to set the current width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * This is used to get the current set height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * This is to set the height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * This is the abstract class that will be used to 
	 * @param g
	 */
	public abstract void draw(Graphics g);

	/**
	 * This is to get the current color
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * This is to change the current color set
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
