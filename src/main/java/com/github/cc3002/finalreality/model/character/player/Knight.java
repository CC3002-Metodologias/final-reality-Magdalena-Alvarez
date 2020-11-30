package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
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

    @Override
    public void equip(IWeapon weapon) {
        if (this.status) {
            weapon.equippedByKnight(this);
        }
    }
}
