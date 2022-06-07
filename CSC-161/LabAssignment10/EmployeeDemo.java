/**
 * <h1>Employee Class</h1>
 * This program creates three Employee objects to hold the following data: 
 * 
 * Name           ID Number      Department     Position
 * Susan Meyer    47899          Accounting     Vice President
 * Mark Jones     39119          IT             Programmer
 * Joy Rogers     81774          Manufacturing  Engineer
 * 
 * The program prompts the user to validate the data prior to writing it to
 * a file and then asks the user to confirm the data is correct by reading
 * the data from the file and displaying the results to the screen.
 * 
 * @author Alexander Laudino
 * for CSC 161-04
 * Dr. Farrett
 * Lab Assignment 10
 * @since 2021-04-26
 * @version 1.0 
 */

import java.io.*;
import java.util.ArrayList;

public class EmployeeDemo {

  public static void main(String[] args) {
    
    // Create ArrayList of Employee objects
    ArrayList<Employee> employees = new ArrayList<Employee>();
    
    // Call setInput to prompt user to have data added automatically or enter
    // the data manually
    Employee.setInput();
    
    // Automatically add data
    if (Employee.getInput()) {
      employees.add( new Employee("Susan Meyer", 47899, "Accounting", "Vice President") );
      employees.add( new Employee("Mark Jones", 39119, "IT", "Programmer") );
      employees.add( new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer") );
      System.out.println("\nNumber of employees to add: " + employees.size());
      System.out.println("\nPreparing to write data to file.");
    }
    // Manually add data
    else {
      Employee.inputData(employees);
    }
    
    // If ArrayList contains elements
    if (employees.size() > 0) {
      
      // Sentinel value to end do-while loop
      boolean dataNotValidated = true;
      
      // Data validation
      do {
        
        if (employees.size() > 0) {
          boolean dataValidation = Employee.confirmData(employees);
          
          // Data is validated
          if (dataValidation == true) {
            dataNotValidated = false;
            System.out.println("\nData validated.");
          }
          
          // Data not validated, prompt user to re-enter data
          else {
            employees.clear();
            System.out.println("\nPlease re-enter data.");
            Employee.inputData(employees);
          }
        }
        
        // No data entered after first loop, program exits successfully
        else {
          System.out.println("No employees to be added.");
          Employee.input.close();
          System.exit(0);
        }
              
      } while (dataNotValidated);
      
      // Open file
      try {
        Employee.openFile();
        System.out.println("\nFile opened.");
      }
      catch (IOException e) {
        System.out.println("An error occured while trying to open the file.");
      }
          
      // Write to file
      try {
        Employee.writeToFile(employees);
        System.out.println("\nData written to file.");
      }
      catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
      }
      
      // Read file    
      try {
        Employee.readFile();
        System.out.println("\nData verified.");
      }
      catch (Exception e) {
        System.out.println("An error occurred while reading the file.");
      }
      finally {
        System.out.println("\nEmployees added to database.");
        Employee.input.close();
        System.exit(0); // Program exits successfully
      }
    }
    
    // If ArrayList contains no elements
    else {
      System.out.println("\nNo employees added to database.");
      Employee.input.close();
      System.exit(0); // Program exits successfully
    }
      
  }

}

/*
 * Console output
 * 
To input data automatically, enter 1. To input data manually, enter 2: 1

Number of employees to add: 3

Preparing to write data to file.

Please confirm data entered is correct.

Name                ID Number           Department          Position            
--------------------------------------------------------------------------------
Susan Meyer         47899               Accounting          Vice President      
Mark Jones          39119               IT                  Programmer          
Joy Rogers          81774               Manufacturing       Engineer            

Write data to file? (Y/N): N

Please re-enter data.

Add new employee? (Y/N): Y

Enter employee name: Susan Meyer
Enter employee ID Number: 47899
Enter employee department: Accounting
Enter employee position: Vice President

Add new employee? (Y/N): Y

Enter employee name: Mark Jones
Enter employee ID Number: 39119
Enter employee department: IT
Enter employee position: Programmer

Add new employee? (Y/N): Y

Enter employee name: Joy Rogers
Enter employee ID Number: 81774
Enter employee department: Manufacturing
Enter employee position: Engineer

Add new employee? (Y/N): N

Number of employees to add: 3

Preparing to write data to file.

Please confirm data entered is correct.

Name                ID Number           Department          Position            
--------------------------------------------------------------------------------
Susan Meyer         47899               Accounting          Vice President      
Mark Jones          39119               IT                  Programmer          
Joy Rogers          81774               Manufacturing       Engineer            

Write data to file? (Y/N): Y

Data validated.

Enter name of text file to store data: employeeDB.txt
File created: employeeDB.txt

File opened.

Writing data to file.

Data written to file.

Verify data written to file? (Y/N): Y

Reading data from file.

Name                ID Number           Department          Position            
--------------------------------------------------------------------------------
Susan Meyer         47899               Accounting          Vice President      
Mark Jones          39119               IT                  Programmer          
Joy Rogers          81774               Manufacturing       Engineer            
*/
