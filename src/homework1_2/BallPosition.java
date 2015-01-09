/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework1_2;

import java.util.Observable;

/**
 *
 * @author Vipul Agarwal
 */
public class BallPosition extends Observable {
    private String ballPosition;    //save the ball position Upper Lower Middle
    
    //If the position changed was valid, then notify all the observers of the change
    private void positionChanged(){
        setChanged();
        notifyObservers();
    }

    
   //contructor...initialse with a value
    public BallPosition(String pos) {
        if(pos.equalsIgnoreCase("lower")||pos.equalsIgnoreCase("upper")||pos.equalsIgnoreCase("middle")){
            this.ballPosition=pos;
        }
        else{
            this.ballPosition="initial";
        }
    }

    //return the current ball position
    public String getBallPosition() {
        return ballPosition;
    }
    
     //function that validates the change in position..If it is valid then call the function to notify observers!
    public void changeBallPosition(String pos){
        if(pos.equalsIgnoreCase("lower")||pos.equalsIgnoreCase("upper")||pos.equalsIgnoreCase("middle")){
            if(!pos.equalsIgnoreCase(ballPosition)){
                ballPosition=pos;
                positionChanged();
            }
        }
        else{
            System.out.println("Wrong Position Entered!!!!!!!!");
        }       
    }   
}
