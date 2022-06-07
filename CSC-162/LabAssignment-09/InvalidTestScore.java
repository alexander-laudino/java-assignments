/**
 * <h1>TestScores Custom Exception Class</h1>
 * <p> This class creates a custom exception to be thrown
 * in the TestScoresWithException class if any test scores
 * in the array are invalid.</p>
 * <p>Dr.Farrett - CSC-162-IN1 - Lab Assignment 9</p>
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-11-15
 */
@SuppressWarnings("serial")

public class InvalidTestScore extends Exception {
  /** Invalid score */
  private double score;
  
  /** 
   * Construct an exception
   * @param index Integer of number of test score entered
   * @param score Double test score
   */
  public InvalidTestScore(int index, double score) {
    super("Invalid score! Test #" + index + ": " + score +
        "\nScore cannot be greater than 100 or negative\n");
    this.score = score;
  }
  
  /** Return the score */
  public double getScore() {
    return score;
  } 
}