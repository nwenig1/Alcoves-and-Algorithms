package cs2.ana.dungeon;

import cs2.ana.npc.Dragon;
import cs2.ana.npc.NPC;

public class DragonLair extends Dungeon {

    public DragonLair() {
        super(1, 0);
        this.enemies = generateEnemies(1);
    }

    @Override
    public NPC[] generateEnemies(int enemy_count) {
        NPC[] opponents = new NPC[enemy_count];
        opponents[0] = new Dragon();
        return opponents;
    }

    @Override
    public String getName() {
        return "Dragon's Lair";
    }

}
