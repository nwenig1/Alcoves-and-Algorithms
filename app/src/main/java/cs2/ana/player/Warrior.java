package cs2.ana.player;

import cs2.ana.DicePool;

/**
 * A warrior is a player with a high hit point total, low armor class, and
 * average to-hit modifier.
 */
public class Warrior extends Player {
  /**
   * Creates a new warrior with the given name. Warriors have 3d8 + 12 hit
   * points, 12 armor class, and +4 to hit.
   * 
   * @param name The name of the warrior.
   */
  public Warrior(String name) {
    super(new DicePool(3, 8).roll() + 12, 12, 4, name);
  }
}
