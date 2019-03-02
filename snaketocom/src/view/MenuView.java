package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MenuView extends JPanel {

	private JButton newGame;
	private JButton scores;
	private JButton exit;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public MenuView() {

		setBounds(0, 0, 700, 600);
		setBackground(Color.GREEN);
		setLayout(null);
		
		newGame = new JButton("New game");
		newGame.setBounds(74, 405, 169, 36);
		add(newGame);
		
		scores = new JButton("Scores");
		scores.setBounds(331, 405, 89, 36);
		add(scores);
		
		exit = new JButton("Exit");
		exit.setBounds(496, 405, 89, 36);
		add(exit);
		
		table = new JTable();
		table.setBounds(519, 353, -381, -250);
		add(table);
	}
	public JButton getNewGame() {
		return newGame;
	}
	public void setNewGame(JButton newGame) {
		this.newGame = newGame;
	}
	public JButton getScores() {
		return scores;
	}
	public void setScores(JButton scores) {
		this.scores = scores;
	}
	public JButton getExit() {
		return exit;
	}
	public void setExit(JButton exit) {
		this.exit = exit;
	}
}
