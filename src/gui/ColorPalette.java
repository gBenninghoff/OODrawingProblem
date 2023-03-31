package gui;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorPalette extends JPanel {

	JColorChooser chooser;
	
	public ColorPalette() {
		
		super();
		
		chooser = new JColorChooser();
		chooser.setPreviewPanel(new JPanel());
		
		chooser.removeChooserPanel(chooser.getChooserPanels()[4]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[3]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[2]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[1]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[0]);

		this.add(chooser);
		this.setLayout(null);
		
	}

}
