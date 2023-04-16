package cs2.ana.player;

import cs2.ana.DicePool;
import cs2.ana.npc.NPC;

/**
 * A Monk is a Player with low hit points, a mdedium armor class, and a high
 * to-hit modifier. Monks also have a special ability that allows them to attack
 * twice in a single turn, but only if their first attack hits.
 */
public class Monk extends Player {
  /**
   * Creates a new Monk with the given name. Monks have 3d6 + 8 hit points, 12
   * armor class, and +5 to hit.
   * @param name  the name of the Monk
   */
  public Monk(String name) {
    super(new DicePool(3, 6).roll()+8, 12, 5, name); 
  }

  /**
   * Unlike a regular Player, if the Monk's first attack hits, the Monk
   * attacks again.
   * @param other  the NPC to attack
   */
  @Override
  public void takeTurn(NPC other) {
if(this.attack(other)){ //if the attack hits (true val)
  this.attack(other);  //attack again
}
  }


    }



