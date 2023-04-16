package cs2.ana.npc;

import cs2.ana.Character;
import cs2.ana.player.Player;

/**
 * An NPC is a Character that is controlled by the computer.
 */
public abstract class NPC extends Character {
  /**
   * Creates an NPC with the given hit points, armor class, and to hit modifier.
   * @param hp  the hit points of the NPC
   * @param ac  the armor class of the NPC
   * @param toHit  the to hit modifier of the NPC
   */
  public NPC(int hp, int ac, int toHit) {
    super(hp, ac, toHit); 
  }

  /**
   * Performs an attack turn for the NPC. NPCs may only attack Players.
   * 
   * By default, this means attacking a Player one time. Subclasses may 
   * override this method depending on the NPC's special abilities.
   * 
   * @param other  the Player to attack
   */
  public void takeTurn(Player other) {
    this.attack(other);
  }
}
