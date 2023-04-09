package cs2.ana;

/**
 * A Weapon is a tool used by a Player to inflict damage on an Enemy.
 */
public class Weapon {
  private DicePool pool;
  private String name;
  /**
   * Creates a new Weapon with the given DicePool.
   * @param p the DicePool used to calculate damage
   * @param n the name of the Weapon
   */
  public Weapon(DicePool p, String n) {}

  /**
   * Rolls the Weapon's DicePool and returns the result.
   * @return  the result of the roll
   */
  public int rollForDamage() {}

  /**
   * Returns the name of the Weapon.
   * @return  the name of the Weapon
   */
  public String getName() {}

  /**
   * An instance of the Weapon class for a battleaxe, which has 1d8 damage, named "Battleaxe".
   */
  public static Weapon battleaxe = null; //REPLACE NULL TO CREATE A BATTLEAXE
  /**
   * An instance of the Weapon class for unarmed strikes, which has 1d4 damage, named "Unarmed Strike".
   */
  public static Weapon unarmed = null; //REPLACE NULL TO CREATE AN UNARMED STRIKE
  /**
   * An instance of the Weapon class for a shortsword, which has 1d6 damage, named "Shortsword".
   */
  public static Weapon shortsword = null; //REPLACE NULL TO CREATE A SHORTSWORD
}
