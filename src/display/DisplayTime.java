package display;

import handler.message.Language;

import java.time.LocalTime;


/**
 * interface with various methods to display time
 */
public interface DisplayTime {

	/**
	 * @brief display the hour
	 * @param hour the hour to display
	 * @param lg
	 */
	public void displayTime(LocalTime hour, Language lg);
	

	
	
}
