import java.io.IOException;
/**
 * <h1>Demo TestScores Class with Custom Exception Using File I/O</h1>
 * <p>This program tests our Custom Exception class using File I/O,
 * the file to be read should contain an array of test scores, if any
 * of the test scores are invalid, the test score is skipped and the
 * file continues to be processes until EOF.</p>
 * 
 * <p>The data is then written to two separate files, one that stores only the scores
 * as double values, and the other that formats the output and includes the average
 * score and grade for the input scores.</p>
 * 
 * <p>Lab Assignment 10 - Dr. Farrett - CSC-162-IN1 - Fall 2021</p>
 * 
 * @author Alexander Laudino
 * @version 2.0
 * @since 2021-11-27
 *
 */
public class DemoTestScores {

  public static void main(String[] args) {
    
    try {
      TestScores test = new TestScores("scores.txt", "NewScores.txt", "TestScores.txt");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/*
 * OUTPUT from Console
 *
97.9
86.5
74.7
61.2
50.1
40.8
100.0
81.9
-8.0
InvalidTestScore: Invalid score! Test #9: -8.0
Score cannot be greater than 100 or negative

  at TestScores.isValidScore(TestScores.java:110)
  at TestScores.setAverageScore(TestScores.java:77)
  at TestScores.<init>(TestScores.java:58)
  at DemoTestScores.main(DemoTestScores.java:8)
74.1
96.23
109.5
InvalidTestScore: Invalid score! Test #11: 109.5
Score cannot be greater than 100 or negative

  at TestScores.isValidScore(TestScores.java:110)
  at TestScores.setAverageScore(TestScores.java:77)
  at TestScores.<init>(TestScores.java:58)
  at DemoTestScores.main(DemoTestScores.java:8)
87.45
91.02
-9.15
InvalidTestScore: Invalid score! Test #13: -9.15
Score cannot be greater than 100 or negative

  at TestScores.isValidScore(TestScores.java:110)
  at TestScores.setAverageScore(TestScores.java:77)
  at TestScores.<init>(TestScores.java:58)
  at DemoTestScores.main(DemoTestScores.java:8)
74.91
107.5
InvalidTestScore: Invalid score! Test #14: 107.5
Score cannot be greater than 100 or negative

  at TestScores.isValidScore(TestScores.java:110)
  at TestScores.setAverageScore(TestScores.java:77)
  at TestScores.<init>(TestScores.java:58)
  at DemoTestScores.main(DemoTestScores.java:8)
99.9

 */
