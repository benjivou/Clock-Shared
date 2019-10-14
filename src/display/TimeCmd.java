package display;

import handler.message.Language;

import java.time.LocalTime;

public class TimeCmd implements DisplayTime {
	private String name;

	public TimeCmd(String name){
		this.name = name;
	}

	

	
	
	/**
	 * @param hour the hour to display
	 * @param lg
	 */
	@Override
	public void displayTime(LocalTime hour, Language lg) {

		if(lg == Language.FR)	//method 1
		{
			System.out.println(this.name+ " : "+ hour.getHour() + "h" + hour.getMinute());
		}
		
		if(lg == Language.EN)	//method 2
		{
			if(hour.getHour() >= 0 && hour.getHour() <= 12)
			{
				System.out.println(this.name + " : " + hour.getHour() + "am" + ":" +hour.getMinute() + " " + hour.getSecond() + "s");
			}
			else
			{
				System.out.println(this.name + " : "+ (hour.getHour() - 12) + "pm" + ":" + hour.getMinute() + " " + hour.getSecond() + "s");
			}
		}
		
		
		
		
		
	}

}
