/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework3;

/**
 *
 * @author Testing
 */
public class StockSellCommand implements Command {
    Client client;
    StockTrade stockTrade;
    Stock stock;
    
    @Override
    public void execute(){
        System.out.println("Client "+client.getClientName()+" made following transactions");    
    stockTrade.sell(stock.getStockName(), stock.getAmount());
    }

    public StockSellCommand(Client client, StockTrade stockTrade, Stock stock) {
        this.client = client;
        this.stockTrade = stockTrade;
        this.stock = stock;
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
