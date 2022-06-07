/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Mar. 1, 2021
 * Lab Assignment 5 - Slot Machine
 */ 

/* This program simulates a slot machine, it prompts the user
 * to enter an amount of money and then randomly generates 
 * three words from a list of images. It displays the three
 * words and then checks if there are any matches. If none of
 * the words match, the program displays that the user has won $0,
 * if two words match, the program displays that the user has won
 * two times the amount entered, and if three words match, the 
 * program displays that the user has won three times the amount
 * entered. The program then prompts the user if they would like
 * to play again. If the user presses Enter, the program will run
 * again, if the user enters "No", the program will display the 
 * total amount of money entered as well as the total amount won,
 * if any.
 */

// Import classes
import javax.swing.JOptionPane; // Dialog box class
import java.text.DecimalFormat; // Decimal format class
import java.util.Random; // Random class

public class SlotMachine {
  
  // Main method
  public static void main(String[] args) {
    
    // Declare and initialize variables
    String[] images = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
    int max = images.length; // Used for random number generator, sets upper limit
    double totalEntered = 0;
    double totalWon = 0;
    String playAgain = "Yes";
    
    // Create DecimalFormat class to format output.
    DecimalFormat fmt = new DecimalFormat("###,###.00");
    
    // Create a Random object.
    Random randValue = new Random();
    
    // Do-while loop for playing slot machine simulation
    do {   
      double moneyEntered = 0;
      double moneyWon = 0;
      
      // While loop to validate moneyEntered is a double type
      while (true) {
        
        try {
          moneyEntered = Double.parseDouble(JOptionPane.showInputDialog(
              "Enter amount of money to enter into slot machine"));
          break;
        } 
        catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Please enter a valid number.");
          continue;
        }
      } // End of moneyEntered while loop
            
      // Randomly generate three words
      String slot0 = images[randValue.nextInt(max)];
      String slot1 = images[randValue.nextInt(max)];
      String slot2 = images[randValue.nextInt(max)];

      // Display generated words
      System.out.println("\n" + slot0 + "|" + slot1 + "|" + slot2);
       
      // Truth values for matches
      boolean match0 = slot0.equals(slot1);
      boolean match1 = slot0.equals(slot2);
      boolean match2 = slot1.equals(slot2); 
      
      // Check if all selected words match
      if (match0 && match1) {
        moneyWon = moneyEntered * 3;
        System.out.printf("\n%s%s\n", "You won: $", fmt.format(moneyWon));
      }
      // Check if two selected words match
      else if (match0 || match1 || match2) {
        moneyWon = moneyEntered * 2;
        System.out.printf("\n%s%s\n", "You won: $", fmt.format(moneyWon));
      }
      // If no words match
      else {
        System.out.print("\nYou won: $0\n");
      }
      
      // Variables for holding value of total money entered and total money won
      totalEntered = totalEntered + moneyEntered;
      totalWon = totalWon + moneyWon;
      
      // Prompts user to play again or quit
      playAgain = JOptionPane.showInputDialog( "Play again? Press enter to continue. Type no to quit.");
      
    } while (!playAgain.toLowerCase().equals("no")); // Sentinel value, if "No" entered, ends input
  
  System.out.printf("\n%s%,.2f\n", "Total money entered into slot machine: $", totalEntered);
  System.out.printf("%s%,.2f", "Total money won: $", totalWon);
  
  System.exit(0);

  }
    
}

/* Console output:
   Plums|Cherries|Cherries

   You won: $2,000.00

   Oranges|Bars|Bars

   You won: $2,000.00

   Melons|Bells|Bells

   You won: $2,000.00

   Bells|Cherries|Plums

   You won: $0

   Melons|Cherries|Plums

   You won: $0

   Cherries|Cherries|Plums

   You won: $2,000.00

   Total money entered into slot machine: $6,000.00
   Total money won: $8,000.00
 */