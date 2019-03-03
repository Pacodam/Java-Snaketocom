package model;

import java.util.List;
import java.util.ArrayList;

public class User {

	private String name;
	private String password;
	private List<Score> scoresHistory;
	private List<Score> newScores;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	    this.newScores = new ArrayList<>();
	}
	
	public void setScoresHistory(ArrayList<Score> scores) {
		this.scoresHistory = scores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Score> getScoresHistory() {
		return scoresHistory;
	}

	public void setScoresHistory(List<Score> scoresHistory) {
		this.scoresHistory = scoresHistory;
	}

	public List<Score> getNewScores() {
		return newScores;
	}

	public void setNewScores(List<Score> newScores) {
		this.newScores = newScores;
	}
	
	public void addNewScore(Score newScore) {
		this.newScores.add(newScore);
	}
	
	
	
	
}
