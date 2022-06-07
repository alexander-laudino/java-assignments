/**
 * <h1>PhoneBookEntry Class</h1>
 * This program creates an ArrayList of PhoneBookEntry objects and
 * displays the contents of each object.
 * 
 * @author Alexander Laudino
 * for CSC 162-IN1
 * Dr. Farrett
 * @since 2021-09-20
 * @version 1.0
 */

import java.util.*;

public class DemoPhoneBookEntry {
  
  // Main method 
  public static void main(String[] args) {
    
    // Create ArrayList of PhoneBookEntry objects
    ArrayList<PhoneBookEntry> contacts = new ArrayList<PhoneBookEntry>();
    
    // Create Scanner object
    Scanner input = new Scanner(System.in);
  
    // For user input 
    int num = 0;
    
    // To break out of do-while loop
    boolean continueInput = true;
    
    // Loop to prompt user for data input method
    do {
      
      // User input validation
      try {
        
        System.out.print("To automatically add data, press 1. To manually add data, press 2: ");
        num = input.nextInt();
        
        // Correct input breaks out of loop
        if (num == 1 || num == 2) {
          continueInput = false;
          input.nextLine();
        }
        
        // Incorrect int input continues loop
        else {
          System.out.println("Try again. (Incorret input: 1 or 2 is required.)");
          continue;
        }
      }
      
      // Catch incorrect data type exception, clear Scanner cache, and continue loop
      catch (InputMismatchException e) {
        System.out.println("Try again. (Incorrect input: an integer is required.)");
        input.nextLine();
      }
    } while (continueInput); // End data input method loop
    
    // Create new PhoneBookEntry objects and add to ArrayList
    // Data input automatically
    if (num == 1) {
      contacts.add( new PhoneBookEntry("Alexander", "Laudino", "267-043-8607") );
      contacts.add( new PhoneBookEntry("Claudio", "Sanchez", "919-851-9517") );
      contacts.add( new PhoneBookEntry("Ludwig", "von Mises", "531-943-3641") );
      contacts.add( new PhoneBookEntry("Carroll", "Quigley", "808-915-0291") );
      contacts.add( new PhoneBookEntry("Elong", "Muskrat", "215-703-9701") );
      contacts.add( new PhoneBookEntry("Alan", "Turing", "457-641-3005") );
      contacts.add( new PhoneBookEntry("John", "von Neumann", "709-403-2105") );
      contacts.add( new PhoneBookEntry("Isaac", "Asimov", "908-258-8507") );
    }
    // Data input manually
    else if (num == 2) {
      
      // Variables to hold user input
      String fName = "";
      String lName = "";
      String pNum = "";
      
      // Counter for objects added to ArrayList
      int i = 0;
      
      // To break out of data input loop
      boolean contInput = true;
      
      // Data input loop
      do {
        
        System.out.print("Enter first name: ");
        fName = input.next();
        
        System.out.print("Enter last name: ");
        lName = input.next();
        
        System.out.print("Enter phone number (including dashes '-'): ");
        pNum = input.next();
        
        // Create new PhoneBookEntry object and add it to ArrayList
        contacts.add( new PhoneBookEntry(fName, lName, pNum) );
        
        // Increment object counter
        i = i + 1;
        
        // Must add minimum of 5 objects
        if (i < 5) {
          continue;
        }
        
        // If user wants to add more PhoneBookEntry objects
        else {
          
          // User input validation
          try {
            
            System.out.print("To add another entry, press 1. To quit, press 0: ");
            int n = input.nextInt();
            
            // To break out of loop
            if (n == 0) {
              contInput = false;
            }
                        
          }
          
          // Invalid data type input, clears Scanner cache, continues loop
          catch (InputMismatchException e) {
            System.out.println("Try again. (Incorrect input: an integer is required.)");
            input.nextLine();
          }
        }
            
      } while (contInput); // End of data input loop
      
    }
        
    // Call displayPhoneBook method with ArrayList as parameter to display
    // contents of each object
    displayPhoneBook(contacts);    
    
    input.close();
    System.exit(0);
  }
  
  /**
   * The displayPhoneBook method takes an ArrayList and loops through the elements
   * to display the contents of each object  
   * @param contacts ArrayList of PhoneBookEntry objects
   */
  public static void displayPhoneBook(ArrayList<PhoneBookEntry> contacts) {
    
    System.out.printf("\n%1$-15s%2$-15s%3$-15s\n", "First Name", "Last Name", "Phone Number");
  
    // Loop through ArrayList using accessor methods to get contents of object variable
    for (PhoneBookEntry contact : contacts) {
      System.out.printf("\n%1$-15s%2$-15s%3$-15s", contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
    }
    
  }

}


/**

Case 1:

To automatically add data, press 1. To manually add data, press 2: 1

First Name     Last Name      Phone Number   

Alexander      Laudino        267-043-8607   
Claudio        Sanchez        919-851-9517   
Ludwig         von Mises      531-943-3641   
Carroll        Quigley        808-915-0291   
Elong          Muskrat        215-703-9701   
Alan           Turing         457-641-3005   
John           von Neumann    709-403-2105   
Isaac          Asimov         908-258-8507   


Case 2:

To automatically add data, press 1. To manually add data, press 2: 2
Enter first name: Alex
Enter last name: Laud
Enter phone number (including dashes '-'): 908-654-8795
Enter first name: John
Enter last name: Dunne
Enter phone number (including dashes '-'): 732-561-0098
Enter first name: Bill
Enter last name: Bradley
Enter phone number (including dashes '-'): 808-959-7812
Enter first name: Susie
Enter last name: Lopez
Enter phone number (including dashes '-'): 745-987-1354
Enter first name: Tom
Enter last name: Thomasson
Enter phone number (including dashes '-'): 879-985-6520
To add another entry, press 1. To quit, press 0: 0

First Name     Last Name      Phone Number   

Alex           Laud           908-654-8795   
John           Dunne          732-561-0098   
Bill           Bradley        808-959-7812   
Susie          Lopez          745-987-1354   
Tom            Thomasson      879-985-6520


Case 3:

To automatically add data, press 1. To manually add data, press 2: 2
Enter first name: Jim
Enter last name: Bo
Enter phone number (including dashes '-'): 789-951-8745
Enter first name: Michael
Enter last name: Jackman
Enter phone number (including dashes '-'): 212-569-7812
Enter first name: ZZ
Enter last name: Top
Enter phone number (including dashes '-'): 808-974-6810
Enter first name: Nilly 
Enter last name: Goel
Enter phone number (including dashes '-'): 908-515-2101
Enter first name: Arnold
Enter last name: Schwartz
Enter phone number (including dashes '-'): 515-298-4021
To add another entry, press 1. To quit, press 0: 1
Enter first name: Harry
Enter last name: Pottser
Enter phone number (including dashes '-'): 815-601-9874
To add another entry, press 1. To quit, press 0: 1
Enter first name: Peter
Enter last name: Parker
Enter phone number (including dashes '-'): 999-999-8888
To add another entry, press 1. To quit, press 0: 0

First Name     Last Name      Phone Number   

Jim            Bo             789-951-8745   
Michael        Jackman        212-569-7812   
ZZ             Top            808-974-6810   
Nilly          Goel           908-515-2101   
Arnold         Schwartz       515-298-4021   
Harry          Pottser        815-601-9874   
Peter          Parker         999-999-8888

*/
