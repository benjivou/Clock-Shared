package abstracts;

import handler.message.AdminMsg;

public abstract class StateAbstract implements Runnable{
    public static final long WAITING_TIME=100;      // waiting time use by default in the onPause state


    protected static String CLASSNAME = "StateThread";

    private boolean work; // say if the handler is Actually Running
    protected long waitingTime = WAITING_TIME; // by default it's 0.1sec

    protected StateAbstract(){
        this.onCreate();
        new Thread(this).start();
    }

    /**
     * States
     */
    @Override
    public void run() {
        while(this.work) {
            onAction();
            onPause();
        }
        onDestroy();

    }

    /**
     * States
     */
    // when U create the handler
    protected void onCreate(){
        //System.out.println("onCreate" + CLASSNAME);
        this.work = true;
    };

    // the acction to reapeat during the execution
    protected void onAction(){
        //System.out.println("onAction" + CLASSNAME);

    }

    // when U should end you work
    protected void onDestroy(){
        //System.out.println("onDestroy"+ CLASSNAME);
        this.work = false;
    };

    // When U wait before checking
    protected void onPause(){
       // System.out.println("onPause"+ CLASSNAME);
        try {
            Thread.sleep(this.waitingTime);
        } catch (InterruptedException e) {
            // Normally It should never append
            e.printStackTrace();
        }
    }

    // go to the on Destroy statment;
    protected void finalizeThread(){
        this.work =false;
    }
}
