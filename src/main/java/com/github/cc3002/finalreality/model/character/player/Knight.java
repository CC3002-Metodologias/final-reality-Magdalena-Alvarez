package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {


    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.KNIGHT);
    }


    /**
     * Equips an Bow to the Engineer
     * @param bowname
     */
    public void equipBow(String bowname) {
        this.equippedWeapon = new BowWeapon(bowname);
    }

    public void equipSword(String swordName) {
        this.equippedWeapon = new SwordWeapon((swordName));
    }

    public void equipKnife(String knifeName) {
        this.equippedWeapon = new KnifeWeapon((knifeName));
    }
}
