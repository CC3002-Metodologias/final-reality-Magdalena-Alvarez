package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

import java.util.Objects;

public class SwordWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Sword
     * @param name
     *      New Sword's name
     */
    public SwordWeapon(String name) {
        super(name, 15, 13, WeaponType.SWORD);
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
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SwordWeapon)) {
            return false;
        }
        final SwordWeapon weapon = (SwordWeapon) o;
        return getType() == weapon.getType() && getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }
}
