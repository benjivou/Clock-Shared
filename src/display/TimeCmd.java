package display;

import java.time.LocalTime;

public class TimeCmd implements DisplayTime {
	
	public static void main(String[] args)
	{
		TimeCmd cmd = new TimeCmd();
		cmd.displayTime(LocalTime.now());
	}
	
	/**
	 * @param hour the hour to display
	 */
	@Override
	public void displayTime(LocalTime hour) {
		
		//method 1
		/*System.out.println(hour.getHour() + "h" +
	hour.getMinute());*/
		
		
		//method 2
		if(hour.getHour() >= 0 && hour.getHour() <= 12)
		{
			System.out.println(hour.getHour() + "am" + ":" +hour.getMinute());
			System.out.println(hour.getSecond() + "s");
		}
		else
		{
			System.out.println(hour.getHour() - 12 + "pm" + ":" + hour.getMinute() + "\t" +/*);*/
			/*System.out.println(*/hour.getSecond() + "s");
		}
		
	}

}
