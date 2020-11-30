package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

public class AxeWeapon extends AbstractWeapon {
    /**
     * Creates a new weapon, whose type is Axe
     * @param name
     *      New Axe's name
     */
    public AxeWeapon(String name) {
        super(name, 8, 15, WeaponType.AXE);
    }

    @Override
    public void attack(ICharacter character){
        character.attackedByAxe();
    }

    @Override
    public void equippedByEngineer(Engineer engineer) {
        engineer.setEquippedWeapon(this);
    }

    @Override
    public void equippedByKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

}

