/*
 Object that holds the Job.It is defined with all the attributes of the job such as resources, start time status etc.
THis is passed to the server etc 
 */

package homework4;

/**
 *
 * @author Vipul Agarwal
 */

enum Status {
    RUNNING, FAILED, COMPLETED,CREATED}

public class Job {
    String Name;
    long startTime;
    int uniqueId;
    int cpuResource;
    int memResource;
    int otherResource;
    String Command;
    Status status;

    public Job(String Name, long startTime, int uniqueId, int cpuResource, int memResource, int otherResource, String Command) {
        this.Name = Name;
        this.startTime = startTime;
        this.uniqueId = uniqueId;
        this.cpuResource = cpuResource;
        this.memResource = memResource;
        this.otherResource = otherResource;
        this.Command = Command;
        this.status = Status.CREATED;
    }

    public String getName() {
        return Name;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public int getCpuResource() {
        return cpuResource;
    }

    public int getMemResource() {
        return memResource;
    }

    public int getOtherResource() {
        return otherResource;
    }

    public String getCommand() {
        return Command;
    }

    public Status getStatus() {
        return status;
    }          
    
}
