/**
 * This program checks if a user input word, phrase, or sentence 
 * is a palindrome, meaning it reads the same forward and backward.
 * @author Alexander Laudino for Dr. Farrett - CSC-162-IN1
 * @version 1.0
 * @since 2021-09-27
 * 
 */
public class TestPalindromeDetector {
  
  /**
   * Main Method
   * @param args Array of string arguments.
   */
  public static void main(String[] args) {
    
    // Create new PalindromeDetector object 
    PalindromeDetector test = new PalindromeDetector();
    
    // Set variable to return value of method 
    boolean c = test.isPalindrome();
    
    // Display result    
    System.out.println("Is " + test.getInput() + " a palindrome: " + c);

  }
}

/*
 * Test 1
   Enter a word or phrase: Able was I, ere I saw Elba
   Is Able was I, ere I saw Elba a palindrome: true
 * 
 * Test 2
   Enter a word or phrase: A man, a plan, a canal, Panama
   Is A man, a plan, a canal, Panama a palindrome: true
 *
 * Test 3
   Enter a word or phrase: palindrome
   Is palindrome a palindrome: false
 *
 * Test 4
   Enter a word or phrase: Aibohphobia
   Is Aibohphobia a palindrome: true  
 */