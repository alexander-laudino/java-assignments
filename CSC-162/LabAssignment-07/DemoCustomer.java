import java.util.ArrayList;

/**
 * This program demonstrates the creation of Person and Customer
 * objects.
 * 
 * Lab Assignment 7 - Person and Customer Class
 * Dr. Farrett - CSC-162-IN1
 * @author Alexander Laudino
 * @version 1.0
 * @since 2021-10-28
 */
public class DemoCustomer {
  /**
   * Main method
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    
    ArrayList<Person> people = new ArrayList<Person>();
    
    people.add( new Person() );
    people.add( new Person("Alan", "Landino") );
    people.add( new Person("Alex", "Laudino", new int[] {7, 3, 5, 8, 3, 0, 9, 3, 1, 2}) );
    people.add( new Person("Al", "Laudano", "23 Washington St.", "Edison", "New Jersey", new int[] {0, 8, 8, 6, 7}) );
    people.add( new Person("Albert", "Laudani", new int[] {9, 0, 8, 6, 5, 1, 3, 9, 7, 4}, 
        "23 Main St.", "Metuchen", "New Jersey", new int[] {0, 8, 8, 5, 7}) );
    people.add( new Customer("John", "Doe")); // Testing polymorphism
        
    ArrayList<Customer> customers = new ArrayList<Customer>();
    
    customers.add( new Customer() );
    customers.add( new Customer("Alec", "Baudino") );
    customers.add( new Customer("Tom", "Arnold", new int[] {8, 5, 6, 9, 5, 2, 4, 3, 2, 1}) );
    customers.add( new Customer("Al", "Caudano", "23 High St.", "Woodbridge", "New Jersey", new int[] {0, 8, 8, 7, 7}) );
    customers.add( new Customer("Al", "Maudano", "23 Side St.", "Middlesex", "New Jersey", new int[] {0, 8, 9, 7, 7}, true) );
    customers.add( new Customer("Alcede", "Paudano", new int[] {7, 3, 2, 7, 7, 9, 9, 4, 5, 6},
        "23 Low St.", "Piscataway", "New Jersey", new int[] {0, 8, 8, 5, 4}) );
    customers.add( new Customer("Alvin", "Waudano", new int[] {7, 3, 1, 4, 7, 6, 0, 4, 5, 6},
        "23 Mid St.", "Dunellen", "New Jersey", new int[] {0, 8, 8, 4, 4}, true) );
            
    displayObject(people);
    displayObject(new Person("Jim", "Beam"));
    System.out.println("\n");
    displayObject(customers);
    displayObject(customers.get(4)); // Testing polymorphism
    System.out.println();
    
    System.out.println("\nTotal customers: " + Customer.getTotalCustomers());
    System.out.println("Total people: " + Person.getTotalPersons());    
  }
  
  /**
   * Display Person object name and date created
   * @param x Person object
   */
  public static void displayObject(Person x) {
    System.out.print("First name: " + x.getFirstName() +
        "\nDate created: " + x.getDateCreated());
  }
  
  /**
   * Display all objects' properties 
   * @param <E> Generic type
   * @param x ArrayList
   */
  public static <E> void displayObject(ArrayList<E> x) {
    for (Object p: x) {
      System.out.println(p + "\n");
    };
  }
}

/* OUTPUT
First name: null
Last name: null
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021

First name: Alan
Last name: Landino
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021

First name: Alex
Last name: Laudino
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 735-830-9312
Date added: Tue Nov 02 11:31:10 EDT 2021

First name: Al
Last name: Laudano
Street: 23 Washington St.
City: Edison
State: New Jersey
Zip Code: 08867
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021

First name: Albert
Last name: Laudani
Street: 23 Main St.
City: Metuchen
State: New Jersey
Zip Code: 08857
Phone Number: 908-651-3974
Date added: Tue Nov 02 11:31:10 EDT 2021

First name: John
Last name: Doe
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000001
Mailing List: false

First name: Jim
Date created: Tue Nov 02 11:31:10 EDT 2021

First name: null
Last name: null
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: null
Mailing List: false

First name: Alec
Last name: Baudino
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000002
Mailing List: false

First name: Tom
Last name: Arnold
Street: null
City: null
State: null
Zip Code: 00000
Phone Number: 856-952-4321
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000003
Mailing List: false

First name: Al
Last name: Caudano
Street: 23 High St.
City: Woodbridge
State: New Jersey
Zip Code: 08877
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000004
Mailing List: false

First name: Al
Last name: Maudano
Street: 23 Side St.
City: Middlesex
State: New Jersey
Zip Code: 08977
Phone Number: 000-000-0000
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000005
Mailing List: true

First name: Alcede
Last name: Paudano
Street: 23 Low St.
City: Piscataway
State: New Jersey
Zip Code: 08854
Phone Number: 732-779-9456
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000006
Mailing List: false

First name: Alvin
Last name: Waudano
Street: 23 Mid St.
City: Dunellen
State: New Jersey
Zip Code: 08844
Phone Number: 731-476-0456
Date added: Tue Nov 02 11:31:10 EDT 2021
Customer number: 0000000007
Mailing List: true

First name: Al
Date created: Tue Nov 02 11:31:10 EDT 2021

Total customers: 7
Total people: 12
 */