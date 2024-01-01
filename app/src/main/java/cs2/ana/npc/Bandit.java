package cs2.ana.npc;

import cs2.ana.DicePool;

/**
 * A Bandit is moderately challenging NPC.
 */
public class Bandit extends NPC {
  /**
   * Creates a Bandit with 2d8 + 2 HP, 12 AC, and +3 to hit.
   */
  public Bandit() {
    super(new DicePool(2, 8).roll()+2, 
    12, 3, 20); 
  }

  /**
   * A Bandit attacks with 1d8 + 2 damage.
   * @return  the damage dealt
   */
  public int determineDamage() {
    return new DicePool(1, 8).roll() +2;
  } 

  /**
   * Returns the name of the NPC (Bandit).
   * @return  the name of the NPC
   */
  public String getName() {
    return "Bandit"; 
}
}
