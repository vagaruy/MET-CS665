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
public class CreateAddRoleDecorator extends AddRoleDecorator{

    public CreateAddRoleDecorator(Roles decoratedRoles) {
        super(decoratedRoles);
    }

    @Override
    public int getRoles() {
        return (decoratedRoles.getRoles()|AccessRoles.access.CREATE.getValue());
    }

    @Override
    public void display() {
        decoratedRoles.display();
        System.out.println("Add permission Create");
    }
    
}
