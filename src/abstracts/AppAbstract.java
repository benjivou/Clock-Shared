package abstracts;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;
import handler.message.AdminMsg;

import java.util.HashMap;
import java.util.Map;

public abstract class AppAbstract extends StateAbstract {
    /*
     List of Handlers
     */
    protected HashMap<Integer, DisplayHandler> listOfDisplays;
    protected HashMap<Integer, TimeHandler> listOfTime;
    protected InputHandler userInputs;

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
            onAdminInputs(this.userInputs.readAdminCommand());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When U get a message from the user
     * @param msg
     */
    protected void onAdminInputs(AdminMsg msg){

    }

    /**
     * Send a message to the the good display thread
     * @param msg
     * @param displayId
     */
    protected void sendToDisplay(String msg, int displayId){
        DisplayHandler displayHandler = this.listOfDisplays.get(displayId);
        displayHandler.sendUtilCommand(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        HandlerAbstract handler;
        DisplayHandler displayHandler;


        // send to everyone the message to kill them
        // time
        for (Map.Entry entryTime : this.listOfTime.entrySet()){
            handler = (HandlerAbstract) entryTime.getValue();
            handler.sendAdminCommand(AdminMsg.OFF);
        }

        // Display
        for (Map.Entry entryTime : this.listOfDisplays.entrySet()){
            handler = (HandlerAbstract) entryTime.getValue();
            handler.sendAdminCommand(AdminMsg.OFF);
        }

        // Inputs
        this.userInputs.sendAdminCommand(AdminMsg.OFF);
    }
}
