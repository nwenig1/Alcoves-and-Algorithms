package cs2.ana;
import java.util.Random;  

/**
 * A simple class to represent a die with a given number of sides.
 */
public class Die {
  private int sides;
  /**
   * Creates a new Die with the given number of sides.
   * @param sides number of sides on the die
   */
  public Die(int s) {
    sides =s; 
  }

  /**
   * Rolls the die and returns the result.
   * @return  the result of the roll (1 to number of sides)
   */
  public int roll() {
    Random rand = new Random(); 
    int num = rand.nextInt(sides+1); 
if(num == 0){  //so 0 can't be rolled, 
  num++;  //not exactly random tho :(
}
    return num; 
  }

  /**
   * A die with 20 sides.
   */
  public static Die d20 = new Die(20);  //REPLACE NULL TO CREATE A D20
}
