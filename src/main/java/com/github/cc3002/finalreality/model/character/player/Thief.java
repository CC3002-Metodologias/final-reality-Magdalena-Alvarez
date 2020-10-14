package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {
    private static final CharacterClass typeThief = CharacterClass.THIEF;
    protected CharacterClass type = typeThief;
    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.THIEF);
        this.type = typeThief;
    }

    public void equipKnife(String knifeName) {
        this.equippedWeapon = new KnifeWeapon((knifeName));
    }

    /**
     * Equips an Bow to the Thief
     * @param bowname
     */
    public void equipBow(String bowname) {
        this.equippedWeapon = new BowWeapon(bowname);
    }
}
