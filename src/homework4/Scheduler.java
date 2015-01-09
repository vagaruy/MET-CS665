/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework4;

import static java.lang.Thread.sleep;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vipul Agarwal
 */
public class Scheduler implements Runnable {
    static ArrayBlockingQueue<Job> queue=new ArrayBlockingQueue<>(100); //store the jobs in a queue
    Server thread[];                                                    //servers that the scheduler will run on.
    private boolean interruption=false;                 //is there a job to be interrupted
    private int jobToInterrupt;             //job id of the job to be interrupted

    public Scheduler(Server thread[]) {
        this.thread=thread;
    }
    
    //Add a new job to the scheduler queue
    public void addCommand(Job job){
       queue.add(job);
       this.thread=thread;
        System.out.println("Job added to scheduler");
    }
    
    //interrupt a job
    public void interruptCommand(int uniqueID){
        interruption=true;
        jobToInterrupt=uniqueID;
    }
    
    //Display status of all jobs ever submitted to us..    
    public void displayJobsStatus(){
        Iterator i=queue.iterator();
            while(i.hasNext()){
                Job job=(Job)i.next();
                System.out.println("Status of Job "+job.getName()+" is "+job.getStatus());
            }
    }
    
    //Thread to keep the scheduler running always..Keeps checking if time elapsed for new jobs etc..
    @Override
    public void run() {
                System.out.println("Scheduler Running");
        while(true){
            if(interruption){
                for(int j=0;j<thread.length;j++){
                    if(thread[j].status()==jobToInterrupt){
                        thread[j].interrupt();
                        System.out.println("Scheduler interrupted a job "+jobToInterrupt);
                        interruption=false;
                    }
                }
                if(interruption){
                    System.out.println("Job was not running on any serve Sorry!!"+jobToInterrupt);
                    interruption=false;
                }
            }  
            Iterator i=queue.iterator();
            while(i.hasNext()){
                
                Job job=(Job)i.next();
                if(job.status==Status.CREATED)  //it needs a CPU allocation find one for it..
                {
                    if(job.getStartTime()<=(new Date()).getTime())
                    //System.out.println("Trying to assign cpu to jobs");
                    
                    for(int j=0;j<thread.length;j++){   //round robin allocation..Allocates the job to the first available CPU.
                        if(!thread[j].availability()){
                            job.status=Status.RUNNING;
                            thread[j].execute(job);
                            break;
                        }
                    }
                }                
                                
            }
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                
            }
        }
         
    }
    
    
    
    
    
}
