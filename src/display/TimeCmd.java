package display;

import handler.message.Language;

import java.time.LocalTime;

public class TimeCmd implements DisplayTime {
	
	public static void main(String[] args)
	{
		TimeCmd cmd = new TimeCmd();
		cmd.displayTime(LocalTime.now(), Language.EN);

		while(true)
			cmd.refreshTime(LocalTime.now(), Language.EN);
	}

	
	/**
	 * refresh the hour
	 * @param hour
	 * @param lg
	 */
	public void refreshTime(LocalTime hour, Language lg)
	{
		displayTime(hour, lg);
	}
	
	
	/**
	 * @param hour the hour to display
	 * @param lg
	 */
	@Override
	public void displayTime(LocalTime hour, Language lg) {
		
		
		if(lg == Language.FR)	//method 1
		{
			System.out.println(hour.getHour() + "h" +
			hour.getMinute());
		}
		
		if(lg == Language.EN)	//method 2
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
