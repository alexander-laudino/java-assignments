/**
 * <h1>Monthly Rainfall</h1>
 * This program prompts a user to enter total rainfall
 * for each of 12 months, and then returns the total
 * rainfall for the year, the average monthly rainfall,
 * the month with the most rain, and the month with the
 * least rain.
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-03-25
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 7
 */

import java.util.*;

public class RainFall {

  public static void main(String[] args) {
    // Initialize month names array
    String[] months = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    
    // Get user input and return array of rainfall totals
    double[] rainByMonth = rainInput(months);
    // Get total rainfall for the year
    double rainTotal = totalRain(rainByMonth);
    System.out.printf("\nTotal rainfall for year: " + rainTotal + " inches\n");
    // Get average monthly rainfall 
    double avgRain = averageRain(rainTotal, months.length);
    System.out.printf("%s%.2f%s","Average monthly rainfall: ", avgRain, " inches");
    // Get month or months with most rain
    mostRain(months, rainByMonth);
    // Get month or months with least rain
    leastRain(months, rainByMonth);
  }
  
  /**
   * Prompts a user to enter rainfall totals for each
   * of 12 months, validates user input, and adds the 
   * input to an array
   * @param months Array of month names
   * @return Array of rainfall amounts
   */
  public static double[] rainInput(String[] months) {
    // Create empty array to hold user inputs
    double[] monthlyRain = new double[months.length];
    // Create new Scanner object
    Scanner input = new Scanner(System.in);
    // Sentinel value for input validation
    boolean continueInput = true;
    // Used for stepping through array index            
    int i = 0;
    // Loop through months to get user input
    for (String month: months) {
      // Initialize variable for user input
      double rain = 0;
      // Test valid input - Begin do-while loop
      do {
        // Prompt for user input
        try {
          System.out.print(month + ": ");
          rain = input.nextDouble();
        } // Exception handling for invalid input
        catch (InputMismatchException ex) {
          System.out.println("Try again. ("
              + "Incorrect input: a number is required.)");
          // Discard current input line so user can enter a new line of input
          input.nextLine();
          continue;
        }
        // Check for positive number
        if (rain >= 0) {
          continueInput = false;
        } // Continue loop if input is less than 0
        else {
          System.out.println("Please enter a number greater than or equal to 0.");
          continue;
        }
      } while (continueInput); // End do-while loop
    // Add user input to array
    monthlyRain[i] = rain;
    i++;
    } // End for loop
    // Close Scanner object
    input.close();
    
    return monthlyRain;
  }
  
  /**
   * Takes a list of numbers and returns the sum total
   * @param rain Array of numbers
   * @return Total value of all elements in list
   */
  public static double totalRain(double[] rain) {
    double total = 0;
    // Loop through array and add element value to total
    for (double m : rain) {
      total = total + m;
    }
    return total;
  }
  
  /**
   * Takes two numbers and returns the quotient
   * @param t Numerator - Sum of rainfall amounts
   * @param m Denominator - Number of months
   * @return Quotient - Average rainfall per month
   */
  public static double averageRain(double t, double m) {
    double average = t / m;
    return average;
  }
  
  /**
   * Takes an array of month names and rainfall totals, finds
   * the month or months with the most rainfall, and displays
   * results
   * @param months Array of month names
   * @param rainFall Array of rainfall amounts
   */
  public static void mostRain(String[] months, double[] rainFall) {
    // Initialize variable for holding value of most rainfall
    double most = 0;
    // Loop through array of rainfall amounts and update most to highest value
    for (double r: rainFall) {
      if (r > most) {
        most = r;
      }
    }
    // Initialize array for list of index values of rainfall 
    // amounts elements with dummy values
    int[] indexList = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int index = 0;
    // Loop through rainfall amounts array and add index values of element 
    // that equal most rainfall 
    for (int r = 0; r < rainFall.length; r++) {
      if (rainFall[r] == most) {
        indexList[index] = r;
        index = index + 1;
      }  
    }
    // Counter for number of months with most rainfall
    int multi = 0;
    // Get number of months with most rainfall
    for (int i: indexList) {
      if (i > 0) {
        multi = multi + 1;
      }
    }
    // Check if more than one month has the most rainfall
    if (multi > 1) {
      System.out.println("\nThere are multiple months with the most rainfall: ");
      // Loop through array of index values to get index for month name
      for (int i: indexList) {
        // Used to disregard dummy values in array
        if (i >= 0) {
          System.out.println(months[i] + " - " + most + " inches");
        }
      }
    }
    // If only one month has the most rainfall
    else {
      System.out.println("Month with most rain: " + months[indexList[0]] 
          + " - " + most + " inches" );
    }
  }
  
  /**
   * Takes an array of month names and rainfall totals, finds
   * the month or months with the least rainfall, and displays
   * results
   * @param months Array of month names
   * @param rainFall Array of rainfall amounts
   */
  public static void leastRain(String[] months, double[] rainFall) {
    // Initialize variable to hold value of least rainfall amount
    double least = 99999;
    // Loop through array of rainfall amounts and update least to lowest value
    for (double r: rainFall) {
      if (r < least) {
        least = r;
      }
    }
    // Initialize array for list of index values of rainfall 
    // amounts elements with dummy values
    int[] indexList = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int index = 0;
    // Loop through rainfall amounts array and add index values of element 
    // that equal most rainfall 
    for (int r = 0; r < rainFall.length; r++) {
      if (rainFall[r] == least) {
        indexList[index] = r;
        index = index + 1;
      }  
    }
    // Counter for number of months with least rainfall
    int multi = 0;
    // Get number of months with least rainfall
    for (int i: indexList) {
      if (i > -1) {
        multi = multi + 1;
      }
    }
    // Check if more than one month has the most rainfall
    if (multi > 1) {
      System.out.println("There are multiple months with the least rainfall: ");
      // Loop through array of index values to get index for month name
      for (int i: indexList) {
        // Used to disregard dummy values in array
        if (i >= 0) {
          if (least < 1) {
            System.out.println(months[i] + " - " + least + " of an inch");
          }
          else if (least == 1) {
            System.out.println(months[i] + " - " + least + " inch");
          }
          else {
            System.out.println(months[i] + " - " + least + " inches");
          }
        }
      } // End for loop
    }
    // If only one month has the least rainfall
    else {
      if (least < 1) {
        System.out.println("Month with least rain: " + months[indexList[0]] + " - " + least + " of an inch" );
      }
      else if (least == 1) {
        System.out.println("Month with least rain: " + months[indexList[0]] + " - " + least + " inch" );
      }
      else {
        System.out.println("Month with least rain: " + months[indexList[0]] + " - " + least + " inches" );
      }
    }
  }
 
}