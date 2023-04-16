package cs2.ana;

import cs2.ana.npc.*; 
import cs2.ana.player.*; 

public class dndTester {
    public static void main (String [] args){
Die test = new Die(10); 
DicePool pool = new DicePool(1, 8); 
System.out.println("Roll: "  +test.roll()); 
System.out.println("Pool Roll: "+pool.roll());  
Weapon thing = new Weapon(pool, "cutty"); 
System.out.println(thing.getName() + "s damage: " 
+thing.rollForDamage()); 
Warrior noah = new Warrior("noah"); 
noah.setWeapon(thing);
    


 
}
}

    
