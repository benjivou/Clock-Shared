package core;

import handler.DisplayHandler;
import handler.TimeHandler;

import java.util.HashMap;

/**
 * The core of the subject it control everything in the APP
 */
public class Application implements Runnable{

    /*
     List of Handlers
     */
    private HashMap<Integer, DisplayHandler> listOfDisplays;
    private HashMap<Integer, TimeHandler> listOfTime;

    public Application(){

    }

    @Override
    public void run() {

    }
}
