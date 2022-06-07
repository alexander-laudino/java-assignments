/**
 * The methods for solving Ackermann's function and displaying the return
 * values of Ackermann's function from a list of non-negative integers
 * @author Alexander Laudino
 *
 */
public class AckermannFunction {
  
  /**
   * Takes two non-negative integers and returns the Ackermann function value
   * @param m non-negative integer
   * @param n non-negative integer
   * @return non-negative integer
   */
  private static int ackermann(int m, int n) {
    if (m == 0) 
      return n + 1; // Base case
    else if (m > 0 && n == 0)
      return ackermann(m - 1, 1);
    else if (m > 0 && n > 0)
      return ackermann(m - 1, ackermann(m, n - 1));
    else
      return n + 1;
  }
  
  /**
   * Takes a list of non-negative integers and displays the Ackermann function value 
   * @param list 2D array of non-negative integers
   */
  public void printAckermann(int[][] list) {
    
    int c0 = 0; // Column 0
    int c1 = 1; // Column 1
    
    for (int row = 0; row < list.length; row++) {
      System.out.println("Ackermann function value for (" + 
          list[row][c0] + ", " + list[row][c1] + "): " + 
          ackermann(list[row][c0], list[row][c1]));
    }
  }
}