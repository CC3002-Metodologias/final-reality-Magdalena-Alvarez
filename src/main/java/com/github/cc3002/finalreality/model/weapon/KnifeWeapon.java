package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;

import java.util.Objects;

public class KnifeWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Knife
     * @param name
     *      New Knife's name
     */
    public KnifeWeapon(String name) {
        super(name, 5, 8, WeaponType.KNIFE);
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
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KnifeWeapon)) {
            return false;
        }
        final KnifeWeapon weapon = (KnifeWeapon) o;
        return getType() == weapon.getType() && getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }
}
