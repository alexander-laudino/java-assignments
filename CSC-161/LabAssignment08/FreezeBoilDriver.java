/**
 * These are the methods that the program depends on 
 * to prompt the user to enter a temperature, validate
 * the input, determine if a substance would freeze or
 * boil at that temperature, and display the results.
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-04-04
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 8
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class FreezeBoilDriver {
  
  /**
   * Variable to hold user input
   */
  private static double temperature; 
  /**
   * Used for range of user input
   */
  final private static double ABSOLUTE_ZERO = -459.67; 
  /**
   * Array of substance names
   */
  final private String[] SUBSTANCES = {"Ethyl Alcohol", "Oxygen", "Water"};
  /**
   * Freezing and boiling temperatures for each substance
   */
  final private static double[][] FREEZE_BOIL_TEMPS = {{-173, 172}, {-362, -306}, {32, 212}};
  /**
   * Empty array to hold boolean values from freezing and boiling methods
   */
  private static boolean[][] freezeBoilBool = new boolean[2][3]; 
  /**
   * Empty array to hold string values of substances that are freezing
   */
  private static String[] freezing = new String[3];
  /**
   * Empty array to hold string values of substances that are boiling
   */
  private static String[] boiling = new String[3];
  
  /**
   * This method prompts a user to input a temperature, then validates if the input is
   * numeric and in range. It then sets the temperature variable to the user input and calls
   * the setFreezeBoil() method to set the values of the freezeBoilBool array.
   */
  public void setTemp() {
    
    // Create new Scanner object
    Scanner input = new Scanner(System.in);
    
    double temp = 0; // Initialize variable to hold user input
    boolean continueInput = true; // Initialize sentinel value for do-while loop
    
    // Do-while loop to validate user input
    do {
      try {
        System.out.print("Enter a temperature: ");
        // Prompt user for input
        temp = input.nextDouble();
      }
      // Catch non-numeric input
      catch (InputMismatchException ex) {
        System.out.println("Try again. ("
            + "Incorrect input: a number is required.)");
        // Discard current input line so user can enter a new line of input
        input.nextLine();
        continue;
      }
      // Check if input is in range of Fahrenheit temperature scale
      if (temp >= ABSOLUTE_ZERO) {
        continueInput = false;
      }
      else {
        System.out.println("Please enter a number greater than " + ABSOLUTE_ZERO);
      }
    } while (continueInput); // End do-while loop
    input.close(); // Close Scanner object
    temperature = temp; // Set user input to temperature variable
    setFreezeBoil(); // Call setFreezeBoil method to set boolean values in freezeBoilBool array
  }
  
  /**
   * This method sets the elements of the freezeBoilBool array to boolean values 
   * for each substance.
   */
  private void setFreezeBoil() {
    freezeBoilBool[0][0] = isEthylFreezing(); // First element of first array
    freezeBoilBool[0][1] = isOxygenFreezing(); // Second element of first array
    freezeBoilBool[0][2] = isWaterFreezing(); // Third element of first array
    freezeBoilBool[1][0] = isEthylBoiling(); // First element of second array
    freezeBoilBool[1][1] = isOxygenBoiling(); // Second element of second array
    freezeBoilBool[1][2] = isWaterBoiling(); // Third element of second array
  }
  
  /**
   * This method calls the methods isFreezing() and isBoiling() to get the number of substances 
   * that are freezing and boiling, it then hands the return values to the printFreeze() and
   * printBoil() methods to display the results.
   */
  public void showFreezeBoil() {
    
    // Calls isFreezing() method and returns number of substances that are freezing
    int numFreezing = isFreezing();
    // Calls isBoiling() method and returns number of substances that are boiling
    int numBoiling = isBoiling();
    
    // Calls printFreeze() method to display results for freezing substances
    printFreeze(numFreezing);
    // Calls printBoil() method to display results for boiling substances
    printBoil(numBoiling);
    
  }
  
  /**
   * This method takes an integer value from 0 to 3 and displays the results based on 
   * the number of substances that are freezing. 
   * @param n Number of substances that are freezing
   */
  private void printFreeze(int n) {
    
    // Number of substances that are freezing equals 1
    if (n == 1) {
      System.out.print("At that temperature, ");
      // Loop through array to get string value 
      for (String sub : freezing) {
        if (sub == null) {
          continue;
        }
        else {
          System.out.print(sub + " ");
        }
      }
      System.out.println("will freeze.");
    }
    // Number of substances that are freezing equals 2
    else if (n == 2 ) {
      String[] twoSub = new String[2]; // Creates empty array to hold string values
      int t = 0;
      // Loop through array to get string values and add them to twoSub array
      for (String sub : freezing) {
        if (sub == null) {
          continue;
        }
        else {
          twoSub[t] = sub;
          t++;
        }
      }
      System.out.println("At that temperature, " + twoSub[0] + " and " + twoSub[1] + " will freeze.");
    }
    // Number of substances that are freezing equals 3
    else if (n == 3) {
      System.out.print("At that temperature, " + freezing[0] + ", " + freezing[1] + 
          " and " + freezing[2] + " will freeze.");
    }
  }
  
  /**
   * This method takes an integer value from 0 to 3 and displays the results based on 
   * the number of substances that are boiling.
   * @param n Number of substances that are boiling
   */
  private void printBoil(int n) {
    
    // Number of substances that are boiling equals 1
    if (n == 1) {
      System.out.print("At that temperature, ");
      // Loop through array to get string value
      for (String sub : boiling) {
        if (sub == null) {
          continue;
        }
        else {
          System.out.print(sub + " ");
        }
      }
      System.out.println("will boil.");
    }
    // Number of substances that are boiling equals 2
    else if (n == 2 ) {
      String[] twoSub = new String[2]; // Empty array to hold string values
      int t = 0;
      // Loop through array to get string values and add them to twoSub array
      for (String sub : boiling) {
        if (sub == null) {
          continue;
        }
        else {
          twoSub[t] = sub;
          t++;
        }
      }
      System.out.print("At that temperature, " + twoSub[0] + " and " + twoSub[1] + " will boil.");
    }
    // Number of substances that are boiling equals 3
    else if (n == 3) {
      System.out.print("At that temperature, " + boiling[0] + ", " + boiling[1] + 
          " and " + boiling[2] + " will boil.");
    }
  }
  
  /**
   * This method counts the number of substances that are freezing and adds
   * their string value to the freezing array.
   * @return Number of substances that are freezing
   */
  private int isFreezing() {
    int multi = 0;
    // Loop through freezeBoilBool array to find boolean values equal to true
    for (int column = 0; column < freezeBoilBool[0].length; column++) {
      if (freezeBoilBool[0][column] == true) {
        // Add substance name to freezing array
        freezing[column] = SUBSTANCES[column];
        multi = multi + 1;
      }
    }
    return multi;
  }
  
  /**
   * This method counts the number of substances that are boiling and adds
   * their string value to the boiling array.
   * @return Number of substances that are boiling
   */
  private int isBoiling() {
    int multi = 0;
    // Loop through freezeBoilBool array to find boolean values equal to true
    for (int column = 0; column < freezeBoilBool[1].length; column++) {
      if (freezeBoilBool[1][column] == true) {
        // Add substance name to boiling array
        boiling[column] = SUBSTANCES[column];
        multi = multi + 1;
      }
    }
    return multi;
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or below the freezing point of ethyl alcohol.
   * Otherwise, it returns false.
   * @return Boolean value 
   */
  private static boolean isEthylFreezing() {
    if (temperature <= FREEZE_BOIL_TEMPS[0][0]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or above the boiling point of ethyl alcohol.
   * Otherwise, it returns false.
   * @return Boolean value
   */
  private static boolean isEthylBoiling() {
    if (temperature >= FREEZE_BOIL_TEMPS[0][1]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or below the freezing point of oxygen.
   * Otherwise, it returns false.
   * @return Boolean value
   */
  private static boolean isOxygenFreezing() {
    if (temperature <= FREEZE_BOIL_TEMPS[1][0]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or above the boiling point of oxygen.
   * Otherwise, it returns false.
   * @return Boolean value
   */
  private static boolean isOxygenBoiling() {
    if (temperature >= FREEZE_BOIL_TEMPS[1][1]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or below the freezing point of water.
   * Otherwise, it returns false.
   * @return Boolean value
   */
  private static boolean isWaterFreezing() {
    if (temperature <= FREEZE_BOIL_TEMPS[2][0]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method returns the boolean value true if the temperature stored in
   * the temperature field is at or above the boiling point of water.
   * Otherwise, it returns false.
   * @return Boolean value
   */
  private static boolean isWaterBoiling() {
    if (temperature >= FREEZE_BOIL_TEMPS[2][1]) {
      return true;
    }
    else {
      return false;
    }
  }
}