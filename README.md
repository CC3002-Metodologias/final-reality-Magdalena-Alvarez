Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

Functioning
---

Every class of playerCharacter are implemented separately in order to equip the corrects types of weapons to each one. 
The different types of weapons are implemented separately too, in this case to make easier the way they are created, the player only can choose the name.

There are six classes of characters, five playerCharacters and the enemy. Every character has life and defense points and 
a name, also the mages have mana to pay their spells. The enemy can't equip weapons, 
only the player characters can, and they follow the following rules: 
* Knights can only equip a sword, an axe or a knife.
* Engineers can only equip an axe or a bow.
* Thieves can only equip a sword, a knife or a bow.
* Black Mages can only equip a knife or a staff.
* White Mages can only equip a staff.

The weapons are in the user's inventory, and can be shared among the player characters.

When it's the turn of a player character, can change its weapon and then has to attack an enemy, and then waits to go back to the queue.
On the other hand, the enemies can only attack a random character during its turn.

The user wins the game if kills all the enemies, and lose if all the players of the party die. The user has to be careful with the attacks, because the friendly fire exists.

Time to play
-----
When you start the game, it will pop up a window where you can create your players and weapons.
You can create just 5 players and all the weapons you want, but you have to make sure that every
player can equip at least a weapon. Then you can press continue to go to the equipping stage.

When you are in the equipping stage, you can press the buttons to equip the weapon to the player,
if it equips successfully, the description will change to **"Equipped : -weapon name-"** *(make sure every description has changed to this before starting)*.
When you are ready, press start to begin the game.

The window displays all the players and enemies information. In the top-left corner is the amount of alive players and enemies and also how many weapons are in
your inventory. In the middle of the screen there is a button to start the turn, if it's the turn of a player it will switch into two text boxes.
In the first box you can write a number and change the player weapon, if it is posible. The second box allows you to select an enemy to attack.
Your turn is over when you attack.

In the case of the enemy turn, the attack sequence is automatic. When it ends, you have to press the button to continue.

If a character life is down to 0, it dies. When that happens, if it's in its turn it will attack but has no effect. When it
ends its turn, it doesn't go back to the queue.

When one of teams die, the game is over. The window will change to a winning or losing image, depending on the result.
