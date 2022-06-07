/**
 * The Person class contains the variables, constructors, and methods
 * to create Person objects
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-10-28
 */
public class Person {
  
  // --------------- VARIABLES ---------------
  
  /** Total Person objects created with data attributes */
  private static int totalPersons;
  /** Person's first name */
  private String firstName;
  /** Person's last name */
  private String lastName;
  /** Person's street address */
  private String streetAddress;
  /** Person's city */
  private String city;
  /** Person's state */
  private String state;
  /** Person's zip code stored as array of integers */
  private int[] zipCodeDigits = new int[5];
  /** Person's zip code stored as string */
  private String zipCode;
  /** Person's phone number stored as array of integers */
  private int[] phoneNumDigits = new int[10];
  /** Person's phone number stored as string */
  private String phoneNum;
  /** Date Person object created */
  private java.util.Date dateCreated;
  
  // --------------- CONSTRUCTORS --------------- 
  
  /**
   * Empty constructor used for testing Person object attribute formatting
   */
  public Person() {
    zipCodeDigitsToString(zipCodeDigits);
    phoneNumDigitsToString(phoneNumDigits);
    dateCreated = new java.util.Date();
  }
  
  /**
   * Constructs Person object with only first and last name
   * @param first String of first name
   * @param last String of last name
   */
  public Person(String first, String last) {
    this.firstName = first;
    this.lastName = last;
    zipCodeDigitsToString(zipCodeDigits);
    phoneNumDigitsToString(phoneNumDigits);
    dateCreated = new java.util.Date();
    incrementPerson();
  }
  
  /**
   * Constructs Person object with first name, last name, and phone number
   * @param first String of first name
   * @param last String of last name
   * @param phone 10 digit array of integers
   */
  public Person(String first, String last, int[] phone) {
    this.firstName = first;
    this.lastName = last;
    zipCodeDigitsToString(zipCodeDigits);
    phoneNumDigitsToString(phone);
    dateCreated = new java.util.Date();
    incrementPerson();
  }
  
  /**
   * Constructs Person object with first name, last name, and address
   * @param first String of first name
   * @param last String of last name
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   */
  public Person(String first, String last, 
      String street, String city, String state, int[] zip) {
    this.firstName = first;
    this.lastName = last;
    this.streetAddress = street;
    this.city = city;
    this.state = state;
    zipCodeDigitsToString(zip);
    phoneNumDigitsToString(phoneNumDigits);
    dateCreated = new java.util.Date();
    incrementPerson();
  }
  
  /**
   * Constructs Person object with first name, last name, phone number,
   * and address
   * @param first  String of first name
   * @param last  String of last name
   * @param phone 10 digit array of integers
   * @param street String of street address
   * @param city String of city
   * @param state String of state
   * @param zip 5 digit array of integers
   */
  public Person(String first, String last, int[] phone,
      String street, String city, String state, int[] zip) {
    this.firstName = first;
    this.lastName = last;
    this.streetAddress = street;
    this.city = city;
    this.state = state;
    zipCodeDigitsToString(zip);
    phoneNumDigitsToString(phone);
    dateCreated = new java.util.Date();
    incrementPerson();
  }
  
  // --------------- METHODS ---------------
  
  /**
   * Get total Person objects created
   * @return Integer of total Person objects
   */
  public static int getTotalPersons() {
    return totalPersons;
  }
  
  /**
   * Increment totalPersons variable
   */
  public static void incrementPerson() {
    totalPersons += 1;
  }
  
  /**
   * Get Person's first name
   * @return String of first name
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Set Person's first name
   * @param f String of first name
   */
  public void setFirstName(String f) {
    this.firstName = f;
  }
  
  /**
   * Get Person's last name
   * @return String of last name
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * Set Person's last name
   * @param l String of last name
   */
  public void setLastName(String l) {
    this.lastName = l;
  }
  
  /**
   * Get Person's street address
   * @return String of street address
   */
  public String getStreetAddress() {
    return streetAddress;
  }
  
  /**
   * Set Person's street address
   * @param address String of street address
   */
  public void setStreetAddress(String address) {
    this.streetAddress = address;
  }
  
  /**
   * Get Person's city
   * @return String of city
   */
  public String getCity() {
    return city;
  }
  
  /**
   * Set Person's city
   * @param city String of city
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /**
   * Get Person's state
   * @return String of state
   */
  public String getState() {
    return state;
  }
  
  /**
   * Set Person's state
   * @param state String of state
   */
  public void setState(String state) {
    this.state = state;
  }
  
  /**
   * Get Person's zip code
   * @return String of zip code
   */
  public String getZipCode() {
    return zipCode;
  }
  
  /**
   * Set Person's zip code
   * @param zip String of zip code 
   */
  public void setZipCode(String zip) {
    this.zipCode = zip;
  }
  
  /**
   * Set Person's zip code
   * @param zip 5 digit array of integers 
   */
  public void setZipCode(int[] zip) {
    zipCodeDigitsToString(zip);
  }
  
  /**
   * Get Person's phone number
   * @return String of phone number
   */
  public String getPhoneNumber() {
    return phoneNum;
  }
  
  /**
   * Set Person's phone number
   * @param p String of phone number
   */
  public void setPhoneNumber(String p) {
    this.phoneNum = p;
  }
  
  /**
   * Set Person's phone number
   * @param p 10 digit array of integers
   */
  public void setPhoneNumber(int[] p) {
    phoneNumDigitsToString(p);
  }
  
  /**
   * Get Person object's date created
   * @return Date created
   */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }
  
  /**
   * Take 5 element array of integers and set zipCode
   * with format of XXXXX 
   * @param d Array of integers representing zip code
   */
  private void zipCodeDigitsToString(int[] d) {
    this.zipCode = Integer.toString(d[0]) +
                   Integer.toString(d[1]) +
                   Integer.toString(d[2]) +
                   Integer.toString(d[3]) +
                   Integer.toString(d[4]);
  }
  
  /** 
   * Take 10 element array of integers and set phoneNum
   * with format of XXX-XXX-XXXX
   * @param d Array of integers representing a phone number
   */
  private void phoneNumDigitsToString(int[] d) {
    this.phoneNum = Integer.toString(d[0]) +
                    Integer.toString(d[1]) +
                    Integer.toString(d[2]) +
                    "-" +
                    Integer.toString(d[3]) +
                    Integer.toString(d[4]) +
                    Integer.toString(d[5]) +
                    "-" +
                    Integer.toString(d[6]) +
                    Integer.toString(d[7]) +
                    Integer.toString(d[8]) +
                    Integer.toString(d[9]);
  }
  
  @Override
  /**
   * Overrides Object toString method with appropriate 
   * data attribute fields included
   */
  public String toString() {
    return "First name: " + firstName +
        "\nLast name: " + lastName +
        "\nStreet: " + streetAddress +
        "\nCity: " + city +
        "\nState: " + state +
        "\nZip Code: " + zipCode +
        "\nPhone Number: " + phoneNum +
        "\nDate added: " + dateCreated;
  }
}