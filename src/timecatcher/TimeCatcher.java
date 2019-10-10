package timecatcher;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;


/**
 * get the hour with various methods
 */
public class TimeCatcher {

	private LocalTime hour;
	private int id;

	
	public TimeCatcher(int id) {
		this.hour = LocalTime.now();
		id = id;
	}


	public LocalTime getSystemHour()
	{
		return this.hour;
	}
	
	public LocalTime getTimeZoneHour(ZoneId zone)
	{
		return LocalTime.now(zone);
	}
	
}
