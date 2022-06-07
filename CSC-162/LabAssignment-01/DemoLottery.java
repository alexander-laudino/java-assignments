/**
 * <h1>Lottery Application</h1>
 * This program prompts a user to enter five numbers, displays
 * five randomly generated lottery numbers along with the user's
 * numbers and the number of digits that match the lottery numbers.
 * 
 * 1. User must enter digits in the range of 0 through 9.
 * 2. If all of the digits match, a message is displayed 
 *    proclaiming the user a grand prize winner. 
 *    
 * @author Alexander Laudino
 * for CSC 162-INC1
 * Dr. Farrett
 * Lab Assignment 1
 * @since 2021-09-15
 * @version 1.0
 */

import java.util.*;

public class DemoLottery {
  
  // Main method
	public static void main(String[] args) {
		
	  // Create new Lottery object
	  Lottery demo = new Lottery();
	  
	  // Prompt user for input of five numbers
	  demo.setUserNumbers();
	  
	  // Returns copy of lotteryNumbers array
	  demo.getLotteryNumbers();
	  
	  // Returns copy of userNumbers array
	  demo.getUserNumbers();
	  
	  // Returns number of matching digits
	  demo.getMatchingNumbers();
	  
	}

}

/**
 * The Lottery class provides the variables, constructors, and methods
 * to randomly generate a number in the range of 0 through 9 that populates
 * an array, prompts a user for input of five digits to populate an array, 
 * compares the arrays and returns the number of matching digits, and displays
 * the two arrays.
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-09-15
 *
 */

class Lottery {
  
  // ----- VARIABLES -----
  
  /**
   * Create a new Scanner object for user input, used in the 
   * inputNumber method which is called by the setUserNumbers 
   * method  
   */
  private static final Scanner INPUT = new Scanner(System.in);
  
  /**
   * The lotteryNumbers variable creates a new array to hold five
   * randomly generated integers 
   */
  private int[] lotteryNumbers = new int[5];
  
  /**
   * The userNumbers variable creates an array to hold five user input
   * integers
   */
  private int[] userNumbers = new int[5];
  
  /**
   * The matchingNumbers variable holds the value of the number of digits
   * from the userNumbers array that match the randomly generated digits
   * from the lotteryNumbers array
   */
  private int matchingNumbers;
  
  // ----- CONSTRUCTORS -----
  
  /**
   * The Lottery constructor calls the generateNumbers method to populate
   * the lotteryNumbers array
   */
  Lottery() {
    this.lotteryNumbers = generateNumbers();
  }
  
  // ----- METHODS -----
  
  /**
   * The generateNumbers method uses the Random class to generate a random
   * number in the range of 0 through 9 to populate a one-dimensional array
   * that contains 5 elements
   * @return One-dimensional int[5] array
   */
  private int[] generateNumbers() {
    
    // Create new Random object
    Random random = new Random();
    
    // Create empty array to store randomly generated integers
    int[] numbers = new int[5];
    
    // Loop through empty array to set randomly generated numbers to 
    // array row index
    for (int row = 0; row < lotteryNumbers.length; row++) {
      int n = random.nextInt(10); // System.out.print(n); to verify grand prize message
      numbers[row] = n;
    }
    
    return numbers;
    
  }

  /**
   * The setUserNumbers method prompts the user to enter 5 integers in the range
   * of 0 through 9 by calling the inputNumbers method and assigns the value to
   * the userNumbers array row index
   */
  public void setUserNumbers() {
    
    System.out.println("\nPlease enter lottery numbers, 5 numbers in the range of 0 to 9.");
    
    // Loop to call inputNumber method to get user input and assign it to array
    for (int row = 0; row < userNumbers.length; row++) {
      int i = inputNumber(row);      
      userNumbers[row] = i;
    }
    
  }
  
  /**
   * The inputNumber method prompts the user to enter an integer between 0 and 9,
   * input is validated to ensure it is correct data type and in range
   * @param row Integer value of row number in for loop of setUserNumbers method
   * @return Integer between 0 and 9
   */
  private int inputNumber(int row) {
    
    // Variable used to hold user input
    int num = 0;
    
    // For ending user input in do-while loop
    boolean continueInput = true;
    
    // For user input validation
    do {
      
      // For data type validation
      try {
        
        // Prompt user for input
        System.out.print("Enter number " + (row + 1) + ": ");
        num = INPUT.nextInt();
        
        // Validate integer is in range, break out of loop
        if (num > 0 && num < 10) {
          continueInput = false;
        }
        
        // If integer not in range, continue loop
        else {
          System.out.println("Try again. (Incorrect input: 0 through 9 required.)");
          continue;
        }
        
      }
      
      // Catch invalid data type input, clear input cache, continue loop
      catch (InputMismatchException e) {
        System.out.println("Try again. (Incorrect input: an integer is required.)");
        INPUT.nextLine();
      }
      
    } while (continueInput); // End of user input validation do-while loop
    
    return num;
    
  }
  
  /**
   * The getLotteryNumbers method loops through the lotteryNumbers array and
   * displays the integers
   */
  public void getLotteryNumbers() {
    
    System.out.print("\nLottery Numbers: ");
    
    for (int row = 0; row < lotteryNumbers.length; row++) {
      System.out.print(lotteryNumbers[row]);
    }
    
  }
  
  /**
   * The getUserNumbers method loops through the user Numbers array and displays
   * the integers
   */
  public void getUserNumbers() {
    
    System.out.print("\nUser Numbers:    ");
    
    for (int row = 0; row < userNumbers.length; row++) {
      System.out.print(userNumbers[row]);
    }
    
  }
  
  /**
   * The compareNumbers method accepts an array of integers and compares it to the
   * lotteryNumbers array and its corresponding elements and sets the matchingNumber
   * variable with the number of digits that match 
   * @param userNums Array of 5 integers that represents a person's lottery picks
   */
  private void compareNumbers(int[] userNums) {
    
    // Variable used to hold count of matching numbers
    int num = 0;
    
    // Loop through array
    for (int row = 0; row < lotteryNumbers.length; row++) {
      
      // Compare values and increment counter if equal
      if (lotteryNumbers[row] == userNums[row]) {
        num = num + 1;
      }
    }
    
    matchingNumbers = num;
    
  }
  
  /**
   * The getMatchingNumbers method calls the compareNumbers method to set the 
   * matchingNumbers variable and displays the results, if all the digits match,
   * a message is displayed proclaiming the user a grand prize winner
   */
  public void getMatchingNumbers() {
    
    compareNumbers(userNumbers);
    
    System.out.println("\nMatching numbers: " + matchingNumbers);
    
    // If all digits match
    if (matchingNumbers == 5) {
      System.out.println("You are a GRAND PRIZE WINNER!!!");
    }
    
  }

}


/**
 * Please enter lottery numbers, 5 numbers in the range of 0 to 9.
Enter number 1: 1
Enter number 2: 1
Enter number 3: 1
Enter number 4: 1
Enter number 5: 1

Lottery Numbers: 50516
User Numbers:    11111
Matching numbers: 1


21587
Please enter lottery numbers, 5 numbers in the range of 0 to 9.
Enter number 1: 2
Enter number 2: 1
Enter number 3: 5
Enter number 4: 8
Enter number 5: 7

Lottery Numbers: 21587
User Numbers:    21587
Matching numbers: 5
You are a GRAND PRIZE WINNER!!!
 */ 


