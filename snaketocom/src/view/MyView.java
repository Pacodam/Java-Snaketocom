package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;

public class MyView {

	private MyFrame frame;
	private MyPanel panel;
	
	
	
	/**
	 * Create the panel. The basic panel consist on JFrame, JPanel and JSplitPane
	 */
	public MyView(ConsoleView console, LoginView login) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Instantiation of MyFrame
					frame = new MyFrame();
					frame.setVisible(true);
					
					
					//Instantiation of MyPanel, add to frame
					panel = new MyPanel(console, login);
					panel.setVisible(true);
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	
   }
	
	public void setMenu(MenuView m) {
		
		panel.getSplitPane().setRightComponent(m);
		panel.getSplitPane().setDividerLocation(200);
		//panel.getSplitPane().invalidate();
	}
	
	/*
	public void setConsole(ConsoleView c) {
	   // panel.getSplitPane().setLeftComponent(c);
	} */
	
	/*
	public void setLoginView(LoginView l) {
		panel.setLoginView(l);
	} */
}
