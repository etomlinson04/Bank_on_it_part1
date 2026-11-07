public class Customer extends User {
  private CheckingAccount checking;
  private SavingsAccount savings;


  public Customer(){
    this("Alice", "0000");
  }

  public Customer(String userName, String PIN){
    setUserName(userName);
    setPIN(PIN);
    this.checking = new CheckingAccount();
    this.savings = new SavingsAccount();
  }

  public void changePin(){
    System.out.print("Enter new PIN: ");
    setPIN(IN.nextLine().trim());
  }

  public String getReport(){
    return getUserName() + " | Checking: " + checking.getBalanceString() + " | Savings: " + savings.getBalanceString();
  }

  public String menu(){
    System.out.println();
    System.out.println("Customer Menu");
    System.out.println("0) Exit");
    System.out.println("1) Manage Checking Account");
    System.out.println("2) Manage Savings Account");
    System.out.println("3) change PIN");
    System.out.println();
    System.out.println("Action (0-3): ");
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
	System.out.println("Checking Account");
	checking.start();
      } else if (response.equals("2")){
	System.out.println("Savings Account");
	savings.start();
      } else if (response.equals("3")){
	changePin();
      } else {
	System.out.println("Please enter 0, 1, 2, or 3");
      }
    }
  }

  public static void main(String[] args){
    Customer customer = new Customer();
    if (customer.login()){
      customer.start();
    }
  }
}
