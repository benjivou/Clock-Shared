package handler;

import abstracts.HandlerAbstract;

public class TimeHandler extends HandlerAbstract {
    private int idTarget;

    public TimeHandler(long waitTime, int idTarget) {
        super();
        this.waitingTime = waitTime;
        this.idTarget = idTarget;
    }

    @Override
    protected void onAction() {
        super.onAction();
    }
}
