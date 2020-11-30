package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

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

    void equippedByWhite_Mage(White_Mage whiteMage);

    void equippedByBlack_Mage(Black_Mage blackMage);

    void equippedByEngineer(Engineer engineer);

    void equippedByKnight(Knight knight);

    void equippedByThief(Thief thief);
}
