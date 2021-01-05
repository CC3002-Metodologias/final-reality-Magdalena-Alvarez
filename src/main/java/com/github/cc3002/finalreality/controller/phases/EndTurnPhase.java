package com.github.cc3002.finalreality.controller.phases;

public class EndTurnPhase extends Phase {

    /**
     * creates a new end turn phase
     */
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
