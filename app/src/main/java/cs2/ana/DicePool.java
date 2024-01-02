package cs2.ana;

import java.util.ArrayList;

/**
 * A collection of dice that can be rolled together.
 */
public class DicePool {
  private ArrayList<Die> dice;

  /**
   * Creates a new DicePool with the given number of dice, each with the given
   * number of sides.
   * @param numDice the number of dice in the pool
   * @param numSides  the number of sides on each die
   */
  public DicePool(int numDice, int numSides) {
dice = new ArrayList<Die>(); 
    for(int i=0; i<numDice; i++){
Die d= new Die(numSides); 
dice.add(d); 

}

  }
  /**
   * Rolls all the dice in the pool and returns the total.
   * @return  the total of all the dice rolls
   */
  public int roll() {
    int sum=0; 
    for(int i=0; i<dice.size(); i++){
      sum+=dice.get(i).roll(); 
    }

    return sum; 
}
/**
 * Increases all Dice in pool
 * For buffing weapon damages in Player.java 
 */
public void buffPool(){
  for(Die d:dice){
    d.increaseSide(); 
  }
}
}
