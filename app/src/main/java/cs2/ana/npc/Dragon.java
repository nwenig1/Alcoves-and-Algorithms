package cs2.ana.npc;

import cs2.ana.DicePool;
import cs2.ana.player.Player;

/**
 * A dragon is the most difficult opponent
 * Deals more damage based on missing health (fury)
 * Can also do % current health damage to the player 
 */
public class Dragon extends NPC {
    private int fury; 
    private int initialHP; 
    
    public Dragon(){
        super(new DicePool(4, 40).roll()+10, 
        7, 10, 250); 
        initialHP = hp; 
    }
    @Override
    public String getName() {
       return "Dragon";
    }

    @Override
    public int determineDamage() {
        return new DicePool(2, 35).roll()+(fury/2);
    }
    @Override 
    public void takeTurn(Player other){
        fury = initialHP-hp; //as hp goes down, fury goes up
        
        this.attack(other); 
        if(Math.random()>.80){
            System.out.println("Dragon's burn was effective!");
            System.out.println("Doing an extra " + (int)(other.getHP()*.10) + "damage."); 
            other.takeDamage((int)(other.getHP()*.10));
              
        } 
    

        
    }
    
}
