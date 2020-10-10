package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Black_MageCharacter extends PlayerCharacter {
    public Black_MageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super (name, turnsQueue, CharacterClass.BLACK_MAGE);
    }
}
