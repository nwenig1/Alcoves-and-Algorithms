package cs2.ana.npc;

import cs2.ana.DicePool;

/**
 * A Bandit is moderately challenging NPC.
 */
public class Bandit extends NPC {
  /**
   * Creates a Bandit with 2d8 + 2 HP, 12 AC, and +3 to hit.
   */
  public Bandit() {}

  /**
   * A Bandit attacks with 1d8 + 2 damage.
   * @return  the damage dealt
   */
  public int determineDamage() {}

  /**
   * Returns the name of the NPC (Bandit).
   * @return  the name of the NPC
   */
  public String getName() {}
}
