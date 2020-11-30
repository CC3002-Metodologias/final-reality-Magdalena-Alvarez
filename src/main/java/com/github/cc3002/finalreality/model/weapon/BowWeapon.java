package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

public class BowWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Bow
     * @param name
     *      New Bow's name
     */
    public BowWeapon(String name) {
        super(name, 15, 19, WeaponType.BOW);
    }

    public void attack(ICharacter character){
        character.attackedByBow();
    }


    @Override
    public void equippedByEngineer(Engineer engineer) {
        engineer.setEquippedWeapon(this);
    }

    @Override
    public void equippedByThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }
}
