package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Mage.White_Mage;

import java.util.Objects;

public class StaffWeapon extends AbstractWeapon {
    /**
     * Creates a new weapon, whose type is Staff
     * @param name
     *      New Staff's name
     */
    public StaffWeapon(String name) {
        super(name, 5, 11, WeaponType.STAFF);
    }

    @Override
    public void attack(ICharacter character){
        character.attackedByStaff();
    }

    @Override
    public void equippedByWhite_Mage(White_Mage whiteMage) {
        whiteMage.setEquippedWeapon(this);
    }

    @Override
    public void equippedByBlack_Mage(Black_Mage blackMage) {
        blackMage.setEquippedWeapon(this);
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StaffWeapon)) {
            return false;
        }
        final StaffWeapon weapon = (StaffWeapon) o;
        return getType() == weapon.getType() && getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getType());
    }

}
