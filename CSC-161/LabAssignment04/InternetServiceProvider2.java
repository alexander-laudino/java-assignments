/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Feb. 21, 2021
 * Lab Assignment 4 - Internet Service Provider 2
 */ 
/** This program calculates a customer's monthly bill.
 *  It prompts the customer to enter the package letter of
 *  their subscription. For Package A and Package B, the 
 *  program prompts the customer to enter the number of hours
 *  that were used. If the customer used more than the total
 *  access hours provided in their plan, the program calculates
 *  the additional fee in addition to their flat fee.
 *  
 *  The program additionally calculates any savings a customer 
 *  could realize if they had purchased a different plan.
 */

import javax.swing.JOptionPane;

public class InternetServiceProvider2 {
  
  public static void main(String[] args) {
    
    double packageC = 19.95; 
    double hours = 0;
        
    // While loop to validate user package letter input
    while (true) {
      
      String packageLetter = JOptionPane.showInputDialog("Enter Package Letter: ");
      
      // Package C
      if (packageLetter.toLowerCase().equals("c")) {
        System.out.printf("Package %s total bill: $%.2f.", packageLetter.toUpperCase(), packageC);
        break;
      }
      
      // Package A or B
      else if (packageLetter.toLowerCase().equals("a") || packageLetter.toLowerCase().equals("b")) {
        
        // While loop to validate user hours input is a double type
        while (true) {
          
          try {
            
            hours = Double.parseDouble(JOptionPane.showInputDialog("Enter number of hours of internet usage"));
            
            // Execute statements for A or B 
            switch (packageLetter.toLowerCase()) {
            
              case "a": System.out.printf("Package %s total bill: $%.2f.\n",
                          packageLetter.toUpperCase(), packageA(hours));
                      
                        // If total bill of Package A is greater than Package B but less than Package C,
                        // calculate the difference and display output
                        if (packageA(hours) > packageB(hours) && packageA(hours) <= packageC) {
                          System.out.printf("By switching to Package B, you could have saved $%.2f",
                              (packageA(hours) - packageB(hours) ) );
                        }
                        
                        // If total bill of Package A is greater than Package B and Package C,
                        // calculate the differences and display outputs
                        else if (packageA(hours) > packageB(hours) && packageA(hours) > packageC) { 
                          System.out.printf("By switching to Package B, you could have saved $%.2f.\n",
                              (packageA(hours) - packageB(hours) ) );
                          System.out.printf("By switching to Package C, you could have saved $%.2f.",
                              (packageA(hours) - packageC) );
                        }
                        break;
            
              case "b": System.out.printf("Package %s total bill: $%.2f.\n",
                          packageLetter.toUpperCase(), packageB(hours));
                        
                        // If total bill of Package B is greater than Package C, calculate the difference
                        // and display output
                        if (packageB(hours) > packageC) {
                          System.out.printf("By switching to Package C, you could have saved $%.2f.",
                              (packageB(hours) - packageC) );
                        }
                        break;
            }
            break; // Break out of double validation loop
          } 
          catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please enter a valid number.");
            continue;
          }
        }
        break; // Break out of package letter validation loop
      }  
      
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid package letter.");
        continue;
      }
    }
    System.exit(0);
  }

  /**
   * Method calculates total bill of Package A
   * @param hours
   * @return Total amount of bill
   */
  private static double packageA(double hours) {
    
    if (hours <= 10) {
      return 9.95;
    }
    else {
      return (9.95 + (2 * (hours - 10) ) );
    }
  }
  
  /**
   * Method calculates total bill of Package B
   * @param hours
   * @return Total amount of bill
   */
  private static double packageB(double hours) {
    
    if (hours <= 20) {
      return 13.95;
    }
    else {
      return (13.95 + (1 * (hours - 20) ) );
    }
  }
}

// Input: Package = A, hours = 10
// Output: Package A total bill: $9.95.

// Input: Package = A, hours = 15 
// Output: Package A total bill: $19.95.
//         By switching to Package B, you could have saved $6.00

// Input: Package = A, hours = 20
// Output: Package A total bill: $29.95.
//         By switching to Package B, you could have saved $16.00.
//         By switching to Package C, you could have saved $10.00.

// Input: Package = B, hours = 20
// Output: Package B total bill: $13.95.

// Input: Package = B, hours = 30
// Output: Package B total bill: $23.95.
//         By switching to Package C, you could have saved $4.00.

// Input: Package = C
// Output: Package C total bill: $19.95.