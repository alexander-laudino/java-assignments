/**
 * This program demonstrates the BankAccount and SavingsAccount classes. 
 * Lab Assignment 8 - BankAccount and SavingsAccount 
 * Dr. Farrett
 * CSC-162-IN1
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-11-10
 */
public class DemoAccounts {
  /**
   * Main method
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    
    System.out.println("~ Open new checking account with $2500 at 1.576% interest. ~");
    BankAccount ba = new BankAccount(2500.00, 0.01576);
    
    System.out.println("\n~ View checking account information ~");
    System.out.print(ba);
    System.out.println();
    
    System.out.println("\n~ Make a $500 withdrawal from checking account ~");
    ba.withdraw(500);
    System.out.println();
    
    System.out.print("\n~ Simulate 1 monthly process ~");
    ba.monthlyProcess();
    System.out.println();
    
    System.out.println("\n~ Make a $2000 deposit into checking account ~");
    ba.deposit(2000);
    System.out.println();
    
    System.out.print("\n~ Simulate 12 months of monthly processes ~");
    balanceAfter(ba, 12);
    System.out.println();
    
    System.out.println("\n~ View checking account information ~");
    System.out.print(ba);
    System.out.println();
    
    System.out.println("\n~ Make a $5000 withdrawal from checking account ~");
    ba.withdraw(5000);
    System.out.println();
    
    System.out.println("\n~ Open new savings account with $20 at 3.56% interest. ~");
    SavingsAccount sa = new SavingsAccount(20, 0.0356);
    
    System.out.println("\n~ Make a $2 deposit into savings account ~");
    sa.deposit(2);
    System.out.println();
    
    System.out.println("\n~ Make a $5 withdrawal from savings account ~");
    sa.withdraw(5);
    System.out.println();
    
    System.out.println("\n~ View savings account information ~");
    System.out.print(sa);
    System.out.println();
    
    System.out.print("\n~ Simulate 1 monthly process ~");
    sa.monthlyProcess();
    System.out.println();
    
    System.out.println("\n~ View savings account information ~");
    System.out.print(sa);
    System.out.println();
    
    System.out.println("\n~ Make a $10 deposit into savings account ~");
    sa.deposit(10);    
    System.out.println();
    
    System.out.println("\n~ View savings account information ~");
    System.out.print(sa);
    System.out.println();
    
    System.out.print("\n~ Simulate 1 monthly process ~");
    sa.monthlyProcess();
    System.out.println();
    
    System.out.println("\n~ View savings account information ~");
    System.out.print(sa);
    System.out.println();
    
    System.out.println("\n~ Open new savings account with $250 at 4.56% interest. ~");
    SavingsAccount sa1 = new SavingsAccount(250, 0.0456);
        
    System.out.println("\n~ View savings account 1 information ~");
    System.out.print(sa1);
    System.out.println();
    
    System.out.println("\n~ Make 10 withdrawals ~");
    sa1.withdraw(5);
    sa1.withdraw(50);
    sa1.withdraw(5);
    sa1.withdraw(15);
    sa1.withdraw(6);
    sa1.withdraw(5);
    sa1.withdraw(4);
    sa1.withdraw(3);
    sa1.withdraw(2);
    sa1.withdraw(1);
    System.out.println();
    
    System.out.print("\n~ Simulate 1 monthly process ~");
    sa1.monthlyProcess();
    System.out.println();
    
    System.out.println("\n~ View savings account 1 information ~");
    System.out.print(sa1);
    
  }
  
  /**
   * Run monthly process on input account for x months
   * @param ba BankAccount object
   * @param months Positive integer 
   */
  private static void balanceAfter(BankAccount ba, int months) {
    for (int i = 0; i < months; i++) {
      ba.monthlyProcess();
    }
  }
}

/*
 * OUTPUT
 * 
~ Open new checking account with $2500 at 1.576% interest. ~

New account OPENED.
Balance: $2500.00
APR: 1.5760%

~ View checking account information ~

********** ACCOUNT INFORMATION **********
Account type: Checking
Account number: 0000000001
Balance: $2500.00
Interest rate: 1.5760%

~ Make a $500 withdrawal from checking account ~

Amount withdrawn: $500.00
Balance: $2000.00

~ Simulate 1 monthly process ~

********** Running monthly process. **********

Balance: $2000.00
Fees: $0.00
Balance after fees: $2000.00
Interest: $2.63
Updated balance: $2002.63

~ Make a $2000 deposit into checking account ~

Amount deposited: $2000.00
Balance: $4002.63

~ Simulate 12 months of monthly processes ~

********** Running monthly process. **********

Balance: $4002.63
Fees: $0.00
Balance after fees: $4002.63
Interest: $5.26
Updated balance: $4007.88

********** Running monthly process. **********

Balance: $4007.88
Fees: $0.00
Balance after fees: $4007.88
Interest: $5.26
Updated balance: $4013.15

********** Running monthly process. **********

Balance: $4013.15
Fees: $0.00
Balance after fees: $4013.15
Interest: $5.27
Updated balance: $4018.42

********** Running monthly process. **********

Balance: $4018.42
Fees: $0.00
Balance after fees: $4018.42
Interest: $5.28
Updated balance: $4023.70

********** Running monthly process. **********

Balance: $4023.70
Fees: $0.00
Balance after fees: $4023.70
Interest: $5.28
Updated balance: $4028.98

********** Running monthly process. **********

Balance: $4028.98
Fees: $0.00
Balance after fees: $4028.98
Interest: $5.29
Updated balance: $4034.27

********** Running monthly process. **********

Balance: $4034.27
Fees: $0.00
Balance after fees: $4034.27
Interest: $5.30
Updated balance: $4039.57

********** Running monthly process. **********

Balance: $4039.57
Fees: $0.00
Balance after fees: $4039.57
Interest: $5.31
Updated balance: $4044.87

********** Running monthly process. **********

Balance: $4044.87
Fees: $0.00
Balance after fees: $4044.87
Interest: $5.31
Updated balance: $4050.19

********** Running monthly process. **********

Balance: $4050.19
Fees: $0.00
Balance after fees: $4050.19
Interest: $5.32
Updated balance: $4055.51

********** Running monthly process. **********

Balance: $4055.51
Fees: $0.00
Balance after fees: $4055.51
Interest: $5.33
Updated balance: $4060.83

********** Running monthly process. **********

Balance: $4060.83
Fees: $0.00
Balance after fees: $4060.83
Interest: $5.33
Updated balance: $4066.17

~ View checking account information ~

********** ACCOUNT INFORMATION **********
Account type: Checking
Account number: 0000000001
Balance: $4066.17
Interest rate: 1.5760%

~ Make a $5000 withdrawal from checking account ~

Insufficient funds.
Balance: $4066.17
Please enter a smaller amount.

~ Open new savings account with $20 at 3.56% interest. ~

Please deposit $5.00 to activate account.

New account OPENED.
Balance: $20.00
APR: 3.5600%
Account Status: Inactive

~ Make a $2 deposit into savings account ~

Unable to deposit $2.00
Account inactive! Must maintain a minimum balance of $25.
Balance: $20.00
You're deposit is $3.00 short.
Please make a deposit of at least $5.00

~ Make a $5 withdrawal from savings account ~

Unable to make a withdrawal.
Account inactive. $25 minimum required.
Balance: $20.00
$5.00 Deposit required to activate account.

~ View savings account information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000002
Balance: $20.00
Interest rate: 3.5600%
Status: Inactive

~ Simulate 1 monthly process ~

********** Running monthly process. **********

Balance: $20.00
Fees: $0.00
Balance after fees: $20.00
Interest: $0.06
Updated balance: $20.06

~ View savings account information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000002
Balance: $20.06
Interest rate: 3.5600%
Status: Inactive

~ Make a $10 deposit into savings account ~

Amount deposited: $10.00
Balance: $30.06

~ View savings account information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000002
Balance: $30.06
Interest rate: 3.5600%
Status: Active

~ Simulate 1 monthly process ~

********** Running monthly process. **********

Balance: $30.06
Fees: $0.00
Balance after fees: $30.06
Interest: $0.09
Updated balance: $30.15

~ View savings account information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000002
Balance: $30.15
Interest rate: 3.5600%
Status: Active

~ Open new savings account with $250 at 4.56% interest. ~

New account OPENED.
Balance: $250.00
APR: 4.5600%
Account Status: Active

~ View savings account 1 information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000003
Balance: $250.00
Interest rate: 4.5600%
Status: Active

~ Make 10 withdrawals ~

Amount withdrawn: $5.00
Balance: $245.00
Amount withdrawn: $50.00
Balance: $195.00
Amount withdrawn: $5.00
Balance: $190.00
Amount withdrawn: $15.00
Balance: $175.00
Amount withdrawn: $6.00
Balance: $169.00
Amount withdrawn: $5.00
Balance: $164.00
Amount withdrawn: $4.00
Balance: $160.00
Amount withdrawn: $3.00
Balance: $157.00
Amount withdrawn: $2.00
Balance: $155.00
Amount withdrawn: $1.00
Balance: $154.00

~ Simulate 1 monthly process ~

********** Running monthly process. **********

Balance: $154.00
Fees: $6.00
Balance after fees: $148.00
Interest: $0.56
Updated balance: $148.56

~ View savings account 1 information ~

********** ACCOUNT INFORMATION **********
Account type: Savings
Account number: 0000000003
Balance: $148.56
Interest rate: 4.5600%
Status: Active
*/