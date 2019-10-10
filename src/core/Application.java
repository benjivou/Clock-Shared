package core;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * The core of the subject it control everything in the APP
 */
public class Application extends StateAbstract {

    /*
     List of Handlers
     */
    private HashMap<Integer, DisplayHandler> listOfDisplays;
    private HashMap<Integer, TimeHandler> listOfTime;
    private InputHandler userInputs;

    public Application(){
        super();
    }

    public void routineTimeToDisplay(){
        TimeHandler timeHandler;
        String msg;
        Integer targetId;

        // read all elements
        for (Map.Entry entryTime : this.listOfTime.entrySet()){
            timeHandler = (TimeHandler) entryTime.getValue();
            try {
                // catch the msg
                msg = timeHandler.readUtilCommand();

                // resend the message
                targetId = (Integer) entryTime.getKey();
                sendToDisplay(msg,targetId.intValue());
            } catch (Exception e) {
                // Do nothing because there is nothing for U
            }

        }
    }


    /**
     * Send a message to the displayId
     * @param msg
     * @param displayId
     */
    private void sendToDisplay(String msg, int displayId){
         DisplayHandler displayHandler = this.listOfDisplays.get(displayId);
         displayHandler.sendUtilCommand(msg);
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

        // send to everyone the message to kill them

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
