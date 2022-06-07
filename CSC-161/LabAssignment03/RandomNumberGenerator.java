import java.util.Random;

public class RandomNumberGenerator {
  
  public int rand(int min, int max) {
    if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
      throw new IllegalArgumentException("Invalid range");
    }
    
    return new Random().nextInt(max - min + 1) + min;
  }

}