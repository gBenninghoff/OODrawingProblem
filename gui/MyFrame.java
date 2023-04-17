package gui;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")

/**
 * @author: jonathonwelker
 * 
 * Class MyFrame extends JFrame to create a customized frame with 
 * an overlaid panel to effectively allow programmer to 
 * add multiple components to the frame
 */
public class MyFrame extends JFrame { // Main Frame
	
	private JPanel mainPanel = new JPanel();

	public MyFrame(String title) {
		
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setLayout(null);
		
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 1000, 1000);
		
		this.add(mainPanel);
		this.setVisible(true);
		
	}
	
	/**
	 * @param Component comp
	 * 
	 * adds a component to the panel sitting on top of the frame
	 */
	public void addComponent(Component comp) {
		mainPanel.add(comp);
	}
	
	
}
