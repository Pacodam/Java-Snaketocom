package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel {

	private JButton newGame;
	private JButton scores;
	private JButton exit;
	/**
	 * Create the panel.
	 */
	public MenuView() {

		setBackground(Color.GREEN);
		setLayout(null);
		
		JButton btnNewButton = new JButton("New game");
		btnNewButton.setBounds(36, 226, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Scores");
		btnNewButton_1.setBounds(172, 226, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(311, 226, 89, 23);
		add(btnNewButton_2);
	}
}
