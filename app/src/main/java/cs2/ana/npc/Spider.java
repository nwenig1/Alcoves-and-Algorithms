package cs2.ana.npc;

import cs2.ana.DicePool;


/**
 * A Spider is a weak NPC.
 */
public class Spider extends NPC {
  /**
   * Creates a Spider with 1d8 + 2 HP, 13 AC, and +3 to hit.
   */
  public Spider() {
    super(new DicePool(1, 8).roll()+2,
     13, 
     3, 10); 
  }

  /**
   * A Spider attacks with 1d6 + 1 damage. It has a 50% chance of doing an
   * additional 2d6 damage as well.
   * @return  the damage dealt
   */
  public int determineDamage() {
    int how_much_ouch = 0; 
    if(Math.random()>.5){
how_much_ouch = new DicePool(2, 6).roll(); 
    }
return new DicePool(1, 6).roll()+1+how_much_ouch; 
    }

  /**
   * Returns the name of the NPC (Spider).
   * @return  the name of the NPC
   */
  public String getName() {
    return "Spider"; 
}
}
