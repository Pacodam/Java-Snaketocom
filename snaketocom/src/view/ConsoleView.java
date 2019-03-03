package view;

import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ConsoleView extends JPanel {
	
	private StringBuilder sb = new StringBuilder();
	private JMenu menuBar;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private JLabel eventsArea;
	private JScrollPane scrollPane;

	
	/**
	 * Create the panel.
	 */
	public ConsoleView() {
		
		setBounds(0,0,200,600);
		//setLayout(null);
		
		menuBar = new JMenu("Program");
		menuBar.setBounds(10, 11, 95, 22);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		setLayout(null);
		add(menuBar);
		
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
		scrollPane.setBounds(0, 44, 200, 556);
		add(scrollPane);
		
		eventsArea = new JLabel();
		scrollPane.setViewportView(eventsArea);
		
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

	public void setItem1(JMenuItem item1) {
		this.item1 = item1;
	}

	public JMenuItem getItem2() {
		return item2;
	}

	public void setItem2(JMenuItem item2) {
		this.item2 = item2;
	}

	public JMenuItem getItem3() {
		return item3;
	}

	public void setItem3(JMenuItem item3) {
		this.item3 = item3;
	}

	
	
	public void setTextEvent(String event) {
		sb.append(event + "\n");
		eventsArea.setText(sb.toString());
	}

	
	
}
