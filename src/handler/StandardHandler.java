package handler;


import handler.message.AdminMsg;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StandardHandler implements Runnable {
    public static final String NONE_RETURN="none"; // Anything to read

    protected ConcurrentLinkedQueue<AdminMsg> sudoInputCommand,sudoOutputCommand; // Channel to administration messages with the App

   /*
    Channel to exchange data infos like serilazed TimeHandlers  objects between the Application and the TimeHandler
    */
   protected ConcurrentLinkedQueue<String> inputsUtil,outputUtil;

    public StandardHandler() {
        this.sudoInputCommand = new ConcurrentLinkedQueue<AdminMsg>();
        this.sudoOutputCommand = new ConcurrentLinkedQueue<AdminMsg>();

        this.inputsUtil = new ConcurrentLinkedQueue<String>() ;
        this.outputUtil = new ConcurrentLinkedQueue<String>() ;
    }

    /**
     * Offer the possibility the Admin to send a message
     * @param msg
     */
    public void sendAdminCommand(AdminMsg msg){
        this.sudoInputCommand.add(msg);
    }

    /**
     * This offer to the App the possibility to read the Acknowledge if necessary
     */
    public AdminMsg readAdminCommand() throws Exception {

        // U have nothing to read
        if(this.sudoOutputCommand.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.sudoOutputCommand.poll();

    }

    /**
     * This offer to the App the possibility to read the Object request to handlers
     */
    public String readUtilCommand() throws Exception {
        // U have nothing to read
        if(this.outputUtil.size() == 0){
            throw new Exception(NONE_RETURN);
        }

        // return msg
        return this.outputUtil.poll();

    }

    /**
     * Offer the possibility the Admin to send a request for usage
     * @param msg
     */
    public void sendAdminCommand(String msg){
        this.inputsUtil.add(msg);
    }


    @Override
    public void run() {

    }
}
