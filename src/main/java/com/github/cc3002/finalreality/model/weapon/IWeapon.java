package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IWeapon {
    /**
     *Returns the weapon's name
     */
    String getName();

    /**
     *Returns the weapon's damage points
     */
    int getDamage();

    /**
     * Returns the weapon's weight
     */
    int getWeight();

    /**
     * Returns the weapon's type
     */
    WeaponType getType();

    void attack(ICharacter character);
}
