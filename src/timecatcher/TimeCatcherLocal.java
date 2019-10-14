package timecatcher;

import java.time.LocalTime;


/**
 * get the hour with various methods
 */
public class TimeCatcherLocal implements TimeCatcher {
	
	/**
	 * constructor
	 */
	public TimeCatcherLocal()
	{
		
	}
	

	public LocalTime getTime()
	{
		return LocalTime.now();
	}
	
}
