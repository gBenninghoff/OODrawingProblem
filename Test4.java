package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test4 {

	public void testClear() {
		Canvas c = new Canvas();
		try {
			c.clear(); //test to see if clear (or paintComponent with no added
			//figures) will error
		} catch (Exception e) {
			fail(); 
		}
	}

}
