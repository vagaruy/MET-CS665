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
public abstract class User implements Roles {

    public  int getRoles(){
        return 0;
    }
    String name;
    int id;
    int roles;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    
    
}
