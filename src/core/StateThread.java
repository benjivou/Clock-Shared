package core;

import handler.message.AdminMsg;

public abstract class StateThread implements Runnable{
    public static final long WAITING_TIME=100;      // waiting time use in the onPause state
    protected boolean work; // say if the handler is Actually Running
    protected long waitingTime = WAITING_TIME; // by default it's 0.1sec
    /**
     * States
     */
    @Override
    public void run() {
        while(this.work) {
            onAction();
            onPause();
        }

    }

    /**
     * States
     */
    // when U create the handler
    protected void onCreate(){
        this.work = true;
    };

    // the acction to reapeat during the execution
    protected void onAction(){

    }

    // when U should end you work
    protected void onDestroy(){
        this.work = false;
    };

    // When U wait before checking
    protected void onPause(){
        try {
            Thread.sleep(this.waitingTime);
        } catch (InterruptedException e) {
            // Normally It should never append
            e.printStackTrace();
        }
    }
}
