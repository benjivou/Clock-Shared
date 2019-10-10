package display;

import handler.message.Language;

import java.awt.Color;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeGraphic implements DisplayTime  {

	// Aouter constructeur de fenêtre
	// une fonction de rafraichissement ( en entrée LocalTime )
	// une méthode pour s'éteindre
	
	private JFrame window;
	private JPanel jpanel;
	private JLabel jlabel;


	public static void main(String[] args) {
		
		double time = 9000000000.0;	//time before close the window
		
		TimeGraphic tmp = new TimeGraphic();
		tmp.displayTime(LocalTime.now(), Language.EN);
		
		long start=System.nanoTime(); 
		while((System.nanoTime() - start) < time)
		{
			tmp.refreshTime(LocalTime.now(), Language.EN);
		}
		
		tmp.closeWindow(tmp.window);

	}
	
	/**
	 * constructor
	 */
	public TimeGraphic()
	{	
		window = new JFrame();
		window.setTitle("Time");
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jpanel = new JPanel();
		window.setContentPane(jpanel);
		//jpanel.setBounds(200, 88, 241, 23);
		
		jlabel = new JLabel("LocalTime");
		//jlabel.setBounds(200, 88, 241, 23);
		
		
		jpanel.add(jlabel);
		
		window.setVisible(true);

	}
	
	
	
	
	//getters and setters
	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	public JPanel getJpanel() {
		return jpanel;
	}

	public void setJpanel(JPanel jpanel) {
		this.jpanel = jpanel;
	}

	public JLabel getJlabel() {
		return jlabel;
	}

	public void setJlabel(JLabel jlabel) {
		this.jlabel = jlabel;
	}

	
	/**
	 * 
	 * @param window the window to close
	 */
	public void closeWindow(JFrame window)
	{
		window.dispose();
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
	public void displayTime(LocalTime hour, Language lg)
	{
		if(lg == Language.FR)	//method 1
		{
			jlabel.setText(Integer.toString(hour.getHour()) + "h" + 
			Integer.toString(hour.getMinute()));
		}
		
		
		if(lg == Language.EN)	//method 2
		{
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
		}
		
		
		
		//couleur
		jlabel.setForeground(new Color(200, 20, 150));
		//jpanel.setForeground(new Color(200,20,100));
		
			}

}
