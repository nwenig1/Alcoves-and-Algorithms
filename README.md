# Repository for CS2 HW7 - Alcoves & Algorithms
Hello! This is a text-based dungeons and dragons-like game in Java and built through gradle, based off a previous class assignment in my Principles of Computer Science 2 course, with Dr. Matthew Hibbs. 
I beefed it up and added some modifications including an XP system,  stat level-ups, additional encounters/enemies/ a final boss, and some other changes gameplay changes. 

Some notes:
Gameplay loop can be run from main in Encounter.java
  
Character hp resets each dungeon, though not every fight

There are 2 rolls each turn, one to determine if the attack is a success, and one to determine it's damage on success. 
A 20 sided dice is rolled and added to the attacker's to hit, and that is compared to the armor of the atackee. A higher armor value than the roll+toHit results in a failed attack. 

Amount of xp needed grows per level, as do the amount of stats you gain per level up
Ex. you gain more health leveling from 8 -> 9, as opposed to 2 -> 3

Thanks for checking my project out!
