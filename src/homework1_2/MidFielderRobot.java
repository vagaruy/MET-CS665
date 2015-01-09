/*
    Implementation for Robot Player playing in Midfield Position
 */

package homework1_2;

import java.util.ArrayList;

/**
 *
 * @author Vipul Agarwal
 */
public class MidFielderRobot extends Robot {
    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public MidFielderRobot(int playerNumber) {
        
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new MidFielderPlay());
    }

    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a MidFielder");
    }
    
}
