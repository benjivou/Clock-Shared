package handler;

import abstracts.HandlerAbstract;
import display.TimeGraphic;
import handler.message.FromMode;

import static timecatcher.TimeCatcher.getTimeLocal;

public class TimeHandler extends HandlerAbstract {
    private FromMode mode;

    public TimeHandler(long waitTime, FromMode mode) {
        super();
        this.waitingTime = waitTime;
        this.mode = mode;
        System.out.println("TimeHandler created");

    }

    @Override
    protected void onAction() {
        super.onAction();
        System.out.println("TimeHandler Action");
        // it depend of the mode selected before
        switch (this.mode){
            case SYSTEM:
                sendUtilCommandH(getTimeLocal());
                break;
            default:
                System.err.println("Undefined Mode");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("TimeHandler Stop pause");
    }
}
