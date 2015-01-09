/*
Interface to implement the Position of the Player.
Contains a function play() which performs the play at the position
Contains a function getName() to return the name of the Position (String)
 */

package homework1_2;

/**
 *
 * @author Vipul Agarwal
 */


public interface PlayBehavior {

    //Perform the play at this position
    public void play(int playerNumber) ; 
    
  //get teh name of the position
    public String getName();
}
