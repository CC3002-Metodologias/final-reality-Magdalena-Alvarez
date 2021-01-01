package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class PlayerSelectingPhase extends Phase {
    private final IPlayer playingChar;
    private ICharacter target;

    public PlayerSelectingPhase(IPlayer playingChar) {
        this.playingChar = playingChar;
    }
    public void setTarget(ICharacter victim){
        this.target = victim;
    }

    @Override
    public void toAttackPhase() {
        changePhase(new AttackPhase(target, playingChar));
    }
}
