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

    public Skeleton() {
        super(new DicePool(4, 20).roll() + 3,
                12, 4, 35);
        poison_applied = false;
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public int determineDamage() {
        return new DicePool(2, 10).roll();
    }

    /**
     * Override for skeleton's turn. Has a 50% chance to poison the player
     * Player is guarenteed to take 2 damage a turn when posioned
     */
    @Override
    public void takeTurn(Player other) {
        if (Math.random() > .5) {
            poison_applied = true;
            System.out.println("Skeleton poisoned " + other.getName());
        }
        this.attack(other);
        if (poison_applied) {
            other.takeDamage(2);
            System.out.println(other.getName() + " took 2 damage from poison.");
        }
    }

}
