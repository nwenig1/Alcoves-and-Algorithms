package cs2.ana.player;

import cs2.ana.Character;
import cs2.ana.Weapon;
import cs2.ana.npc.NPC;

/**
 * A Player is a Character that can be controlled by a human player.
 */
public abstract class Player extends Character {
  /**
   * The weapon that the player is currently using.
   */
  protected Weapon weapon;
  /**
   * The name of the player.
   */
  private String name;
  
  /**
   * Creates a Player with the given hit points, armor class, to hit, and name.
   * @param hp  the hit points of the Player
   * @param ac  the armor class of the Player
   * @param toHit  the to hit of the Player
   * @param n  the name of the Player
   */
  public Player(int _hp, int _ac, int _toHit, String _n) {
    super(_hp, _ac, _toHit); 
    name = _n; 
  }

  /**
   * Sets the weapon that the player is using.
   * @param w  the weapon to use
   */
  public void setWeapon(Weapon w) {
    weapon = w; 
  }

  /**
   * Gets the name of the Player.
   * @return  the name of the Player
   */
  public String getName() {
    return name; 
  }

  /**
   * Determines the damage done by the Player's weapon.
   * @return  total damage done
   */
  public int determineDamage() {
    return this.weapon.rollForDamage(); 
  } 

  /**
   * Performs an attack turn for the Player. Players may only attack NPCs.
   * 
   * By default, this means attacking an NPC one time. Subclasses may override
   * this method depending on the Player's special abilities.
   * 
   * @param other  the NPC to attack
   */
  public void takeTurn(NPC other) {}

  /**
   * Formats the Player as a String. The format should be:<br>
   * <i>NAME</i> (HP:<i>HPAMOUNT</i> AC:<i>ACAMOUNT</i> ToHit:<i>TOHITAMOUNT</i>) Weapon: <i>WEAPONNAME</i>
   * For example, a character named Holga with 34 hit points, an armor class of 
   * 12, and a to hit of 5 wielding a shortsword would be formatted as:<br>
   * Holga (HP:34 AC:12 ToHit:5) Weapon: Shortword
   * 
   * @return  the Player as a String
   */
  @Override
   public String toString() {
    return \n + this.getName() 
}
