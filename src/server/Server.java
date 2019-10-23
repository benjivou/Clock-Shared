package server; 
 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.OutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.time.LocalTime; 
 
public class Server implements Runnable { 
	 
	private ServerSocket ss; 
	private Socket s2; 
	private ObjectOutputStream oos; 
	 
	/*public static void main(String[] args) 
	{ 
		Server server = new Server(); 
		server.serverConnection();
	}*/
	 
	public Server() 
	{ 
		ss = null; 
		s2 = null; 
		oos = null; 
	} 
	




	public void /*serverConnection*/run() 
	{ 
		try { 
			ss = new ServerSocket(80); 
			System.out.println("wait for connection"); 
			
			
			ss.setSoTimeout(100000);
			while(true)
			{
				s2 = ss.accept(); 
				 
				
				ss.setSoTimeout(100000);
				LocalTime time = LocalTime.now(); 
				 
				ObjectOutputStream oos = new ObjectOutputStream(s2.getOutputStream()); 
				oos.writeObject(time);  
				 
				
				s2.close();	//close the connection 
			
			}
			
			//ss.close();
			 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
 
	}

		 
}