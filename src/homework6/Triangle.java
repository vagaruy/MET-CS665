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

//Implementation of the compound shape Triange.
//extends the class Compoundshape
public class Triangle extends CompoundShape {

    //initialise the triangle with all the constitutent parts.
    public Triangle(Shape line1,Shape line2, Shape line3) {
        super();            //call constructor of the super class
        shapeParts.add(line1);
        shapeParts.add(line2);
        shapeParts.add(line3);               
    }

    
    
    @Override
    public void renderShapeToScreen() {
        System.out.println("Rendering a Triangle");//call triangle specific function to screen
        super.renderShapeToScreen();    //recursively render the shapes it is made of.
        
    }



    @Override
    public String getName() {
        return("Triangle");     //return the anem of the class object.
    }
    
}
