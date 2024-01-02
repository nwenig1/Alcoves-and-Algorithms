package cs2.ana.dungeon;

import cs2.ana.npc.Assassin;
import cs2.ana.npc.Bandit;
import cs2.ana.npc.NPC;
import cs2.ana.npc.Skeleton;

/**
 * A catacomb is a midlevel Dungeon
 * 
 */
public class Catacomb extends Dungeon {
    /*
     * Returns an instance of Catacomb, with 5 enemies
     */
    public Catacomb() {
        super(5, 80);
        this.enemies = generateEnemies(5);
    }

    /**
     * Generates the enemies for a catcomb.
     * Chances of assasins and bandits, with skeletons being more likely later on
     * 
     * @param enemy_count the number of enemies in the Catacomb
     */
    @Override
    public NPC[] generateEnemies(int enemy_count) {
        NPC[] opponents = new NPC[enemy_count];
        for (int i = 0; i < opponents.length; i++) {
            if (Math.random() > (1 - (.15 * i))) {
                opponents[i] = new Skeleton();
            } else if (Math.random() > .4) {
                opponents[i] = new Assassin();
            } else {
                opponents[i] = new Bandit();
            }
        }

        return opponents;
    }

    /**
     * Gives name of Catacomb
     * 
     * @return the catacomb name
     */
    @Override
    public String getName() {
        return "Catacomb";
    }

}
