package abstracts;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;
import handler.message.AdminMsg;

import java.util.HashMap;
import java.util.Map;

import static abstracts.HandlerAbstract.NONE_RETURN;

public abstract class AppAbstract extends StateAbstract {
    /*
     List of Handlers
     */
    protected HashMap<Integer, DisplayHandler> listOfDisplays;
    protected HashMap<Integer, TimeHandler> listOfTime;
    protected InputHandler userInputs;

    @Override
    protected void onCreate() {
        super.onCreate();
        this.listOfDisplays = new HashMap<>();
        this.listOfTime = new HashMap<>();
        this.userInputs = new InputHandler();
    }

    @Override
    protected void onAction() {
        super.onAction();
        onRoutineAdmin();
    }


    /**
     * this state listen to handlers messages
     */
    protected void onRoutineAdmin(){
        try {
            // if U have something to do
            onAdminInputs(this.userInputs.readAdminCommandA());
        } catch (Exception e) {
           if(! e.getMessage().equals(NONE_RETURN)) {
               e.printStackTrace();
           }
        }
        sendBroadcastAdmin(AdminMsg.CONTINUE);
    }

    /**
     * When U get a message from the user
     * @param msg
     */
    protected void onAdminInputs(AdminMsg msg){

    }

    /**
     * Send a message to the the good display thread
     * @param obj
     * @param displayId
     */
    protected void sendToDisplay(Object obj, int displayId){
        DisplayHandler displayHandler = this.listOfDisplays.get(displayId );
        if (obj != null)
            displayHandler.sendUtilCommandA(obj);
    }

    protected void sendBroadcastAdmin(AdminMsg msg){
        HandlerAbstract handler;
        DisplayHandler displayHandler;


        // send to everyone the message to kill them
        // time
        for (Map.Entry entryTime : this.listOfTime.entrySet()){
            handler = (HandlerAbstract) entryTime.getValue();
            handler.sendAdminCommandA(msg);
        }

        // Display
        for (Map.Entry entryTime : this.listOfDisplays.entrySet()){
            handler = (HandlerAbstract) entryTime.getValue();
            handler.sendAdminCommandA(msg);
        }

        // Inputs
        this.userInputs.sendAdminCommandA(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        sendBroadcastAdmin(AdminMsg.OFF);
    }
}
