/*
/*
 Class that implements the Goalkeeper Play Position Behavior.
 */

package homework1_2;

/**
 *
 * @author Testing
 */
public class GoalkeeperPlay_1 implements PlayBehavior_1 {

    @Override
    public void play(int playerNumber) {
        System.out.println("Number "+playerNumber+" Goalkeeper Played");
    }
    
    @Override
    public String getName() {
        return("Goalkeeper");
    }
    
}
