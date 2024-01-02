package cs2.ana;

import java.util.Scanner;

import cs2.ana.npc.*;
import cs2.ana.player.*;
import cs2.ana.dungeon.*; 

/**
 * The main class for the game. Allows the user to select a character and a weapon
 * and then randomly generates an enemy to fight. The player and enemy take turns
 * attacking each other until one of them is defeated.
 */
public class Encounter {
  private static Scanner sc = new Scanner(System.in);
  private static Player player;
  private static NPC enemy;
 


  private static void weaponSelect() {
    System.out.println("Weapon select - choose between 3 weapons");
    System.out.println("1. Shortsword");
    System.out.println("2. Battleaxe");
    System.out.println("3. Unarmed");
    int choice = sc.nextInt();
    if(choice == 1) {
      player.setWeapon(Weapon.shortsword);
    } else if(choice == 2) {
      player.setWeapon(Weapon.battleaxe);
    } else if(choice == 3) {
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
    System.out.println("1. Warrior");
    System.out.println("2. Monk");
    System.out.println("3. Paladin");
    int choice = sc.nextInt();
    if(choice == 1) {
      player = new Warrior(name);
    } else if(choice == 2) {
      player = new Monk(name);
    } else if(choice == 3) {
      player = new Paladin(name);
    } else {
      System.out.println("Invalid choice");
      characterSelect();
    }
  }
  private static Dungeon dungeonSelect(){
    System.out.println("Choose your next dungeon:");
    System.out.println("1. Cave");
    System.out.println("2. Catacombs");
    System.out.println("3. Dragon's Lair");
    int choice = sc.nextInt(); 
    if(choice == 1){
    return new Cave(); 
  } else if(choice == 2){
   // return new Catacomb()
   return new Cave();  //delete once catacomb exists 
  } else if(choice ==3){
    //return new DragonLair()
    return new Cave(); //delete this once lair exists
  }else {
    System.out.println("Invalid choice");
    return dungeonSelect(); 
  }
}

  //private static void randomEnemey() {
  //  int choice = (int)(Math.random() * 3) + 1;
  //  if(choice == 1) {
  //    enemy = new Assassin();
  //  } else if(choice == 2) {
  //    enemy = new Bandit();
  //  } else if(choice == 3) {
  //    enemy = new Spider();
  //  }
  //  System.out.println("You have encountered a " + enemy.getName() + "!");
  //}

  /**
   * The main method for the game. Allows the user to select a character and a weapon
   * and then randomly generates an enemy to fight. The player and enemy take turns
   * attacking each other until one of them is defeated.
   * @param args  command line arguments (unused)
   */  

     public static void main(String[] args) {
       characterSelect();
       weaponSelect();
       System.out.println("You are " + player);
       boolean continue_flag = true; 
       while(continue_flag){
      Dungeon trial = dungeonSelect(); 
      

   }

     }
  

     public boolean fightEnemy(){
     while(player.getHP() > 0 && enemy.getHP() > 0){
        System.out.println("-".repeat(10) + player.getName() + "'s Turn" + "-".repeat(10));
         player.takeTurn(enemy);
        if(enemy.getHP() > 0) {
          System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" + "-".repeat(10));
          enemy.takeTurn(player);
     }
      return false; 
     }
   // while(player.getHP() > 0 && enemy.getHP() > 0) {
   //   System.out.println("-".repeat(10) + player.getName() + "'s Turn" + "-".repeat(10));
   //   player.takeTurn(enemy);
   //   if(enemy.getHP() > 0) {
   //     System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" + "-".repeat(10));
   //     enemy.takeTurn(player);
   //   }
   // }
   // System.out.println("-".repeat(10) + "BATTLE OVER" + "-".repeat(10));
   // if(player.getHP() > 0) {
   //   System.out.println(player.getName() + "(" + player.getHP() + " HP) defeats the " + enemy.getName() + "!");
   // } else {
   //   System.out.println("The " + enemy.getName() + "(" + enemy.getHP() + " HP) has defeated " + player.getName() + "!");
   // }
  
  //
  //public static void main(String[] args) {
  //  Cave thing = new Cave(); 
  //  thing.printEnemies();
  //  characterSelect();
  //  weaponSelect();
  //  System.out.println("You are " + player);
  //  randomEnemey();
  //  while(player.getHP() > 0 && enemy.getHP() > 0) {
  //    System.out.println("-".repeat(10) + player.getName() + "'s Turn" + "-".repeat(10));
  //    player.takeTurn(enemy);
  //    if(enemy.getHP() > 0) {
  //      System.out.println("-".repeat(10) + enemy.getName() + "'s Turn" + "-".repeat(10));
  //      enemy.takeTurn(player);
  //    }
  //  }
  //  System.out.println("-".repeat(10) + "BATTLE OVER" + "-".repeat(10));
  //  if(player.getHP() > 0) {
  //    System.out.println(player.getName() + "(" + player.getHP() + " HP) defeats the " + enemy.getName() + "!");
  //  } else {
  //    System.out.println("The " + enemy.getName() + "(" + enemy.getHP() + " HP) has defeated " + player.getName() + "!");
  //  }
  //}
  
}
