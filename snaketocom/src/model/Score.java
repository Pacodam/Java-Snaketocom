package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Score implements Comparable<Score> {
	
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
  //dateTime = LocalDateTime.parse(contenido, formatter);
  private LocalDateTime time;
  private String timeString;
  private int points;
  
  //constructor of  Score, receiving int
  public Score(String timeString, int points) {
	  this.points = points;
	  this.time = LocalDateTime.parse(timeString, formatter);
  }
  
  //constructor of Score, receiving String
  public Score(String timeString, String pointsFormatted) {
	  this.points = Integer.parseInt(pointsFormatted.replaceFirst("^0+(?!$)", ""));
	  this.time = LocalDateTime.parse(timeString, formatter);
  }
  
  //constructor of new Score
  public Score(int points) {
	  this.points = points;
	  this.time = LocalDateTime.now();
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

public String actualTimeString() {
    return time.format(formatter);
}

public int getPoints() {
	return points;
}

public void setPoints(int points) {
	this.points = points;
}


@Override
public String toString() {
	return "Score [time=" + time + ", points=" + points + "]";
}

public String getPointsFormatted() {
if(points == 0) return "0000000000";
   return String.format(Locale.getDefault(), "%010d", points);
}



@Override
public int compareTo(Score o) {
	return o.getPoints() - points;  //de mayor a menor
	//return points - o.getPoints(); de menor a mayor
}


  
  
  
  
	
}
