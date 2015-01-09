/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Testing
 */
public class Homework5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        playGame();
        
    }
    
    private static void playGame() {
        System.out.println("Job Scheduling Program Demonstration.");
        System.out.println("Starting the job manager");
        ArrayList<Jobs> jobs =new ArrayList<>(100);
        UserFactory factory=new UserFactory();
        System.out.println("Making a Operator User");
        
        Roles user=factory.getRole("Operator","Vipul",1);
        user.display();
        
        while (true) {

            //Menu of the actions that can be performed.
            System.out.println("Please enter your choice from below");
            System.out.println("Actions 1.Create a Job 2.Display all Jobs  3.Delete a Job 4.View Job 5.Change State of Job 6.Add Permission to User 7.Exit");
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
                String userName;
                String name;
                //Read the name of the client and the stock symbol and amount to buy
                try {
                    System.out.println("Please enter the Job name");
                    Scanner sc = new Scanner(System.in);
                    name = sc.next();
                    Jobs job = new Jobs(name);
                    if((user.getRoles()&AccessRoles.access.CREATE.getValue())==AccessRoles.access.CREATE.getValue()){                        
                        System.out.println("User has privilige to add jobs ..Adding the job");
                        jobs.add(job);
                    }
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }

            } //Display status of all Jobs
            else if (action == 2) {
                Iterator i=jobs.iterator();
                while(i.hasNext()){
                 Jobs j=(Jobs) i.next();
                    System.out.println("Job "+j.getName()+" State="+j.isState());
                }

            } //delete a job after checking the users permissions
            else if (action == 3) {
                
                String name;
              
                try {
                    System.out.println("Please enter the Job name to delete");
                    Scanner sc = new Scanner(System.in);
                    name = sc.next();
                    if((user.getRoles()&AccessRoles.access.DELETE.getValue())==AccessRoles.access.DELETE.getValue()){                        
                        System.out.println("User has privilige to delete jobs ..deleting the job");
                        Iterator i=jobs.iterator();
                        while(i.hasNext()){
                             Jobs j=(Jobs) i.next();
                             if(j.getName().equals(name))
                             {
                                 System.out.println("Job found and is being deleted");
                                 break;
                             }
                        }                        
                    }
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }

            } //Check if the stock exchange is currently processing the commands 
            else if (action == 4) {
                String name;
              
                try {
                    System.out.println("Please enter the Job name to view status of");
                    Scanner sc = new Scanner(System.in);
                    name = sc.next();
                    if((user.getRoles()&AccessRoles.access.VIEW.getValue())==AccessRoles.access.VIEW.getValue()){                        
                        System.out.println("User has privilige to VIEW jobs");
                        Iterator i=jobs.iterator();
                        while(i.hasNext()){
                             Jobs j=(Jobs) i.next();
                             if(j.getName().equals(name))
                             {
                                 System.out.print("Job found");
                                 if(j.isState())
                                     System.out.print(" and is Running\n");
                                 else
                                     System.out.print("and is stopped\n");
                                 break;
                             }
                        }                        
                    }
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }
        }
             else if (action == 5) {
                String name;
              
                try {
                    System.out.println("Please enter the Job name to change status of");
                    Scanner sc = new Scanner(System.in);
                    name = sc.next();
                    if((user.getRoles()&AccessRoles.access.VIEW.getValue())==AccessRoles.access.VIEW.getValue()){                        
                        System.out.println("User has privilige to change status");
                        Iterator i=jobs.iterator();
                        while(i.hasNext()){
                             Jobs j=(Jobs) i.next();
                             if(j.getName().equals(name))
                             {
                                 System.out.print("Job found");
                                 if(j.isState())
                                     j.setState(false);
                                 else
                                     j.setState(true);
                                 break;
                             }
                        }                        
                    }
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }
        }
             else if (action == 6) {
                int name;
              
                try {
                    System.out.println("Please enter the permission number to add 1.View 2.DELETE 3.change state 4.create ");
                    Scanner sc = new Scanner(System.in);
                    name = sc.nextInt();
                    
                    switch(name){
                        case 1:
                            user=new ViewAddRoleDecorator(user);
                            
                            break;
                        case 2:
                            user=new DeleteAddRoleDecorator(user);
                            break;
                        case 3:
                            user=new RunAddRoleDecorator(user);
                            break;
                        case 4:
                            user=new CreateAddRoleDecorator(user);
                            break;
                    }
                    user.display();
                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }
        }
             else if(action==7){
                 System.exit(0);
             }
    }
}

    
}
