/*
    Implementation for Robot Player playing in Defender Position
 */

package homework1_2;

import java.util.ArrayList;

/**
 *
 * @author Vipul Agarwal
 */
public class DefenderRobot extends Robot {

    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public DefenderRobot(int playerNumber) {
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new DefenderPlay());
    }

    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a Defender");
    }
    
}
