package core;

import abstracts.AppAbstract;
import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;
import handler.message.AdminMsg;

import java.util.HashMap;
import java.util.Map;

/**
 * The core of the subject it control everything in the APP
 */
public class Application extends AppAbstract {

    /*
     List of Handlers
     */
    private HashMap<Integer, DisplayHandler> listOfDisplays;
    private HashMap<Integer, TimeHandler> listOfTime;
    private InputHandler userInputs;

    public Application(){
        super();
    }

    /**
     * Describe what we should do to catch the time and send it to the display app
     */
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

    public void addClock(){

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

        // Catch all Hours U receive
        routineTimeToDisplay();

    }

    @Override
    protected void onAdminInputs(AdminMsg msg) {
        super.onAdminInputs(msg);
        switch (msg){
            case OFF:
                // go to onDestroy statement
                finalizeThread();
                break;
            case ON:
                break;
            case WAIT:
                break;
        }
    }

}
