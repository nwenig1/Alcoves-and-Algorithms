package cs2.ana.npc;

import cs2.ana.DicePool;

/**
 * A dragon is the most difficult opponent
 */
public class Dragon extends NPC {

    public Dragon(){
        super(new DicePool(4, 40).roll()+10, 
        35, 10, 250); 
    }
    @Override
    public String getName() {
       return "Dragon";
    }

    @Override
    public int determineDamage() {
        return new DicePool(2, 35).roll()+5;
    }
    
}
