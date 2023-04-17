package gui;

import static org.junit.Assert.*;

import java.awt.Color;

public class Test {
	
	@org.junit.Test
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
	
	@org.junit.Test
	public void testUndo() { 
		Canvas c = new Canvas();
		try {
			c.undo(); //see if the undo method (+ the stack it utilizes) 
			c.undo(); //actually catches an error when it is called to undo nothing
		} catch (Exception e) {
			fail();  //if no warning is generated, then the index will be -1, which
			// will result in a index-out-of-bounds-exception
		}
	}
	
	@org.junit.Test
	public void testSetStroke() {
		Canvas c = new Canvas(); //see if toolbox will generate a warning frame
		Toolbox t = new Toolbox(c); // instead of setting a stroke size <1
			t.setStrokeSize(0);
			
			if (t.getStrokeSize() == 0) {
				fail(); //if no warning is generated then stroke size will be 0
			}
	
		
	}
	
	@org.junit.Test
	public void testClear() {
		Canvas c = new Canvas();
		try {
			c.clear(); //test to see if clear (or paintComponent with no added
			//figures) will error
		} catch (Exception e) {
			fail(); 
		}
	}
	
	@org.junit.Test
	public void testFigure() throws RuntimeException {
		Canvas c = new Canvas();
		try {
			c.setFigure("not a real shape"); //test to see if setShape method
			// will throw an error if it's not given a legitimate  shape
			fail(); //if set Shape does not throw any exception, test fails
		} catch (Exception e) {
			//passed
		}
	}
	
	

}
