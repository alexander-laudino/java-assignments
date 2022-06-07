import java.util.*;

/**
 * <h1>TestScoresWithException Class</h1>
 * <p>The TestScores class is used to create objects that prompt
 * the user to enter a series of test scores and then computes
 * the average test score.</p>
 * <p>Dr.Farrett - CSC-162-IN1 - Lab Assignment 9</p>
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-11-15
 */
public class TestScoresWithException {
  
  // ------------------ VARIABLES ------------------
  
  /** Scanner object for accepting user input */
  private static final Scanner INPUT = new Scanner(System.in);
  /** Average test score */
  private double averageScore;
  /** List of test scores */
  private double[] scores;
  
  // ------------------ CONSTRUCTORS ------------------
  
  /**
   * Empty constructor
   */
  TestScoresWithException() {
  }
  
  /**
   * Construct new object with test scores as argument
   * @param testScores ArrayList<Double> of test scores
   */
  TestScoresWithException(ArrayList<Double> testScores) 
      throws InvalidTestScore {
    setAverageScore(testScores);
    setScores(testScores);
  }
  
  // ------------------ METHODS ------------------
  
  /**
   * Take a list of doubles representing test scores and return average score
   * @param testScores ArrayList<Double> user entered arguments
   * @throws InvalidTestScore If score is greater than 100 or negative
   */
  private void setAverageScore(ArrayList<Double> testScores) 
      throws InvalidTestScore {
    double sum = 0;
    for (double score: testScores) {
      if (score > 100 || score < 0)
        throw new InvalidTestScore((testScores.indexOf(score) + 1), score);
      else
        sum += score;
    }
    this.averageScore = sum / testScores.size();
  }
  
  /**
   * Prompt user to enter a test score
   * @return Double representing score
   */
  public static double getScore() {
    
    boolean continueInput = true; // Sentinel value
    double score = 0;
    // Prompt user for input, catches invalid inputs
    do {
      try {
        System.out.print("Enter a test score: ");
        score = INPUT.nextDouble();
        
        // Display the result
        System.out.printf("The test score entered is %.2f\n", score);
        
        continueInput = false;
      }
      catch (InputMismatchException ex) {
        System.out.println("Try again. (" +
            "Incorrect input: an double is required.)");
        INPUT.nextLine(); // Discard current input
      }
    } while (continueInput);
    
    return score;
  }
  
  /**
   * Prompt user if they want to enter a score, calls getScore() and 
   * adds return value to list
   * @return ArrayList<Double> list of test scores
   */
  public static ArrayList<Double> getTestScores() {
    ArrayList<Double> scores = new ArrayList<>();
    boolean continueInput = true; // Sentinel value
    
    do {
      System.out.print("Enter score? (Y/N): ");
      String i = INPUT.next();
      
      if (i.toLowerCase().equals("n")) {
        continueInput = false;
      }
      else if (i.toLowerCase().equals("y")) {
        double score = getScore();
        scores.add(score);
        continue;
      }
      else {
        System.out.println("Try again. (Invalid input: Y or N required.)");
        INPUT.nextLine(); // Discard current input
        continue;
      }        
      
    } while (continueInput);
    
    return scores;
  }

  /**
   * Takes array list and set scores array from elements
   * @param testScores ArrayList<Double> of test scores
   */
  private void setScores(ArrayList<Double> testScores) {
    this.scores = new double[testScores.size()];
    int index = 0;
    for (double test: testScores) {
      this.scores[index] = test;
      index++;
    }
  }
  
  /**
   * Format output for displaying all test scores
   * @return String representing test scores
   */
  private String displayScores() {
    String output = "";
    int index = 1;
    for (double score: scores) {
      output = output + "\nTest score #" + index + ": " + score;
      index++;
    }
    return output;
  }
  
  /**
   * Return averageScore
   * @return Positive double
   */
  public double getAverageScore() {
    return averageScore;
  }
  
  /**
   * Check averageScore and return grade
   * @return String of grade letter
   */
  private String getGrade() {
    if (averageScore >= 93)
      return "A";
    else if (averageScore >= 90)
      return "A-";
    else if (averageScore >= 87)
      return "B+";
    else if (averageScore >= 83)
      return "B";
    else if (averageScore >= 80)
      return "B-";
    else if (averageScore >= 77)
      return "C+";
    else if (averageScore >= 70)
      return "C";
    else if (averageScore >= 60)
      return "D";
    else
      return "F";
  }
  
  /**
   * Override Object toString() method, outputs test scores on new lines,
   * displays average score and grade
   */
  @Override
  public String toString() {
    return displayScores() +
        String.format("\n\nAverage score: %.2f%%", getAverageScore()) +
        String.format("\nGrade: %s\n", getGrade());
  }
}