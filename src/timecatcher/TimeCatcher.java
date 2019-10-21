package timecatcher;

import java.time.LocalTime;

public interface TimeCatcher {
	
	/**
	 * 
	 * @return the time
	 */
	public LocalTime getTime() throws ClassNotFoundException;

}
