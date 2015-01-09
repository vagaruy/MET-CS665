/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework6;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Vipul
 */
//Class to represent the compound shape Rectangle
public class Rectangle extends CompoundShape{

    //contructor to create the rectange from te give basic shapes...
    public Rectangle(Shape line1,Shape line2,Shape line3,Shape line4) {
        super();                //call constructor of the superclass to initialise the array
        shapeParts.add(line1);     //add all the basic shape parts that make this up.
        shapeParts.add(line2);    
        shapeParts.add(line3);
        shapeParts.add(line4);
    }

    
    //Render the rectange to the screem
    @Override
    public void renderShapeToScreen() {
        System.out.println("Rendering a rectangle");        //rectangle specific code goes here
        super.renderShapeToScreen();                        //recursively render the individual parts it is made of
    }


    //return the name of the object
    @Override
    public String getName() {
        return("Rectangle");
    }
    
}
