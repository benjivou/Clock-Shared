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

        // Create the object for the display strategy
        switch (this.clockMode ){
            case GRAPHIC:
                this.timeGraphic = new TimeGraphic(this.name);
                break;
            case CMD:
                this.timeGraphic = new TimeCmd(this.name);
                break;
        }
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
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        switch (this.clockMode){
            case GRAPHIC:
                // close the window if it's a panel
                ((TimeGraphic)this.timeGraphic).closeWindow();
                break;
        }
    }
}
