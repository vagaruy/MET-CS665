/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework6;

/**
 *
 * @author Testing
 */
public class Homework6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test case to check the various functionalities of the system
        
        Line line1=new Line(10,20,30,40);
        System.out.println("Rendering a line to the screen");
        line1.renderShapeToScreen();
         System.out.println("------------------------------------------------------------------------");
        
        Line line2 = new Line(0, 20, 40, 40);
        System.out.println("Rendering another line on the screen");
        line2.renderShapeToScreen();
        System.out.println("------------------------------------------------------------------------");
        
        Line line3=new Line(10,50,70,80);
        Line line4=new Line(10,15,30,40);
        Rectangle rect=new Rectangle(line1, line2, line3, line4);
        System.out.println("Rendering a compound shape Rectange made up of 4 lines");
        rect.renderShapeToScreen();
         System.out.println("------------------------------------------------------------------------");
        Triangle triangle=new Triangle(line1,line2,line3);
        System.out.println("Rendering a compound shape Triangle to the screen made up of 3 lines");
        triangle.renderShapeToScreen();
         System.out.println("------------------------------------------------------------------------");
        Arrow arrow=new Arrow(line1,triangle);
        System.out.println("rendering a compound shape Arrow made up of a triange and a line");
        arrow.renderShapeToScreen();
         System.out.println("------------------------------------------------------------------------");
        System.out.println("The number of basic shapes the shape arrow is made of"+arrow.explodeShape().size());//will give out the number of basic shapes
         System.out.println("------------------------------------------------------------------------");
        System.out.println("The numebr of basic shapes the shape triangle is made of"+triangle.explodeShape().size());//give out the number of basic shapes.
         System.out.println("------------------------------------------------------------------------");
    }
    
}
