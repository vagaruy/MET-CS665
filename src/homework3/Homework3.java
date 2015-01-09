/*
 Function to test the functionalities of the whole system
 */
package homework3;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Vipul Agarwal
 */
public class Homework3 {

    /**
     * Test case for testing the whole system.
     */
    public static void main(String[] args) {
        // The following function encapsulatees the whole

        playGame();

        
    }

    private static void playGame() {
        System.out.println("Welcome To Vagaruy Stock Trading!We Help You Make Kazillions!");
        TransactorThread stockExchange = new TransactorThread();
        Thread thread=new Thread(stockExchange);
        thread.start();
        StockTrade stockTrade = new StockTrade();

        while (true) {

            
            //Menu of the actions that can be performed.
            System.out.println("Please enter your choice from below");
            System.out.println("Actions 1.Stock Buy 2.Stock Sell  3.Get the number of commands in queue 4.Check if stocks are currently getting processed 5.Exit");
            int action;

            //Read in the action to be performed
            try {
                Scanner sc = new Scanner(System.in);
                action = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Error while reading ");
                return;
            }

            //If the action is buying stocks
            if (action == 1) {
                String clientName = null, stockSymbol = null;
                int clientId = 0, stockAmount = 0;
                //Read the name of the client and the stock symbol and amount to buy
                try {
                    System.out.println("Please enter the client name");
                    Scanner sc = new Scanner(System.in);
                    clientName = sc.next();
                    System.out.println("Please enter the client ID");
                    sc = new Scanner(System.in);
                    clientId = sc.nextInt();
                    System.out.println("Please enter the stock symbol you want to buy");
                    sc = new Scanner(System.in);
                    stockSymbol = sc.next();
                    System.out.println("Please enter the stock amount you want to buy");
                    sc = new Scanner(System.in);
                    stockAmount = sc.nextInt();

                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }
                
                Client client = new Client(clientName, clientId);//create a new client with the supplied data
                Stock stock = new Stock(stockAmount, stockSymbol);//create a new stock object with the supplied data
                StockBuyCommand buy = new StockBuyCommand(client, stockTrade, stock);//create a new Buy command
                stockExchange.addCommand(buy);//add the command to the Transaction Queue which will process it in the right time

            } //Sell stocks
            
            else if (action == 2) {
                String clientName = null, stockSymbol = null;
                int clientId = 0, stockAmount = 0;
                //Read the name of the client and the stock symbol and amount to sell
                try {
                    System.out.println("Please enter the client name");
                    Scanner sc = new Scanner(System.in);
                    clientName = sc.next();
                    System.out.println("Please enter the client ID");
                    sc = new Scanner(System.in);
                    clientId = sc.nextInt();
                    System.out.println("Please enter the stock symbol you want to sell");
                    sc = new Scanner(System.in);
                    stockSymbol = sc.next();
                    System.out.println("Please enter the stock amount you want to sell");
                    sc = new Scanner(System.in);
                    stockAmount = sc.nextInt();

                } catch (Exception ex) {
                    System.out.println("Error while reading ");
                }

                Client client = new Client(clientName, clientId);//create  a new client with supplied data
                Stock stock = new Stock(stockAmount, stockSymbol);//create a new stock object with supplied data
                StockSellCommand sell = new StockSellCommand(client, stockTrade, stock);//create  a new stock sell command
                stockExchange.addCommand(sell);//add the stock sell command to the stock command queue to be executed at the right time
                
            }
            //Check the number of commands currently in the queue to be processed
            else if (action == 3) {
                System.out.println("No of queued commands is" + stockExchange.queueSize());//Print the queue size 
            } //Check if the stock exchange is currently processing the commands 
            else if (action == 4) {
                if(stockExchange.checkTime())
                    System.out.println("Yes Stock exchange is open");
                else
                    System.out.println("Sorry Stock Exchange is closed.");

            } //Exit the test program.
            else if (action == 5) {
                System.out.println("Stock Brokering Exiting. Off to Sleep");
                exit(0);
            }

        }
    }
}
