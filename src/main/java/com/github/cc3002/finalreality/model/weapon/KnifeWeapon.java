package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class KnifeWeapon extends AbstractWeapon{

    public KnifeWeapon(String name) {
        super(name, 5, 10, WeaponType.KNIFE);
    }

    @Override
    public void attack(ICharacter character) {
        character.attackedByKnife();
    }
}
