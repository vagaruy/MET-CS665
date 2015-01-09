/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework3;

import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vipul Agarwal
 */
public class TransactorThread implements Runnable {
    private final ArrayBlockingQueue<Command> commandQueue;//Thread safe queue to store the commands sent to the stock exchange

    
    
    public TransactorThread() {
        commandQueue=new ArrayBlockingQueue<>(1000);   //array blocking queue to store the commands sent its way.initialized here
    }
    
    //Add a command to the queue
    public void addCommand(Command cmd){
        commandQueue.add(cmd);
    }
    
    //Function to check if the stock exchange is currently processing commands.
    //Returns true if Yes else False
    public boolean checkTime() {
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //System.out.println("day of week is"+dayOfWeek);
        if ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY)) {//check if the day is between Mondary and Friday
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            if ((hour > 9) && (hour <= 16)) {//Check if Hour is between 9 and 4
                return true;
            } else if ((hour == 9) && (min >= 30)) {//check if Hour is 9 and Minutes >30
                return true;
            } 
        }
        return false;//if all of them fails returns false..
    }
    
    
    public int queueSize(){
        int size=0;
        Iterator i=commandQueue.iterator();//Iterator to calculate the number of commands currently queued.
        while(i.hasNext()){
            size++;
            i.next();
        }
        
        return size;    //return the number of queueud commands
    }

    @Override
    public void run() {
        
        while(true){    //keep the thread up and running forever!!
            if(checkTime())    //time is betweenw hat we expect it be then
            {
                if(!commandQueue.isEmpty()){    //if there are commands to process
                    
                    Command cmd=commandQueue.remove();  //pop an item from the queue
                    cmd.execute();  //execute the item
                }
              
                else{       //no commands in teh queue..keep sleeping!
                    try {
                        sleep(4000);        //wake every 4 seconds to check if there are any commands to execute.
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TransactorThread.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Thread Interrupted..All data garbaged!!");
                    }
                }
            }
            try {
                sleep(4000);    //nothing to do..sleep for some time before checking again.
            } catch (InterruptedException ex) {
                Logger.getLogger(TransactorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
