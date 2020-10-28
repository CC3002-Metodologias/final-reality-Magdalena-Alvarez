package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractPlayerCharacter {
    /**
     * Creates a new character that it's class is thief.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.THIEF);
    }

    /**
     * Equip a knife to the Thief
     * @param knifeName
     *      knife's name
     */
    public void equipKnife(String knifeName) {
        this.equippedWeapon = new KnifeWeapon((knifeName));
    }

    /**
     * Equips a Bow to the Thief
     * @param bowname
     *      bow's name
     */
    public void equipBow(String bowname) {
        this.equippedWeapon = new BowWeapon(bowname);
    }

    /**
     * Equips a Sword to the Thief
     * @param swordname
     *      sword's name
     */
    public void equipSword(String swordname) {
        this.equippedWeapon = new SwordWeapon(swordname);
    }
}
