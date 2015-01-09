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
       
        Robot[] players=new Robot[6];
        players[0]=new GoalkeeperRobot(0);
        players[1]=new DefenderRobot(1);
        players[2]=new DefenderRobot(2);
        players[3]=new MidFielderRobot(3);
        players[4]=new ForwardRobot(4);       
        
        //Print out each player number along with their positions
        for(int k=0;k<5;k++){
            System.out.println("Player Number "+players[k].getPlayerNumber()+"is playing "+players[k].getCurrentPlayBehavior().getName());
            
        }
        
        //Initially the ball is with the goalkeeper
        int playerBall=0;
            
        // kicking the ball
        players[playerBall].performPlay();
        
        playerBall=2;
        
        //kickign the ball
        players[playerBall].performPlay();
        
        //give red card
        players[playerBall].setDown(true);
        System.out.println("Red card given to player"+players[playerBall].getPlayerNumber());
          
            
        //Add a playing position to a player
        
        System.out.println("1.Defender 2.Midfielder 3.Foward");
        try{
            Scanner sc = new Scanner(System.in);
            int position = sc.nextInt();
            switch(position){
            case 1:players[playerBall].setCurrentPlayBehavior(new DefenderPlay());
                break;
            case 2:players[playerBall].setCurrentPlayBehavior(new MidFielderPlay());
                break;
            case 3:players[playerBall].setCurrentPlayBehavior(new ForwardPlay());
                break;
            }
            }catch(Exception ex){
                System.out.println("Error while reading ");
                return;
            }               

            
            //Get the current position the player is playing in
            System.out.println(players[playerBall].getCurrentPlayBehavior().getName());
            
            
            
        
    
}
}
