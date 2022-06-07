/**
 * <h1>Letter Grades and Average Test Score</h1>
 * This program will prompt the user to enter five 
 * test scores and will display a letter grade for 
 * each score and the average test score
 * 
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-03-13
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 6
 */

public class DemoTestAvgGrade {
  /** Main method */
  public static void main(String[] args) {
    
    // Create a MethodsAvgGrade object    
    MethodsAvgGrade test = new MethodsAvgGrade();
    
    System.out.println("Enter five test scores.");
    
    // Call scoresInput method to get user input and return array of test scores
    double[] testScores = test.scoresInput();
    
    // Call calcAverage method to get average test score
    double averageScore = test.calcAverage(testScores);
    
    // Call determineGrade method to get average letter grade
    char averageGrade = test.determineGrade(averageScore);
    
    // Display average test score and average letter grade
    System.out.printf("%s%.2f","\nAverage test score: ", averageScore);
    System.out.println("\nAverage test grade: " + averageGrade);

  }

}

/* 
Enter five test scores.

Score for test #1: p
Try again. (Incorrect input: a double is required.)

Score for test #1: 985
Please enter a number between 0 and 100.

Score for test #1: 95
Grade for test #1: A

Score for test #2: 85
Grade for test #2: B

Score for test #3: 75
Grade for test #3: C

Score for test #4: 65
Grade for test #4: D

Score for test #5: 55
Grade for test #5: F

Average test score: 75.00
Average test grade: C
 */