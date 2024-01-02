package cs2.ana;

import java.util.Scanner;

import cs2.ana.npc.*;
import cs2.ana.player.*;
import cs2.ana.dungeon.*;

/**
 * The main class for the game. Allows the user to select a character and a
 * weapon.
 */
public class Encounter {
  private static Scanner sc = new Scanner(System.in);
  private static Player player;
 

  private static void weaponSelect() {
    System.out.println("Weapon select - choose between 3 weapons");
    System.out.println("1. Shortsword");
    System.out.println("2. Battleaxe");
    System.out.println("3. Unarmed");
    int choice = sc.nextInt();
    if (choice == 1) {
      player.setWeapon(Weapon.shortsword);
    } else if (choice == 2) {
      player.setWeapon(Weapon.battleaxe);
    } else if (choice == 3) {
      player.setWeapon(Weapon.unarmed);
    } else {
      System.out.println("Invalid choice");
      weaponSelect();
    }
  }

  private static void characterSelect() {
    System.out.println("Name your character:");
    String name = sc.nextLine();
    System.out.println("Character select - choose between 3 characters");
    System.out.println("1. Warrior (High hp but low armor, avg damage)");
    System.out.println("2. Monk (Low hp but high dmg)");
    System.out.println("3. Paladin (High hp and armor, but low dmg)");
    int choice = sc.nextInt();
    if (choice == 1) {
      player = new Warrior(name);
    } else if (choice == 2) {
      player = new Monk(name);
    } else if (choice == 3) {
      player = new Paladin(name);
    } else {
      System.out.println("Invalid choice");
      characterSelect();
    }
  }

  private static Dungeon dungeonSelect() {
    System.out.println("Choose your next dungeon:");
    System.out.println("1. Cave");
    System.out.println("2. Catacombs");
    System.out.println("3. Dragon's Lair");
    int choice = sc.nextInt();
    if (choice == 1) {
      return new Cave();
    } else if (choice == 2) {
      return new Catacomb();

    } else if (choice == 3) {
      return new DragonLair();
    } else {
      System.out.println("Invalid choice");
      return dungeonSelect();
    }
  }

  /**
   * The main method for the game. Allows the user to select a character and a
   * weapon and series of enemy encounters. Player can continue to level up
   * and attempt encounters, or repeat the same ones to gain more xp. 
   *
   * @param args command line arguments (unused)
   */

  public static void main(String[] args) {
    System.out.println("Welcome to Alcoves and Algorithms!");
    System.out.println("A couple notes before we begin: \n You have a 3 main stats you can level up.");
    System.out.println(
        "The first is your health. It replenishes upon clearing a whole dungeon, but does not reset between enemies");
    System.out.println("Armor determines the chance an attack can miss. ");
    System.out.println("You can upgrade your weapon for the chance to do more damage!");
    characterSelect();
    weaponSelect();
    boolean continue_flag = true;
    while (continue_flag) {
      System.out.println("Your current stats " + player);
      Dungeon trial = dungeonSelect();
      NPC[] enemies = trial.getEnemies();
      player.rest();
      for (int i = 0; i < enemies.length; i++) {
        if (fightEnemy(enemies[i])) { // if combat is won
          // player.rest();
          if (i < enemies.length - 1) { // pauses before next combat in encounter
            System.out.println("Preparing for next combat...");
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {

              e.printStackTrace();
            }
          }
          if (i == enemies.length - 1) { // if player defeated last enemy in dungeon, give bonus xp
            System.out.println(trial.getName() + " cleared! Gaining " + trial.getBonusXP() + " XP.");
            player.gainXP(trial.getBonusXP());
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {

              e.printStackTrace();
            }

          }
        } else {
          i = enemies.length;
          System.out.println("Would you like to try again? (0 for no, 1 for yes)");
          if (sc.nextInt() == 0) {
            continue_flag = false;

          }
        }
      }

    }
    System.out.println("Thanks for playing!");

  }

  public static boolean fightEnemy(NPC enemy) {
    while (player.getHP() > 0 && enemy.getHP() > 0) {
      System.out.println("-".repeat(10) + player.getName() + "'s Turn" + "-".repeat(10));
      player.takeTurn(enemy);
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {

        e.printStackTrace();
      }
      if (enemy.getHP() > 0) {
        System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" + "-".repeat(10));
        enemy.takeTurn(player);
        try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {

          e.printStackTrace();
        }
      }
    }
    if (player.getHP() > 0) {
      System.out.println(player.getName() + "(" + player.getHP() + " HP) defeats the " + enemy.getName() + "!");
      player.gainXP(enemy.getXP());
      return true;
    } else {
      System.out
          .println("The " + enemy.getName() + "(" + enemy.getHP() + " HP) has defeated " + player.getName() + "!");
      return false;
    }

  }
  // while(player.getHP() > 0 && enemy.getHP() > 0) {
  // System.out.println("-".repeat(10) + player.getName() + "'s Turn" +
  // "-".repeat(10));
  // player.takeTurn(enemy);
  // if(enemy.getHP() > 0) {
  // System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" +
  // "-".repeat(10));
  // enemy.takeTurn(player);
  // }
  // }
  // System.out.println("-".repeat(10) + "BATTLE OVER" + "-".repeat(10));
  // if(player.getHP() > 0) {
  // System.out.println(player.getName() + "(" + player.getHP() + " HP) defeats
  // the " + enemy.getName() + "!");
  // } else {
  // System.out.println("The " + enemy.getName() + "(" + enemy.getHP() + " HP) has
  // defeated " + player.getName() + "!");
  // }

  //
  // public static void main(String[] args) {
  // Cave thing = new Cave();
  // thing.printEnemies();
  // characterSelect();
  // weaponSelect();
  // System.out.println("You are " + player);
  // randomEnemey();
  // while(player.getHP() > 0 && enemy.getHP() > 0) {
  // System.out.println("-".repeat(10) + player.getName() + "'s Turn" +
  // "-".repeat(10));
  // player.takeTurn(enemy);
  // if(enemy.getHP() > 0) {
  // System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" +
  // "-".repeat(10));
  // enemy.takeTurn(player);
  // }
  // }
  // System.out.println("-".repeat(10) + "BATTLE OVER" + "-".repeat(10));
  // if(player.getHP() > 0) {
  // System.out.println(player.getName() + "(" + player.getHP() + " HP) defeats
  // the " + enemy.getName() + "!");
  // } else {
  // System.out.println("The " + enemy.getName() + "(" + enemy.getHP() + " HP) has
  // defeated " + player.getName() + "!");
  // }
  // }

}
