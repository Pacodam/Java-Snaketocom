package view;

import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsoleView extends JPanel {
	
	private JMenu menuBar;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;

	
	/**
	 * Create the panel.
	 */
	public ConsoleView() {
		
		
		//setLayout(null);
		
		menuBar = new JMenu("Program");
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
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
	
	
	

	


	
	//usar JmenuBar y JmenuItem
	
	
}
