package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {

    private static final CharacterClass typeKnight = CharacterClass.KNIGHT;
    protected CharacterClass type = typeKnight;
    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.KNIGHT);
        this.type = typeKnight;
    }


    public CharacterClass getType() {
        return type;
    }
}
