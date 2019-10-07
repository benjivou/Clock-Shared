package handler;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TimeHandler extends StandardHandler{
    public TimeHandler(ConcurrentLinkedQueue<String> sudoInputCommand, ConcurrentLinkedQueue<String> sudoOutputCommand) {
        super(sudoInputCommand, sudoOutputCommand);
    }
}
