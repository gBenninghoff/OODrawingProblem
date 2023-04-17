package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Test2 {
	
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

}
