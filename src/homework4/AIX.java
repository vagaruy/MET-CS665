/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework4;

import static java.lang.Thread.sleep;

/**
 *
 * @author Testing
 */
public class AIX extends Server{
    private int sleepTime;

    public AIX(int serverId, String serverName) {
        super(serverId, serverName);
    }

    @Override
    void execute(Job job) {
        System.out.println("AIX Superior Server.I am starting "+job.getName());
        sleepTime=(int) (Math.random() * 60);
        job.status=Status.RUNNING;        
        memUsage=job.getMemResource();
        cpuUsage=job.getCpuResource();
        System.out.println("AIX REPORTING :Job will run for "+sleepTime+".Job is utilising "+cpuUsage+ " CPU AND "+memUsage+" memory");
        this.job=job;
        status=true;
    }

    @Override
    void interrupt() {
        System.out.println("AIX Machine Command Interrupted Cancelling Job" +job.getName());
        job.status=Status.FAILED; 
        status=false;
        
        
    }
@Override
    public void run() {
        while(true){
            if(job!=null){
                if(job.status==Status.RUNNING && sleepTime>0){
                    //run the job for a arbitrary amount of time.
                    sleepTime--;
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        sleepTime--;
                    }
                }
                else if(job.status==Status.RUNNING && sleepTime<=0){
                    job.status=Status.COMPLETED;
                    System.out.println("AIX Completed the job"+job.getName());
                    job=null;                       
                }
                else if(job.status==Status.COMPLETED){try {
                    //do nothing
                    sleep(1000);
                    status=false;
                    } catch (InterruptedException ex) {                        
                    }
                }                    
            }
            else{
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
            }
            
        }
               
    }
    
}
