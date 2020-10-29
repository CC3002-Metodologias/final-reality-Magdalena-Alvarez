package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerCharacter {

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
     * Equips a Axe to the Knight
     * @param Axename
     *      axe's name
     */
    public void equipAxe(String Axename) {

        if (this.status){
            this.equippedWeapon = new AxeWeapon(Axename);
        }
    }
    /**
     * Equips a Bow to the Knight
     * @param swordName
     *      sword's name
     */
    public void equipSword(String swordName) {

        if (this.status){
            this.equippedWeapon = new SwordWeapon((swordName));
        }
    }

    /**
     * Equips a Knife to the Knight
     * @param knifeName
     *      knife's name
     */
    public void equipKnife(String knifeName) {

        if (this.status) {
            this.equippedWeapon = new KnifeWeapon((knifeName));
        }
    }
}
