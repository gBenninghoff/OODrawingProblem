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
	private int strokeSize = 1;

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	public Toolbox(Canvas canvas) {

		super();
		this.canvas = canvas;
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setOpaque(true);

		JButton squareButton = new JButton("Square");
		squareButton.setBounds(10, 10, 100, 100);
		squareButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		squareButton.setVisible(true);

		JButton lineButton = new JButton("Line");
		lineButton.setBounds(10, 110, 100, 100);
		lineButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton circleButton = new JButton("Circle");
		circleButton.setBounds(110, 110, 100, 100);
		circleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton triangleButton = new JButton("Triangle");
		triangleButton.setBounds(110, 10, 100, 100);
		triangleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(10, 210, 150, 40);
		undoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 9));

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(160, 210, 150, 40);
		clearButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 9));

		JButton colorButton = new JButton("Pick Custom Color");
		colorButton.setBounds(570, 218, 330, 35);
		colorButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton drawButton = new JButton("Draw");
		drawButton.setBounds(210, 10, 100, 100);
		drawButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(210, 110, 100, 100);
		saveButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setOpaque(true);
		blueButton.setBounds(685, 10, 100, 100);
		blueButton.setBorderPainted(false);

		JButton redButton = new JButton();
		redButton.setBackground(Color.RED);
		redButton.setOpaque(true);
		redButton.setBounds(580, 10, 100, 100);
		redButton.setBorderPainted(false);

		JButton greenButton = new JButton();
		greenButton.setBackground(Color.GREEN);
		greenButton.setOpaque(true);
		greenButton.setBounds(790, 10, 100, 100);
		greenButton.setBorderPainted(false);
		
		JButton purpleButton = new JButton();
		purpleButton.setBackground(Color.PINK);
		purpleButton.setOpaque(true);
		purpleButton.setBounds(580, 115, 100, 100);
		purpleButton.setBorderPainted(false);
		
		JButton orangeButton = new JButton();
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setOpaque(true);
		orangeButton.setBounds(685, 115, 100, 100);
		orangeButton.setBorderPainted(false);

		JButton yellowButton = new JButton();
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setOpaque(true);
		yellowButton.setBounds(790, 115, 100, 100);
		yellowButton.setBorderPainted(false);

		JLabel label = new JLabel();
		label.setLayout(null);
		label.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));
		label.setText("Stroke Size (px): " + getStrokeSize());
		label.setBounds(420, 83, 100, 50);

		JButton upButton = new JButton("Up");
		upButton.setBounds(365, 60, 50, 50);
		upButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton downButton = new JButton("Down");
		downButton.setBounds(365, 110, 50, 50);
		downButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		this.add(squareButton);
		this.add(lineButton);
		this.add(circleButton);
		this.add(triangleButton);
		this.add(undoButton);
		this.add(clearButton);
		this.add(saveButton);
		this.add(colorButton);
		this.add(blueButton);
		this.add(redButton);
		this.add(greenButton);
		this.add(yellowButton);
		this.add(purpleButton);
		this.add(orangeButton);
		this.add(drawButton);
		this.add(label);
		this.add(upButton);
		this.add(downButton);

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == undoButton) {
					canvas.undo();
				} else if (e.getSource() == clearButton) {
					canvas.clear();
				} else if (e.getSource() == colorButton) {
					canvas.setColor(JColorChooser.showDialog(null, "Pick Color", Color.BLACK));
				} else if (e.getSource() == saveButton) {
					canvas.saveImage("drawing");
				} else if (e.getSource() == upButton) {
					setStrokeSize(getStrokeSize() + 1);
					label.setText("Stroke Size (px): " + getStrokeSize());
					canvas.setStrokeSize(getStrokeSize());
				} else if (e.getSource() == downButton) {
					if (getStrokeSize() - 1 < 1) {
						JFrame warningFrame = new JFrame();
						warningFrame.setBounds(100, 100, 210, 50);
						JLabel warningLabel = new JLabel("STROKE SIZE CANNOT BE 0 px");
						warningLabel.setBounds(0, 0, 200, 45);
						warningFrame.add(warningLabel);
						warningFrame.setVisible(true);
					} else {
						setStrokeSize(getStrokeSize() - 1);
						label.setText("Stroke Size (px): " + getStrokeSize());
						canvas.setStrokeSize(getStrokeSize());
					}
				} else if (e.getSource() == purpleButton) {
					canvas.setColor(purpleButton.getBackground());
				} else if (e.getSource() == yellowButton) {
					canvas.setColor(yellowButton.getBackground());
				} else if (e.getSource() == blueButton) {
					canvas.setColor(blueButton.getBackground());
				} else if (e.getSource() == greenButton) {
					canvas.setColor(greenButton.getBackground());
				} else if (e.getSource() == orangeButton) {
					canvas.setColor(orangeButton.getBackground());
				} else if (e.getSource() == redButton) {
					canvas.setColor(redButton.getBackground());
				}
				else {
					canvas.setShape(((JButton) e.getSource()).getText());
				}

			}

		};

		circleButton.addActionListener(al);
		squareButton.addActionListener(al);
		triangleButton.addActionListener(al);
		lineButton.addActionListener(al);
		undoButton.addActionListener(al);
		clearButton.addActionListener(al);
		colorButton.addActionListener(al);
		drawButton.addActionListener(al);
		saveButton.addActionListener(al);
		upButton.addActionListener(al);
		downButton.addActionListener(al);
		blueButton.addActionListener(al);
		yellowButton.addActionListener(al);
		redButton.addActionListener(al);
		greenButton.addActionListener(al);
		purpleButton.addActionListener(al);
		orangeButton.addActionListener(al);

	}

}