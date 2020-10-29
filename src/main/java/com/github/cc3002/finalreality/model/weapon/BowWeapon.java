package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

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
}
