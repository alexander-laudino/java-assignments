/**
 * <h1>Freezing and Boiling Points</h1>
 * This program prompts a user to enter a temperature,
 * it then determines if Ethyl Alcohol, Oxygen, and Water
 * will either freeze or boil at that temperature, and 
 * displays the results.
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-04-04
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 8
 */
public class FreezeBoil {

  public static void main(String[] args) {
    
    // Create new FreezeBoilDriver object
    FreezeBoilDriver driver = new FreezeBoilDriver();
    
    // Call setTemp method to get user input
    driver.setTemp();
    
    // Call showFreezeBoil to display results
    driver.showFreezeBoil();
  }

}