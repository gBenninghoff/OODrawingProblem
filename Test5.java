package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test5 {
	
	
	@Test
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
