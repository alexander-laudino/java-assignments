/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Feb. 4, 2021
 * Lab Assignment 2 - Stock Commission
 * 
 * This program calculates the amount paid for 600 shares of stock
 * at a price of $21.77, the amount of a 2% commission on the transaction,
 * and the total amount paid for the stock and the commission.
 */

public class StockCommission {

  public static void main(String[] args) {
    int shares = 600; // Total shares purchased
    double pricePerShare = 21.77; // Price per share
    double commissionRate = 0.02; // Broker commission percentage
    
    // Calculate total amount paid for shares
    double shareCost = shares * pricePerShare;
    
    // Calculate amount of commission for transaction
    double commission = shareCost * commissionRate;
    
    // Calculate total amount paid for stock plus commission
    double totalCost = shareCost + commission;
    
    // Display output
    System.out.printf("%s%,.2f\n", "Amount paid for stock: $", shareCost);
    System.out.println("Amount of commission on transaction: $" + commission);
    System.out.printf("%s%,.2f", "Total amount paid for the stock plus the commission: $", totalCost);
  }
}

/* Console output:
 * Amount paid for stock: $13,062.00
 * Amount of commission on transaction: $261.24
 * Total amount paid for the stock plus the commission: $13,323.24 */