package utility;
import java.util.ArrayList;

import objects.*;

public class Ink {
  
  public Ink() {
    // do nothing
  }

  // ANSI codes for adding colour and bold text
  
  String Bold = "\u001B[1m";
  String Underline = "\u001B[4m";
  String Reset = "\u001B[0m";
  String White = "\u001B[37m"; 
  String Red = "\u001B[31m";
  String Green = "\u001B[32m";
  String Blue = "\u001B[34m";
  String Yellow = "\u001B[33m";
  String Magenta = "\u001B[35m";
  String Cyan = "\u001B[36m";

  // did you think I wasn't going to use ASCII art?

  // Welcome message
  public void printWelcome() {
    System.out.println(Bold + Cyan + "\nWelcome to\n" + Reset);
    String logo = """
         █████████   █████                      █████      █████  █████           ███
        ███░░░░░███ ░░███                      ░░███      ░░███  ░░███           ░███
       ░███    ░░░  ███████    ██████   ██████  ░███ █████ ░███   ░░███  ████████ ░███
       ░░█████████ ░░░███░    ███░░███ ███░░███ ░███░░███  ░███   ░░███ ░░███░░███░███
        ░░░░░░░░███  ░███    ░███ ░███░███ ░░░  ░██████░   ░███   ░░███  ░███ ░███░███
        ███    ░███  ░███ ███░███ ░███░███  ███ ░███░░███  ░███   ░░███  ░███ ░███░░░ 
       ░░█████████   ░░█████ ░░██████ ░░██████  ████ █████ ░░████████   ░███████  ███
        ░░░░░░░░░     ░░░░░   ░░░░░░   ░░░░░░  ░░░░ ░░░░░   ░░░░░░░░    ░███░░░  ░░░ 
                                                                        ░███         
                                                                        █████        
                                                                       ░░░░░         \n
    """;
    
    // getting fancy with foreground/background colour. 
    for (char c : logo.toCharArray()) {
        if (c == '░') {
            System.out.print(Cyan);
        } else if (c == '█') {
            System.out.print(White);
        }
        System.out.print(c);
    }
    System.out.println(Bold + Cyan + "How can we help you today?\n" + Reset);
    System.out.print(Reset); // reset to default terminal color
  }

  public void printGoodday() {
    System.out.println(Bold + Cyan + "Thank you for using\n" + Reset);
    String logo = """
       █████████   █████                      █████      █████  █████           ███
      ███░░░░░███ ░░███                      ░░███      ░░███  ░░███           ░███
     ░███    ░░░  ███████    ██████   ██████  ░███ █████ ░███   ░░███  ████████ ░███
     ░░█████████ ░░░███░    ███░░███ ███░░███ ░███░░███  ░███   ░░███ ░░███░░███░███
      ░░░░░░░░███  ░███    ░███ ░███░███ ░░░  ░██████░   ░███   ░░███  ░███ ░███░███
      ███    ░███  ░███ ███░███ ░███░███  ███ ░███░░███  ░███   ░░███  ░███ ░███░░░ 
     ░░█████████   ░░█████ ░░██████ ░░██████  ████ █████ ░░████████   ░███████  ███
      ░░░░░░░░░     ░░░░░   ░░░░░░   ░░░░░░  ░░░░ ░░░░░   ░░░░░░░░    ░███░░░  ░░░ 
                                                                      ░███         
                                                                      █████        
                                                                     ░░░░░         \n
  """;
  
  // getting fancy with foreground/background colour. 
  for (char c : logo.toCharArray()) {
      if (c == '░') {
          System.out.print(Cyan);
      } else if (c == '█') {
          System.out.print(White);
      }
      System.out.print(c);
  }
  System.out.print(Reset); // reset to default terminal color
  System.out.println(Bold + Cyan + "Have a good day!" + Reset);    
  }
  
  public void printStartingFunds() {
    System.out.println(Bold + Underline + "How much money are you starting with?" + Reset);
  }



  public void printStock(Stock stock) {
// need to use the ANSI codes directly in the formatted string - no easy way around this
      // stock name: bold cyan
      // symbol: bold yellow
      // price: bold red
      // rest of the text is default bold
      // reset after each change    
System.out.printf("\u001B[1mName:\u001B[0m \u001B[36m\u001B[1m%s\u001B[0m \u001B[1mSymbol:\u001B[0m \u001B[1m\u001B[33m%s\u001B[0m \u001B[1mPrice:\u001B[0m \u001B[31m\u001B[1m$%.2f\u001B[0m\n",
      stock.getName(), stock.getSymbol(), stock.getPrice());
      System.out.println(Green + Bold + Underline + "\nHow many units of this stock would you like??" + Reset);
  } // printStock()

  public void printPortfolio(ArrayList<Stock> stocks, double networth, 
    double balance) {
    for(int i = 0; i < stocks.size(); i++) {
      
      System.out.printf("\u001B[32m\u001B[1m(%d)\u001B[0m \u001B[1mName:\u001B[0m \u001B[36m\u001B[1m%s\u001B[0m \u001B[1mSymbol:\u001B[0m \u001B[1m\u001B[33m%s\u001B[0m \u001B[1mPrice:\u001B[0m \u001B[31m\u001B[1m$%.2f\u001B[0m \u001B[1mQty:\u001B[0m \u001B[1m\u001B[35m%d\u001B[0m\n",
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice(),
        stocks.get(i).getQty());
    } // for
    System.out.printf("Networth: $%.2f\n", networth);
    System.out.printf("Balance: $%.2f\n", balance);
  } // printPortfolio()

  public void printMarket(ArrayList<Stock> stocks) {
    System.out.println(Red + Bold + Underline + "\nStocks" + Reset);
    System.out.println(Bold + "Which stock would you like to buy?:\n " + Reset); // moved to the top for better readability
    for(int i = 0; i < stocks.size(); i++) {

        System.out.printf("\u001B[32m\u001B[1m(%d)\u001B[0m \u001B[1mName:\u001B[0m \u001B[36m\u001B[1m%s\u001B[0m \u001B[1mSymbol:\u001B[0m \u001B[1m\u001B[33m%s\u001B[0m \u001B[1mPrice:\u001B[0m \u001B[31m\u001B[1m$%.2f\u001B[0m\n", 
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice());
    } // for
    
  } // printMarket()

  public void printMenu() {
    System.out.println(Bold + Red + Underline + "\nMain Menu" + Reset);
    System.out.println(Bold + "Please make your selection\n" + Reset);
    System.out.println(Bold + Green + "(1)" + Reset + " Show Portfolio");
    System.out.println(Bold + Green + "(2)" + Reset + " Show Stocks");
    System.out.println(Bold + Green + "(3)" + Reset + " Add Funds");
    System.out.println(Bold + Green + "(4)" + Reset + " Withdraw Funds");
    System.out.println(Bold + Green + "(4)" + Reset + " Exit\n");
  } // printMenu()

  public void printStockDetail(Stock stock) {
    System.out.printf("\u001B[1mName:\u001B[0m \u001B[36m\u001B[1m%s\u001B[0m \u001B[1mSymbol:\u001B[0m \u001B[1m\u001B[33m%s\u001B[0m \u001B[1mPrice:\u001B[0m \u001B[31m\u001B[1m$%.2f\u001B[0m \u001B[1mQty:\u001B[0m \u001B[1m\u001B[35m%d\u001B[0m\n",
      stock.getName(), stock.getSymbol(), 
      stock.getPrice(), stock.getQty());
  }

  public void printAddFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to add?: ",
      balance);
  }

  public void printWithdrawFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to withdraw?: ",
      balance);
  }
} // class
