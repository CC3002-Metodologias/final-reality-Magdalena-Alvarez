package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

public class KnifeWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Knife
     * @param name
     *      New Knife's name
     */
    public KnifeWeapon(String name) {
        super(name, 5, 10, WeaponType.KNIFE);
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedByKnife();
    }

    @Override
    public void equippedByBlack_Mage(Black_Mage blackMage) {
        blackMage.setEquippedWeapon(this);
    }

    @Override
    public void equippedByKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equippedByThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }
}
