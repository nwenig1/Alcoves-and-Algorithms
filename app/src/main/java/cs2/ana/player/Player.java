package cs2.ana.player;

import cs2.ana.Character;
import cs2.ana.Weapon;
import cs2.ana.npc.NPC;
import java.util.Scanner;

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
   * The level of the player
   */
  protected int xpLevel;

  /**
   * The amount of points the player has towards the next level
   */
  protected int xpPoints;

  /**
   * The amount of avaliable upgrade points the player has
   */
  protected int upgradePoints;

  protected int maxHP;

  

  /**
   * Creates a Player with the given hit points, armor class, to hit, and name.
   * Starting xp level 1
   * 
   * @param hp    the hit points of the Player
   * @param armor the armor class of the Player
   * @param toHit the to hit of the Player
   * @param n     the name of the Player
   */
  public Player(int _hp, int _armor, int _toHit, String _n) {
    super(_hp, _armor, _toHit);
    maxHP = _hp;
    name = _n;
    xpLevel = 1;
    xpPoints = 0;
    upgradePoints = 0;

  }

  /**
   * Sets the weapon that the player is using.
   * 
   * @param w the weapon to use
   */
  public void setWeapon(Weapon w) {
    weapon = w;
  }

  /**
   * Gets the name of the Player.
   * 
   * @return the name of the Player
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the XP level of the Player
   * 
   * @return the level of the Player
   */
  public int getXP() {
    return this.xpLevel;
  }

  /**
   * Gets the XP points (towards the next level) of the Player
   * 
   * @return the XP points of the Player
   */
  public int getPoints() {
    return this.xpPoints;
  }

  /**
   * Determines the damage done by the Player's weapon.
   * 
   * @return total damage done
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
   * @param other the NPC to attack
   */
  public void takeTurn(NPC other) {
    this.attack(other);
  }

  /**
   * Resets a player's health to their maximum HP
   */
  public void rest() {
    this.hp = maxHP;
  }

  /**
   * Formats the Player as a String.
   * For example, a character named Holga with 34 hit points, an armor class of
   * 12, and a to hit of 5 wielding a shortsword would be formatted as:<br>
   * Holga (HP:34 AC:12 ToHit:5) Weapon: Shortword
   * 
   * @return the Player as a String
   */
  @Override
  public String toString() {
    return "\n " + this.getName()
        + "(HP:" + this.getHP()
        + " AC:" + this.getArmor()
        + " ToHit:" + toHit
        + " XP Level " + this.getXP()
        + ") Weapon: "
        + this.weapon.getName();

  }

  /**
   * 
   * @param points
   */
  public void gainXP(int points) {
    while (this.hasLeveledUp(points)) {
      System.out.println("Congrats you leveled up to level " + (this.getXP() + 1) + "!");
      points -= ((this.getXP() * 10) - this.xpPoints);
      this.xpLevel++;
      this.xpPoints = 0;
      this.upgradePoints++;
      this.upgradeStats();
    }
    this.xpPoints += points; // gives remainder of points towards next level
  }

  /**
   * Determines if the character has leveled up.
   * Character needs 10*current_level_number of points to level up.
   * Points reset upon leveling up.
   * Ex: A level 2 character needs 20 points to level up, a level 5 would need 50.
   * 
   * @param points
   * @return whether or not the player has leveled up
   */
  private boolean hasLeveledUp(int points) {
    return this.getPoints() + points >= (this.getXP() * 10);
  }

  public void upgradeStats() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose which stat to upgrade:");
    System.out.println("1. HP");
    System.out.println("2. Armor");
    System.out.println("3. Weapon");
    
    int choice = sc.nextInt();
    if (choice == 1) {
      maxHP += 7 * this.getXP();
    } else if (choice == 2) {
      armor += 2 * this.getXP();
    } else if (choice == 3) {
      for (int i = 0; (i < this.getXP()/2); i++) {
        this.weapon.buffStats();
      }
    }
  }
}
