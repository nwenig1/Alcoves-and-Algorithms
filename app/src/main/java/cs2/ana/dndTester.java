package cs2.ana;

public class dndTester {
    public static void main (String [] args){
Die test = new Die(10); 
DicePool pool = new DicePool(1, 8); 
System.out.println("Roll: "  +test.roll()); 
System.out.println("Pool Roll: "+pool.roll());  
Weapon thing = new Weapon(pool, "cutty"); 
System.out.println(thing.getName() + "s damage: " 
+thing.rollForDamage()); 
}
}

    
