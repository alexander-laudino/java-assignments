/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Feb. 21, 2021
 * Lab Assignment 4 - Internet Service Provider
 */ 
/** This program calculates a customer's monthly bill.
 *  It prompts the customer to enter the package letter of
 *  their subscription. For Package A and Package B, the 
 *  program prompts the customer to enter the number of hours
 *  that were used. If the customer used more than the total
 *  access hours provided in their plan, the program calculates
 *  the additional fee in addition to their flat fee.
 */

import javax.swing.JOptionPane;

public class InternetServiceProvider {
  
  public static void main(String[] args) {
    
    // While loop to validate user package letter input 
    while (true) {
       
      String packageLetter = JOptionPane.showInputDialog("Enter Package Letter: ");
       
      // Check to see if letter input matches one of the package letters
      if (packageLetter.toLowerCase().equals("a") || packageLetter.toLowerCase().equals("b") 
          || packageLetter.toLowerCase().equals("c")) {
        
        // Check value of package letter and execute statement if value matches
        switch (packageLetter.toLowerCase()) {
         
          case "a": System.out.printf("Package %s total bill: $%.2f.", packageLetter.toUpperCase(), packageA());
                    break;
         
          case "b": System.out.printf("Package %s total bill: $%.2f.", packageLetter.toUpperCase(), packageB());
                    break;
         
          case "c": System.out.printf("Package %s total bill: $%.2f.", packageLetter.toUpperCase(), 19.95);
                    break;
        }
        break;
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
   * based on number of hours user inputs
   * @return Total amount of bill
   */
  private static double packageA() {
    
    double hours;
    
    // While loop to validate user input is a double type
    while (true) {
      
      try {
        // Converts Dialog box input from String to Double
        hours = Double.parseDouble(JOptionPane.showInputDialog("Enter number of hours of internet usage"));
        break;
      } 
      catch (Exception e) {
        System.out.println("Please enter a valid number.");
        continue;
      }
    }
    if (hours <= 10) {
      return 9.95;
    }
    else {
      return (9.95 + (2 * (hours - 10) ) );
    }  
  }
  
  /**
   * Method calculates total bill of Package B
   * based on number of hours user inputs
   * @return Total amount of bill
   */
  private static double packageB() {
    
    double hours;
    
    // While loop to validate user input is a double type
    while (true) {
      
      try {
        // Converts Dialog box input from String to Double
        hours = Double.parseDouble(JOptionPane.showInputDialog("Enter number of hours of internet usage"));
        break;
      } 
      catch (Exception e) {
        System.out.println("Please enter a valid number.");
        continue;
      }
    }  
    if (hours <= 20) {
      return 13.95;
    }
    else {
      return 13.95 + (1 * (hours - 20));
    }
  }
}

// Input: Package = A, hours = 10
// Output: Package A total bill: $9.95.

// Input: Package = A, hours = 20
// Output: Package A total bill: $29.95.

// Input: Package = B, hours = 20
// Output: Package B total bill: $13.95.

// Input: Package = B, hours = 30
// Output: Package B total bill: $23.95.

// Input: Package = C
// Output: Package C total bill: $19.95.