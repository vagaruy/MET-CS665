/*

 */

package homework4;

/**
 *
 * @author Vipul Agarwal
 */
public abstract class Server implements Runnable {
    
    int serverId;       //Server Id
    String serverName;  //Server Name
    int cpuUsage;       //Current CPU Usage
    int memUsage;       //Current Memory Usage
    boolean status;     //Server is not running or not
    Job job;

    public Server(int serverId, String serverName) {    //Initialise the server Variables
        this.serverId = serverId;
        this.serverName = serverName;
        this.cpuUsage=0;
        this.memUsage=0;
        this.status=false;
    }
    
    public int status(){
        if(job!=null){
            return job.uniqueId;
        }
        else
            return 0;
    }
    
    public int cpuUsage(){
        return cpuUsage;
    }
    
    public boolean availability(){
        return status;
    }
    
    abstract void execute(Job job);
    abstract void interrupt();
    
    @Override
    public abstract void run();
    
}
