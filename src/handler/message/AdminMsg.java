package handler.message;

/**
 * Represent Administration msg
 */
public enum AdminMsg {
    ON,     // to restart a waiting handler
    OFF,    // to stop / kill the handler
    CONTINUE, // this message maintaint alive the threads
    WAIT;   // to stop the execution of the handler

}
