package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Objects;

public class BowWeapon extends AbstractWeapon{
    /**
     * Creates a new weapon, whose type is Bow
     * @param name
     *      New Bow's name
     */
    public BowWeapon(String name) {
        super(name, 15, 13, WeaponType.BOW);
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
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BowWeapon)) {
            return false;
        }
        final BowWeapon weapon = (BowWeapon) o;
        return getType() == weapon.getType() && getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }
}
