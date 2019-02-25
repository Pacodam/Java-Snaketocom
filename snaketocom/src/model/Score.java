package model;

import java.time.LocalDateTime;

public class Score {
	
  private LocalDateTime time;
  private int points;
  
  //constructor of existing Score
  public Score(LocalDateTime time, int points) {
	  this.points = points;
	  this.time = time;
  }
  
  //constructor of new Score
  public Score(int points) {
	  this.points = points;
	  this.time = LocalDateTime.now();
  }
  
  
	
}
