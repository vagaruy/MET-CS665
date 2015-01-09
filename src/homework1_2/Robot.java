/*
    This is the abstract class for a Robot Player
    Every kind of RObot Player inherits this class and implements the abstract methods.
 */
package homework1_2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Vipul Agarwal
 */
public abstract class Robot {

    
    int playerNumber;                       //Unique Player Number
    PlayBehavior currentPlayBehavior;       //Variable to store current Player Position
    boolean down;                           //Variable to store if a red card is given to the player

    
    //Returns if the player has been given a red card or not
    public boolean isDown() {
        return down;
    }

    //Sets if a red card has been given to the player
    public void setDown(boolean down) {
        this.down = down;
    }

    public Robot() {
    }

    //Abstract method to display some info about the player..Individual implementations made
    abstract void display();

    //Returns the Player NUmber of the Robot player
    public int getPlayerNumber() {
        return playerNumber;
    }

    //Sets the player Number
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    //Returns the current playing position of the player
    public PlayBehavior getCurrentPlayBehavior() {
        return currentPlayBehavior;
    }
    
    //Sets the current palying position of the player
    public void setCurrentPlayBehavior(PlayBehavior pb) {
        currentPlayBehavior = pb;
    }

    //Plays.Also checks if the player is down.Then doesn't play.
    public void performPlay() {
        if(down){
            System.out.println("Player "+playerNumber+" is down!");
        }
        else{
        getCurrentPlayBehavior().play(playerNumber);
        }
    }
}
