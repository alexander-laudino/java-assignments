import java.util.ArrayList;

/**
 * <h1>DemoTestScoresWithException Class</h1>
 * <p>This program demonstrates the TestScoresWithException class which
 * prompts the user to enter a series of test scores, the program checks
 * whether any of the scores are negative or greater than 100, if found, 
 * the class throws an InvalidTestScore exception.</p>
 * <p>Dr.Farrett - CSC-162-IN1 - Lab Assignment 9</p>
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-11-15
 */
public class DemoTestScoresWithException {

  public static void main(String[] args) throws InterruptedException {
    
    System.out.println("~ Test valid scores. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores = TestScoresWithException.getTestScores();
    // Try creating new object
    try {
      TestScoresWithException s0 = new TestScoresWithException(scores);
      System.out.println(s0);
    }
    catch (InvalidTestScore ex) {
      ex.printStackTrace();
    }
    // For displaying stack trace
    Thread.sleep(1000);
    
    System.out.println("~ Test invalid score above 100. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores1 = TestScoresWithException.getTestScores();
    // Try creating new object
    try {
      TestScoresWithException s1 = new TestScoresWithException(scores1);
      System.out.println(s1);
    }
    catch (InvalidTestScore ex) {
      ex.printStackTrace();;
    }
    // For displaying stack trace
    Thread.sleep(1000);
    
    System.out.println("\n~ Test invalid score below 0. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores2 = TestScoresWithException.getTestScores();
    // Try creating new object
    try {
      TestScoresWithException s2 = new TestScoresWithException(scores2);
      System.out.println(s2);
    }
    catch (InvalidTestScore ex) {
      ex.printStackTrace();
    }
  }
}

/*
 * OUTPUT
 * 
~ Test valid scores. ~

Enter score? (Y/N): 85
Try again. (Invalid input: Y or N required.)
Enter score? (Y/N): y
Enter a test score: 85
The test score entered is 85.00
Enter score? (Y/N): y
Enter a test score: 95.6
The test score entered is 95.60
Enter score? (Y/N): y
Enter a test score: 78.45
The test score entered is 78.45
Enter score? (Y/N): y
Enter a test score: 89.5
The test score entered is 89.50
Enter score? (Y/N): n

Test score #1: 85.0
Test score #2: 95.6
Test score #3: 78.45
Test score #4: 89.5

Average score: 87.14%
Grade: B+

~ Test invalid score above 100. ~

Enter score? (Y/N): y
Enter a test score: 95
The test score entered is 95.00
Enter score? (Y/N): y
Enter a test score: 106
The test score entered is 106.00
Enter score? (Y/N): y
Enter a test score: 87
The test score entered is 87.00
Enter score? (Y/N): n
InvalidTestScore: Invalid score! Test #2: 106.0
Score cannot be greater than 100 or negative

~ Test invalid score below 0. ~

Enter score? (Y/N): y
Enter a test score: 97
The test score entered is 97.00
Enter score? (Y/N): y
Enter a test score: -8
The test score entered is -8.00
Enter score? (Y/N): y
Enter a test score: 67
The test score entered is 67.00
Enter score? (Y/N): n
InvalidTestScore: Invalid score! Test #2: -8.0
Score cannot be greater than 100 or negative
 */