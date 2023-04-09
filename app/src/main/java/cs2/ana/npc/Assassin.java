package cs2.ana.npc;

import cs2.ana.DicePool;
import cs2.ana.player.Player;

/**
 * An Assassin is a challenging NPC.
 */
public class Assassin extends NPC {
  /**
   * Creates an Assassin with 3d6 + 6 HP, 15 AC, and +6 to hit.
   */
  public Assassin() {}

  /**
   * An Assassin attacks with 1d6 + 3 damage.
   * @return  the damage dealt
   */
  public int determineDamage() {}
  /**
   * Returns the name of the NPC (Assassin).
   * @return  the name of the NPC
   */
  public String getName() {}

  /**
   * Unlike a regular NPC, an Assassin's turn consists of two attacks in a row.
   * @param other  the Player to attack
   */
  @Override
  public void takeTurn(Player other) {}
}
