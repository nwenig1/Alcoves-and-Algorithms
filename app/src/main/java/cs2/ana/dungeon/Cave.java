package cs2.ana.dungeon;

import cs2.ana.npc.Assassin;
import cs2.ana.npc.Bandit;
import cs2.ana.npc.NPC;
import cs2.ana.npc.Spider;

/**
 * A cave is an easy encounter filled with mostly spiders
 * Bandits can occur more frequentley later in the cave
 */

public class Cave extends Dungeon {
    /**
     * Creates a cave with 3 enemies, with a 75% of each being a spider
     * 
     */
    public Cave() {
        super(3, 40);
        this.enemies = generateEnemies(3);
    }

    /**
     * Makes an arry of enemies for a cave
     * Later opponents have a higher chance of being bandits (more difficult)
     * 
     * @param the size of array/ number of enemies
     * @return an NPC array with the enemies
     */
    @Override
    public NPC[] generateEnemies(int enemy_count) {
        NPC[] opponents = new NPC[enemy_count];

        for (int i = 0; i < opponents.length; i++) {
            if (Math.random() > .9) {
                opponents[i] = new Assassin();
            } else if (Math.random() > (1.0 - (.25 * i))) {
                opponents[i] = new Bandit();
            } else {
                opponents[i] = new Spider();
            }
        }
        return opponents;
    }

    public String getName() {
        return "Cave";
    }

}
