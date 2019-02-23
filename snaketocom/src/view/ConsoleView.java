package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ConsoleView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConsoleView() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Program");
		lblNewLabel.setBounds(10, 11, 81, 14);
		add(lblNewLabel);
		
	}

}
