package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Score {
	
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
  //dateTime = LocalDateTime.parse(contenido, formatter);
  private LocalDateTime time;
  private String timeString;
  private String points;
  
  //constructor of existing Score
  public Score(String time, String points) {
	  this.points = points;
	  this.timeString = time;
  }
  
  //constructor of new Score
  public Score(String points) {
	  this.points = points;
	  
	  //this.time = LocalDateTime.now();
  }
  
public String getTimeString() {
	return timeString;
}

public void setTimeString(String time) {
	this.timeString = time;
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
