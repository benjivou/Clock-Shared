package handler;

import java.time.LocalTime;

import abstracts.HandlerAbstract;
import handler.message.FromMode;
import timecatcher.TimeCatcher;
import timecatcher.TimeCatcherLocal;
import timecatcher.TimeCatcherServer;

public class TimeHandler extends HandlerAbstract {
    private FromMode mode;
    private TimeCatcher timecatcher;

    public TimeHandler(long waitTime, FromMode mode) {
        super();
        this.waitingTime = waitTime;
        this.mode = mode;

        
     // Create the object for the time strategy
        switch (this.mode ){
            case SYSTEM:
                this.timecatcher = new TimeCatcherLocal();
                break;
            case WEB:
                this.timecatcher = new TimeCatcherServer();
                break;
        }

    }

    @Override
    protected void onAction() {
        super.onAction();

        // it depend of the mode selected before

        try {
            this.sendUtilCommandH(this.timecatcher.getTime());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
