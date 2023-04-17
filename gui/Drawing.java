package gui;
import java.awt.*;
import java.util.*;

/**
 * @author: jonathonwelker
 * 
 * Class Drawing enables a user to draw using a pen on the Class canvas
 * by collecting x/y coordinates as the user drags the mouse and drawing 
 * a bunch of lines between them
 */
public class Drawing implements Drawable {

	private ArrayList<Point> pointList;
	private Color color;
	private int strokeSize;
	
	/**
	 * @param Color color: color of the line
	 * @param int strokeSize: thickness of the drawing
	 * 
	 * constructor that initializes the arrayList of points and stores
	 * the stroke size and color of the lines
	 */
	public Drawing(Color color, int strokeSize) {
		
		pointList = new ArrayList<Point>();
		this.color = color;
		this.strokeSize = strokeSize;
	}
	
	/**
	 * @param Point point: a point to be added to the arraylist
	 * 
	 * collects another point for another line to be drawn
	 */
	public void addPoint(Point newPoint) {
		
		pointList.add(newPoint);
		
	}
	
	/**
	 * @param Graphics g: used to draw pen drawing
	 * 
	 * cast graphics to graphics2D so that the user can draw the lines,
	 * connect all the points in the arrayList collection and utilizing the 
	 * corresponding stroke size and color
	 */
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g; //g2 allows stroke size conbfiguration
		g2.setStroke(new BasicStroke(strokeSize));
		g2.setColor(color);
		
		if (pointList.size() > 1) {
			
			for (int i = 1; i < pointList.size(); i++) {
				g2.drawLine(((int) pointList.get(i-1).getX()), ((int) pointList.get(i-1).getY()), ((int) pointList.get(i).getX()), ((int) pointList.get(i).getY()));
			}
			
		}
		
	}
	
}
