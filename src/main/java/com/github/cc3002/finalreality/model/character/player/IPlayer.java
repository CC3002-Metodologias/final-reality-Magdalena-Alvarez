package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IPlayer extends ICharacter {
    /**
     * Returns the weapon that is equipped in the player character.
     */
    IWeapon getEquippedWeapon();

    /**
     * Returns this character's name.
    */
    String getName();

    /**
     * Returns this character's class.
    */
    CharacterClass getCharacterClass();

     
}
