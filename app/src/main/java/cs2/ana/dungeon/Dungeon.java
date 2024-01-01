package cs2.ana.dungeon;

import cs2.ana.npc.NPC;

public abstract class Dungeon {
     private int numEnemies; 
    protected NPC[] enemies; 
    
    public Dungeon(int _numEnemies){
        this.numEnemies = _numEnemies; 
        this.enemies =new NPC[_numEnemies]; 
       
    }
   
    public int getNumEnemies(){
        return this.numEnemies; 
    }
     public abstract NPC[] generateEnemies(int enemy_count); 
     public abstract String getName(); 
}
