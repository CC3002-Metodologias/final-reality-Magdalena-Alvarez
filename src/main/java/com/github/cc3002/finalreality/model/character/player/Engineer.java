package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer extends PlayerCharacter{
    private static final CharacterClass typeEngineer = CharacterClass.ENGINEER;
    protected CharacterClass type = typeEngineer;
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.ENGINEER);
    }

    /**
     * Equips an Axe to the Engineer
     * @param axename
     */
    public void equipAxe(String axename){
        this.equippedWeapon = new AxeWeapon(axename);
    }
    /**
     * Equips an Bow to the Engineer
     * @param bowname
     */
    public void equipBow(String bowname) {
        this.equippedWeapon = new BowWeapon(bowname);
    }
}
