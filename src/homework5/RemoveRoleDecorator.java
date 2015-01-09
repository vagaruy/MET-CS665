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
public abstract class RemoveRoleDecorator implements Roles{
    protected Roles decoratedRoles;

    public RemoveRoleDecorator(Roles decoratedRoles) {
        this.decoratedRoles = decoratedRoles;
    }

    @Override
    public abstract int getRoles();
    
}
