import java.util.ArrayList;

/**
 * <h1>DemoTestScores Class</h1>
 * <p>This program demonstrates the TestScores class which prompts the user 
 * to enter a series of test scores, the program checks whether any of 
 * the scores are negative or greater than 100, if found, 
 * the class throws an IllegalArgumentException.</p>
 * <p>Dr.Farrett - CSC-162-IN1 - Lab Assignment 9</p>
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-11-15
 */
public class DemoTestScores {

  public static void main(String[] args) throws InterruptedException {
    
    System.out.println("~ Test valid scores. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores = TestScores.getTestScores();
    // Try creating new object
    try {
      TestScores s0 = new TestScores(scores);
      System.out.println(s0);
    }
    catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
    // For displaying stack trace 
    Thread.sleep(1000);
    
    System.out.println("~ Test invalid score over 100. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores1 = TestScores.getTestScores();
    // Try creating new object
    try {
      TestScores s1 = new TestScores(scores1);
      System.out.println(s1);
    }
    catch (IllegalArgumentException ex) {
      ex.printStackTrace();;
    }
    // For displaying stack trace
    Thread.sleep(1000);
    
    System.out.println("\n~ Test invalid score below 0. ~\n");
    // Prompt for test scores
    ArrayList<Double> scores2 = TestScores.getTestScores();
    // Try creating new object
    try {
      TestScores s2 = new TestScores(scores2);
      System.out.println(s2);
    }
    catch (IllegalArgumentException ex) {
      ex.printStackTrace();;
    }
  }  
}

/*
 * OUTPUT 
 * 
~ Test valid scores. ~

Enter score? (Y/N): 98
Try again. (Invalid input: Y or N required.)
Enter score? (Y/N): y
Enter a test score: 98.5
The test score entered is 98.50
Enter score? (Y/N): y
Enter a test score: 87.12
The test score entered is 87.12
Enter score? (Y/N): y
Enter a test score: 77.64
The test score entered is 77.64
Enter score? (Y/N): n

Test score #1: 98.5
Test score #2: 87.12
Test score #3: 77.64

Average score: 87.75%
Grade: B+

~ Test invalid score over 100. ~

Enter score? (Y/N): y
Enter a test score: 97.5
The test score entered is 97.50
Enter score? (Y/N): y
Enter a test score: 64.12
The test score entered is 64.12
Enter score? (Y/N): y
Enter a test score: 106.5
The test score entered is 106.50
Enter score? (Y/N): n
java.lang.IllegalArgumentException: Score cannot be greater than 100 or negative
  at TestScores.setAverageScore(TestScores.java:19)
  at TestScores.<init>(TestScores.java:9)
  at DemoTestScores.main(DemoTestScores.java:26)

~ Test invalid score below 0. ~

Enter score? (Y/N): y
Enter a test score: 54.05
The test score entered is 54.05
Enter score? (Y/N): y
Enter a test score: 97.01
The test score entered is 97.01
Enter score? (Y/N): y
Enter a test score: -7
The test score entered is -7.00
Enter score? (Y/N): y
Enter a test score: h
Try again. (Incorrect input: an double is required.)
Enter a test score: 95.1
The test score entered is 95.10
Enter score? (Y/N): n
java.lang.IllegalArgumentException: Score cannot be greater than 100 or negative
  at TestScores.setAverageScore(TestScores.java:19)
  at TestScores.<init>(TestScores.java:9)
  at DemoTestScores.main(DemoTestScores.java:40)
 */