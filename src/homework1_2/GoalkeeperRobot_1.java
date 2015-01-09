/*
    Implementation for Robot Player playing in Goalkeeper Position
 */

package homework1_2;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Vipul Agarwal
 */
public class GoalkeeperRobot_1 extends Robot_1 {
    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public GoalkeeperRobot_1(int playerNumber,Observable o) {
        playBehavior=new ArrayList<>();
        playBehavior.add(new DefenderPlay_1());
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new GoalkeeperPlay_1());
        this.observable=o;
        o.addObserver(this);
    }
    
    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a GoalKeeper");
    }
    
}
