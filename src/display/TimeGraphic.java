package display;

import java.awt.Color;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeGraphic {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		

		window.setTitle("Time");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpanel = new JPanel();
		window.setContentPane(jpanel);
		//jpanel.setBounds(200, 88, 241, 23);
		
		JLabel jlabel = new JLabel("LocalTime");
		//jlabel.setBounds(200, 88, 241, 23);
		
		//test
		/*jlabel.setText(Integer.toString(LocalTime.now().getHour()) + ":" + 
		Integer.toString(LocalTime.now().getMinute()) + ":"
				+Integer.toString(LocalTime.now().getSecond()));*/
		
		//method 1
		/*jlabel.setText(Integer.toString(LocalTime.now().getHour()) + "h" + 
		Integer.toString(LocalTime.now().getMinute()));*/
		
		
		//method 2
		if(LocalTime.now().getHour() >= 0 && LocalTime.now().getHour() <= 12)
		{
			jlabel.setText(Integer.toString(LocalTime.now().getHour()) + "am" + ":" +
					Integer.toString(LocalTime.now().getMinute()) + " "
							+Integer.toString(LocalTime.now().getSecond()) + "s");
		}
		else
		{
			jlabel.setText(Integer.toString(LocalTime.now().getHour() - 12) + "pm" + ":" +
					Integer.toString(LocalTime.now().getMinute()) + " "
							+Integer.toString(LocalTime.now().getSecond()) + "s");
		}
		
		//couleur
		jlabel.setForeground(new Color(200, 20, 150));
		//jpanel.setForeground(new Color(200,20,100));
		
		jpanel.add(jlabel);
		
		window.setVisible(true);
		
		
		
		
		/*lblLocalDateTime = new JLabel("LocalDateTime");
		// lblLocalDateTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalDateTime.setBounds(200, 88, 241, 23);
		int realHours = (clocking.getRealTime()).getHour();
		int realMinutes = (clocking.getRealTime()).getMinute();
		int roundedHours = (clocking.getRoundedTime()).getHour();
		int roundedMinutes = (clocking.getRoundedTime()).getMinute();
		lblLocalDateTime.setText(Integer.toString(realHours) + ":"
				+ Integer.toString(realMinutes) + " ... let's say "
				+ Integer.toString(roundedHours) + ":"
				+ Integer.toString(roundedMinutes));
		getContentPane().add(lblLocalDateTime);*/
		

	}
	
	/*public void DisplayTime(LocalTime hour)
	{
		JFrame window = new JFrame();
		window.setVisible(true);

		window.setSize(400,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpanel = new JPanel();
		window.setContentPane(jpanel);

		JLabel jlabel = new JLabel();
		jpanel.add(jlabel);
	}*/

}
