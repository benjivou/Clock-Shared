package handler;

import abstracts.HandlerAbstract;
import display.TimeGraphic;
import handler.message.ClockMode;
import handler.message.Language;

import java.time.LocalTime;

public class DisplayHandler extends HandlerAbstract {

    private ClockMode clockMode;
    private Language language;
    private TimeGraphic timeGraphic;

    public DisplayHandler(ClockMode clockMode, Language language){
        super();
        this.clockMode = clockMode;
        this.language = language;

        // if We need a graphic Panel
        if ( this.clockMode == ClockMode.GRAPHIC){
            this.timeGraphic = new TimeGraphic();
            refreshTime(LocalTime.now());
        }
    }

    private void refreshTime(LocalTime localTime){
        this.timeGraphic.refreshTime(localTime,this.language);
    }

    @Override
    protected void onCreate() {
        super.onCreate();



    }

    @Override
    protected void onMsgReceive() {
        super.onMsgReceive();
        try {
            // retrieve message from the queue
            LocalTime lt  =(LocalTime)this.readUtilCommandH();
            switch (this.clockMode){
                case GRAPHIC:
                    this.timeGraphic.displayTime(lt,this.language);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
