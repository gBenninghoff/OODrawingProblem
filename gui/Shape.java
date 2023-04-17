package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author: jonathonwelker
 * 
 * Abstract Class shape creates a framework for any specified shape by creating
 * a storage for its x/y coordinates and its width and height, as well as an abstract method
 * draw() that an inherited shape can implement
 * 
 */
public abstract class Shape {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	/**
	 * @param int x & int y: x and y coordinates of the shape drawn
	 * according tthe location of the mouse on canvas
	 * @param int width & int height: store the langth and width of whatever 
	 * shapes is drawn
	 * @param Color color: store the color of the drawn shape
	 * 
	 * constructor to inilize all variables
	 */
	public Shape(int x, int y, int width, int height, Color color) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	//getters and setters for each variable initialized in the constructor--no javadocs needed
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public abstract void draw(Graphics g);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
