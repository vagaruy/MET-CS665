/*
/*
 Class that implements the Forward Play Position Behavior.
 */

package homework1_2;

/**
 *
 * @author Testing
 */
public class ForwardPlay implements PlayBehavior{

    @Override
    public void play(int playerNumber) {
        System.out.println("Number "+playerNumber+" Forward Played");
    }
    
    @Override
    public String getName() {
        return ("Forward");
    }
    
}
