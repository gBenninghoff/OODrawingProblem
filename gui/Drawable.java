package gui;

import java.awt.Graphics;

/**
 * @author: jonathonwelker
 * 
 * Interface Drawable is an experimental interface that binds classes
 * drawing, triangle, square, circle, and line together so that canvas can have a 
 * ArrayList stack of class drawing, which allows paintcomponent() to simply draw every
 * component on the arrayList instead of using instance of, which is considered a 
 * poor coding pratice
 */
public interface Drawable {

	public void draw(Graphics g);
	//draws the figure using graphics class
	
}
