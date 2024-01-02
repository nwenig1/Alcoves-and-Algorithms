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
  public Assassin() {
    super(new DicePool(3, 6).roll() + 6,
        15, 6, 50);
  }

  /**
   * An Assassin attacks with 1d6 + 3 damage.
   * 
   * @return the damage dealt
   */
  public int determineDamage() {
    return new DicePool(1, 6).roll() + 3;
  }

  /**
   * Returns the name of the NPC (Assassin).
   * 
   * @return the name of the NPC
   */
  public String getName() {
    return "Assassin";
  }

  /**
   * Unlike a regular NPC, an Assassin's turn consists of two attacks in a row.
   * 
   * @param other the Player to attack
   */
  @Override
  public void takeTurn(Player other) {
    this.attack(other);
    this.attack(other);
  }
}
