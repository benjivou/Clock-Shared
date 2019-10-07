package handler;


import handler.message.AdminMsg;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StandardHandler {

    protected ConcurrentLinkedQueue<AdminMsg> sudoInputCommand,sudoOutputCommand; // Channel to administration messages with the App

    public StandardHandler() {
        this.sudoInputCommand = new ConcurrentLinkedQueue<AdminMsg>();
        this.sudoOutputCommand = new ConcurrentLinkedQueue<AdminMsg>();
    }

    /**
     * Offer the possibility the Admin to send a message
     * @param msg
     */
    public void sendAdminCommand(AdminMsg msg){
        this.sudoInputCommand.add(msg);
    }

   /* public void readAdminCommand(){
        if(this.sudoOutputCommand.size() == 0){
            throw
        }
    }*/
}
