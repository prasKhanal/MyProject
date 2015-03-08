package pras.com.sparrowProblem.solutions.timeConfusion;
/**
 * 
 */

/**
 * This object is hour and minute representation of real world time
 * with minutes and second as attributes.
 * @author pras_khanal
 *
 */
public class Time {
	
private int hour;
private int minute;

public Time(int hour, int minute){
	this.hour=hour;
	this.minute=minute;
}
/**
 * @return the hour
 */
public int getHour() {
	return hour;
}
/**
 * @param hour the hour to set
 */
public void setHour(int hour) {
	this.hour = hour;
}
/**
 * @return the minute
 */
public int getMinute() {
	return minute;
}
/**
 * @param minute the minute to set
 */
public void setMinute(int minute) {
	this.minute = minute;
}

public Time compareTimeDifference(Time time){
 return new Time(compareHours(this.getHour(),time.getHour()),
		 compareMinutes(this.getMinute(),time.getMinute()));
}
/**
 * This methods two time objects.
 * using their field value hours and minutes.
 * @param time
 * @return 
 */
public boolean equals(Time time){
	return (this.minute==time.getMinute()
			&&this.hour==time.getHour());
}
/**
 * This method compares two given hours as argument 
 * taking in consideration that hour is always less than 13
 * @param hour1
 * @param hour2
 * @return the compaired value as int
 */
private int compareHours(int hour1, int hour2){
	if(hour1>hour2) 
		return 12-hour1+hour2;
	return hour2-hour1;
}
/**
 * This private method compare two given minutes as 
 * argument if taken into consideration that minute value is always less 
 * than 60.
 * @param minute1 
 * @param minute2
 * @return the compaired result.
 */
private int compareMinutes(int minute1, int minute2){
	if(minute1>minute2) 
		return 60-minute1+minute2;
	return minute2-minute1;
}
/**
 * This is overridden method of object 
 * If the minute is less than 10 then 0 is added in front of minute
 * as a character of the string.
 * @param args
 */
public String toString(){
	if(this.getMinute()<10)
		return this.getHour()+":0"+this.getMinute();
	return this.getHour()+":"+this.getMinute();
	
}

	}


