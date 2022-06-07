/**
 * The Customer class contains the variables, constructors, and methods
 * to create Customer objects
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-10-28
 */
public class Customer extends Person{
  
  // --------------- VARIABLES ---------------
  
  /** Total number of Customer objects created with data attributes */
  private static int totalCustomers;
  /** Customer number as string */
  private String custNum;
  /** Customer number as 10 digit array */
  private int[] custNumDigits = new int[10];
  /** Mailing list opt-in */
  private boolean mailListOptIn;
  
  // --------------- CONSTRUCTORS ---------------
  
  /**
   * Empty constructor
   */
  public Customer() {
  }
  
  /**
   * Constructs Customer object with first and last name 
   * @param first String of first name
   * @param last String of last name
   */
  public Customer(String first, String last) {
    setFirstName(first);
    setLastName(last);
    incrementCustomers();
    setCustNum();
    incrementPerson();
  }
  
  /**
   * Constructs Customer object with first name, last name, and
   * phone number
   * @param first String of first name
   * @param last String of last name
   * @param phone 10 digit array of integers
   */
  public Customer(String first, String last, int[] phone) {
    setFirstName(first);
    setLastName(last);
    setPhoneNumber(phone);
    incrementCustomers();
    setCustNum();
    incrementPerson();
  }
  
  /**
   * Constructs Customer object with first name, last name, and
   * address 
   * @param first String of first name
   * @param last String of last name
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   */
  public Customer(String first, String last, 
      String street, String city, String state, int[] zip) {
    setFirstName(first);
    setLastName(last);
    setStreetAddress(street);
    setCity(city);
    setState(state);
    setZipCode(zip);
    incrementCustomers();
    setCustNum();
    incrementPerson();
  }
  
  /**
   * Constructs Customer object with first name, last name, 
   * address, and mailing list opt-in
   * @param first String of first name
   * @param last String of last name
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   * @param mList Boolean to set mail list opt-in
   */
  public Customer(String first, String last, 
      String street, String city, String state, int[] zip, boolean mList) {
    setFirstName(first);
    setLastName(last);
    setStreetAddress(street);
    setCity(city);
    setState(state);
    setZipCode(zip);
    incrementCustomers();
    setCustNum();
    setMailListOptIn(mList);
    incrementPerson();
  }
  
  /**
   * Constructs Customer object with first name, last name, phone number,
   * and address
   * @param first String of first name
   * @param last String of last name
   * @param phone 10 digit array of integers
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   */
  public Customer(String first, String last, int[] phone, 
      String street, String city, String state, int[] zip) {
    setFirstName(first);
    setLastName(last);
    setStreetAddress(street);
    setCity(city);
    setState(state);
    setZipCode(zip);
    setPhoneNumber(phone);
    incrementCustomers();
    setCustNum();
    incrementPerson();
  }
  
  /**
   * Constructs Customer object with first name, last name, phone number,
   * address, and mailing list opt-in
   * @param first String of first name
   * @param last String of last name
   * @param phone 10 digit array of integers
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   * @param mList Boolean to set mail list opt-in
   */
  public Customer(String first, String last, int[] phone, 
      String street, String city, String state, int[] zip, boolean mList) {
    setFirstName(first);
    setLastName(last);
    setStreetAddress(street);
    setCity(city);
    setState(state);
    setZipCode(zip);
    setPhoneNumber(phone);
    incrementCustomers();
    setCustNum();
    setMailListOptIn(mList);
    incrementPerson();
  }
  
  // --------------- METHODS ---------------
  
  /**
   * Increment totalCustomers variable
   */
  private static void incrementCustomers() {
    totalCustomers += 1;
  }
  
  /**
   * Get total Customer objects 
   * @return Integer of total Customer objects
   */
  public static int getTotalCustomers() {
    return totalCustomers;
  }
  
  /**
   * Get Customer customer number
   * @return String of customer number
   */
  public String getCustNum() {
    return custNum;
  }
  
  /**
   * Set Customer customer number
   */
  private void setCustNum() {
    // Total customer variable to integer
    String c = Integer.toString(totalCustomers);
    String t = "";
    // Set number of zeros in customer number
    for (int i = 0; i < (custNumDigits.length - c.length()); i++ ) {
      t = t + "0";
    }
    custNum = t + c;
  }
  
  /**
   * Get mailing list opt-in
   * @return True if on mailing list
   */
  public boolean isMailListOptIn() {
    return mailListOptIn;
  }
  
  /**
   * Set mailing list opt-in 
   * @param m Boolean 
   */
  public void setMailListOptIn(boolean m) {
    this.mailListOptIn = m;
  }
  
  @Override
  /**
   * Overrides Person toString method with appropriate 
   * data attribute fields included
   */
  public String toString() {
    return super.toString() +
        "\nCustomer number: " + custNum +
        "\nMailing List: " + mailListOptIn;
  }
}