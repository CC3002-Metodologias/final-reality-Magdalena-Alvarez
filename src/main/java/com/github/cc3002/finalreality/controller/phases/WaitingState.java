package com.github.cc3002.finalreality.controller.phases;

public class WaitingState extends Phase{

    @Override
    public void toStartTurnPhase() {
        changePhase(new StartTurnPhase());
    }
}
