/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework6;

import java.util.ArrayList;

/**
 *
 * @author VIpul
 */

//Interface that implements the shape..Consists of a renderer, exploder and getName.
public interface Shape {
    public void renderShapeToScreen(); // draw this shape on screen
    public ArrayList<Shape> explodeShape(); // return the list of all basic shapes forming this shape
    public String getName();
    
}
