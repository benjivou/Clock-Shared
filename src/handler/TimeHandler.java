package handler;

import handler.message.AdminMsg;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TimeHandler extends StandardHandler{
    @Override
    public void sendAdminCommand(AdminMsg msg) {
        super.sendAdminCommand(msg);
    }

    @Override
    public AdminMsg readAdminCommand() throws Exception {
        return super.readAdminCommand();
    }

    @Override
    public String readUtilCommand() throws Exception {
        return super.readUtilCommand();
    }

    @Override
    public void sendUtilCommand(String msg) {
        super.sendUtilCommand(msg);
    }

    public TimeHandler() {
        super();
    }
}
