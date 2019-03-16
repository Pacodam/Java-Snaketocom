package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JPanel {

	private JButton newGame;
	private JButton scores;
	private JButton exit;
	private JTable table;
	private JScrollPane scrollPane;
	
	
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
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(496, 405, 89, 36);
		add(exit);
		
		JLabel lblNewLabel = new JLabel("Your Best Plays");
		lblNewLabel.setBounds(97, 71, 222, 36);
		add(lblNewLabel);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 131, 511, 176);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table); 
			
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
	
	public void setDataModel(TableData td) {
		table.setModel(td);
	}
	
	
		
	
}
