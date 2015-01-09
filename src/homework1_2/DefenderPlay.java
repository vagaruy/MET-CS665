/*
 Class that implements the Defender Play Position Behavior.
 */

package homework1_2;

/**
 *
 * @author Vipul Agarwal
 */
public class DefenderPlay implements PlayBehavior {
    
    @Override
    public void play(int playerNumber) {
        System.out.println("Number "+playerNumber+" Defender Played");
        
    }
    
    @Override
    public String getName() {
        return ("Defender");
    }
    
}
