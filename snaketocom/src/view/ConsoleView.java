package view;

import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

public class ConsoleView extends JPanel {
	
	private StringBuilder sb;
	private JMenu menuBar;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private JScrollPane scrollPane;
    private JTextArea textArea;
    private JMenuBar menuBar_1;
	
	/**
	 * Create the panel.
	 */
	public ConsoleView() {
		
		setBounds(0,0,200,600);
		setLayout(null);
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 198, 21);
		add(menuBar_1);
		
		menuBar = new JMenu("Program");
		menuBar_1.add(menuBar);
		
		/*
		menuBar = new JMenuBar();
		add(menuBar); */
		
	    item1 = new JMenuItem("MENU");
		menuBar.add(item1);
		
		item2 = new JMenuItem("LOGOUT");
		menuBar.add(item2);
		
		item3 = new JMenuItem("EXIT");
		menuBar.add(item3);
		
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 200, 564);
		add(scrollPane);
		
	    textArea = new JTextArea();
	    textArea.setEditable(false);
	    //textArea.isEditable();
		scrollPane.setViewportView(textArea);
		
	    sb = new StringBuilder();
	}

	public JMenu getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenu menuBar) {
		this.menuBar = menuBar;
	}

	public JMenuItem getItem1() {
		return item1;
	}


	public JMenuItem getItem2() {
		return item2;
	}


	public JMenuItem getItem3() {
		return item3;
	}
	
	public void setTextEvent(String event) {
		//sb.append(event + "\n");
		//textArea.setText(sb.toString());
		textArea.append(event);
		textArea.append("\n");
	}
	
	public void initEvents() {
        textArea.setText(null);
	}
}
