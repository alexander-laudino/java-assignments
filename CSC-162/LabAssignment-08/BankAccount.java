/**
 * The variables, constructors, and methods needed to create new BankAccount objects.
 * @author Alexander Laudino
 */
public class BankAccount {
  /**
   * Total BankAccount accounts created
   */
  private static int totalAccounts;
  /**
   * BankAccount account number as a String
   */
  private String accountNumber;
  /**
   * BankAccount account balance
   */
  private double balance;
  /**
   * Number of deposits in month
   */
  private int deposits;
  /**
   * Number of withdrawals in month
   */
  private int withdrawals;
  /**
   * Annual interest rate
   */
  private double apr;
  /**
   * Monthly service charges
   */
  private float fees;
  /**
   * True if BankAccount is SavingsAccount object
   */
  private boolean isSavings;
  
  /**
   * Empty constructor
   */
  BankAccount( ) {
  }
  
  /**
   * Create BankAccount object and set balance and rate variables
   * @param balance Double: 0 or positive number
   * @param rate Double: Decimal less than 1
   */
  BankAccount(double balance, double rate) {
    incrementAccounts();
    setAccountNum();
    this.balance = balance;
    this.apr = rate;
    System.out.printf("\nNew account OPENED." + 
                      "\nBalance: $%.2f" +
                       "\nAPR: %.4f%%\n", getBalance(), (apr * 100));
  }
  
  /**
   * Increment totalAccounts by 1
   */
  public void incrementAccounts() {
    totalAccounts += 1;
  }
  
  /**
   * Set BankAccount account number based off of totalAccounts
   */
  public void setAccountNum() {
    String n = Integer.toString(totalAccounts);
    String z = "";
    // Set number of zeros in customer number
    for (int i = 0; i < (10 - n.length()); i++ ) {
      z = z + "0";
    }
    accountNumber = z + n;
  }
  
  /**
   * Add argument to account balance and increment total deposits
   * @param amt Double: amount of deposit
   */
  public void deposit(double amt) {
    this.balance += amt;
    incrementDeposits();
    System.out.printf("\nAmount deposited: $%.2f" + 
                      "\nBalance: $%.2f", amt, getBalance());
  }
  
  /**
   * Increment deposits by 1
   */
  private void incrementDeposits() {
    this.deposits += 1;
  }
  
  /**
   * Get number of deposits
   * @return 0 or positive integer
   */
  public int getDeposits() {
    return deposits;
  }
  
  /**
   * Subtract argument from account balance and increment total withdrawals
   * if amount input is less than account balance
   * @param amt Double: amount to withdraw
   */
  public void withdraw(double amt) {
    // If amount to withdraw exceeds amount in account
    if (amt > this.balance)
      System.out.printf("\nInsufficient funds." +
                        "\nBalance: $%.2f" +
                        "\nPlease enter a smaller amount.", balance);
    else {
      this.balance -= amt;
      incrementWithdrawals();
      System.out.printf("\nAmount withdrawn: $%.2f" + 
                        "\nBalance: $%.2f", amt, getBalance());
    }
  }
  
  /**
   * Increment withdrawals by 1
   */
  private void incrementWithdrawals() {
    this.withdrawals += 1;
  }
  
  /**
   * Get number of withdrawals
   * @return 0 or positive integer
   */
  public int getWithdrawals() {
    return withdrawals;
  }
  
  /**
   * Updates account balance by calculating monthly interest earned
   * on account and adding this interest to the account balance
   */
  private void calcInterest() {
    // Monthly interest rate = (Annual interest rate / 12)
    double rate = (this.apr / 12);
    // Monthly interest = Balance * Monthly interest rate
    double interest = this.balance * rate;
    // Balance = Balance + Monthly interest
    this.balance += interest;
  }
  
  /**
   * Subtract monthly service charge from balance, calculate interest, and 
   * set withdrawals, deposits, and fees variables to 0
   */
  public void monthlyProcess() {
    System.out.printf("\n\n********** Running monthly process. **********\n" +
                      "\nBalance: $%.2f" +
                      "\nFees: $%.2f", getBalance(), getFees());
    this.balance -= fees;
    double afterFees = getBalance();
    System.out.printf("\nBalance after fees: $%.2f", afterFees);
    calcInterest();
    double interest = getBalance() - afterFees; 
    System.out.printf("\nInterest: $%.2f" + 
                      "\nUpdated balance: $%.2f", interest, getBalance());
    this.withdrawals = 0;
    this.deposits = 0;
    this.fees = 0;
  }
  
  /**
   * Get account balance
   * @return Double: 0 or positive number
   */
  public double getBalance() {
    return balance;
  }
  
  /**
   * Set account balance
   * @param amt Double
   */
  public void setBalance(double amt) {
    this.balance = amt;
  }
  
  /**
   * Get account number
   * @return 10 char String of account number
   */
  public String getAccountNum() {
    return accountNumber;
  }
  
  /**
   * Get annual interest rate
   * @return Double: less than 1
   */
  public double getAPR() {
    return apr;
  }
  
  /**
   * Set annual interest rate
   * @param rate Double less than 1
   */
  public void setAPR(double rate) {
    this.apr = rate;
  }
  
  /**
   * Get monthly service charges
   * @return Float: 0 or positive number
   */
  public float getFees() {
    return fees;
  }
  
  /**
   * Set monthly service charges
   * @param amt Float: 0 or positive number
   */
  public void setFees(float amt) {
    this.fees = amt;
  }
  
  /**
   * Set isSavings to true
   */
  public void setAsSavings() {
    this.isSavings = true;
  }
  
  /**
   * Get type of bank account
   * @return "Checking" or "Savings"
   */
  private String getAccountType() {
    if (isSavings == false)
      return "Checking";
    else
      return "Savings";
  }
  
  @Override
  /**
   * Overrides Object toString
   */
  public String toString() {
    return "\n********** ACCOUNT INFORMATION **********" +
           String.format("\nAccount type: %s", getAccountType()) +
           String.format("\nAccount number: %s", accountNumber) +
           String.format("\nBalance: $%.2f", balance) +
           String.format("\nInterest rate: %.4f%%", (apr * 100));
  }
}
