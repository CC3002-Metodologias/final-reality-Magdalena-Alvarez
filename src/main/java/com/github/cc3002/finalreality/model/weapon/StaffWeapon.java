package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class StaffWeapon extends AbstractWeapon {
    public StaffWeapon(String name) {
        super(name, 5, 15, WeaponType.STAFF);
    }

    @Override
    public void attack(ICharacter character){
        character.attackedByStaff();
    }
}
