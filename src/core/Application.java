package core;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;

import java.util.HashMap;

/**
 * The core of the subject it control everything in the APP
 */
public class Application extends StateThread{

    /*
     List of Handlers
     */
    private HashMap<Integer, DisplayHandler> listOfDisplays;
    private HashMap<Integer, TimeHandler> listOfTime;
    private InputHandler userInputs;

    public Application(){
        super();
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        this.listOfDisplays = new HashMap<>();
        this.listOfTime = new HashMap<>();
        this.waitingTime =10;
    }

    @Override
    protected void onAction() {
        super.onAction();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // send to every one the message to kill them

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
