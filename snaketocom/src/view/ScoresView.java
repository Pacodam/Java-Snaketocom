package view;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;


public class ScoresView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoresView() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 741, 510);
		add(tabbedPane);
        
		 tabbedPane.addTab("Tab1", makePanel("This is tab 1"));
	      tabbedPane.addTab("Tab2", makePanel("This is tab 2"));

		
		
	}
	
	 private static JPanel makePanel(String text) {
	        JPanel p = new JPanel();
	        p.add(new JLabel(text));
	        p.setLayout(new GridLayout(1, 1));
	        return p;
	    }
	 

	
}
