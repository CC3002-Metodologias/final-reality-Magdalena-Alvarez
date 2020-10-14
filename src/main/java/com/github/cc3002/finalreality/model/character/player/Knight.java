package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {

    /**
     * Creates a new character that it's class is knight.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.KNIGHT);
    }


    /**
     * Equips a Bow to the Knight
     * @param bowname
     *      bow's name
     */
    public void equipBow(String bowname) {
        this.equippedWeapon = new BowWeapon(bowname);
    }
    /**
     * Equips a Bow to the Knight
     * @param swordName
     *      sword's name
     */
    public void equipSword(String swordName) {
        this.equippedWeapon = new SwordWeapon((swordName));
    }

    /**
     * Equips a Knife to the Knight
     * @param knifeName
     *      knife's name
     */
    public void equipKnife(String knifeName) {
        this.equippedWeapon = new KnifeWeapon((knifeName));
    }
}
