package cs2.ana.dungeon;

import cs2.ana.npc.Assassin;
import cs2.ana.npc.Bandit;
import cs2.ana.npc.NPC;
import cs2.ana.npc.Skeleton;

public class Catacomb extends Dungeon {

    public Catacomb(){
        super(5); 
        this.enemies = generateEnemies(5); 
    }
    @Override
    public NPC[] generateEnemies(int enemy_count) {
        NPC[] opponents = new NPC[enemy_count]; 
        for(int i=0; i< opponents.length; i++){
            if(Math.random()>(1-(.15*i))){
                opponents[i] = new Skeleton(); 
            }else if(Math.random() > .4){
                opponents[i] = new Assassin(); 
            }else{
                opponents[i] = new Bandit(); 
            }
        }

        return opponents; 
    }

    @Override
    public String getName() {
        return "Catacomb"; 
    }
    
}
