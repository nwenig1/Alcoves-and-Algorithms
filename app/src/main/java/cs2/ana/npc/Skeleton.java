package cs2.ana.npc;

import cs2.ana.DicePool;
import cs2.ana.player.Player;

/*
 * A Skeleton is a moderatley difficult NPC
 * Has a 50% chance to apply poison to the player, 
 * which will apply continuous damage for the rest of the combat phase 
 */
public class Skeleton extends NPC {
    private boolean poison_applied = false; 
    public Skeleton(){
        super(new DicePool(3, 10).roll()+3, 
        9, 4, 35);
        poison_applied = false; 
    }
    @Override
    public String getName() {
        return "skeleton";
    }

    @Override
    public int determineDamage() {
        return new DicePool(2, 10).roll(); 
    }
    @Override 
    public void takeTurn(Player other){
        if(Math.random()>.5){
            poison_applied = true; 
        }
        this.attack(other); 
        if(poison_applied){
            other.takeDamage(2);
        }
    }
    
}
