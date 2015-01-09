/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework5;

/**
 *
 * @author Testing
 */
public class Operator extends User {

    public Operator(String name, int id) {
        super(name, id);
    }

    @Override
    public void display() {
        System.out.println("I am Operator.I will kill you");
    }
    
}
