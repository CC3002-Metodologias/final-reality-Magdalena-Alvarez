package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

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

    @Override
    public void equippedByKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equippedByThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }
}
