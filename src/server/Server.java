package server; 
 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.OutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.time.LocalTime; 
 
public class Server { 
	 
	private ServerSocket ss; 
	private Socket s2; 
	private ObjectOutputStream oos; 
	 
	public static void main(String[] args) 
	{ 
		Server server = new Server(); 
		server.serverConnection(); 
	}
	 
	public Server() 
	{ 
		ss = null; 
		s2 = null; 
		oos = null; 
	} 
	
	
	
	 
	public void serverConnection() 
	{ 
		try { 
			ServerSocket ss = new ServerSocket(80); 
			System.out.println("wait for connection"); 
			 
			Socket s2 = ss.accept(); 
			 
			 
			//InputStream is = s2.getInputStream();	//read data send by the client 
			//OutputStream os = s2.getOutputStream();	//allow to send an answer to the client 
			 
			LocalTime time = LocalTime.now(); 
			 
			ObjectOutputStream oos = new ObjectOutputStream(s2.getOutputStream()); 
			oos.writeObject(time);  
			 
			//int nb = is.read(); 
			 
			//os.write(nb);	//send the answer 
			 
			 
			s2.close();	//close the connection 
			 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
 
	} 
}