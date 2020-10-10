package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EngineerCharacter extends PlayerCharacter{
    public EngineerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, CharacterClass.ENGINEER);
    }
}
