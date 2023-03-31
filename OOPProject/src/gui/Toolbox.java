package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class Toolbox extends JPanel {
	
	@SuppressWarnings("unused")
	private String shape;
	@SuppressWarnings("unused")
	private Canvas canvas;

	public Toolbox(Canvas canvas) {
	
		super();
		this.canvas = canvas;
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		
		JButton squareButton = new JButton("Square");
		squareButton.setBounds(10, 10, 100, 100);
		squareButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		
		
		JButton drawButton = new JButton("Draw");
		drawButton.setBounds(10, 110, 100, 100);
		drawButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		
		JButton circleButton = new JButton("Circle");
		circleButton.setBounds(110, 110, 100, 100);
		circleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
	
		
		JButton triangleButton = new JButton("Triangle");
		triangleButton.setBounds(110, 10, 100, 100);
		triangleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		
		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(12, 210, 99, 40);
		undoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 9));
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(112, 210, 99, 40);
		clearButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 9));
		
		
		
		this.add(squareButton);
		this.add(drawButton);
		this.add(circleButton);
		this.add(triangleButton);
		this.add(undoButton);
		this.add(clearButton);
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JColorChooser chooser = new JColorChooser();
				@SuppressWarnings("static-access")
				Color color = chooser.showDialog(null, "Color", Color.BLACK);
				
				
				canvas.setShape(((JButton) e.getSource()).getText());
				canvas.setColor(color);
				
			}
			
		};
		
		circleButton.addActionListener(al);
		squareButton.addActionListener(al);
		triangleButton.addActionListener(al);

	}
	
}