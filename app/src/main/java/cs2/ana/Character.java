package cs2.ana;

/**
 * A character in the game.
 */
public abstract class Character {
  /**
   * The character's hit points.
   */
  protected int hp;
  /**
   * The character's armor class.
   */
  protected int ac;
  /**
   * The character's hit modifier.
   */
  protected int toHit;

  /**
   * Creates a new character with the given stats.
   * @param hp  the character's hit points
   * @param ac  the character's armor class
   * @param toHit the character's hit modifier
   */
  public Character(int _hp, int _ac, int _toHit) {
hp = _hp; 
ac = _ac; 
toHit = _toHit; 
  }

  /**
   * Gets the character's hit points.
   * @return  the character's hit points
   */
  public int getHP() {
    return hp; 
  }

  /**
   * Reduces the character's hit points by the given amount.
   * @param dmg the amount of damage to take
   */
  public void takeDamage(int dmg) {
    hp= getHP()- dmg; 
  }

  /**
   * Gets the character's armor class.
   * @return  the character's armor class
   */
  public int getAC() {
    return ac; 
  }

  /**
   * Gets the character's name for use in messages.
   * @return  the character's name
   */
  public abstract String getName();

  /**
   * Determines the amount of damage to deal for a single attack.
   * @return  the amount of damage to deal
   */
  public abstract int determineDamage();

  /**
   * Attacks another character. This method will roll a d20 and add the
   * character's toHit modifier. If the result is greater than the other
   * character's armor class, the attack hits and the other character takes
   * damage. Otherwise, the attack misses.
   * 
   * This method will print messages to the console indicating the result of
   * the attack. The format of the messages is:<br>
   * ***<i>ATTACKER</i> attacks <i>DEFENDER</i><br>
   * <i>ATTACKER</i> rolled a <i>ROLL_AMOUNT</i> to hit.<br>
   * If the attack hits:<br>
   * <i>ATTACKER</i> hit for <i>DAMAGE_AMOUNT</i> damage.<br>
   * If the attack misses:<br>
   * <i>ATTACKER</i> missed.<br>
   * 
   * @param other  the character to attack
   * @return  true if the attack hit, false otherwise
   */
  public boolean attack(Character other) {
int roll = new Die(20).roll(); 
System.out.println("***" + this.getName()+ " attacks "+ other.getName()); 
System.out.println(this.getName()+ " rolled a "+roll + " to hit."); 


if(roll+this.toHit>other.getAC()){
  int dmg = this.determineDamage(); 
System.out.println(this.getName()+ " hit for " + dmg +" damage"); 
other.takeDamage(dmg);
  
return true; 
}
else{
  System.out.println(this.getName() + " missed"); 
  return false; 
}
  }
}
