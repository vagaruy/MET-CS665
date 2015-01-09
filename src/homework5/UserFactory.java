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
public class UserFactory {
    
	
   //use getShape method to get object of type shape 
   public Roles getRole(String userType,String userName,int userId){
      if(userType == null){
          System.out.println("Bro give me some inputs");              
         return null;
      }		
      if(userType.equalsIgnoreCase("ADMIN")){
         return (new RunAddRoleDecorator(new DeleteAddRoleDecorator(new ViewAddRoleDecorator(new EditAddRoleDecorator(new CreateAddRoleDecorator(new Admin(userName,userId)))))));
      } else if(userType.equalsIgnoreCase("DEVELOPER")){
         return (new EditAddRoleDecorator(new CreateAddRoleDecorator(new Developer(userName,userId))));
      } else if(userType.equalsIgnoreCase("MONITOR")){
         return (new ViewAddRoleDecorator(new Monitor(userName,userId)));
      }else if(userType.equalsIgnoreCase("Operator")){
         return (new RunAddRoleDecorator(new DeleteAddRoleDecorator(new ViewAddRoleDecorator(new Operator(userName,userId)))));
      }
      return null;
   }
}

