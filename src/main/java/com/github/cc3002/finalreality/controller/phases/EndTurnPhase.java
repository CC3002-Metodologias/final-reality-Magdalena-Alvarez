package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class EndTurnPhase extends Phase {


    public EndTurnPhase() {

    }
    @Override
    public void endTurn(){
        controller.endTurn(character);
        toWaitingPhase();
    }
    @Override
    public void toWaitingPhase() {
        changePhase(new WaitingState());
    }

}
