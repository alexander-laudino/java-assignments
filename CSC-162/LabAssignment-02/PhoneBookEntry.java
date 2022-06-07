/**
 * The PhoneBookEntry class contains the variables, constructors, and methods that
 * the program depends on to create new PhoneBookEntry objects and accessor and 
 * mutator methods for manipulating the object's attribute fields. 
 */

public class PhoneBookEntry {
  
  // ----- VARIABLES -----
    
  /**
   * Contact first name
   */
  private String firstName;
  
  /**
   * Contact last name
   */
  private String lastName;
  
  /**
   * Contact phone number
   */
  private String phoneNumber;
  
  // ----- CONSTRUCTORS -----
  
  /**
   * Creates new empty PhoneBookEntry object 
   */
  PhoneBookEntry() {
    this.firstName = "";
    this.lastName = "";
    this.phoneNumber = "";
  }
  
  /**
   * Creates new PhoneBookEntry object and sets all data fields
   * @param fName Contact first name
   * @param lName Contact last name
   * @param pNum Contact phone Number
   */
  PhoneBookEntry(String fName, String lName, String pNum) {
    this.firstName = fName;
    this.lastName =  lName;
    this.phoneNumber = pNum;
  }
  
  // ----- METHODS -----
  
  /**
   * Sets PhoneBookEntry first name 
   * @param fName Contact first name 
   */
  public void setFirstName(String fName) {
    this.firstName = fName;
  }
  
  /**
   * Gets PhoneBookEntry first name
   * @return Contact first name
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Sets PhoneBookEntry last name
   * @param lName Contact last name
   */
  public void setLastName(String lName) {
    this.lastName = lName;
  }
  
  /**
   * Gets PhoneBookEntry last name
   * @return Contact last name
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * Sets PhoneBookEntry phone number
   * @param pNum Contact phone number
   */
  public void setPhoneNumber(String pNum) {
    this.phoneNumber = pNum;
  }
  
  /**
   * Gets PhoneBookEntry phone number
   * @return Contact phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }
}
