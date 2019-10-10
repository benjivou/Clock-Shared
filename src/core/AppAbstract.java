package core;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.StandardHandler;
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
        onRoutineUtil();
    }

    protected void onRoutineUtil() {
    }

    protected void onRoutineAdmin(){
        try {
            // if U have something to do
            onAdminInputs(this.userInputs.readAdminCommand());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onAdminInputs(AdminMsg msg){

    }

    /**
     * Send a message to the displayId
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

        StandardHandler handler;
        DisplayHandler displayHandler;


        // send to everyone the message to kill them
        // time
        for (Map.Entry entryTime : this.listOfTime.entrySet()){
            handler = (StandardHandler) entryTime.getValue();
            handler.sendAdminCommand(AdminMsg.OFF);
        }

        // Display
        for (Map.Entry entryTime : this.listOfDisplays.entrySet()){
            handler = (StandardHandler) entryTime.getValue();
            handler.sendAdminCommand(AdminMsg.OFF);
        }

        // Inputs
        this.userInputs.sendAdminCommand(AdminMsg.OFF);
    }
}
