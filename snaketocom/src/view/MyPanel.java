package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class MyPanel extends JPanel {

	private JTextField textField;
	private JPasswordField passwordField;
	
	private JPanel ConsoleView;

	
	private JSplitPane splitPane;
	/**
	 * Create the panel.
	 */
	public MyPanel(ConsoleView consoleView, LoginView loginView) {
		setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 900, 600);
		splitPane.setForeground(Color.GRAY);
		splitPane.setDividerLocation(200);
		add(splitPane);
		
		/*
		JPanel panelR = new JPanel();
		panelR.setBackground(Color.ORANGE);
		splitPane.setRightComponent(panelR);
		panelR.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(64, 63, 248, 20);
		panelR.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(64, 123, 248, 20);
		panelR.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(132, 172, 89, 23);
		panelR.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(89, 27, 172, 14);
		panelR.add(lblNewLabel_1);
		*/
		//splitPane.setRightComponent(new MenuView());
		splitPane.setRightComponent(loginView);
		splitPane.setLeftComponent(consoleView);
		/*
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Program");
		lblNewLabel.setBounds(10, 11, 81, 14);
		panel.add(lblNewLabel);
		
		*/
		
		
		/*
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 900, 600);
		splitPane.setForeground(Color.GRAY);
		add(splitPane);
		
		*/
		
		
	}
	
	
	
	
	
	public void setLoginView(LoginView l) {
		splitPane.setRightComponent(null);
		splitPane.setRightComponent(l);
	} 
	
	
	public JSplitPane getSplitPane() {
		return splitPane;
	} 
	
	
	
	
	

}
