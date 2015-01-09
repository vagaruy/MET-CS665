/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework6;

import java.util.ArrayList;

/**
 *
 * @author Vipul    
 */
public class Arrow extends CompoundShape{
    //Initialise an array containing all shape parts and add the line and triangle to it which makes up an arrow object.
    public Arrow(Shape line,Shape triangle) {
        super();            //call contructor of the super class
        shapeParts.add(line);       
        shapeParts.add(triangle);                
    }

    
    
    //Function to render an arrow to the screen.
    @Override
    public void renderShapeToScreen() {
        System.out.println("Rendering the arrow to the screen");//Arrow specific rendering if required done here..
        super.renderShapeToScreen(); //render all the shape parts recursively
    }

        
    //Return the name of the object class
    @Override
    public String getName() {
        return ("Arrow");        
    }
    
}
