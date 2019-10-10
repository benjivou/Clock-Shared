package core;

import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;

import java.util.HashMap;

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

        onRoutineUtil();
        onRoutineAdmin();
    }

    private void onRoutineUtil() {
    }

    protected void onRoutineAdmin(){

    }
}
