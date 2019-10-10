package display;

import java.time.LocalTime;

public class TimeCmd implements DisplayTime {
	
	public static void main(String[] args)
	{
		TimeCmd cmd = new TimeCmd();
		cmd.displayTime(LocalTime.now(), 1);
		
		while(true)
			cmd.refreshTime(LocalTime.now(), 1);
	}
	
	
	/**
	 * refresh the hour
	 * @param hour
	 * @param Id
	 */
	public void refreshTime(LocalTime hour, int Id)
	{
		displayTime(hour, Id);
	}
	
	
	/**
	 * @param hour the hour to display
	 */
	@Override
	public void displayTime(LocalTime hour, int Id) {
		
		
		if(Id == 0)	//method 1
		{
			System.out.println(hour.getHour() + "h" +
			hour.getMinute());
		}
		
		if(Id == 1)	//method 2
		{
			if(hour.getHour() >= 0 && hour.getHour() <= 12)
			{
				System.out.println(hour.getHour() + "am" + ":" +hour.getMinute() + " " + hour.getSecond() + "s");
			}
			else
			{
				System.out.println(hour.getHour() - 12 + "pm" + ":" + hour.getMinute() + " " + hour.getSecond() + "s");
			}
		}
		
		
		
		
		
	}

}
