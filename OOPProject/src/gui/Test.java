package gui;

public class Test {
	
	public static void main(String[] args) {
	
	MyFrame frame = new MyFrame("Paint App GUI");
	
	Canvas canvas = new Canvas();
	canvas.setBounds(100, 285, 800, 520);
	
	Toolbox toolbox = new Toolbox(canvas);
	toolbox.setBounds(50, 10, 900, 260);
		
	frame.addComponent(canvas);
	frame.addComponent(toolbox);
	}
	

}
