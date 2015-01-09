/*
    Implementation for Robot Player playing in Midfield Position
 */

package homework1_2;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Vipul Agarwal
 */
public class MidFielderRobot_1 extends Robot {
    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public MidFielderRobot_1(int playerNumber,Observable o) {
        playBehavior=new ArrayList<>();
        playBehavior.add(new MidFielderPlay());
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new MidFielderPlay());
        this.observable=o;
        o.addObserver(this);
    }

    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a MidFielder");
    }
    
}
