/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Feb. 15, 2021
 * Lab Assignment 3 - Word Game
 * 
 * This program prompts the user to enter several string variables,
 * and then displays the user input data inserted into a text story. 
 */

// Step 1. Import Dialog Box methods
import javax.swing.JOptionPane;

public class WordGame {
  
  public static void main(String[] args) {
        
  // Step 2. Prompt the user to enter name
    String name = JOptionPane.showInputDialog("Enter name: ");
        
  // Step 3. Prompt the user to enter age
    String age = JOptionPane.showInputDialog("Enter age: ");
    
  // Step 4. Prompt the user to enter city
    String city = JOptionPane.showInputDialog("Enter city: ");
    
  // Step 5. Prompt the user to enter college
    String college = JOptionPane.showInputDialog("Enter college: ");
        
  // Step 6. Prompt the user to enter profession
    String profession = JOptionPane.showInputDialog("Enter profession: ");
        
  // Step 7. Prompt the user to enter a type of pet animal
    String animal = JOptionPane.showInputDialog("Enter a type of pet animal: ");
        
  // Step 8. Prompt the user to enter the pet’s name
    String petName = JOptionPane.showInputDialog("Enter pet's name: ");
        
  // Step 9. Display user entered data inserted into various strings
    System.out.println("It was a snowy day as " + name + " looked out the window of their home in " + 
        city + ".");
    
    System.out.println("At the age of " + age + ", they wondered where the time went" +
        " and how they ended up at " + college + ".");
    
    System.out.println("They thought to themself, 'Am I crazy to pursue my dream of becoming a " +
        profession + "?'");
    
    System.out.println("Looking over to their " + animal.toLowerCase() + " " + petName +
        " as it lay on the bed, " + name + " began to imagine life as a " + animal.toLowerCase() + ".");
    
    System.out.println("Compared to being a " + profession.toLowerCase() + ", a " + animal.toLowerCase() +
        "'s life sounds a lot more relaxing.");
    
    System.out.println("But as much fun as it sounded to them, " + name + " knew it could never be, "+
        "yet they knew they had made the right decision.");
    
    System.out.println("Besides, life in " + city + " wasn't that bad, and attending " + college + 
        " was the smart move as it allowed them to save money.");
    
    System.out.println("As the day began to wane, " + name + " began to drift off to sleep.\n");
  }
}

/* It was a snowy day as Alexander looked out the window of their home in Piscataway.
 * At the age of 33, they wondered where the time went and how they ended up at Middlesex County College.
 * They thought to themself, 'Am I crazy to pursue my dream of becoming a Software Engineer?'
 * Looking over to their dog Bubba as it lay on the bed, Alexander began to imagine life as a dog.
 * Compared to being a software engineer, a dog's life sounds a lot more relaxing.
 * But as much fun as it sounded to them, Alexander knew it could never be, yet they knew they had made the right decision.
 * Besides, life in Piscataway wasn't that bad, and attending Middlesex County College was the smart move as it allowed them to save money.
 * As the day began to wane, Alexander began to drift off to sleep.
 */