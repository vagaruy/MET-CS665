/*
Stores details about the client.
 */

package homework3;

/**
 *
 * @author Vipul Agarwal
 */
public class Client {
 private String clientName; //Client Name
 private int clientID;      //Client ID

 //Constructor to initialise variables
    public Client(String clientName, int clientID) {
        this.clientName = clientName;
        this.clientID = clientID;
    }

    //Return client Name
    public String getClientName() {
        return clientName;
    }

    //return Client ID
    public int getClientID() {
        return clientID;
    }
 
}
