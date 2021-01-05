package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.character.player.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.White_Mage;

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

    /**
     * attacks a character
     * @param character
     */
    void attack(ICharacter character);

    /**
     * equips the weapon to a White Mage
     * @param whiteMage
     *      white mage to equip the weapon
     */
    void equippedByWhite_Mage(White_Mage whiteMage);

    /**
     * equips the weapon to a Black Mage
     * @param blackMage
     *      black mage to equip the weapon
     */
    void equippedByBlack_Mage(Black_Mage blackMage);

    /**
     *equips the weapon to a engineer
     * @param engineer
     *      engineer to equip the weapon
     */
    void equippedByEngineer(Engineer engineer);

    /**
     * equips the weapon to a knight
     * @param knight
     *      knight to equip the weapon
     */
    void equippedByKnight(Knight knight);

    /**
     * equips the weapon to a thief
     * @param thief
     *      thief to equip the weapon
     */
    void equippedByThief(Thief thief);
}
