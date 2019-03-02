package model;

import java.time.LocalDateTime;

public class Score {
	
  private LocalDateTime time;
  private String points;
  
  //constructor of existing Score
  public Score(LocalDateTime time, String points) {
	  this.points = points;
	  this.time = time;
  }
  
  //constructor of new Score
  public Score(String points) {
	  this.points = points;
	  this.time = LocalDateTime.now();
  }

@Override
public String toString() {
	return "Score [time=" + time + ", points=" + points + "]";
}
  
  
  
  
	
}
