/**
 * This program demonstrates Ackermann's function, which is a recursive
 * mathematical algorithm that can be used to test how well a computer
 * performs recursion. The program displays the return values from a list of
 * non-negative integers.
 * @author Alexander Laudino for Dr. Farrett - CSC-162-IN1 
 * @since 2021-10-03
 * @version 1.0
 * Lab Assignment 4 - Ackermann Function
 *
 */
public class DemoAckermannFunction {

  public static void main(String[] args) {
    
    int[][] list = {{0, 0}, 
                    {0, 1},
                    {1, 1},
                    {1, 2},
                    {1, 3},
                    {2, 2},
                    {3, 2}
    };
    
    AckermannFunction demo = new AckermannFunction();
    
    demo.printAckermann(list);
    
  }
}

/*
Ackermann function value for (0, 0): 1
Ackermann function value for (0, 1): 2
Ackermann function value for (1, 1): 3
Ackermann function value for (1, 2): 4
Ackermann function value for (1, 3): 5
Ackermann function value for (2, 2): 7
Ackermann function value for (3, 2): 29
 */