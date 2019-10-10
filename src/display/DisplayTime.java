package display;

import java.time.LocalTime;


/**
 * interface with various methods to display time
 */
public interface DisplayTime {

	/**
	 * @brief display the hour
	 * @param hour the hour to display
	 */
	public void displayTime(LocalTime hour, int Id);
	
	/**
	 * 
	 * @param hour
	 * @param Id
	 */
	public void refreshTime(LocalTime hour, int Id);
	
	
}
