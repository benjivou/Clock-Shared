package core;



import server.Server;


/**
 * Launch the project
 */
public class Application {


    public static void main(String[]Args){
    	
    	new Thread(new Server()).start(); //lance le serveur
    	
        new Thread(new MainController()).start();
        
        
    }

}