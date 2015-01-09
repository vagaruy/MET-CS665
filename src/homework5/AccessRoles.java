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
public class AccessRoles {
    
    enum access{
        CREATE,
        EDIT ,
        VIEW ,
        RUN,
        DELETE;
        
        public int getValue(){
            return (int)(Math.pow(2,ordinal()));
        }
        
        
        
    }
    
}
