package display;

import java.awt.Color;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeGraphic implements DisplayTime  {

	// Aouter constructeur de fenêtre
	// une fonction de rafraichissement ( en entrée LocalTime )
	// une méthode pour s'éteindre


	public static void main(String[] args) {
		
		TimeGraphic tmp = new TimeGraphic();
		tmp.displayTime(LocalTime.now());

	}
	
	
	/**
	 * @param hour the hour to display
	 */
	public void displayTime(LocalTime hour)
	{
		JFrame window = new JFrame();
		

		window.setTitle("Time");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpanel = new JPanel();
		window.setContentPane(jpanel);
		//jpanel.setBounds(200, 88, 241, 23);
		
		JLabel jlabel = new JLabel("LocalTime");
		//jlabel.setBounds(200, 88, 241, 23);
		
		
		//method 1
		/*jlabel.setText(Integer.toString(hour.getHour()) + "h" + 
		Integer.toString(hour.getMinute()));*/
		
		
		//method 2
		if(hour.getHour() >= 0 && hour.getHour() <= 12)
		{
			jlabel.setText(Integer.toString(hour.getHour()) + "am" + ":" +
					Integer.toString(hour.getMinute()) + " "
							+Integer.toString(hour.getSecond()) + "s");
		}
		else
		{
			jlabel.setText(Integer.toString(hour.getHour() - 12) + "pm" + ":" +
					Integer.toString(hour.getMinute()) + " "
							+Integer.toString(hour.getSecond()) + "s");
		}
		
		//couleur
		jlabel.setForeground(new Color(200, 20, 150));
		//jpanel.setForeground(new Color(200,20,100));
		
		jpanel.add(jlabel);
		
		window.setVisible(true);
	}

}
