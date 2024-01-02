package cs2.ana;

/**
 * A Weapon is a tool used by a Player to inflict damage on an Enemy.
 */
public class Weapon {
  private DicePool pool;
  private String name;
  private int upgradeCounter; 

  /**
   * Creates a new Weapon with the given DicePool.
   * 
   * @param p the DicePool used to calculate damage
   * @param n the name of the Weapon
   */
  public Weapon(DicePool p, String n) {
    pool = p;
    name = n;
    upgradeCounter = 0; 
  }

  /**
   * Rolls the Weapon's DicePool and returns the result.
   * 
   * @return the result of the roll
   */
  public int rollForDamage() {
    return pool.roll();
  }

  /**
   * Returns the name of the Weapon.
   * 
   * @return the name of the Weapon
   */
  public String getName() {
    return name + (" (Upgraded " +  upgradeCounter + " times)");
  }

  /**
   * An instance of the Weapon class for a battleaxe, which has 1d8 damage, named
   * "Battleaxe".
   */
  public static Weapon battleaxe = new Weapon(new DicePool(1, 8), "Battleaxe");
  /**
   * An instance of the Weapon class for unarmed strikes, which has 1d4 damage,
   * named "Unarmed Strike".
   */
  public static Weapon unarmed = new Weapon(new DicePool(1, 4), "Unarmed Strike"); 
                                                                       
  /**
   * An instance of the Weapon class for a shortsword, which has 1d6 damage, named
   * "Shortsword".
   */
  public static Weapon shortsword = new Weapon(new DicePool(1, 6), "Shortsword");

  public void buffStats() {
    this.pool.buffPool();
    this.upgradeCounter++; 
  }
}
