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
public class DeleteAddRoleDecorator extends AddRoleDecorator{

    public DeleteAddRoleDecorator(Roles decoratedRoles) {
        super(decoratedRoles);
    }

    @Override
    public int getRoles() {
        return (decoratedRoles.getRoles()|AccessRoles.access.DELETE.getValue());
    
    }

   @Override
    public void display() {
        decoratedRoles.display();
        System.out.println("Add permission Delete");
    }
    
}
