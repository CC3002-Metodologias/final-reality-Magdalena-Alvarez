package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class AttackPhase extends Phase {
    private final ICharacter target;
    private final ICharacter playingChar;

    public AttackPhase(ICharacter target, ICharacter playingChar) {
        this.target = target;
        this.playingChar = playingChar;
        controller.attack(playingChar, target);
    }

    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase(playingChar));
    }
}
