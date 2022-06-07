import java.util.Scanner;

/**
 * The variables, constructors, and methods that the program depends on to 
 * get user input and determine whether a String argument is a palindrome.
 * The method uses recursion to check the String and returns true if the 
 * argument reads the same forward and backward.
 * @author Alexander Laudino
 *
 */
public class PalindromeDetector {
  
  // ----- VARIABLES -----
  
  /**
   * String of word, phrase, or sentence
   */
  private String s;
  
  /**
   * Array of word, phrase, or sentence
   * containing only letters and digits 
   */
  private char[] c;
  
  // ----- CONSTRUCTORS -----
  
  /**
   * This constructs the variables that are used as input for the 
   * isPalindrome method 
   */
  public PalindromeDetector() {
    this.s = setInput();
    this.c = normalizeInput(s);
  }
  
  // ----- METHODS -----
  
  /**
   * Prompts user for input
   * @return String of word, phrase, or sentence
   */
  private static String setInput() {
    
    // Create Scanner object
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a word or phrase: ");
    String s = input.nextLine();
    
    input.close();
    
    return s;
  }
  
  /**
   * Takes a string and removes all characters except
   * letters and digits, changes all characters to lowercase,
   * and adds them to a char[] array
   * @param s String of word, phrase, or sentence
   * @return Array of characters
   */
  private static char[] normalizeInput(String s) {
    
    // Temporary array to store characters in string
    char[] temp = new char[s.length()];
    
    // Counter for number of characters added to array
    int charCount = 0;
    
    // Loop through string, if character is a letter
    // or a digit, change to lowercase and add to temp array
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        temp[charCount] = Character.toLowerCase(s.charAt(i));
        charCount++; // Increment counter
      }
    }
    
    // Create new array with no empty elements
    char[] c = new char[charCount];
    
    // Copy elements from temp array to character array
    for (int j = 0; j < charCount; j++) {
      c[j] = temp[j];
    }
    
    return c;
  }
  
  /**
   * Get user input word, phrase, or sentence
   * @return String of user input 
   */
  public String getInput() {
    return s;
  }
  
  /**
   * Method to be called from test program 
   * @return True if input is palindrome
   */
  public boolean isPalindrome() {
    return isPalindrome(c);
  }
  
  /**
   * Checks whether an array of characters is a palindrome
   * @param c Array of characters
   * @return True if input is palindrome
   */
  private static boolean isPalindrome(char[] c) {
    return isPalindrome(c, 0, c.length - 1);
  }
  
  /**
   * Helper method to check whether a subarray is a palindrome
   * @param c Array of characters 
   * @param low Low index of array 
   * @param high High index of array
   * @return True if input is palindrome
   */
  private static boolean isPalindrome(char[] c, int low, int high) {
    if (high <= low) // Base case
      return true;
    else if (c[low] != c[high]) // Base case
      return false;
    else
      return isPalindrome(c, low + 1, high - 1); // Call method recursively with smaller subarray
  }
}