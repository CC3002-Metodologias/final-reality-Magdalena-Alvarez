package com.github.cc3002.finalreality.model.weapon;

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
}
