package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class User {

	private String name;
	private String password;
	private List<Score> scores;
	
	public User() {}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	    this.scores = new ArrayList<>();
	}
	
	public void setScoresHistory(ArrayList<Score> scores) {
		this.scores = scores;
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


	public void setScoresHistory(List<Score> scores) {
		this.scores = scores;
	}

	public List<Score> scores() {
		return scores;
	}

	
	public void addNewScore(Score score) {
		this.scores.add(score);
	}
	
	public String getResumeForScore1() {
		Collections.sort(scores);
		Score bestScore = scores.get(0);
		String s = name + "\n" +
		          "Plays: " + scores.size() + "\n"+
				  "Best Score : " +  bestScore.getPointsFormatted() + "\n" +
		          "on Date: " + bestScore.getTimeString();
		return "s";
	}
	
	
	
	
}
