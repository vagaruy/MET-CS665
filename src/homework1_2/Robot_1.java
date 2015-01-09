/*
    This is the abstract class for a Robot Player
    Every kind of RObot Player inherits this class and implements the abstract methods.
 */
package homework1_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Vipul Agarwal
 */
public abstract class Robot_1 implements Observer,ActivityBehavior {

    ArrayList<PlayBehavior_1> playBehavior;   //Container for all types of Positions a palyer can play in
    int playerNumber;                       //Unique Player Number
    PlayBehavior_1 currentPlayBehavior;       //Variable to store current Player Position
    boolean down;     //Variable to store if a red card is given to the player
    
    
    boolean pastActivity; //save the last Activity of the player Whether playing or sleeping
    Observable observable;  //The observable object that is checked and notified

    //Update method of the observer.Called whenever there is a change in the ball position.
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof BallPosition) {
            BallPosition pos = (BallPosition) o;
            //Get list of all the positions the player can play in
            Iterator<PlayBehavior_1> it = playBehavior.iterator();
            int flag=0;
            while (it.hasNext()) {
                PlayBehavior_1 p = it.next();
                //if one of the position is a goalkeeper  then
                if (p.getName().equalsIgnoreCase("Goalkeeper")) {
                    //If position is lower then activate the robot if not already activated.
                    if (pos.getBallPosition().equalsIgnoreCase("lower")) {
                        if(!pastActivity){
                            pastActivity=true;
                            resume();
                            return;
                        } 
                        else{
                            return;
                        }
                        
                    }
                    else{
                        flag=1;
                    }
                }
                
                else if (p.getName().equalsIgnoreCase("Defender")) {
                    if (pos.getBallPosition().equalsIgnoreCase("lower")) {
                        if(!pastActivity){
                            pastActivity=true;
                            resume();
                            return;
                        } 
                        else{
                            return;
                        }
                        
                    }
                    else{
                        flag=1;
                    }
                }
                else if (p.getName().equalsIgnoreCase("Midfielder")) {
                    if (pos.getBallPosition().equalsIgnoreCase("middle")) {
                        if(!pastActivity){
                            pastActivity=true;
                            resume();
                            return;
                        } 
                        else{
                            return;
                        }
                        
                    }
                    else{
                        flag=1;
                    }
                }
                else  if (p.getName().equalsIgnoreCase("Forward")) {
                    if (pos.getBallPosition().equalsIgnoreCase("upper")) {
                        if(!pastActivity){
                            pastActivity=true;
                            resume();
                            return;
                        } 
                        else{
                            return;
                        }
                        
                    }
                    else{
                        flag=1;
                    }
                }
                }
            
            //The ball is not in this players position so goto sleep if not already sleeping!
             if(flag==1){
                    if(pastActivity){
                        pastActivity=false;
                        sleep();
                        return;
                    }
                    else{
                        return;
                    }
            

            }

        }

    }

    @Override
    public void sleep() {
        System.out.println("Payer "+playerNumber+" playing at "+currentPlayBehavior.getName()+" is going to sleep");        
    }

    @Override
    public void resume() {
        System.out.println("Payer "+playerNumber+" playing at "+currentPlayBehavior.getName()+" is going to start playing again");
    }
   
    //Returns if the player has been given a red card or not
    public boolean isDown() {
        return down;
    }

    //Sets if a red card has been given to the player
    public void setDown(boolean down) {
        this.down = down;
    }

    public Robot_1() {

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

    //Add a new playing position to the player
    //If already present, then doesn't add
    public void setPlayBehavior(PlayBehavior_1 pb) {
        Iterator<PlayBehavior_1> it = playBehavior.iterator();
        while(it.hasNext()){
            PlayBehavior_1 p=it.next();
            if(p.getName().equals(pb.getName()))
                return;
        }
        playBehavior.add(pb);
    }

    //Remove a position from the player.Works only if the position is present.
    public void removePlayBehavior(String play) {
        Iterator<PlayBehavior_1> it = playBehavior.iterator();
        while (it.hasNext()) {
            PlayBehavior_1 pb = it.next();
            if (pb.getName().equals(play)) {
                it.remove();
                System.out.println(play + " position deleted for the player");
            }
        }
    }

    //Get list of all positions being played by the player
    public void getPlayBehavior() {
        System.out.println("The player plays in following positions.");
        if (playBehavior.isEmpty()) {
            System.out.println("None");
        } else {
            Iterator<PlayBehavior_1> it = playBehavior.iterator();
            while (it.hasNext()) {
                PlayBehavior_1 pb = it.next();
                System.out.println(pb.getName());
            }
        }
    }

    //Returns the current playing position of the player
    public PlayBehavior_1 getCurrentPlayBehavior() {
        return currentPlayBehavior;
    }
    
    //Sets the current palying position of the player
    public void setCurrentPlayBehavior(PlayBehavior_1 pb) {
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
