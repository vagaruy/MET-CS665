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
public class Admin extends User {

    public Admin(String name, int id) {
        super(name, id);
    }
    
    public void display(){
        System.out.println("I am admin.I have god like powers!");
    }
    
}
