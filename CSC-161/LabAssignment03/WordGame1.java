/* Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Feb. 8, 2021
 * Lab Assignment 3 - Word Game
 */ 
/** TODO - Enter program description
 */

// Step 1. Import Dialog Box methods
import javax.swing.JOptionPane;
import java.util.HashMap;

public class WordGame1 {
  
  public static void main(String[] args) {
        
  // Prompt the user to enter name
    String name = JOptionPane.showInputDialog("Enter name: ");
        
  // Prompt the user to enter age
    String age = JOptionPane.showInputDialog("Enter age: ");
    
  // Prompt the user to enter city
    String city = JOptionPane.showInputDialog("Enter city: ");
    
  // Prompt the user to enter college
    String college = JOptionPane.showInputDialog("Enter college: ");
        
  // Prompt the user to enter profession
    String profession = JOptionPane.showInputDialog("Enter profession: ");
        
  // Prompt the user to enter a type of animal
    String animal = JOptionPane.showInputDialog("Enter a type of pet animal: ");
        
  // Prompt the user to enter the pet’s name
    String petName = JOptionPane.showInputDialog("Enter pet's name: ");
        
  // Display user entered data inserted into various strings
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
    
  // Just for fun
    while (true) {
      String dream = JOptionPane.showInputDialog("Enter " + name + "'s dream? (Y/N) ");
         
      if (dream.toLowerCase().equals("y") || dream.toLowerCase().equals("yes")) {
        dreamState(name); 
        break; 
      }
      else if (dream.toLowerCase().equals("n") || dream.toLowerCase().equals("no")) {
        JOptionPane.showMessageDialog(null, "Snap back to reality!");
        break; 
      }
      else {
        JOptionPane.showMessageDialog(null, "Twas only a dream...but your input was invalid.");
        continue; 
      }
    }
  }
 
  // Dream state method
  private static void dreamState(String name) {
    System.out.println("***Entered " + name + "'s dream state***\n");
    
    // Dream state genre selection
    while (true) {
      String selectDream = JOptionPane.showInputDialog("Choose one: Fantasy, Historical, or Sci-Fi");
      
      if (selectDream.toLowerCase().equals("fantasy") || selectDream.toLowerCase().equals("historical") || 
          selectDream.toLowerCase().equals("sci-fi")) {
        
        switch (selectDream.toLowerCase()) {
          case "fantasy":    Fantasy fantasyStory = new Fantasy();
                             fantasyStory.fantasy(name); 
                             break;
          case "historical": Historical historyStory = new Historical(); 
                             historyStory.historical(name);
                             break;
          case "sci-fi":     SciFi sciFiStory = new SciFi();
                             sciFiStory.sciFi(name);
                             break;
        }
        
        JOptionPane.showMessageDialog(null, "End of adventure.");
        break; 
      }
      else {
        
        JOptionPane.showMessageDialog(null, "Please enter valid input.");
        continue; 
      }
    }
    
    JOptionPane.showMessageDialog(null, "Time to wake up!");
  }  
}