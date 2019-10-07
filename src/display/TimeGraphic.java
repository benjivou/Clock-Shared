package display;

import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * display the hour in Swing
 */
public class TimeGraphic implements DisplayTime {

	@Override
	public void displayTime(LocalTime hour) {
		
		JFrame window = new JFrame();
		window.setVisible(true);
		
		window.setSize(400,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpanel = new JPanel();
		window.setContentPane(jpanel);
		
		JLabel jlabel = new JLabel();
		jpanel.add(jlabel);
		
		
		
	}
	

}
