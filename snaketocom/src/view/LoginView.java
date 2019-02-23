package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JPanel {

	
	private JTextField name;
	private JPasswordField password;
	private JButton loginButton;
	
	public LoginView() {

		
		setBackground(Color.ORANGE);
		setLayout(null);
		
		name = new JTextField();
		name.setBounds(244, 156, 284, 20);
		add(name);
		name.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(257, 271, 284, 20);
		add(password);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(340, 387, 57, 23);
		add(loginButton);
		
	}

	public JTextField getsName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	
	

}
