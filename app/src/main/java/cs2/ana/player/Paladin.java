package cs2.ana.player;

import cs2.ana.DicePool;

/**
 * A Paladin is a Player with high hit pionts, a high armor class, and a low
 * to-hit modifier.
 */
public class Paladin extends Player {
  /**
   * Creates a new Paladin with the given name. Paladins have 3d10 + 15 hit
   * points, 14 armor class, and +2 to hit.
   * 
   * @param name the name of the Paladin
   */
  public Paladin(String name) {
    super(new DicePool(3, 10).roll() + 15,
        14, 2, name);
  }
}
