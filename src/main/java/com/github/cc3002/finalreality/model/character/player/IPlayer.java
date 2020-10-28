package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IPlayer {
    /**
     * Returns the weapon that is equipped in the player character.
     */
    Weapon getEquippedWeapon();

    /**
     * Returns this character's name.
    */
    String getName();

    /**
     * Returns this character's class.
    */
    CharacterClass getCharacterClass();

     
}
