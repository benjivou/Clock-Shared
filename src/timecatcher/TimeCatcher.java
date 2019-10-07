package timecatcher;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * get the hour with various methods
 */
public class TimeCatcher {

	private LocalTime hour;
	private int ID;

	
	public TimeCatcher() {
		super();
	}
	
	
	public TimeCatcher(int iD) {
		super();
		ID = iD;
	}


	public LocalTime getSystemHour()
	{
		return LocalTime.now();
	}
	
	public LocalTime getTimeZoneHour(ZoneId zone)
	{
		return LocalTime.now(zone);
	}
	
}
