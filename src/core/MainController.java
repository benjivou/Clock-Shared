package core;

import abstracts.AppAbstract;
import handler.DisplayHandler;
import handler.InputHandler;
import handler.TimeHandler;
import handler.message.AdminMsg;
import handler.message.ClockMode;
import handler.message.FromMode;
import handler.message.Language;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static abstracts.HandlerAbstract.NONE_RETURN;

/**
 * The core of the subject it control everything in the APP
 */
public class MainController extends AppAbstract {
    private int id ;
    /*
     List of Handlers
     */

    private InputHandler userInputs;



    /**
     * Describe what we should do to catch the time and send it to the display app
     */
    public void routineTimeToDisplay(){
        TimeHandler timeHandler;
        Object obj;
        Integer targetId;

        // read all elements
        for (Map.Entry entryTime : this.listOfTime.entrySet()){
            timeHandler = (TimeHandler) entryTime.getValue();
            try {
                // catch the msg
                obj = timeHandler.readUtilCommandA();
//                System.out.println("Application time " + ((LocalTime)obj).toString());
                // resend the message
                targetId = (Integer) entryTime.getKey();
                sendToDisplay((LocalTime)obj,targetId);


            } catch (Exception e) {
                String msg = e.getMessage();
                if (!( msg == NONE_RETURN)) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void addClock(ClockMode cl, Language lg, long waitingTime, FromMode fromMode,String name){
        this.listOfDisplays.put(id,new DisplayHandler(cl,lg,name));
        this.listOfTime.put(id,new TimeHandler(waitingTime,fromMode));
        id++;

 //       System.out.println("Sizeof listDisplays : " + this.listOfDisplays.size());
//        System.out.println("Sizeof listTime : " + this.listOfTime.size());
//        System.out.println("Id " + id);
    }




    @Override
    protected void onCreate() {
        super.onCreate();
        this.id = 0;
        this.listOfDisplays = new HashMap<>();
        this.listOfTime = new HashMap<>();
        this.waitingTime =10;


        // Creation of Clocks
        addClock(ClockMode.CMD,Language.FR,60000,FromMode.SYSTEM,"French_Clock" );
        addClock(ClockMode.CMD,Language.EN,1000,FromMode.SYSTEM,"English_Clock");
        // waiting initialization of the different handler
        addClock(ClockMode.GRAPHIC,Language.FR,60000,FromMode.SYSTEM,"French_Clock" );
        addClock(ClockMode.GRAPHIC,Language.EN,1000,FromMode.SYSTEM,"English_Clock");
        
        
        //add for server communication
        addClock(ClockMode.CMD,Language.FR,60000,FromMode.WEB,"French_Clock_server");
        addClock(ClockMode.CMD,Language.EN,1000,FromMode.WEB,"English_Clock_server");
        
        addClock(ClockMode.GRAPHIC,Language.FR,60000,FromMode.WEB,"French_Clock_server" );
        addClock(ClockMode.GRAPHIC,Language.EN,1000,FromMode.WEB,"English_Clock_server");
    }

    @Override
    protected void onAction() {
        super.onAction();

        // Catch all Hours U receive
        routineTimeToDisplay();

    }

    @Override
    protected void onAdminInputs(AdminMsg msg) {
        super.onAdminInputs(msg);
        switch (msg){
            case OFF:
                // go to onDestroy statement
                finalizeThread();
                break;
            case ON:
                break;
            case WAIT:
                break;
        }
    }

}
