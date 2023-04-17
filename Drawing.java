package gui;
import java.awt.*;
import java.util.*;

/**
 * This class is used to define what happens when the user wants to free draw
 * @author Jon
 */
public class Drawing {

	private ArrayList<Point> pointList;
	private Color color;
	private int strokeSize;
	
	/**
	 * This constructor is used to set the initial state of the drawing 
	 * @param color
	 * @param strokeSize
	 */
	public Drawing(Color color, int strokeSize) {
		
		pointList = new ArrayList<Point>();
		this.color = color;
		this.strokeSize = strokeSize;
	}
	
	/**
	 * The addPoint method adds a new point to the list of points 
	 * @param newPoint
	 */
	public void addPoint(Point newPoint) {
		
		pointList.add(newPoint);
		
	}
	
	
	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(strokeSize));
		g2.setColor(color);
		
		if (pointList.size() > 1) {
			
			for (int i = 1; i < pointList.size(); i++) {
				g2.drawLine(((int) pointList.get(i-1).getX()), ((int) pointList.get(i-1).getY()), ((int) pointList.get(i).getX()), ((int) pointList.get(i).getY()));
			}
			
		}
		
	}
	
}
