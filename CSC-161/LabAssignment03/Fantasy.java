import java.util.HashMap;
import javax.swing.JOptionPane;

public class Fantasy {
  public void fantasy(String name) {
    JOptionPane.showMessageDialog(null, "Fantasy selected!");
    
    // Character array
    String[] fantasyChar = {"Barbarian", "Druid", "Knight", "Paladin"};
    for (String e: fantasyChar) {
      System.out.println(e);
    }

    String chosenChar = fantasyCharSelect(fantasyChar);
    System.out.println("\n" + name + " the " + chosenChar + "\n");
    
    // Create empty hash map 
    HashMap<String, Integer> weapons = new HashMap<>();
    
    // Add weapons to map
    weapons.put("Axe", 20);
    weapons.put("Knife", 5);
    weapons.put("Mace", 10);
    weapons.put("Staff", 15);
    weapons.put("Sword", 25);
    
    System.out.println("Weapon | Damage");
    
    for (String w : weapons.keySet()) {
      System.out.println(w + " - " + weapons.get(w));
    }

    // Weapon select
    String weapon = weaponSelect(weapons);
    int weaponDamage = weapons.get(weapon);
    System.out.println("\n" + name + " the " + chosenChar + " selects "+ weapon +
        " with a damage rating of " + weaponDamage + "\n");
    
    // Enemy hash map
    HashMap<String, Integer> enemies = new HashMap<>();
    
    // Add enemies to map
    enemies.put("Troll", 75);
    enemies.put("Ogre", 150);
    enemies.put("Zombie", 50);
    enemies.put("Dragon", 200);
    enemies.put("Orc", 100);
    
    // Creates new array of enemy names
    String[] enemyArray = new String[enemies.size()];
    int index = 0;
    for (HashMap.Entry<String, Integer> enemiesEntry : enemies.entrySet()) {
      enemyArray[index] = enemiesEntry.getKey();
      index++;
    }
    
    for (String a: enemyArray) {
      System.out.println(a + " - " + enemies.get(a));
    }
    
    // Generates random number to select a random enemy
    RandomNumberGenerator random = new RandomNumberGenerator();
    int low = 0;
    int high = enemyArray.length - 1;
    
    int r = random.rand(low, high);
    System.out.println("\n" + r);
    
    // TODO Story
    
    // TODO Enemy fight
    String enemy = enemyArray[r];
    int enemyHealth = enemies.get(enemy);
    System.out.println("\n" + enemy + " HP: " + enemyHealth);
  }
  
  /** Method selects fantasy character
   * 
   * @param fantasyChar - Array of fantasy characters
   * @return chosenChar - Chosen fantasy character
   */
  private static String fantasyCharSelect(String[] fantasyChar) {
 // Character select
    String chosenChar;
    while (true) {
      int x = Integer.parseInt(JOptionPane.showInputDialog("Choose a character: Enter 1 for Barbarian"
          + ", 2 for Druid, 3 for Knight, or 4 for Paladin."));
      
      if (x < 5) {
        chosenChar = fantasyChar[x-1];
        break;
      }
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid input!");
        continue;
      }
    }
    return chosenChar;
  }
  
  /** Method selects characters weapon
   * 
   * @param HashMap<String, Integer> weapons
   * @return weapon
   */
  private static String weaponSelect(HashMap<String, Integer> weapons) {
    String weapon;
    while (true) {
      weapon = JOptionPane.showInputDialog("Choose weapon: Axe, Knife, Mace, Staff, or Sword");
      if (weapon.toLowerCase().equals("axe") || weapon.toLowerCase().equals("knife") 
          || weapon.toLowerCase().equals("mace") || weapon.toLowerCase().equals("staff")
          || weapon.toLowerCase().equals("sword")) {
        break;
      }
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid input!");
      }
    }
    return weapon;
  }
}