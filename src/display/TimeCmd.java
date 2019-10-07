package display;

import java.time.LocalTime;

/**
 * display the hour in the terminal
 */
public class TimeCmd implements DisplayTime {

	@Override
	public void displayTime(LocalTime hour) {
		System.out.println(hour);
	}

}
