package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class PlayerSelectingPhase extends Phase {
    private ICharacter target;

    public PlayerSelectingPhase(){//IPlayer playingChar) {
        //this.playingChar = playingChar;
    }

    @Override
    public void setTarget(ICharacter enemy) {
        this.target=enemy;
        toAttackPhase();

    }



    @Override
    public void toAttackPhase() {
        changePhase(new AttackPhase(target));
    }
}
