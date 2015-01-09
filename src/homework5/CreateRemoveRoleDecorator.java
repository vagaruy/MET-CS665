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
public class CreateRemoveRoleDecorator extends RemoveRoleDecorator{

    public CreateRemoveRoleDecorator(Roles decoratedRoles) {
        super(decoratedRoles);
    }

    @Override
    public int getRoles() {
        return (decoratedRoles.getRoles()^AccessRoles.access.CREATE.getValue());
    }

   @Override
    public void display() {
        decoratedRoles.display();
        System.out.println("Remove permission Create");
    }
        
    
}
