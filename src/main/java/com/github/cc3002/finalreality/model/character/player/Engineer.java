package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer extends PlayerCharacter{
    private static final CharacterClass typeEngineer = CharacterClass.ENGINEER;
    protected CharacterClass type = typeEngineer;
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.ENGINEER);
    }
}
