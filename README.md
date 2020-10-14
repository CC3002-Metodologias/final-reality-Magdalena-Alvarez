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