/*
/*
 Class that implements the MidFielder Play Position Behavior.
 */
 

package homework1_2;

/**
 *
 * @author Testing
 */
public class MidFielderPlay implements PlayBehavior  {

    @Override
    public void play(int playerNumber) {
        System.out.println("Number "+playerNumber+" MidFielder Player");
    }

    @Override
    public String getName() {
        return ("MidFielder");
    }

 
    
}
