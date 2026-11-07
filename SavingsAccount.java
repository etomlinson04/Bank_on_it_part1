public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    public double getInterestRate(){
      return this.interestRate;
    }

    public void setInterestRate(double interestRate){
      this.interestRate = interestRate;
    }

    public void calcInterest(){
      setBalance(getBalance() * (1 + this.interestRate));
    }

    public static void main(String[] args){
      SavingsAccount account = new SavingsAccount();
      account.start();
    }

}
