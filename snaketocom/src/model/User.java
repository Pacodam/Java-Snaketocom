package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class User {

	private String name;
	private String password;
	private List<Score> scores;
	private List<Score> provisionalScores;
	
	public User() {}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	    this.scores = new ArrayList<>();
	    this.provisionalScores = new ArrayList<>();
	}
	
	public User(String name, List scores) {
		this.name = name;
		this.scores = scores;
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
	
	public void addNewProvisionalScore(Score score) {
		this.provisionalScores.add(score);
	}
	
	public List<Score> getProvisionalScores(){
		return provisionalScores;
	}
	
	public Score getBestScore() {
		Collections.sort(scores);
		return scores.get(0);
	}
	
	public String getResumeForScore1() {
		Collections.sort(scores);
		Score bestScore = scores.get(0);
		String s = name + "\n" +
		          "Plays: " + scores.size() + "\n"+
				  "Best Score : " +  bestScore.getPointsFormatted() + "\n" +
		          "on Date: " + bestScore.actualTimeString();
		return s;
	}
	
	
	
	
	
	
}
