public class SavingsAccount extends BankAccount {
  /**
   * Account status: active = true, inactive = false
   */
  private boolean status;
  
  /**
   * Empty constructor
   */
  SavingsAccount() {
  }
  
  /**
   * Create new SavingsAccount object and set the balance and interest rate
   * @param amt Double: 0 or positive number
   * @param rate Double: Decimal less than 1
   */
  SavingsAccount(double amt, double rate) {
    incrementAccounts();
    setAccountNum();
    setAsSavings();
    setBalance(amt);
    setAPR(rate);
    setStatus();
    System.out.printf("\nNew account OPENED." + 
        "\nBalance: $%.2f" +
         "\nAPR: %.4f%%" + 
         "\nAccount Status: %s\n",
         getBalance(), (getAPR() * 100), getStatus());
  }
  
  /**
   * Check account balance
   * Set to inactive if balance is less than 25
   * Set to active if balance greater than 25
   */
  private void setStatus() {
    if (getBalance() < 0) { // This should never happen either
      this.status = false;
      System.out.println("\nMake deposit or account will be closed.");
    }
    else if (getBalance() > 0 && getBalance() < 25) {
      this.status = false;
      System.out.printf("\nPlease deposit $%,.2f to activate account.\n",
          (25 - getBalance()));
    }
    else if (getBalance() > 25) {
      this.status = true;
    }
    else {
      System.out.print("This should never happen.");
    }
  }
  
  /**
   * Get account status as String
   * @return "Inactive" or "Active"
   */
  private String getStatus() {
    if (status == false)
      return "Inactive";
    else
      return "Active";
  }
  
  @Override
  /**
   * Determine whether account is inactive before making a withdrawal,
   * if inactive, no withdrawals allowed, if active, call superclass method
   */
  public void withdraw(double amt) {
    if (status == false) {
      System.out.printf("\nUnable to make a withdrawal." +
          "\nAccount inactive. $25 minimum required." + 
          "\nBalance: $%.2f" +
          "\n$%.2f Deposit required to activate account.",
          getBalance(), (25 - getBalance()));
    }
    else {
      super.withdraw(amt);
    }
  }
  
  @Override
  /**
   * Determine whether account is inactive before making deposit. If account is 
   * inactive and deposit brings account above $25, set account to active, then
   * call superclass method
   */
  public void deposit(double amt) {
    if (status == false && (amt + getBalance()) < 25) {
      System.out.printf("\nUnable to deposit $%.2f" +
          "\nAccount inactive! Must maintain a minimum balance of $25." +
          "\nBalance: $%.2f" +
          "\nYou're deposit is $%.2f short." +
          "\nPlease make a deposit of at least $%.2f",
          amt, getBalance(), (25 - (amt + getBalance())), (25 - getBalance()));
    }
    else if (status == false && (amt + getBalance()) > 25) {
      this.status = true;
      super.deposit(amt);
    }
    else {
      super.deposit(amt);
    }
  }
  
  @Override
  /**
   * Checks number of withdrawals prior to calling superclass method,
   * if number of withdrawals is more than 4, a service charge of $1 is applied
   * for each withdrawal over 4
   */
  public void monthlyProcess() {
    if (getWithdrawals() > 4) {
      float serviceCharge = getWithdrawals() - 4;
      setFees(serviceCharge);
      super.monthlyProcess();
      setStatus();
    }
    else {
      super.monthlyProcess();
    }
  }
  
  @Override
  /**
   * Overrides BankAccount toString with additional field
   */
  public String toString() {
    return super.toString() + 
           String.format("\nStatus: %s", getStatus());
  }
}