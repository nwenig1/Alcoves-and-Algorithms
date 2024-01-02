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
  private static boolean dragonSlain = false;

  private static void weaponSelect() {
    System.out.println("Weapon select - choose between 3 weapons");
    System.out.println("1. Shortsword");
    System.out.println("2. Battleaxe");
    System.out.println("3. Unarmed");
    try{
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
  }catch(Exception E){
    System.out.println("Invalid input, enter a number");
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
    try {
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
    } catch (Exception e) {
      System.out.println("Invalid choice, enter a number.");
      characterSelect();
    }

  }

  private static Dungeon dungeonSelect() {
    System.out.println("Choose your next dungeon:");
    System.out.println("1. Cave");
    System.out.println("2. Catacombs");
    System.out.println("3. Dragon's Lair");
    try {
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
    } catch (Exception e) {
      System.out.println("Invalid choice, enter a number");
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

    characterSelect();
    weaponSelect();
    boolean continue_flag = true;
    while (continue_flag) {
      player.rest();
      System.out.println("Your current stats " + player);
      Dungeon trial = dungeonSelect();
      NPC[] enemies = trial.getEnemies();

      for (int i = 0; i < enemies.length; i++) {
        if (fightEnemy(enemies[i])) { // if combat is won
          // player.rest();
          if (i < enemies.length - 1) { // pauses before next combat in encounter
            System.out.println("Preparing for next combat...");
            try {
              Thread.sleep(2250);
            } catch (InterruptedException e) {

              e.printStackTrace();
            }
          }
          if (i == enemies.length - 1) { // if player defeated last enemy in dungeon, give bonus xp
            if (trial instanceof DragonLair == false) { //gives xp before repeating 
              System.out.println(trial.getName() + " cleared! Gaining " + trial.getBonusXP() + " XP.");
              player.gainXP(trial.getBonusXP());
            } else { //we're here if the dragon was killed 
              continue_flag = false;
              dragonSlain = true;
            }
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {

              e.printStackTrace();
            }

          }
        } else { //we're here if player is defeated 
          i = enemies.length; //breaks out from dungeon loop
         
          if(!playAgain()){
            continue_flag = false;
          }

          
        }
      }

    }
    if (dragonSlain) {
      System.out.println("Congratulations! You killed the dragon!");
      player.rest();
      System.out.println("Your final stats: " + player.toString());
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
  public static boolean playAgain(){
    try{
       System.out.println("Would you like to try again? (0 for no, 1 for yes)");
      int continueSelect = sc.nextInt(); 
      if(continueSelect == 0){
        return false; 
      } else{
        return true; 
      }
    } catch(Exception E){
      return playAgain(); 
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
