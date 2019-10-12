package abstracts;

import handler.message.AdminMsg;

public abstract class StateAbstract implements Runnable{
    public static final long WAITING_TIME=100;      // waiting time use by default in the onPause state




    private boolean work; // say if the handler is Actually Running
    protected long waitingTime;

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
        this.waitingTime = WAITING_TIME;
    };

    // the acction to reapeat during the execution
    protected void onAction(){
        //System.out.println("onAction" );

    }

    // when U should end you work
    protected void onDestroy(){
        System.out.println("onDestroy "+ "Handler");
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
        System.out.println("Finalize Handler");
        this.work =false;
    }
}
