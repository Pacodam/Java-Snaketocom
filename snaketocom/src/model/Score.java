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
  
  

public LocalDateTime getTime() {
	return time;
}

public void setTime(LocalDateTime time) {
	this.time = time;
}

public String getPoints() {
	return points;
}

public void setPoints(String points) {
	this.points = points;
}

@Override
public String toString() {
	return "Score [time=" + time + ", points=" + points + "]";
}
  
  
  
  
	
}
