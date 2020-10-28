package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class AxeWeapon extends AbstractWeapon {

    public AxeWeapon(String name) {
        super(name, 8, 15, WeaponType.AXE);
    }

    @Override
    public void attack(ICharacter character){
        character.attackedByAxe();
    }


    }

