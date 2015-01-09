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
 * @author Vipul Agarwal
 */
//Abstract class to implement cmpound shapes..
public abstract class CompoundShape implements Shape {
    ArrayList<Shape> shapeParts;    
    //Initialise the array containing all the shapes here..
    public CompoundShape() {
       shapeParts=new ArrayList<>();
    }   
    
    //Function to return all the basic shapes contained in a specific shape.
    //We find this by recursively claling teh explode shape of each shape till we get basic shapes
    //and then we add all them to a list and return teh list bck to the user.
    @Override
    public  ArrayList<Shape> explodeShape(){
        ArrayList<Shape> shapes=new ArrayList<Shape>();
            Iterator i=shapeParts.iterator();
            while(i.hasNext()){
                Shape shape=(Shape) i.next();
                shapes.addAll(shape.explodeShape());
            }
            return shapes;
    }
    
    //Recursively iterate through all shapes and call their renderer.
    @Override
    public  void renderShapeToScreen(){
        Iterator i=shapeParts.iterator();
        while(i.hasNext()){
            Shape shape=(Shape) i.next();
            shape.renderShapeToScreen();           
        }
    }   
}
