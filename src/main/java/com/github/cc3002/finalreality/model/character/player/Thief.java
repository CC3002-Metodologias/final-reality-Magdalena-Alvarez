package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
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

    @Override
    public void equip(IWeapon weapon) {
        if (this.status){
            weapon.equippedByThief(this);
        }
    }
}
