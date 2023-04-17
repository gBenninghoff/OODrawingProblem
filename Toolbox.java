package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * This class defines all the buttons and anything else inside of the panel that will only have buttons inside of it
 * @author jon
 *
 */
@SuppressWarnings("serial")
public class Toolbox extends JPanel {

	@SuppressWarnings("unused")
	private String shape;
	@SuppressWarnings("unused")
	private Canvas canvas;
	private int strokeSize = 1;

	/**
	 * This is to get the stroke size if changed by the user
	 * @return strokeSize
	 */
	public int getStrokeSize() {
		return strokeSize;
	}

	/**
	 * This is to set the stroke size 
	 * @param strokeSize
	 */
	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	/**
	 * This is used to define the toolbox and includes the following buttons:
	 * square button, line button, circle button, triangle button, undo button, 
	 * clear button, color button, draw button, save button, the color blue button,
	 * the color red button, the color green button, purple  button, orange button, 
	 * yellow button, the change stroke up one button, change stroke down one button
	 * and includes a label for the change of stroke
	 *
	 * Also implements that listeners for each of the system of buttons which are:
	 * select object
	 * color selection
	 * and the non-drawing buttons
	 * @param canvas
	 */
	public Toolbox(Canvas canvas) {

		super();
		this.canvas = canvas;
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setOpaque(true);

		JButton squareButton = new JButton("\u25A0");
		squareButton.setBounds(10, 10, 100, 100);
		squareButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 75));
		squareButton.setVisible(true);

		JButton lineButton = new JButton("\u21A6");
		lineButton.setBounds(10, 110, 100, 100);
		lineButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 50));

		JButton circleButton = new JButton("\u25CF");
		circleButton.setBounds(110, 110, 100, 100);
		circleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 75));

		JButton triangleButton = new JButton("\u25B2");
		triangleButton.setBounds(110, 10, 100, 100);
		triangleButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));

		JButton undoButton = new JButton("\u21A9");
		undoButton.setBounds(10, 210, 150, 40);
		undoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

		JButton clearButton = new JButton("\u2716");
		clearButton.setBounds(160, 210, 150, 40);
		clearButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

		JButton colorButton = new JButton("Choose Custom Color");
		colorButton.setBounds(570, 218, 330, 35);
		colorButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 11));

		JButton drawButton = new JButton("\u2710");
		drawButton.setBounds(210, 10, 100, 100);
		drawButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 50));

		JButton saveButton = new JButton("\u21B4");
		saveButton.setBounds(210, 110, 100, 100);
		saveButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 50));

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

		JButton upButton = new JButton("+");
		upButton.setBounds(365, 60, 50, 50);
		upButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		JButton downButton = new JButton("-");
		downButton.setBounds(365, 110, 50, 50);
		downButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

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

		ActionListener operationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == undoButton) {
					canvas.undo();
				} else if (e.getSource() == clearButton) {
					canvas.clear();
				} else if (e.getSource() == saveButton) {
					try {
						canvas.saveImage();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (e.getSource() == upButton) {
					setStrokeSize(getStrokeSize() + 1);
					label.setText("Stroke Size (px): " + getStrokeSize());
					canvas.setStrokeSize(getStrokeSize());
				} else {
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
				}

			}

		};

		ActionListener colorListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == colorButton) {
					canvas.setColor();
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
				} else {
					canvas.setColor(redButton.getBackground());
				}
			}

		};
		
		ActionListener figureListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == circleButton) {
					canvas.setFigure("Circle");
				} else if (e.getSource() == squareButton) {
					canvas.setFigure("Square");
				} else if (e.getSource() == triangleButton) {
					canvas.setFigure("Triangle");
				} else if (e.getSource() == drawButton) {
					canvas.setFigure("Draw");
				} else {
					canvas.setFigure("Line");
				}
				
			}
			
		};

		circleButton.addActionListener(figureListener);
		squareButton.addActionListener(figureListener);
		triangleButton.addActionListener(figureListener);
		lineButton.addActionListener(figureListener);
		drawButton.addActionListener(figureListener);
		
		undoButton.addActionListener(operationListener);
		clearButton.addActionListener(operationListener);
		saveButton.addActionListener(operationListener);
		upButton.addActionListener(operationListener);
		downButton.addActionListener(operationListener);
		
		colorButton.addActionListener(colorListener);
		blueButton.addActionListener(colorListener);
		yellowButton.addActionListener(colorListener);
		redButton.addActionListener(colorListener);
		greenButton.addActionListener(colorListener);
		purpleButton.addActionListener(colorListener);
		orangeButton.addActionListener(colorListener);

	}

}