public class BankAccount {

    private static int bankAccountsCount = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;


    public BankAccount()    {
        this.id = bankAccountsCount;
        bankAccountsCount++;
    }

    static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return interestRate * years * this.balance;
    }

    public int getId()  {
        return this.id;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
    }
}
