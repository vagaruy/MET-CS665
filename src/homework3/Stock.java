/*
 Object that stores the stock details namely the symbol and amount
 */

package homework3;

/**
 *
 * @author Vipul Agarwal
 */
public class Stock {    
    private int amount; //stock amount
    private String stockName;   //stock name

    //constructor to initialise the variables
    public Stock(int amount, String stockName) {
        this.amount = amount;
        this.stockName = stockName;
    }

    //get stock amount
    public int getAmount() {
        return amount;
    }

    //get stock name
    public String getStockName() {
        return stockName;
    }
    
    
}
