/*
    Implementation for Robot Player playing in Goalkeeper Position
 */

package homework1_2;

import java.util.ArrayList;

/**
 *
 * @author Vipul Agarwal
 */
public class GoalkeeperRobot extends Robot {
    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public GoalkeeperRobot(int playerNumber) {
        
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new GoalkeeperPlay());
    }
    
    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a GoalKeeper");
    }
    
}
