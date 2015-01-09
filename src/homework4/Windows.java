/*

 */

package homework4;

import static java.lang.Thread.sleep;

/**
 *
 * @author Vipul Agarwal
 */
public class Windows extends Server {
    
    int sleepTime;
    public Windows(int serverId, String serverName) {
        super(serverId, serverName);
    }

    @Override
    void execute(Job job) {
        System.out.println("I am windows.I am starting "+job.getName());
        sleepTime=(int) (Math.random() * 60);
        job.status=Status.RUNNING;        
        memUsage=job.getMemResource();
        cpuUsage=job.getCpuResource();
        System.out.println("Job will run for "+sleepTime+".Job is utilising "+cpuUsage+ " CPU AND "+memUsage+" memory");
        this.job=job;
        status=true;
    }

    @Override
    void interrupt() {
        System.out.println("Windows Machine Command Interrupted Cancelling Job" +job.getName());
        job.status=Status.FAILED;  
        job=null;
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
                    status=false;
                    System.out.println("Windows Completed the job "+job.getName());
                    job=null;                       
                }
                else if(job.status==Status.COMPLETED){try {
                    //do nothing
                    sleep(1000);
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
