/*
    Implementation for Robot Player playing in Forward Position
 */

package homework1_2;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Vipul Agarwal
 */
public class ForwardRobot_1 extends Robot_1 {
    
    //INitialise the playbehavior array.Add the default position to it and
    //add default position to the currentPosition
    //Intialise with a player Number passed to it 
    public ForwardRobot_1(int playerNumber,Observable o) {
        playBehavior=new ArrayList<>();
        playBehavior.add(new ForwardPlay_1());
        setPlayerNumber(playerNumber);
        setCurrentPlayBehavior(new ForwardPlay_1());
        this.observable=o;
        o.addObserver(this);
    }

    @Override
    void display() {
        System.out.println("Robot No "+getPlayerNumber()+".I am a Forward Player");
    }
    
}
