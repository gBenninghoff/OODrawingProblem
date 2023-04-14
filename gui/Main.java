package gui;

import java.awt.Color;

import javax.swing.JPanel;

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
