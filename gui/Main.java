package gui;
//Jonathan Welker; Gabe Benninghoff | April 17, 2023
//This project was meant to create a paint application GUI that allows
//a user to draw and save different kinds of shapes
// All code in this project is entirely original | Jon Welker

import java.awt.Color;


import javax.swing.JPanel;

/**
 * @author: jonathonwelker
 * 
 * Class Main initializes canvas and toolbox onto a customized jframe (myframe)
 */

public class Main {
	
	public static void main(String[] args) {
	
	MyFrame frame = new MyFrame("Paint App GUI");
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(100, 285, 800, 520);
	panel.setOpaque(true);
	
	Canvas canvas = new Canvas();
	canvas.setBounds(100, 285, 800, 520);
	
	Toolbox toolbox = new Toolbox(canvas);
	toolbox.setBounds(50, 10, 900, 260);
	
	
	frame.addComponent(panel);
	frame.addComponent(canvas);
	frame.addComponent(toolbox);
	}
	

}
