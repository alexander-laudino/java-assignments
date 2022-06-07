/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Jan. 28, 2021
 * Lab Assignment 1 - Land Calculation
 *
 * This program calculates the number of acres
 * in a tract of land with 389,767 square feet. */

public class LandCalculation {
    
  // Main method
  public static void main(String[] args) {
    float acre = 43560; // Square feet per acre
    float landTract = 389767; // Square feet in land tract
    
    // Compute acres of land tract
    float landTractAcres = landTract / acre;
    
    // Display output
    System.out.println("A tract of land that is " +
      landTract + " square feet is " + landTractAcres +
      " acres.");
  }
}

/* Output from console 
 * A tract of land that is 389767.0 square feet is 8.947819 acres. */