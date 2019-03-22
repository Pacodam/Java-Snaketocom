package model;

import java.util.List;

public class UserScore implements Comparable<UserScore> {

	private String name;
	private Score score;
	
	public UserScore(String name, Score score) {
		this.name = name;
		this.score = score;
	}
	
	
	public String getName() {
		return name;
	}

	public Score getScore() {
		return score;
	}



	@Override
	public int compareTo(UserScore us) {
		return us.getScore().getPoints() - score.getPoints();  
	}


	@Override
	public String toString() {
		return "name=" + name + ", score=" + score;
	}
	
	
}
