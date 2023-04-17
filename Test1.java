package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Test1 {

	public void testColorChooser() { //test if color chooser appears
		Canvas c = new Canvas(); // and changes canvas color
		try {
			c.setColor(Color.BLACK);
			c.setColor(); // choose any color except black
		} catch (Exception e) {
			fail();
		}
		
		if (c.getColor().equals(Color.BLACK)) { //if there is no color change
			fail();
		}
		
		
	}
}
