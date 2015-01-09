/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import static java.lang.System.exit;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Testing
 */
public class Homework4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        System.out.println("Job Scheduling Program Demonstration.");
        Server server[] = new Server[4];
        server[0] = new Windows(100, "Windows");
        server[1] = new Solaris(190, "Solaris");
        server[2] = new Linux(230, "Linux");
        server[3] = new AIX(450, "AIX");

        Thread thread[] = new Thread[4];
        thread[0] = new Thread(server[0]);
        thread[1] = new Thread(server[1]);
        thread[2] = new Thread(server[2]);
        thread[3] = new Thread(server[3]);
        thread[0].start();
        thread[1].start();
        thread[2].start();
        thread[3].start();

        Scheduler sch = new Scheduler(server);
        Thread schthread = new Thread(sch);
        schthread.start();

        while (true) {

            //Menu of the actions that can be performed.
            System.out.println("Please enter your choice from below");
            System.out.println("Actions 1.Add a Job 2.See All Jobs Status  3.Interrupt a Job 4.List Servers & Their Activity 5.Exit");
            int action;

            //Read in the action to be performed
            try {
                Scanner sc = new Scanner(System.in);
                action = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Error while reading ");
                return;
            }

            //If the action is adding a new job!!
            if (action == 1) {
                int id, cpu;
                long starttime;
                String name, command;
                //Read the name of the client and the stock symbol and amount to buy
                try {
                    System.out.println("Please enter the Job name");
                    Scanner sc = new Scanner(System.in);
                    name = sc.next();
                    System.out.println("Please enter the Job ID");
                    sc = new Scanner(System.in);
                    id = sc.nextInt();
                    System.out.println("Please enter the Job StartTime Milliseconds from now!");
                    sc = new Scanner(System.in);
                    starttime = sc.nextLong();
                    System.out.println("Please enter the Job CPU resource");
                    sc = new Scanner(System.in);
                    cpu = sc.nextInt();
                    System.out.println("Please enter the Job Command");
                    sc = new Scanner(System.in);
                    command = sc.next();
                    Job job = new Job(name, starttime + (new Date()).getTime(), id, cpu, cpu, cpu, command);
                    sch.addCommand(job);
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }

            } //Display status of all Jobs
            else if (action == 2) {
                sch.displayJobsStatus();

            } //Check the number of commands currently in the queue to be processed
            else if (action == 3) {
                int id = 0;
                System.out.println("Please enter the Job ID to interrupt!!");
                try {
                    Scanner sc = new Scanner(System.in);
                    id = sc.nextInt();
                } catch (Exception ex) {

                }
                sch.interruptCommand(id);

            } //Check if the stock exchange is currently processing the commands 
            else if (action == 4) {
                for (int i = 0; i < server.length; i++) {
                    System.out.println("Server Name" + server[i].serverName);
                    System.out.println("ID" + server[i].serverId + " CPU Usage:" + server[i].cpuUsage + " MEM Usage:" + server[i].memUsage);
                    if (server[i].status() == 0) {
                        System.out.println("Server is running no jobs");
                    } else {
                        System.out.println("Server is running Job " + server[i].job.getName() + " Job Id" + server[i].status());
                    }
                }
            } else if (action == 5) {
                System.exit(0);
            }
        }
    }
}
