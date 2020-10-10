package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class KnightCharacter extends PlayerCharacter{

    public KnightCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, CharacterClass.KNIGHT);
    }
}
