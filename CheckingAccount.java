import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
  private double balance;

  public CheckingAccount(){
    this.balance = 0d;
  }

  public CheckingAccount(double balance){
    this.balance = balance;
  }

  public double getBalance(){
    return this.balance;
  }

  public String getBalanceString(){
    return String.format("$%.2f", this.balance);
  }

  public void setBalance(double balance){
    this.balance = balance;
  }

  private double getDouble(){
    double result = 0d;
    try {
      result = Double.parseDouble(IN.nextLine().trim());
    } catch (NumberFormatException e){
      System.out.println("Invalid number.");
    }
    return result;
  }

  public void checkBalance(){
    System.out.println("Checking balance...");
    System.out.print("Current balance: " + getBalanceString());
  }

  public void makeDeposit(){
    System.out.println("Making a deposit...");
    System.out.print("How much to deposit? ");
    this.balance += getDouble();
    System.out.println("New Balance: " + getBalanceString());
  }

  public void makeWithdrawal(){
    System.out.println("Making a withdrawal...");
    System.out.print("How much to withdraw? ");
    this.balance -= getDouble();
    System.out.println("New Balance: " + getBalanceString());
  }

  public String menu(){
    System.out.println();
    System.out.println("Account menu");
    System.out.println();
    System.out.println("0) quit");
    System.out.println("1) check balance");
    System.out.println("2) make a deposit");
    System.out.println("3) make a withdrawal");
    System.out.println();
    System.out.println("Please enter 0-3");
    String response = IN.nextLine().trim();
    return response;
  }

  public void start(){
    boolean keepGoing = true;
    String response;
    while(keepGoing){
      response = menu();
      if (response.equals("0")){
	keepGoing = false;
      } else if (response.equals("1")){
	checkBalance();
      } else if (response.equals("2")){
	makeDeposit();
      } else if (response.equals("3")){
	makeWithdrawal();
      } else {
	System.out.println("Please enter 0, 1, 2, or 3");
      }
    }
  }

  public static void main(String[] args){
    CheckingAccount account = new CheckingAccount();
    account.start();
  }

}
