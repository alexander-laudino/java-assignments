/**
 * These are the variables, constructors, and methods that the program  
 * depends on to create new Employee objects, take user input, verify
 * data, opening, writing, and reading a file, handling exceptions, and
 * mutating and accessing the objects attribute fields. 
 * 
 * Alexander Laudino
 * CSC 161-04
 * Dr. Farrett
 * Lab Assignment 10 - Employee Class
 */

import java.util.*;
import java.io.*;

public class Employee {
  
  // ----- VARIABLES -----

  /**
   * Create new Scanner object for user input, used in the following methods:
   * setInput()
   * inputData()
   * confirmData()
   * getFileName()
   * openFile()
   * readFile()
   */
  public static final Scanner input = new Scanner(System.in);
  /**
   * If true, data is automatically set for Employee objects, if false, user must
   * manually enter data
   */
  private static boolean autoAddData = true;
  /**
   * Employee database file name
   */
  private static String fileName;
  /**
   * Employee Name
   */
  private String name;
  /**
   * Employee ID Number
   */
  private int idNumber;
  /**
   * Employee Department
   */
  private String department;
  /**
   * Employee Position
   */
  private String position;
  
  // ----- CONSTRUCTORS -----
  
  /**
   * Creates new Employee object and sets all data fields
   * @param name Employee Name
   * @param idNum Employee ID Number
   * @param dept Employee Department
   * @param pos Employee Position
   */
  Employee(String name, int idNum, String dept, String pos) {
    this.name = name;
    this.idNumber = idNum;
    this.department = dept;
    this.position = pos;
  }
  
  /**
   * Creates new Employee object, sets name and idNumber data fields,
   * department and position fields assigned as empty strings
   * @param name Employee Name
   * @param idNum Employee ID Number
   */
  Employee(String name, int idNum) {
    this.name = name;
    this.idNumber = idNum;
    this.department = "";
    this.position = "";
  }
  
  /**
   * Creates new Employee object, name, department, and position assigned as 
   * empty strings, idNumber field assigned as 0
   */
  Employee() {
    this.name = "";
    this.idNumber = 0;
    this.department = "";
    this.position = "";
  }
  
  // ----- METHODS -----
  
  /**
   * The setInput method prompts the user to either have the data entered
   * automatically or have them enter it in manually, if user selects manually,
   * autoAddData is set to false
   */
  public static void setInput() {
    
    // Variable used to hold user input
    int num = 0;
    // For ending user input in do-while loop
    boolean continueInput = true;
    
    // Do-while loop for user input validation    
    do {
      
      try {
        
        // Prompt user for input
        System.out.print("To input data automatically, enter 1. To input data manually, enter 2: ");
        num = input.nextInt();
        
        // User entered valid input, break out of loop
        if (num == 1 || num == 2) {
          continueInput = false;
        }
        
        else {
          System.out.println("Try again. (Incorrect input: 1 or 2 is required.)");
          continue;
        }
      }
      // Catch any erroneous inputs
      catch (InputMismatchException e) {
        System.out.println("Try again. (Incorrect input: an integer is required)");
        input.nextLine();
      }
      
    } while (continueInput);
    
    // Set autoAddData to false for manual entry of data
    if (num == 2) {
      autoAddData = false;
    }
    
    input.nextLine(); // Discard input
        
  }
  
  /**
   * Returns true if data is automatically added, false if user is manually
   * entering data
   * @return Boolean value for autoAddData
   */
  public static boolean getInput() {
    return autoAddData;
  }
  
  /**
   * The inputData method prompts the user to enter the employee data manually, then
   * creates a new Employee object and adds it to the ArrayList of Employee objects
   * @param employees ArrayList of Employee objects
   */
  public static void inputData(ArrayList<Employee> employees) {
    
    // For ending user input in do-while loop
    boolean continueInput = true;
    // Counter for number of employees added
    int numOfNewEmp = 0;
    
    // Do-while loop for adding new employee
    do {
      
      // Prompt user for input
      System.out.print("\nAdd new employee? (Y/N): ");
      String newEmp = input.nextLine();
      
      // (1) Add new employee
      if (newEmp.toLowerCase().equals("y")) {
        
        System.out.print("\nEnter employee name: ");
        String name = input.nextLine();
        
        System.out.print("Enter employee ID Number: ");
        int idNum = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter employee department: ");
        String dept = input.nextLine();
        
        System.out.print("Enter employee position: ");
        String pos = input.nextLine();
        
        // Create new Employee object and add to ArrayList
        employees.add( new Employee(name, idNum, dept, pos));
        
        numOfNewEmp++;
      }
      
      // (1) Do not add new employee and employees have been added 
      else if (newEmp.toLowerCase().equals("n") && numOfNewEmp > 0) {
        System.out.println("\nNumber of employees to add: " + numOfNewEmp);
        System.out.println("\nPreparing to write data to file.");
        continueInput = false;
      }
      
      // (1) Do not add new employee and no employees have been added
      else if (newEmp.toLowerCase().equals("n") && numOfNewEmp == 0) {

        // Prompt user for input
        System.out.print("\nContinue without adding any employees? (Y/N): ");
        String noEmp = input.nextLine();
        
        // (2) Continue without adding any employees
        if (noEmp.toLowerCase().equals("y")) {
          continueInput = false;
        }
        
        // (2) Continue loop to add new employee
        else if (noEmp.toLowerCase().equals("n")) {
          continue;
        }
        // (2)
        else {
          System.out.println("Try again. (Incorrect input: Please enter Y or N)");
        }
      }
      // (1)
      else {
        System.out.println("Try again. (Incorrect input: Please enter Y or N)");
        continue;
      }   
      
    } while (continueInput);
    
  }
  
  /**
   * The confirmData method takes an ArrayList of Employee objects and displays
   * the objects attributes, then it prompts the user to confirm writing the data to
   * the file. If the data is to be written, the method returns true. 
   * @param employees ArrayList of Employee objects
   * @return Boolean value, true if data is confirmed
   */
  public static boolean confirmData(ArrayList<Employee> employees) {
    
    System.out.println("\nPlease confirm data entered is correct.");
    System.out.printf("\n%1$-20s%2$-20s%3$-20s%4$-20s\n", "Name", "ID Number", "Department", "Position");
    
    for (int i = 0; i < 80; i++) {
      System.out.print("-");
    }

    System.out.println();
    
    // Loop through ArrayList and print out data attributes
    for (Employee em : employees) {
      System.out.printf("%1$-20s%2$-20s%3$-20s%4$-20s\n", em.getName(), Integer.toString(em.getIDNumber()), 
          em.getDepartment(), em.getPosition());
    }
    
    System.out.println();
    
    // Variables for user input validation
    String confirmWrite = "null";
    boolean continueInput = true;
    
    // Do-while loop for writing data to file
    do {
      
      // Prompt user 
      System.out.print("Write data to file? (Y/N): ");
      confirmWrite = input.next();
    
      if (confirmWrite.toLowerCase().equals("y") || confirmWrite.toLowerCase().equals("n")) {
        continueInput = false;
      }
      
      else {
        System.out.println("Try again. (Incorrect input: Enter Y or N)");
      }
      
    } while (continueInput);
    
    input.nextLine(); // Discard input
    
    // Data validated
    if (confirmWrite.toLowerCase().equals("y")) {
      return true;
    }
    // Data not validated
    else {
      return false;
    }
    
  }
  
  /**
   * The getFileName method prompts the user to enter a file name, then calls
   * the setFile method to assign the value to the fileName variable
   */
  public static void getFileName() {
    
    System.out.print("\nEnter name of text file to store data: ");
    String file = input.nextLine();
    
    setFile(file);
  }  

  /**
   * Sets the fileName variable
   * @param file String value of file name
   */
  private static void setFile(String file) {
    fileName = file;
  }
  
  /**
   * Returns fileName value
   * @return String of file name
   */
  private static String getFile() {
    return fileName;
  }
  
  /**
   * The openFile method calls the getFile method, creates a new file object by 
   * calling getFile method to return file name. 
   * 
   * If the file already exists the method asks if the file should be overwritten,
   * if yes, the file is overwritten, if no, the method recursively calls itself to
   * get a new file name.
   * 
   * If the file does not exist, the file is created
   * @throws IOException If error opening file
   */
  public static void openFile() throws IOException {
    
    // Gets input from user and sets fileName attribute
    getFileName();
    
    // Create new File object
    File file = new File(getFile());
    
    // Checks if file already exists
    if (file.exists()) {
      System.out.print("File already exists. Do you want to overwrite the existing file? (Y/N): ");
      String overwrite = input.nextLine();
      
      // Overwrites existing file
      if (overwrite.toLowerCase().equals("y")) {
        file.createNewFile();
        System.out.println("\nOverwriting file: " + file.getName());
      }
      
      // Recursively calls self to get new file name
      else {
        openFile();
      }
    }
    
    // Creates new file if file doesn't exist
    else if (file.createNewFile()) {
      System.out.println("File created: " + file.getName());
    }
  }  

  /**
   * The writeToFile method loops through the ArrayList of Employee objects and
   * writes their attributes to the file formatted as a table
   * @param employees ArrayList of Employee objects
   * @throws IOException If error writing to file
   */
  public static void writeToFile (ArrayList<Employee> employees) throws IOException {
    
    System.out.println("\nWriting data to file.");
    
    // Creates new PrintWriter object
    PrintWriter writer = new PrintWriter(getFile());
    
    // Print table heading
    writer.format("\n%1$-20s%2$-20s%3$-20s%4$-20s\n", "Name", "ID Number", "Department", "Position");
    writer.flush();
    
    // Print heading divider
    for (int i = 0; i < 80; i++) {
      writer.write("-");
    }
    
    writer.flush();
    writer.write("\n");
    
    // Loops through elements of ArrayList objects to create table with employee data
    for (Employee em : employees) {
      writer.format("%1$-20s%2$-20s%3$-20s%4$-20s\n", em.getName(), Integer.toString(em.getIDNumber()), 
          em.getDepartment(), em.getPosition());
      writer.flush();
    }
    
    writer.close();
    
  }  
  
  /**
   * The readFile method prompts the user to verify the data written to the file,
   * if yes, the data is read as input and displayed to the screen
   * @throws Exception If error reading file
   */
  public static void readFile() throws Exception {
    
    // For ending user input
    boolean continueInput = true;
    
    // Prompt user to verify data
    do {
      System.out.print("\nVerify data written to file? (Y/N): ");
      String dataVerification = input.next();
      
      // Verify data
      if (dataVerification.toLowerCase().equals("y")) {
        
        System.out.println("\nReading data from file.");
        
        // Create new FileReader object
        FileReader reader = new FileReader(getFile());
        
        // Create char array to hold input
        char[] a = new char[1000];
        reader.read(a);
        
        // Display results
        for (char c : a) {
          System.out.print(c);
        }
        
        reader.close();
        continueInput = false;
      }
      
      else if (dataVerification.toLowerCase().equals("n")) {
        System.out.println("Data not verified.");
        continueInput = false;
      }
      
      else {
        System.out.println("Try again. (Incorrect input: Enter Y or N");
      }
      
    } while (continueInput);
  }
 
  /**
   * Sets employee name
   * @param name Employee's name
   */
  private void setName(String name) {
    this.name = name;
  }
  
  /**
   * Gets employee name
   * @return Employee's name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets employee ID Number
   * @param idNum Employee's ID Number
   */
  private void setIDNumber(int idNum) {
    this.idNumber = idNum;
  }
  
  /**
   * Gets employee ID Number
   * @return Employee's ID Number
   */
  public int getIDNumber() {
    return idNumber;
  }
  
  /**
   * Sets employee department
   * @param dept Employee's Department
   */
  private void setDepartment(String dept) {
    this.department = dept;
  }
  
  /**
   * Gets employee department
   * @return Employee's department
   */
  public String getDepartment() {
    return department;
  }
  
  /**
   * Sets employee position
   * @param pos Employee's Position
   */
  private void setPosition(String pos) {
    this.position = pos;
  }
  
  /**
   * Gets employee position
   * @return Employee's Position
   */
  public String getPosition() {
    return position;
  }
  
}