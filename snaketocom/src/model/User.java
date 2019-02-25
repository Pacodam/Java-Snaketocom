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
	
	
}
