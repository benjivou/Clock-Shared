package abstracts;


import handler.message.AdminMsg;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class HandlerAbstract extends StateAbstract {
    public static final String NONE_RETURN="none";  // Anything to read

    protected static String CLASSNAME = "StandardHandler";

    private ConcurrentLinkedQueue<AdminMsg> sudoInputCommand,sudoOutputCommand; // Channel to administration messages with the App

   /*
    Channel to exchange data infos like serialized TimeHandlers  objects between the Application and the TimeHandler
    */
    private ConcurrentLinkedQueue<Object> inputsUtil,outputUtil;
    private LocalTime lastAdvertise; // the last time You receive the message to continue
    // TODO

    public HandlerAbstract() {
        this.sudoInputCommand = new ConcurrentLinkedQueue<AdminMsg>();
        this.sudoOutputCommand = new ConcurrentLinkedQueue<AdminMsg>();

        this.inputsUtil = new ConcurrentLinkedQueue<Object>() ;
        this.outputUtil = new ConcurrentLinkedQueue<Object>() ;



        onCreate();

        new Thread(this).start();
    }

    /**
     * Admin to send a message
     * @param msg
     */
    public void sendAdminCommandA(AdminMsg msg){
        this.sudoInputCommand.add(msg);
    }
    /**
     * Handler send an Admin message
     * @param msg
     */
    protected void sendAdminCommandH(AdminMsg msg){
        this.sudoOutputCommand.add(msg);
    }

    /**
     * Admin read command admin message
     */
    public AdminMsg readAdminCommandA() throws Exception {

        // U have nothing to read
        if(this.sudoOutputCommand.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.sudoOutputCommand.poll();

    }

    /**
     * Handler read command admin message
     */
    protected AdminMsg readAdminCommandH() throws Exception {

        // U have nothing to read
        if(this.sudoInputCommand.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.sudoInputCommand.poll();

    }

    /**
     * Admin read the Object canal
     */
    public Object readUtilCommandA() throws Exception {
        // U have nothing to read
        if(this.outputUtil.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.outputUtil.poll();

    }

    /**
     * Handler read the Object canal
     */
    protected Object readUtilCommandH() throws Exception {
        // U have nothing to read
        if(this.outputUtil.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.outputUtil.poll();

    }


    /**
     * Admin send a message
     * @param msg
     */
    public void sendUtilCommandA(Object msg){
        this.inputsUtil.add(msg);
    }

    /**
     * Handler send a message
     * @param msg
     */
    protected void sendUtilCommandH(Object msg){
        this.outputUtil.add(msg);
    }


    @Override
    protected void onAction() {
        super.onAction();

        if(this.inputsUtil.size() >0){
            onMsgReceive();
        }

        if (this.sudoInputCommand.size()>0){
            onSudoRequest();
        }
    }

    /**
     * Special States
     */


    // When U receive a message
    protected void onMsgReceive(){};

    // When U receipt a command
    protected void onSudoRequest(){
        // if U receive a message of stop
        if(this.sudoInputCommand.peek().equals(AdminMsg.OFF) ){
            finalizeThread();
        }
    };


}
