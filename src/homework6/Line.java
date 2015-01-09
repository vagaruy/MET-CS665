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

//Implementation of a basic shape.
public class Line implements Shape{
    int startX,startY,endX,endY;        //A line object consisits of 2 points (their x and y coridnates)

    
    //Initialise the coords of the line
    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    
    //render teh line to the screen..
    @Override
    public void renderShapeToScreen() {
        System.out.println("Draw a line from"+startX+","+startY+"to"+" "+endX+","+endY);
    }
    
    
    //return the line which is the base level for the recursion heirarchy.
    @Override    
    public ArrayList<Shape> explodeShape() {
    ArrayList<Shape> shapeParts = new ArrayList<>();
    shapeParts.add(this);
    return shapeParts;
  }
    
    public static void main(String[] args) {
        Line line=new Line(32,45,43,67);
      ArrayList<Shape> shape=line.explodeShape();
        Line line1=(Line) shape.get(0);
        System.out.println("Length is "+line1.startX);
        
    }

    @Override
    public String getName() {
        return ("Line");
    }

    
}
