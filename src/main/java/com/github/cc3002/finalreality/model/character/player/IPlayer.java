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
    /**
     * Equips a weapon to the player character.
     * @param weapon
     *    weapon that is going be equipped
     */
    void equip(IWeapon weapon);

    /**
     * set the player's equipped weapon
     * @param equippedWeapon
     *      weapon to set
     */
    void setEquippedWeapon(IWeapon equippedWeapon);
}
