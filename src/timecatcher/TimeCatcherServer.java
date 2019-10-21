package timecatcher;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.Scanner;


public class TimeCatcherServer implements TimeCatcher {
	
	
	private Socket s1;
	private LocalTime hour;
	private ObjectInputStream ois;
	
	
	
	public static void main(String[] args)
	{
		//TimeCatcherServer test = new TimeCatcherServer();
		//System.out.println(test.getTime());
	}
	
	public TimeCatcherServer()
	{
		hour = null;
		ois = null;
		s1 = null;
		
	}
	
	/**
	 * to establish the connection and get the hour
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	@Override
	public LocalTime getTime() throws ClassNotFoundException {
		
		Scanner sc1 = new Scanner(System.in); //the user enter the port number
		System.out.println("Enter the port number");
		int port = sc1.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the address");
		String address = sc2.next();
		
		
		try {
			Socket s1 = new Socket(address, port);
			ois = new ObjectInputStream(s1.getInputStream());
			
			hour = (LocalTime) ois.readObject();
			
			s1.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hour;
		
			
	}
	
	
		
	
}
