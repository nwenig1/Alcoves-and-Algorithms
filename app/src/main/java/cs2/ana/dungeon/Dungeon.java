package cs2.ana.dungeon;

import cs2.ana.npc.NPC;

public abstract class Dungeon {
     private int numEnemies;
    protected NPC[] enemies; 
    private int BonusXP; 

    
    public Dungeon(int _numEnemies, int _BonusXP){
        this.numEnemies = _numEnemies; 
        this.enemies =new NPC[_numEnemies]; 
        this.BonusXP =  _BonusXP; 
       
    }
   
    public int getNumEnemies(){
        return this.numEnemies; 
    }
    public NPC[] getEnemies(){
        return this.enemies; 
    }
    public int getBonusXP(){
        return this.BonusXP; 
    }
       //for testing enemy generation 
       public void printEnemies(){
        for(int i=0; i<this.enemies.length; i++){
            System.out.println(enemies[i].toString());
        }
    }
     public abstract NPC[] generateEnemies(int enemy_count); 
     public abstract String getName(); 
}
