package handler;

import abstracts.HandlerAbstract;
import handler.message.FromMode;

public class TimeHandler extends HandlerAbstract {
    private FromMode mode;

    public TimeHandler(long waitTime, FromMode mode) {
        super();
        this.waitingTime = waitTime;
        this.mode = mode;
    }

    @Override
    protected void onAction() {
        super.onAction();
    // TO-DO
    }
}
