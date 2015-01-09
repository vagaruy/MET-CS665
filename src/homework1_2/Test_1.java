/*
    The test program is a game playing simulation.
    1.The game starts by asking the number of players to be initialised as playing in various positions.
    2.After that the player numbers assigned and their positions are printed for the user.
    3.The game starts by displaying the ball with the user and then gives a list of actions that can be performed.
    4a.Kick Ball-Here we pass ball towards the Goal by using this relation GOalkeeper->Defender->MIdfield->FOrward.
        In each step, a random generator decides which player to pass the ball to and then passes the ball.
        When it reaches the forward, a random generator gives a 50% chance of scoring after which it is returned to the goalkeeper
    4b.Red Card- GIve a red card to the current player.The player won't be able to play after getting the red card.
    4c.Add Position->Add a new position to the current player.List of all availalbe positions are given.Only added if not already in the list of its positions.
    4d.Display ALl Positions->List of all positions that the current players plays in.
    4e.Display Current Position->Current Position the player is playing in.
    4f.Exit Game->Exit the game.
    4g.Restart Game->Start the game from the beginning.
 */

package homework1_2;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Testing
 */
public class Test {
    
    
    
    public static void main(String args[]){
       
       while(true)
        {
            playGame();
        }
   
        
//        Robot[] players=new Robot[6];
//        players[0]=new GoalkeeperRobot(0);
//        players[1]=new DefenderRobot(1);
//        players[2]=new DefenderRobot(2);
//        players[3]=new MidFielderRobot(3);
//        players[4]=new ForwardRobot(4);       
        
    }

    private static void playGame() {
        
        int totalPlayers=0; //Total number of players
        
        BallPosition pos=new BallPosition("initial");
        System.out.println("Playing a 1-Player Game of Football.Enjoy!");
        System.out.println("Please enter the number of defender midfield and forward players eg 3 3 2");
        
        int[] integers;//Array to save the number of players at different positions
         try{
        Scanner sc = new Scanner(System.in);
         integers = new int[3];
        for(int i = 0; i < 3; i++)
        {
            integers[i] = sc.nextInt(); //Save the number of players in each position
            totalPlayers+=integers[i];  //Increase the total player count
            
        }
        }catch(Exception ex){
            System.out.println("Player number error.Restarting the game");
            return;
        }
        totalPlayers+=1;    //One more player for the goalkeeper
        
        System.out.println("Total players in team is "+totalPlayers);
        
        Robot[] players=new Robot[totalPlayers];    //Initialise the list of all players
        
        int i=0;
        //Initialise the player 0 as Goalkeeper
        players[0]=new GoalkeeperRobot(i++,pos);
        
        System.out.println("Player Number "+players[0].getPlayerNumber()+"is playing "+players[0].getCurrentPlayBehavior().getName());
        
        //Initialise the defense players..
        for(int k=i;k<i+integers[0];k++){
            players[k]=new DefenderRobot(k,pos);
        }        
        i+=integers[0];
        
        //initialise midfield players
        for(int k=i;k<i+integers[1];k++){
            players[k]=new MidFielderRobot(k,pos);
        }        
        i+=integers[1];
        
        //initialise forward players
        for(int k=i;k<i+integers[2];k++){
            players[k]=new ForwardRobot(k,pos);
        }        
        i+=integers[2];
        System.out.println(i);
        
        //Print out each player number along with their positions
        for(int k=0;k<totalPlayers;k++){
            System.out.println("Player Number "+players[k].getPlayerNumber()+"is playing "+players[k].getCurrentPlayBehavior().getName());
            
        }
        
        System.out.println("Game Starting now");
        
        //Initially the ball is with the goalkeeper
        int playerBall=0;
        pos.changeBallPosition("lower");
        
        while(true){
            
            //System.out.println("Ball is with Player "+players[playerBall].getPlayerNumber()+" "+players[playerBall].getCurrentPlayBehavior().getName());
            //Menu of the actions that can be performed.
            System.out.println("Actions 1.Kick Ball 2.Give Red Card 3.Add Position 4.Display All Positions 5.Display Current Position 6.Exit Game 7.Restart Game 8.Change Ball Position");
            
            int action;
            
            //Read in the action to be performed
            try{
                Scanner sc = new Scanner(System.in);
                action = sc.nextInt();
            }catch(Exception ex){
                System.out.println("Error while reading ");
                return;
            }
            
            //If the action is kicking the ball
            if (action == 1) {
                
                //Select a player at one position at random and pass him the ball
                Random randomGenerator = new Random();
                if (players[playerBall].getCurrentPlayBehavior().getName().equals("Goalkeeper")) {
                    playerBall = randomGenerator.nextInt(integers[0]) + 1;
                    
                } else if (players[playerBall].getCurrentPlayBehavior().getName().equals("Defender")) {
                    playerBall = randomGenerator.nextInt(integers[1]) + integers[0] + 1;
                    pos.changeBallPosition("middle");
                } else if (players[playerBall].getCurrentPlayBehavior().getName().equals("MidFielder")) {
                    playerBall = randomGenerator.nextInt(integers[2]) + integers[1] + integers[0] + 1;
                    pos.changeBallPosition("upper");
                } else if (players[playerBall].getCurrentPlayBehavior().getName().equals("Forward")) {
                    if (randomGenerator.nextInt(2) == 1) {
                        System.out.println("GOALLLLL!!!!");
                    } else {
                        System.out.println("MISSED GOAL :(");
                    }
                    pos.changeBallPosition("lower");
                    playerBall = 0;
                }
                players[playerBall].performPlay();
                System.out.println("Ball passed to " + players[playerBall].getPlayerNumber() + " " + players[playerBall].getCurrentPlayBehavior().getName());
            }
            
            //Give a player a red card
            else if(action==2){
                players[playerBall].setDown(true);
                System.out.println("Red card given to player"+players[playerBall].getPlayerNumber());
            }
            
            //Add a playing position to a player
            else if(action==3){
                System.out.println("1.Defender 2.Midfielder 3.Foward");
                try{
                    Scanner sc = new Scanner(System.in);
                    int position = sc.nextInt();
                    switch(position){
                    case 1:players[playerBall].setPlayBehavior(new DefenderPlay());
                        break;
                    case 2:players[playerBall].setPlayBehavior(new MidFielderPlay());
                        break;
                    case 3:players[playerBall].setPlayBehavior(new ForwardPlay());
                        break;
                    }
                    }catch(Exception ex){
                        System.out.println("Error while reading ");
                        return;
                    }               
            }
            
            //Get all the positions the player plays at
            else if(action==4){
                players[playerBall].getPlayBehavior();
            }
            
            //Get the current position the player is playing in
            else if(action==5){
                System.out.println(players[playerBall].getCurrentPlayBehavior().getName());
            }
            
            //Stop playing the game
            else if(action==6){
                System.out.println("Exit Game");
                exit(0);
            }
            
            //Restart the game
            else if(action==7){
                System.out.println("Restarting Game");
                return;
            }
            else if (action==8){
                try{
                    Scanner sc = new Scanner(System.in);
                    String position = sc.next();
                    pos.changeBallPosition(position);
                    
                    }catch(Exception ex){
                        System.out.println("Error while reading ");
                        return;
                    }               
            }
            
        }
    
}
}
