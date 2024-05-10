package objects;
import java.util.ArrayList;
import java.util.Calendar;

public class Portfolio {

  private Calendar openDate = Calendar.getInstance();
  private Calendar closeDate = Calendar.getInstance(); 
  private double balance;
  private double networth;
  // composition!
  private ArrayList<Stock> stocks = new ArrayList<>();
  
  public Portfolio(double deposit) {
    this.balance = deposit;
    this.networth = deposit; // make it so the networth is equal to the deposit
  } // constructor

  //==============>>
  // GETTERS
  public String getOpenDate() {
    return this.openDate.toString();
  }
  public String getCloseDate() {
    return this.closeDate.toString();
  }
  public double getBalance() {
    return this.balance;
  }
  public double getNetworth() {
    // spidey sense if tingling...
    return this.networth;
  }
  public ArrayList<Stock> getStocks() {
    return this.stocks;
  }
  //==============>>
  // SETTERS
  public void setCloseDate() {
    this.closeDate = Calendar.getInstance();
  }
  public void addFunds(double amount) {
    if(amount > 0)
      this.balance += amount;
  } // addFunds()
  
  public void withdrawFunds(double removeAmount) {
    if(removeAmount >0)
    this.balance -= removeAmount;
  } // withdrawFunds()
  
  //=============>>
  // STOCKS
  public void addStock(Stock stock) {
    stocks.add(stock);
  } // addStock

  public void buyStock(Stock stock, int qty, double purchaseAmount) {
    // take the purchaseAmount out of our balance
    this.balance -= purchaseAmount;
    stock.setQty(qty); // sets the quantity
    stocks.add(stock); // appends our new stock
    updateNetworth(); // what it says on the tin
  } // buyStock()

  public void sellStock(int idx) {
    double price = stocks.get(idx).getPrice(); // get stock price
    int qty = stocks.get(idx).getQty(); // get the qty of that stock
    double amount = price * qty; // calc the total amount

    this.addFunds(amount); // adds the money from the stock to our balance
    stocks.remove(idx); // finally remove that stock
  } // sellStock

  public void updateNetworth() {
    double stockValue = 0.0;
    // calculate the value of stocks
    for (Stock stock : stocks) {
      stockValue += stock.getPrice() * stock.getQty();
    }
    // update networth
    this.networth = this.balance + stockValue;
  }

} // class