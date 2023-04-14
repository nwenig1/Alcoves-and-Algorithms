package cs2.ana;

public class dndTester {
    public static void main (String [] args){
Die test = new Die(10); 
DicePool pool = new DicePool(5, 20); 

System.out.println("Roll: "  +test.roll()); 
for(int i=0; i<100; i++){
System.out.println("Pool Roll" +i+": "+pool.roll());  
}
}

    }
