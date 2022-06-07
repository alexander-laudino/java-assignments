/**
 * These are the methods that the program depends on 
 * to prompt the user to enter the test scores and 
 * validate the inputs, calculate the average grade 
 * of the user’s input, and determine the letter grade
 * of each score entered.
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-03-13
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 6
 */

import java.util.*;

public class MethodsAvgGrade {
   
  /**
   * Prompts the user to enter a test score, validates the input,
   * calls the determineGrade method and prints it's return value,
   * and adds the test score to an array.
   * @return Array of 5 user inputed test scores
   */
  public double[] scoresInput() {
    // Declare and create array
    double[] scores = new double[5];
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    // For loop to prompt user for 5 inputs
    for (int i = 0; i < scores.length; i++) {
      // Initialize and declare variable as placeholder for user input
      double score = 0;
      // Sentinel value for input validation
      boolean continueInput = true;
      // Check whether input is valid      
      do {
        try {
          System.out.print("\nScore for test #" + (i + 1) + ": ");
          score = input.nextDouble();
        }
        // Catch non-numeric input
        catch (InputMismatchException ex) {
          System.out.println("Try again. ("
              + "Incorrect input: a double is required.)");
       // Discard current input line so user can enter a new line of input
          input.nextLine();
          continue;
        }
        // Check if input is in range
        if (score <=100 && score >= 0) {
          continueInput = false;
        }
        else {
          System.out.println("Please enter a number between 0 and 100.");
          continue;
        }
      } while (continueInput);
      // Calls determineGrade method to get grade letter for score
      char grade = determineGrade(score);
      // Displays grade letter for test
      System.out.println("Grade for test #" + (i + 1) + ": " + grade);
      // Add input to array
      scores[i] = score;
    }
    
    input.close();
    
    return scores;
  }
  
  /**
   * Calculates the average test score of user's entered test scores.
   * @param scores Array of 5 test scores
   * @return Average test score
   */
  public double calcAverage(double[] scores) {
    double sum = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
    double avg = sum / 5.0;
    return avg;
  }

  /**
   * Converts a numeric score into a letter grade.
   * @param score User inputed test score
   * @return Letter grade of test score
   */
  public char determineGrade(double score) {
    char grade;
    if (score >= 90) {
      grade = 'A';
    }
    else if (score >= 80) {
      grade = 'B';
    }
    else if (score >= 70) {
      grade = 'C';
    }
    else if (score >= 60) {
      grade = 'D';
    }
    else {
      grade = 'F';
    }
    return grade;
  }
  
}