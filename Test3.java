package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test3 {

	public void testSetStroke() {
		Canvas c = new Canvas(); //see if toolbox will generate a warning frame
		Toolbox t = new Toolbox(c); // instead of setting a stroke size <1
			t.setStrokeSize(0);
			
			if (t.getStrokeSize() == 0) {
				fail(); //if no warning is generated then stroke size will be 0
			}
	
		
	}
}
