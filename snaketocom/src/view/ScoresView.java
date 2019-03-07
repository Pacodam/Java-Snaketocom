package view;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ScoresView extends JPanel {

	JTabbedPane tabbedPane;
	JPanel tab1;
	JPanel tab2;
	/**
	 * Create the panel.
	 */
	public ScoresView() {
		setLayout(null);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(10, 11, 741, 510);
		add(tabbedPane);
        
		tab1 = new JPanel();
		 tabbedPane.addTab("tab1", tab1);
	      tabbedPane.addTab("Tab2", makePanel("This is tab 2"));

		
		
	}
	
	 private static JPanel makePanel(String text) {
	        JPanel p = new JPanel();
	        p.add(new JLabel(text));
	        p.setLayout(new GridLayout(1, 1));
	        return p;
	    }
	 

	
}
