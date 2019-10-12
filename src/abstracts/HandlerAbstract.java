package abstracts;


import com.sun.scenario.effect.impl.state.AccessHelper;
import handler.message.AdminMsg;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class HandlerAbstract extends StateAbstract {
    public static final String NONE_RETURN="none";  // Anything to read
    public static final long LIFE_WITHOUT_ADVERTISE = 2000;


    private ConcurrentLinkedQueue<AdminMsg> sudoInputCommand,sudoOutputCommand; // Channel to administration messages with the App

   /*
    Channel to exchange data infos like serialized TimeHandlers  objects between the Application and the TimeHandler
    */
    private ConcurrentLinkedQueue<Object> inputsUtil,outputUtil;
    private long lastAdvertise; // the last time You receive the message to continue


    public HandlerAbstract() {
        onCreate();

    }

    @Override
    protected void onCreate() {
        super.onCreate();
        this.sudoInputCommand = new ConcurrentLinkedQueue<AdminMsg>();
        this.sudoOutputCommand = new ConcurrentLinkedQueue<AdminMsg>();

        this.inputsUtil = new ConcurrentLinkedQueue<Object>() ;
        this.outputUtil = new ConcurrentLinkedQueue<Object>() ;

        this.lastAdvertise = System.currentTimeMillis();
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
        if(this.outputUtil.isEmpty()){
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


        if(this.inputsUtil.isEmpty() ){
            throw new Exception(NONE_RETURN);
        }
        Object obj = this.inputsUtil.poll();
        // return msg
        return obj;

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

    /**
     * Finalize the thread if the handler didn't say anything
     */
    protected void checkConection(){
        if ( (System.currentTimeMillis()- this.lastAdvertise) > LIFE_WITHOUT_ADVERTISE ) {
            finalizeThread();
            System.out.println("Thread killed");
        }
    }

    @Override
    protected void onAction() {
        super.onAction();
        Boolean readSudo = true; // if U should read sudo channel
        AdminMsg adminMsg;

        Object obj = null;
        try {
            obj = this.readUtilCommandH();
        } catch (Exception e) {
            if (e.getMessage() != NONE_RETURN)
                e.printStackTrace();
        }

        if (obj != null )
            onMsgReceive(obj);




        // Admin command received
        while (this.sudoInputCommand.size()>0 && readSudo ){

                adminMsg = this.sudoInputCommand.poll();

                if (adminMsg != AdminMsg.CONTINUE) {
                    onSudoRequest(adminMsg);
                    readSudo = false; // stop reading the channel
                }

                this.lastAdvertise = System.currentTimeMillis();
            }
        checkConection();
    }

    /**
     * Special States
     */


    // When U receive a message
    protected void onMsgReceive(Object obj){};

    // When U receipt a command
    protected void onSudoRequest(AdminMsg msg){
        // if U receive a message of stop
        if(msg == AdminMsg.OFF  ){
            finalizeThread();
        }
        this.lastAdvertise = System.currentTimeMillis();
    };




}
