package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class EndTurnPhase extends Phase {


    public EndTurnPhase(ICharacter playingChar) {
        controller.endTurn(playingChar);
    }

    @Override
    public void toStartTurnPhase() {
        controller.setPhase(new StartTurnPhase());
    }
}
