package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class SwordWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Sword
     * @param name
     *      New Sword's name
     */
    public SwordWeapon(String name) {
        super(name, 15, 15, WeaponType.SWORD);
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedBySword();
    }
}
