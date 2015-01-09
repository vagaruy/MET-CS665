/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework3;

/**
 *
 * @author Vipul Agarwal
 */
public class StockBuyCommand implements Command {
    Client client;  //Client details Object
    StockTrade stockTrade;  //Stock Trading Object
    Stock stock;        //Stock details Object

    
    //Initialise all objects
    public StockBuyCommand(Client client, StockTrade stockTrade, Stock stock) {
        this.client = client;
        this.stockTrade = stockTrade;
        this.stock = stock;
    }
    
    
    @Override
    public void execute(){
    System.out.println("Client "+client.getClientName()+" made following transactions"); 
    
    //call the stock trade funciton which will execute the stock trading.
    stockTrade.buy(stock.getStockName(), stock.getAmount());
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
