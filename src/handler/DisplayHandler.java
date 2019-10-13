package handler;

import abstracts.HandlerAbstract;
import display.DisplayTime;
import display.TimeCmd;
import display.TimeGraphic;
import handler.message.ClockMode;
import handler.message.Language;

import java.time.LocalTime;

public class DisplayHandler extends HandlerAbstract {

    private ClockMode clockMode;
    private Language language;
    private DisplayTime timeGraphic;
    private String name;

    public DisplayHandler(ClockMode clockMode, Language language, String name){
        super();
        this.clockMode = clockMode;
        this.language = language;
        this.name = name;

        // if We need a graphic Panel
        switch (this.clockMode ){
            case GRAPHIC:
 //               System.out.println("Graphic ");
                this.timeGraphic = new TimeGraphic(this.name);
                break;
            case CMD:
 //               System.out.println("CMD ");
                this.timeGraphic = new TimeCmd(this.name);
                break;

        }
   //     System.out.println("Display handler");

    }



    @Override
    protected void onCreate() {
        super.onCreate();

    }

    @Override
    protected void onMsgReceive(Object obj) {
        super.onMsgReceive(obj);


        // retrieve message from the queue
        LocalTime lt  =(LocalTime)obj;


        switch (this.clockMode){
            case GRAPHIC:
                this.timeGraphic.displayTime(lt,this.language);
                break;
            case CMD:

                this.timeGraphic.displayTime(lt,this.language);
 //               System.out.println("CMD Display");
                break;
        }
 //       System.out.println("Local time received to display localtime stored");

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        switch (this.clockMode){
            case GRAPHIC:
                ((TimeGraphic)this.timeGraphic).closeWindow();
                break;

        }
    }
}
